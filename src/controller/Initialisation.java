package controller;

import java.util.ArrayList;
import java.util.List;

import dictionary.Model;
import processor.ProcessorCtTypeName;
import processor.ProcessorPackageName;
import spoon.Launcher;
import spoon.ModelHandler;
import spoon.SpoonSingleton;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;

public class Initialisation {

	private String inputDir;
	private String modelDir;
	private String outputDir;

	private static Model model;
	
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
		spoonEditor.addInputResource(modelDir);
		spoonEditor.setOutputDirectory(outputDir);
		
		 
    	// D�finition des processeurs
		//NameMethodProcessor nmp = new NameMethodProcessor();
		ProcessorPackageName abp = new ProcessorPackageName();
		ProcessorCtTypeName abct = new ProcessorCtTypeName();
		
    	// Association des process a spoon
		spoonEditor.addProcessor(abp);
		spoonEditor.addProcessor(abct);

		// Application effective du mod�le sur le projet cible
		Process();
	}


	private void readModelProjectToModel() {
		this.model = new ModelHandler(spoonReader).getModelFromSpoon();
	}

	private void Process() {
		spoonEditor.process();
		spoonEditor.run();
	}
	
	public static Model getModel() {
		return model;
	}
	
}
