package processor;

import java.util.List;
import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.filter.CompositeFilter;
import spoon.reflect.visitor.filter.FilteringOperator;
import spoon.reflect.visitor.filter.InvocationFilter;
import spoon.reflect.visitor.filter.NameFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import util.MethodNameProvider;
import util.NameProvider;

public class NameMethodProcessor extends AbstractProcessor<CtType> {

	public void process(CtType element) {

		System.out.println("-_-_-_- CHANGE METHODS OF " + element.getSimpleName() +" -_-_-_-");

		NameProvider nameProvider = new MethodNameProvider(getFactory(), element);
		Set<CtMethod> methods = element.getMethods();
		
		for (CtMethod method : methods) {

			// Don't touch to the mains methods
			if (!isModifiable(method)) {
				continue;
			}

			String newName = nameProvider.getNewName(method);
			System.out.println(" ");
			// System.out.println(method.getPosition()+" ===
			// "+method.getSimpleName());
			System.out.println("Change method " + method.getReference());
			System.out.println("..Old = " + method.getSimpleName());
			System.out.println("..New = " + newName);

			// creation des filtres avant de changer le nom de la methode (pour
			// l'ancienne reference).
			InvocationFilter filterInvoc = new InvocationFilter(method.getReference());
			NameFilter filterName = new NameFilter(method.getSimpleName());

			method.setSimpleName(newName);
			changeAllInvocationExecutable(filterInvoc, method);

			changeAllSubClass(filterName, method, element);
		}

	}

	public void changeAllInvocationExecutable(InvocationFilter filter, CtMethod method) {
		// System.out.println("....Change all invocations of the method:");

		CtPackage p = getFactory().Package().getRootPackage();
		List<CtInvocation<?>> invocationList = p.getElements(filter);

		/*
		 * QueryVisitor visiteur = new QueryVisitor(filter);
		 * List<CtInvocation<?>> invocationList = visiteur.getResult();
		 */

		for (CtInvocation<?> invoc : invocationList) {
			System.out.println("....Change invocations:");
			System.out.println("......" + invoc.getPosition() + "  " + invoc.getSignature());
			/*
			 * System.out.println("......Invocation Executable");
			 * System.out.println("......Position ="+invoc.getPosition());
			 * System.out.println("......Old = "+invoc.getExecutable());
			 */

			invoc.setExecutable(method.getReference());

			/* System.out.println("------ New = "+invoc.getExecutable()); */
		}
	}

	/* need to change all subclass */
	public void changeAllSubClass(NameFilter nameFilter, CtMethod method, CtType type) {
		CompositeFilter filter = new CompositeFilter(FilteringOperator.INTERSECTION, nameFilter,
				new TypeFilter(CtMethod.class));

		List<CtType<?>> subclasses = getFactory().Class().getAll(true);

		for (CtType<?> c : subclasses) {

			// si c hérite ou implemente la currentClass
			if (type.getReference().equals(c.getSuperclass()) || c.getSuperInterfaces().contains(type.getReference())) {
				System.out.println("....Change SubClass " + c.getSimpleName());
				List<CtMethod> methods = c.getElements(filter);
				for (CtMethod m : methods) {
					System.out.println("......" + m.getSimpleName() + " become " + method.getSimpleName());
					m.setSimpleName(method.getSimpleName());

					// System.out.println(method.getPosition()+" ===
					// "+method.getSimpleName());
				}
			}
		}

	}

	public void changeAllSubInterface(CtMethod method) {

	}

	public boolean isModifiable(CtMethod method) {
		if (method.getSimpleName().equals("main")) {
			return false;
		}

		if (isOverride(method)) {
			System.out.println("METHOD NOT OVERRIDE " + method.getSimpleName());
			return false;
		}

		return true;
	}

	public boolean isOverride(CtMethod method) {

		/*
		 * final List<CtAnnotation<? extends Annotation>> methodAnnotations =
		 * method.getAnnotations(); for (final CtAnnotation<? extends
		 * Annotation> annotation : methodAnnotations) { if
		 * (annotation.getAnnotationType().getActualClass().equals(Override.
		 * class)) { return true; } }
		 */
		return (method.getAnnotation(Override.class) != null);

	}

}
