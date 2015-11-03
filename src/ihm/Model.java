package ihm;

public class Model {

	private Controller controller;
	private View view;
	private String destDir;
	private String sourceDir;

	/**
	 * Constructeur
	 */
	public Model() {
		this.controller = new Controller(this);
		this.view = new View(this, controller);
	}
	
	
	public String getDestDir() {
		return destDir;
	}


	public String getSourceDir() {
		return sourceDir;
	}


	public void setDestDir(String text) {
		this.destDir = text;
	}

	public void setSourceDir(String text) {
		this.sourceDir = text;
	}

}
