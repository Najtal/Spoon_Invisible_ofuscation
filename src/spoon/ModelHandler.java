package spoon;

import java.util.Collection;
import java.util.List;

import dictionary.BOMClass;
import dictionary.BOMPackages;
import dictionary.Model;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.Filter;
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
	 * @param isRootLevel est-ce que le package est à la racine du projet ou est-il enfant d'un autre package
	 * @param mParent si il n'est pas root, quel est son parent. Nécessaire que si pas root
	 * @param sPackage le package a analyser. Nécessaire que si pas root
	 */
	private void introPackages(boolean isRootLevel, BOMPackages mParent, CtPackage sPackage) {
		if (!isRootLevel && mParent == null) {
			throw new IllegalArgumentException("L'argument parent ne peut pas être vide si le package n'est pas un package root");
		}
		
		// On récupère tous les packages du package
		List<CtPackage> lPackages;
		List<CtClass> lClass = null;
				
		if (isRootLevel) {
			lPackages = (List<CtPackage>) launcher.getFactory().Package().getAll();
			System.out.println(lPackages.toString());
		} else {
			lPackages = sPackage.getElements(tfPackage);
			lClass = sPackage.getElements(tfClass);
			System.out.println(lPackages.toString());
			System.out.println(lClass.toString());
		}
		
		
		// ### packages
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
		}
		
		// ### class
		if (lClass == null) return;
		for (CtClass eClass : lClass) {
			BOMClass newBomClass = mParent.addClass(eClass.getSimpleName());
			introPackages(false, bomp, pack);

			// On parcours tous ses elements
			List<CtElement> packageElements = spoonPackage.getElements(null);
			for (CtElement element : packageElements) {

				// TODO Pour chaque type d'elements, appeler la classe associee
				// Je ne trouve pas comment faire pour determiner le type de chaque element :/
				// Sans doute avec les annotations.
				
				// Solution du prof
				//packages.getElements(new TypeFilter<>(CtType.class));
				
				//packages.getElements(arg0)(arg0)
			
			}
			
		}
	}
	
	
	private void introClasses(BOMPackages bomPackage, CtPackage spoonPackage) {

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
