package controller;

import java.util.Collection;

import dictionary.Model;
import spoon.Launcher;
import spoon.ModelHandler;
import spoon.SpoonSingleton;
import spoon.reflect.declaration.CtPackage;

public class Initialisation {

	private String inputDir;
	private String modelDir;
	private String outputDir;

	private Model model;
	
	private Launcher spoonReader;
	private Launcher spoonEditor;
	
	
	/**
	 * Constructor
	 * @param inputDir le réportoire du projet source
	 * @param outputDir le répertoire du projet a générer
	 */
	public Initialisation(String inputDir, String modelDir, String outputDir) {		
		// Paramètres relatifs aux dossiers des projets
		this.inputDir = inputDir;
		this.modelDir = modelDir;
		this.outputDir = outputDir;
		
		// Initialisation de l'instance spoon permettant de lire le modèle
		this.spoonReader = SpoonSingleton.getSpoonModelReaderLauncher();
		spoonReader.addInputResource(inputDir);

		// Lecture effective du modèle
		readModelProjectToModel();
		
		// Initialisation de l'instance spoon permettant d'éditer le projet à affeccter		
		this.spoonEditor = SpoonSingleton.getSpoonEditorLauncher();
		spoonEditor.addInputResource(inputDir);
		spoonEditor.setOutputDirectory(outputDir);
		
		// Application effective du modèle sur le projet cible
		initProcessors();
		Process();
		
	}


	private void readModelProjectToModel() {
		this.model = new ModelHandler(spoonReader).getModelFromSpoon();
	}

	private void initProcessors() {
		// TODO Auto-generated method stub
		
	}

	private void Process() {
		spoonReader.run();
	}
	
}
