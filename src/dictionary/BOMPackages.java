package dictionary;

import java.util.ArrayList;

public class BOMPackages {

	private BOMPackages parent;
	private Model model;
	private String name;
	private ArrayList<BOMClass> classes;
	private ArrayList<BOMPackages> packages;
	protected int nbAttribute;
	protected int nbPackages;
	protected int nbClass;
	protected int nbComments;
	protected int nbConstant;
	protected int nbMethods;
	
	public BOMPackages(Model model, BOMPackages parent, String name) {
		this.classes = new ArrayList<>();
		this.packages = new ArrayList<>();
		
		this.model = model;
		this.parent = parent;
		this.name = name;
		
		this.nbPackages = 0;
		this.nbClass = 0;
		this.nbAttribute = 0;
		this.nbComments = 0;
		this.nbConstant = 0;
		this.nbMethods = 0;
	}
	
	public BOMClass addClass(String name) {
		BOMClass nc = new BOMClass(model, this, name);
		this.classes.add(nc);
		if (parent != null) parent.nbPackages++;
		model.nbPackage++;
		this.nbClass++;
		return nc;
	}
	
	public BOMPackages addPackage(String name) {
		BOMPackages np = new BOMPackages(model, this, name);
		this.packages.add(np);
		this.nbPackages++;
		model.nbPackage++;
		return np;
	}
	
}
