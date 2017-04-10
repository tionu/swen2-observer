package de.htwg.gib.swen2.observer;

public class Starter {

	public static void main(String[] args) {
		Model model = new Model();
		View bmiApp = new View(model);
		Controller controller = new Controller(model, bmiApp);
		model.addListener(bmiApp);
		bmiApp.addActionListener(controller);
		bmiApp.show();
	}

}
