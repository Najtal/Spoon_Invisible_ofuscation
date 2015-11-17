package spoon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.omg.PortableInterceptor.InterceptorOperations;

import dictionary.BOMClass;
import dictionary.BOMPackages;
import dictionary.Model;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.filter.CompositeFilter;
import spoon.reflect.visitor.filter.FilteringOperator;
import spoon.reflect.visitor.filter.TypeFilter;

public class ModelHandler {

	private Model model;
	private Launcher launcher;

	private TypeFilter tfPackage;
	private TypeFilter tfClass;

	public ModelHandler(Launcher launcher) {
		this.launcher = launcher;
		this.model = new Model();

		tfPackage = new TypeFilter(CtPackage.class);
		tfClass = new TypeFilter(CtClass.class);
	}

	public Model getModelFromSpoon() {
		launcher.buildModel();
		introPackages(true, null, null);
		return model;
	}

	/**
	 * Analyse le contenu Packages et l'ajoute dans le modèle
	 * 
	 * @param isRootLevel
	 *            est-ce que le package est à la racine du projet ou est-il
	 *            enfant d'un autre package
	 * @param mParent
	 *            si il n'est pas root, quel est son parent. Nécessaire que si
	 *            pas root
	 * @param sPackage
	 *            le package a analyser. Nécessaire que si pas root
	 */
	private void introPackages(boolean isRootLevel, BOMPackages mParent, CtPackage sPackage) {
		if (!isRootLevel && mParent == null) {
			throw new IllegalArgumentException(
					"L'argument parent ne peut pas être vide si le package n'est pas un package root");
		}

		// On récupère tous les packages du package
		List<CtPackage> lPackages = new ArrayList();

		if (isRootLevel) {
			lPackages = (List<CtPackage>) launcher.getFactory().Package().getAll();
		} else {
			// lPackages = sPackage.getElements(new
			// TypeFilter<>(CtPackage.class));
		}

		// Si le package contient des packages
		if (lPackages.size() != 0) {

			for (CtPackage ePackage : lPackages) {
				// on ajoute le package au modele
				BOMPackages newBomPackage;

				if (isRootLevel) {
					newBomPackage = model.addPackage(ePackage.getSimpleName());
				} else {
					newBomPackage = mParent.addPackage(ePackage.getSimpleName());
				}

				// parcourir les ss-packages
				introPackages(false, newBomPackage, ePackage);
				
				// parcourrir les ss-elements
				introClasses(newBomPackage, ePackage);
			}
		}

	}

	private void introClasses(BOMPackages bomPackage, CtPackage sPackage) {

		List<CtClass> lClass = sPackage.getElements(new TypeFilter<>(CtType.class));
		
		if (lClass == null) return; 
		for (CtClass eClass : lClass) {
			if (eClass != null) {
				bomPackage.addClass(eClass.getSimpleName());
			}
		 } 
	}

	private void introAttributes() {
		// TODO
	}

	private void introConstants() {
		// TODO
	}

	private void introMethods() {
		// TODO
	}

	private void introComments() {
		// TODO
	}

}
