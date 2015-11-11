package spoon;

import java.util.Collection;
import java.util.List;

import dictionary.BOMPackages;
import dictionary.Model;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtPackage;

public class ModelHandler {

	private Model model;
	private Launcher launcher;
	
	public ModelHandler(Launcher launcher) {
		this.launcher = launcher;
		this.model = new Model();
	}
	
	public Model getModelFromSpoon() {
		launcher.buildModel();
		introPackages(true, null, null);
		return model;
	}
	
	
	private void introPackages(boolean isRootLevel, BOMPackages parent, CtPackage spoonPackage) {
		Collection<CtPackage> packages;
		if (isRootLevel) {
			packages = launcher.getFactory().Package().getAll();
		} else {
			packages = spoonPackage.getFactory().Package().getAll();
		}
		if (packages.isEmpty()) return;
		
		// parcourir les packages
		for (CtPackage pack : packages) {
			// on ajoute le package au modele
			BOMPackages bomp;
			
			if (isRootLevel) {
				bomp = model.addPackage(pack.getSimpleName());	
			} else {
				bomp = parent.addPackage(pack.getSimpleName());
			}
			
			// parcourir les ss-packages
			introPackages(false, bomp, pack);

			// On parcours tous ses éléments
			List<CtElement> packageElements = spoonPackage.getElements(null);
			for (CtElement element : packageElements) {

				// TODO Pour chaque type d'éléments, appeler la classe associée
				// Je ne trouve pas comment faire pour déterminer le type de chaque élément :/
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
