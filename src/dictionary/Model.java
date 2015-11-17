package dictionary;

import java.util.ArrayList;

import controller.Initialisation;

public class Model {

	private ArrayList<BOMPackages> model;
	protected int nbPackage;
	protected int nbClass;
	protected int nbAttribute;
	protected int nbConstant;
	protected int nbMethods;
	protected int nbComments;
	
	/**
	 * Consructor
	 */
	public Model() {
		this.model = new ArrayList<>();
		
		this.nbAttribute = 0;
		this.nbClass = 0;
		this.nbComments = 0;
		this.nbConstant = 0;
		this.nbMethods = 0;
		this.nbPackage = 0;	
	}
	
	public BOMPackages addPackage(String name) {
		BOMPackages np = new BOMPackages(this, null, name);
		this.model.add(np);
		this.nbPackage++;
		return np;
	}
	
	public ArrayList<BOMPackages> getModel() {
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
	
	public String getMeADamnPackageName(BOMPackages pack) {
		
		if (pack == null){
			
			for (BOMPackages bomPackages : model) {
				// on regarde si on prends le nom
				if (!bomPackages.isTaken) {
					bomPackages.isTaken = true;
					return bomPackages.getName();
				}
				// sinon on introspectionise
				if (!bomPackages.getPackages().isEmpty()) {
					String in = getMeADamnPackageName(bomPackages);
					if (in != null) {
						return in;
					}
				}
			}
			return null;
		} else {
				// on regarde si on prends le nom
				if (!pack.isTaken) {
					pack.isTaken = true;
					return pack.getName();
				}
				// sinon on introspectionise
				if (!pack.getPackages().isEmpty()) {
					String in = getMeADamnPackageName(pack);
					if (in != null) {
						return in;
					}
				}
			
			return null;
		}
		
		
	}

	public String getMeADamnTypeName(BOMPackages pack) {
		if (pack ==null) {
			
			for (BOMPackages bomPackages : model) {
				for(BOMClass bomclass : bomPackages.getClasses()) {
					if (!bomclass.istaken) {
						bomclass.istaken = true;
						return bomclass.getName();
					}
				}
			}
			return null;
		}
		return null;
	}
	
}
