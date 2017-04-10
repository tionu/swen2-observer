package de.htwg.gib.swen2.observer;

import java.util.LinkedList;
import java.util.List;

public class Model {

	public interface ModelListener {
		public void modelChanged();
	}

	private List<ModelListener> listeners;
	private double height;
	private double weight;
	private double bmi;
	private BmiGradation bmiGradation;

	public Model() {
		this.listeners = new LinkedList<>();
		resetValues();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public BmiGradation getBmiGradation() {
		return bmiGradation;
	}

	public void calculateBmi() {
		bmi = weight / ((height / 100) * (height / 100));
		bmiGradation = BmiGradation.getGradation(bmi);
		modelChanged();
	}

	public void resetValues() {
		height = 0;
		weight = 0;
		bmi = 0;
		bmiGradation = null;
		modelChanged();
	}

	public void addListener(ModelListener listener) {
		listeners.add(listener);
	}

	private void modelChanged() {
		for (ModelListener listener : listeners)
			listener.modelChanged();
	}
}
