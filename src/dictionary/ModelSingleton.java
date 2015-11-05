package dictionary;

public class ModelSingleton {

	private Model model;
	
	{
		model = new Model();
	}
	
	public Model getModel() {
		return model;
	}
	
	
}
