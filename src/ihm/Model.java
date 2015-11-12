package ihm;

public class Model {

	private Controller controller;
	private View view;
	private String destDir;
	private String sourceDir;
	private String modelDir;

	/**
	 * Constructeur
	 */
	public Model() {
		this.controller = new Controller(this);
		this.view = new View(this, controller);
	}
	
	public Model(String sourceDir, String modelDir, String destDir) {
		setDestDir(destDir);
		setSourceDir(sourceDir);
		setModelDir(modelDir);
	}
	
	
	/*
	 * GETTERS
	 */
	
	public String getDestDir() {
		return destDir;
	}

	public String getSourceDir() {
		return sourceDir;
	}
	
	public String getModelDir() {
		return modelDir;
	}

	
	/*
	 * SETTERS
	 */
	
	public void setDestDir(String text) {
		this.destDir = text;
	}

	public void setSourceDir(String text) {
		this.sourceDir = text;
	}

	public void setModelDir(String text) {
		this.modelDir = text;
	}

}
