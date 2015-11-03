package dictionary;

import java.util.ArrayList;

public class Model {

	private ArrayList<ModelPackages> model;
	protected int nbPackage;
	protected int nbClass;
	protected int nbAttribute;
	protected int nbConstant;
	protected int nbMethods;
	protected int nbComments;
	
	public Model() {
	
		this.model = new ArrayList<>();
		
		this.nbAttribute = 0;
		this.nbClass = 0;
		this.nbComments = 0;
		this.nbConstant = 0;
		this.nbMethods = 0;
		this.nbPackage = 0;	
	}
	
	public ModelPackages addPackage(String name) {
		ModelPackages np = new ModelPackages(this, name);
		this.model.add(np);
		this.nbPackage++;
		return np;
	}
	
	public ArrayList<ModelPackages> getModel() {
		return model;
	}

	/*
	 * GETTERS
	 */
	public int getNbPackage() {
		return nbPackage;
	}

	public int getNbClass() {
		return nbClass;
	}

	public int getNbAttribute() {
		return nbAttribute;
	}

	public int getNbConstant() {
		return nbConstant;
	}

	public int getNbMethods() {
		return nbMethods;
	}

	public int getNbComments() {
		return nbComments;
	}
	
}
