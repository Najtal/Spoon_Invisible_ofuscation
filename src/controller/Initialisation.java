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
	 * @param inputDir le r�portoire du projet source
	 * @param outputDir le r�pertoire du projet a g�n�rer
	 */
	public Initialisation(String inputDir, String modelDir, String outputDir) {		
		// Param�tres relatifs aux dossiers des projets
		this.inputDir = inputDir;
		this.modelDir = modelDir;
		this.outputDir = outputDir;
		
		// Initialisation de l'instance spoon permettant de lire le mod�le
		this.spoonReader = SpoonSingleton.getSpoonModelReaderLauncher();
		spoonReader.addInputResource(inputDir);

		// Lecture effective du mod�le
		readModelProjectToModel();
		
		// Initialisation de l'instance spoon permettant d'�diter le projet � affeccter		
		this.spoonEditor = SpoonSingleton.getSpoonEditorLauncher();
		spoonEditor.addInputResource(inputDir);
		spoonEditor.setOutputDirectory(outputDir);
		
		// Application effective du mod�le sur le projet cible
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
