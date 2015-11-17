package controller;

import dictionary.Model;
import processor.ProcessorCtTypeName;
import processor.ProcessorPackageName;
import spoon.Launcher;
import spoon.ModelHandler;
import spoon.SpoonSingleton;

public class Initialisation {

	private static Model model;
	
	private Launcher spoonReader;
	private Launcher spoonEditor;
	
	
	/**
	 * Constructor
	 * @param inputDir le réportoire du projet source
	 * @param outputDir le répertoire du projet a générer
	 */
	public Initialisation(String inputDir, String modelDir, String outputDir) {		
		
		// Initialisation de l'instance spoon permettant de lire le modèle
		this.spoonReader = SpoonSingleton.getSpoonModelReaderLauncher();
		spoonReader.addInputResource(inputDir);

		// Lecture effective du modèle
		readModelProjectToModel();
		
		// Initialisation de l'instance spoon permettant d'éditer le projet à affeccter		
		this.spoonEditor = SpoonSingleton.getSpoonEditorLauncher();
		spoonEditor.addInputResource(modelDir);
		spoonEditor.setOutputDirectory(outputDir);
		
		 
    	// Définition des processeurs
		//NameMethodProcessor nmp = new NameMethodProcessor();
		ProcessorPackageName abp = new ProcessorPackageName();
		ProcessorCtTypeName abct = new ProcessorCtTypeName();
		
    	// Association des process a spoon
		spoonEditor.addProcessor(abp);
		spoonEditor.addProcessor(abct);

		// Application effective du modèle sur le projet cible
		Process();
	}


	private void readModelProjectToModel() {
		this.model = new ModelHandler(spoonReader).getModelFromSpoon();
	}

	private void Process() {
		spoonEditor.process();
		spoonEditor.run();
		System.out.println("Terminated");
	}
	
	public static Model getModel() {
		return model;
	}
	
}
