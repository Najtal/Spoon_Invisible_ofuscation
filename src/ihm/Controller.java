package ihm;

import controller.Initialisation;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void actionProceed() {
		new Initialisation(model.getSourceDir(),
				model.getModelDir(),
				model.getDestDir());
	}

	public void actionCancel() {
		System.exit(0);
	}
	
}
