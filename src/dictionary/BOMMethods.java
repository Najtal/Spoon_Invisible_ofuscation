package dictionary;

public class BOMMethods {

	private String name;
	private Model model;
	private BOMClass parent;

	public BOMMethods(Model model, BOMClass parent, String name) {
		this.model = model;
		this.parent = parent;
		this.name = name;
	}

}
