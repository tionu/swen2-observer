package de.htwg.gib.swen2.observer;

public enum BmiGradation {

	VERY_SEVERELY_UNDERWEIGHT("starkes Untergewicht", 16), SEVERELY_UNDERWEIGHT("m‰ﬂiges Untergewicht",
			17), UNDERWEIGHT("leichtes Untergewicht", 18.5), NORMAL_HEALTHY_WEIGHT("Normalgewicht", 25), OVERWEIGHT(
					"Pr‰adipositas", 30), OBESE_CLASS_I("Adipositas Grad I", 35), OBESE_CLASS_II("Adipositas Grad II",
							40), OBESE_CLASS_III("Adipositas Grad III", Double.MAX_VALUE);

	private final String name;
	private final double upperBound;

	BmiGradation(String name, double upperBound) {
		this.name = name;
		this.upperBound = upperBound;
	}

	public String getName() {
		return name;
	}

	public static BmiGradation getGradation(double bmiValue) {
		if (bmiValue < VERY_SEVERELY_UNDERWEIGHT.upperBound) {
			return VERY_SEVERELY_UNDERWEIGHT;
		} else if (bmiValue < SEVERELY_UNDERWEIGHT.upperBound) {
			return SEVERELY_UNDERWEIGHT;
		} else if (bmiValue < UNDERWEIGHT.upperBound) {
			return UNDERWEIGHT;
		} else if (bmiValue < NORMAL_HEALTHY_WEIGHT.upperBound) {
			return NORMAL_HEALTHY_WEIGHT;
		} else if (bmiValue < OVERWEIGHT.upperBound) {
			return OVERWEIGHT;
		} else if (bmiValue < OBESE_CLASS_I.upperBound) {
			return OBESE_CLASS_I;
		} else if (bmiValue < OBESE_CLASS_II.upperBound) {
			return OBESE_CLASS_II;
		} else if (bmiValue < OBESE_CLASS_III.upperBound) {
			return OBESE_CLASS_III;
		}
		return null;
	}

}
