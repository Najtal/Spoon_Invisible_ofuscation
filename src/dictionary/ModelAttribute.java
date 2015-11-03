package dictionary;

public class ModelAttribute {

	private Model model;
	private ModelClass parent;
	private String name;

	public ModelAttribute(Model model, ModelClass parent, String name) {
		this.model = model;
		this.parent = parent;
		this.name = name;	}

}
