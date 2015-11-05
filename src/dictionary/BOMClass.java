package dictionary;

import java.util.ArrayList;

public class BOMClass {

	private Model model;
	private BOMPackages parent;
	private String name;
	private ArrayList<BOMMethods> methodes;
	private ArrayList<BOMConstant> constants;
	private ArrayList<BOMAttribute> attributes;
	protected int nbAttribute;
	protected int nbComments;
	protected int nbConstant;
	protected int nbMethods;
	
	
	public BOMClass(Model model, BOMPackages parent, String name) {
		this.methodes = new ArrayList<>();
		this.constants = new ArrayList<>();
		this.attributes = new ArrayList<>();
		
		this.parent = parent;
		this.model = model;
		this.name = name;
		
		this.nbAttribute = 0;
		this.nbComments = 0;
		this.nbConstant = 0;
		this.nbMethods = 0;
	}
	
	
	public BOMMethods addMethod(String name) {
		BOMMethods nc = new BOMMethods(model, this, name);
		this.methodes.add(nc);
		model.nbMethods++;
		parent.nbMethods++;
		this.nbMethods++;
		return nc;
	}

	public BOMConstant addConstant(String name) {
		BOMConstant nc = new BOMConstant(model, this, name);
		this.constants.add(nc);
		model.nbConstant++;
		parent.nbConstant++;
		this.nbConstant++;
		return nc;
	}
	
	public BOMAttribute addAttribute(String name) {
		BOMAttribute nc = new BOMAttribute(model, this, name);
		this.attributes.add(nc);
		model.nbAttribute++;
		parent.nbAttribute++;
		this.nbAttribute++;
		return nc;
	}


	public ArrayList<BOMMethods> getMethodes() {
		return methodes;
	}


	public ArrayList<BOMAttribute> getAttributes() {
		return attributes;
	}


	public ArrayList<BOMConstant> getConstants() {
		return constants;
	}
	
}
