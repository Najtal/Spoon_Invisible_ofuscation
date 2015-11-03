package dictionary;

public class ModelMethods {

	private String name;
	private Model model;
	private ModelClass parent;

	public ModelMethods(Model model, ModelClass parent, String name) {
		this.model = model;
		this.parent = parent;
		this.name = name;
	}

}
