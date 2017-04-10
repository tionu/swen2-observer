package de.htwg.gib.swen2.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void actionPerformed(ActionEvent event) {
		view.writeToModel();
		switch (event.getActionCommand()) {
		case "CALCULATE":
			model.calculateBmi();
			break;
		case "RESET":
			model.resetValues();
			break;
		}
	}

}
