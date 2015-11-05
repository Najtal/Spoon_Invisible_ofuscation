package dictionary;

public class BOMAttribute {

	private Model model;
	private BOMClass parent;
	private String name;

	public BOMAttribute(Model model, BOMClass parent, String name) {
		this.model = model;
		this.parent = parent;
		this.name = name;	}

}
