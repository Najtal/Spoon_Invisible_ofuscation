package ihm;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public static void actionProceed() {
		// TODO Appele le reste du programme
	}

	public static void actionCancel() {
		System.exit(0);
	}
	
}
