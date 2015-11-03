package controller;

import java.util.Collection;

import spoon.Launcher;
import spoon.SpoonSingleton;
import spoon.reflect.declaration.CtPackage;

public class Initialisation {

	private String inputDir;
	private String outputDir;
	private Launcher spoon;
	
	
	/**
	 * Constructor
	 * @param inputDir le réportoire du projet source
	 * @param outputDir le répertoire du projet a générer
	 */
	public Initialisation(String inputDir, String outputDir) {		
		this.inputDir = inputDir;
		this.outputDir = outputDir;
		
		this.spoon = SpoonSingleton.getSpoonLauncher();
		
		spoon.addInputResource(inputDir);
		spoon.setOutputDirectory(outputDir);
		
		writeProjectAndGenerateModel();
		
		initProcessors();
		
		Process();
		
	}


	private void writeProjectAndGenerateModel() {
		// TODO Auto-generated method stub
		spoon.buildModel();
		Collection<CtPackage> packages = spoon.getFactory().Package().getAll();
		
		// parcourir les packages
		
		// Créer en entrer tout dans le modèle
		
		// ... a continuer 
		
	}

	private void initProcessors() {
		// TODO Auto-generated method stub
		
	}

	private void Process() {
		spoon.run();
	}
	
}
