package de.htwg.gib.swen2.observer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import de.htwg.gib.swen2.observer.Model.ModelListener;

public class View implements ModelListener {

	private Model model;
	private JFrame frame;
	private JPanel panel;
	private GridLayout panelLayout;
	private JPanel controls;
	private JLabel heightLabel;
	private JFormattedTextField heightField;
	private JLabel heightUnit;
	private JLabel weightLabel;
	private JFormattedTextField weightField;
	private JLabel weightUnit;
	private JLabel bmiLabel;
	private JTextField bmiField;
	private JLabel bmiUnit;
	private JLabel classificationLabel;
	private JTextField classificationField;
	private JButton buttonCalculate;
	private JButton buttonReset;
	private NumberFormat numberFormat;

	public View(Model model) {
		this.model = model;
		numberFormat = NumberFormat.getIntegerInstance();
		frame = new JFrame("BMI Rechner");
		frame.setLayout(new BorderLayout());
		panel = new JPanel();
		panelLayout = new GridLayout(5, 3);
		panelLayout.setHgap(7);
		panelLayout.setVgap(7);
		panel.setLayout(panelLayout);
		controls = new JPanel();
		controls.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		heightLabel = new JLabel("Größe");
		heightField = new JFormattedTextField(numberFormat);
		heightUnit = new JLabel("cm");
		weightLabel = new JLabel("Gewicht");
		weightField = new JFormattedTextField(numberFormat);
		weightUnit = new JLabel("kg");
		bmiLabel = new JLabel("BMI");
		bmiField = new JTextField();
		bmiUnit = new JLabel("kg/m^2");
		classificationLabel = new JLabel("Klassifikation");
		classificationField = new JTextField();
		buttonCalculate = new JButton("Berechnen");
		buttonReset = new JButton("Maske löschen");
	}

	public void show() {
		readFromModel();
		buttonCalculate.setActionCommand("CALCULATE");
		buttonReset.setActionCommand("RESET");
		bmiField.setEditable(false);
		classificationField.setEditable(false);

		panel.setBorder(BorderFactory.createEmptyBorder(16, 12, 0, 0));
		panel.add(heightLabel);
		panel.add(heightField);
		panel.add(heightUnit);
		panel.add(weightLabel);
		panel.add(weightField);
		panel.add(weightUnit);
		panel.add(bmiLabel);
		panel.add(bmiField);
		panel.add(bmiUnit);
		panel.add(classificationLabel);
		panel.add(classificationField);
		controls.add(buttonCalculate);
		controls.add(buttonReset);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(controls, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(430, frame.getHeight());
		frame.setVisible(true);
	}

	public void modelChanged() {
		readFromModel();
	}

	private void readFromModel() {
		heightField.setText(model.getHeight() == 0 ? "" : new DecimalFormat("#").format(model.getHeight()));
		weightField.setText(model.getWeight() == 0 ? "" : new DecimalFormat("#").format(model.getWeight()));
		bmiField.setText(model.getBmi() == 0 ? "-" : new DecimalFormat("#.##").format(model.getBmi()));
		classificationField.setText(model.getBmiGradation() == null ? "-" : model.getBmiGradation().getName());
	}

	public void writeToModel() {
		model.setHeight(heightField.getText().equals("") ? 0 : Integer.parseInt(heightField.getText()));
		model.setWeight(weightField.getText().equals("") ? 0 : Integer.parseInt(weightField.getText()));
	}

	public void addActionListener(ActionListener listener) {
		buttonCalculate.addActionListener(listener);
		buttonReset.addActionListener(listener);
	}

}
