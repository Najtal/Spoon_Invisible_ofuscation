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
		initProcessors();
		Process();
	
	}


	private void readModelProjectToModel() {
		this.model = new ModelHandler(spoonReader).getModelFromSpoon();
	}

	private void initProcessors() {
		
		//processPackages();
		
		processClasses();
		
		processMethodes();
		
	}
	
	
	private void processPackages() {

		//spoonReader.buildModel();
		// On ajoute tous les packages
		ArrayList<CtPackage> ctpl = new ArrayList<>();
		for (CtPackage ctpR : spoonReader.getFactory().Package().getAll()) {
			ctpl.add(ctpR);
		}
		
		//spoonEditor.buildModel();
		List<CtPackage> lPackages = (List<CtPackage>) spoonEditor.getFactory().Package().getAll();
		for (int i=0 ; i<lPackages.size() ; i++) {
			CtPackage x = spoonEditor.getFactory().Package().get(lPackages.get(i).getQualifiedName());
			x.setSimpleName(ctpl.get(i).getSimpleName());
		}
	}
	
	private void processClasses() {
		/*ArrayList<CtType> ctty = new ArrayList<>();
		for (CtType ctty : spoonReader.getFactory().Package().getAllRoots(). getAll()) {
			ctpl.add(ctpR);
		}
		
		spoonEditor.buildModel();
		List<CtPackage> lPackages = (List<CtPackage>) spoonEditor.getFactory().Package().getAll();
		for (int i=0 ; i<lPackages.size() ; i++) {
			CtPackage x = spoonEditor.getFactory().Package().get(lPackages.get(i).getQualifiedName());
			x.setSimpleName(ctpl.get(i).getSimpleName());
		}*/

	}
	
	private void processMethodes() {
		// TODO
	}

	private void Process() {
		
		spoonEditor.process();
		//spoonEditor.run();
		//spoonEditor.buildModel();
		
		spoonEditor.run();
		
		//spoonEditor.createCompiler().compile();
		//spoonReader.run();
	}
	
	public static Model getModel() {
		return model;
	}
	
}
