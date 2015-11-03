package dictionary;

import java.util.ArrayList;

public class ModelClass {

	private Model model;
	private ModelPackages parent;
	private String name;
	private ArrayList<ModelMethods> methodes;
	private ArrayList<ModelConstant> constants;
	private ArrayList<ModelAttribute> attributes;
	protected int nbAttribute;
	protected int nbComments;
	protected int nbConstant;
	protected int nbMethods;
	
	
	public ModelClass(Model model, ModelPackages parent, String name) {
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
	
	
	public ModelMethods addMethod(String name) {
		ModelMethods nc = new ModelMethods(model, this, name);
		this.methodes.add(nc);
		model.nbMethods++;
		parent.nbMethods++;
		this.nbMethods++;
		return nc;
	}

	public ModelConstant addConstant(String name) {
		ModelConstant nc = new ModelConstant(model, this, name);
		this.constants.add(nc);
		model.nbConstant++;
		parent.nbConstant++;
		this.nbConstant++;
		return nc;
	}
	
	public ModelAttribute addAttribute(String name) {
		ModelAttribute nc = new ModelAttribute(model, this, name);
		this.attributes.add(nc);
		model.nbAttribute++;
		parent.nbAttribute++;
		this.nbAttribute++;
		return nc;
	}


	public ArrayList<ModelMethods> getMethodes() {
		return methodes;
	}


	public ArrayList<ModelAttribute> getAttributes() {
		return attributes;
	}


	public ArrayList<ModelConstant> getConstants() {
		return constants;
	}
	
}
