package dictionary;

import java.util.ArrayList;

public class ModelPackages {

	private Model parent;
	private String name;
	private ArrayList<ModelClass> classes;
	protected int nbAttribute;
	protected int nbClass;
	protected int nbComments;
	protected int nbConstant;
	protected int nbMethods;
	
	public ModelPackages(Model parent, String name) {
		this.classes = new ArrayList<>();
		this.parent = parent;
		this.name = name;
		
		this.nbClass = 0;
		this.nbAttribute = 0;
		this.nbComments = 0;
		this.nbConstant = 0;
		this.nbMethods = 0;
	}
	
	public ModelClass addClass(String name) {
		ModelClass nc = new ModelClass(parent, this, name);
		this.classes.add(nc);
		parent.nbPackage++;
		this.nbClass++;
		return nc;
	}
	
}
