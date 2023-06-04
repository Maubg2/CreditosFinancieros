package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalIconFactory.TreeFolderIcon;

import co.edu.unbosque.model.Tree;
import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener {
	
	private MainView mv;
	private Tree tree;
	
	private String ageOperator, ageLimit;
	private String incomeOperator, incomeLimit;
	private String amountOperator, amountLimit;
	private String scoreOperator, scoreLimit;
	
	private boolean treeDefine = false;
	
	public Controller() {
		
		mv = new MainView();
		tree = new Tree();
		setListeners();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "Definir":
			
			tree.deleteTree();
			
			try {
				
				//Se setean los campos cada variable
				mv.getFieldForOptionDefine().setText("      ");
				mv.getLabelInputVar().setText("Edad: ");
				
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine());
				ageOperator = (String)mv.getOptionsDefine().getSelectedItem();
				ageLimit = mv.getFieldForOptionDefine().getText().trim();
				int ageLimitCasted = Integer.parseInt(ageLimit);
				
				//La edad para sacar un crédito va a estar entre 18 y 75 años
				if(ageLimitCasted < 18 || ageLimitCasted > 75) {
					JOptionPane.showMessageDialog(null, "La edad debe estar entre los 18 y 75 años");
					break;
				}
				if((ageLimitCasted == 18 && ageOperator.equals("Menor que")) || (ageLimitCasted == 75 && ageOperator.equals("Mayor que"))) {
					JOptionPane.showMessageDialog(null, "La edad debe estar entre los 18 y 75 años");
					break;
				}
				
				String ageOptions = JOptionPane.showInputDialog("Si la edad del solicitante es "+ageOperator+" "+ageLimit+": \n"
						+ "1. Conectar con la siguiente premisa\n"
						+ "2. Rechazar\n"
						+ "3. No sé que hacer");
				
				if(!ageOptions.matches("[1-3]{1}")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor de 1 a 3");
					break;
				}
				
				tree.insertNode("1", "Edad", ageOperator, ageLimitCasted, ageOptions);
				tree.insertNode("3", "Edad", "Crédito rechazado", 0, ageOptions);
				
				
				
				mv.getFieldForOptionDefine().setText("      ");
				mv.getLabelInputVar().setText("Ingresos: ");
				
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				incomeOperator = (String)mv.getOptionsDefine().getSelectedItem();
				incomeLimit = mv.getFieldForOptionDefine().getText().trim();
				int incomeLimitCasted = Integer.parseInt(incomeLimit);
				
				if(incomeLimitCasted < 1300000) {
					JOptionPane.showMessageDialog(null, "Debe ganar por lo menos un salario minimo (1300.000)");
					break;
				}
				if(incomeLimitCasted == 1300000 && incomeOperator.equals("Menor que")) {
					JOptionPane.showMessageDialog(null, "Debe ganar por lo menos un salario minimo (1300.000)");
					break;
				}
				if(incomeLimitCasted > 100000000) {
					JOptionPane.showMessageDialog(null, "Ingresos exagerados");
					break;
				}
				
				String incomeOptions = JOptionPane.showInputDialog("Si el ingreso mensual del solicitante es "+incomeOperator+" "+incomeLimit+": \n"
						+ "1. Conectar con la siguiente premisa\n"
						+ "2. Rechazar\n"
						+ "3, No sé que hacer");
				
				if(!incomeOptions.matches("[1-3]{1}")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor de 1 a 3");
					break;
				}
				
				tree.insertNode("1", "Ingresos", incomeOperator, incomeLimitCasted, incomeOptions);
				tree.insertNode("2", "Ingresos", "Crédito rechazado", 0, incomeOptions);
				
				
				mv.getFieldForOptionDefine().setText("        ");
				mv.getLabelInputVar().setText("Monto solicitado: ");
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				amountOperator = (String)mv.getOptionsDefine().getSelectedItem();
				amountLimit = mv.getFieldForOptionDefine().getText().trim();
				int amountLimitCasted = Integer.parseInt(amountLimit);
				
				if(amountLimitCasted > incomeLimitCasted*5) {
					JOptionPane.showMessageDialog(null, "El monto solicitado debe ser menor a cinco veces los ingresos del solicitante ("+(incomeLimitCasted*5)+")");
					break;
				}
				if(amountLimitCasted == incomeLimitCasted*5 && amountOperator.equals("Mayor que")) {
					JOptionPane.showMessageDialog(null, "El monto solicitado debe ser menor a cinco veces los ingresos del solicitante ("+(incomeLimitCasted*5)+")");
					break;
				}
				if(amountLimitCasted < 1300000) {
					JOptionPane.showMessageDialog(null, "No se puede solicitar menos de un salario minimo");
					break;
				}
				
				String amountOptions = JOptionPane.showInputDialog("Si el monto del solicitante es "+amountOperator+" "+amountLimit+": \n"
						+ "1. Conectar con la siguiente premisa\n"
						+ "2. Rechazar\n"
						+ "3. No sé que hacer");
				
				if(!amountOptions.matches("[1-3]{1}")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor de 1 a 3");
					break;
				}
				
				tree.insertNode("1", "Monto solicitado", amountOperator, amountLimitCasted, amountOptions);
				tree.insertNode("2", "Monto solicitado", "Crédito rechazado", 0, amountOptions);
				
				mv.getFieldForOptionDefine().setText("       ");
				mv.getLabelInputVar().setText("Ptos centrales de riesgo: ");
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				scoreOperator = (String)mv.getOptionsDefine().getSelectedItem();
				scoreLimit = mv.getFieldForOptionDefine().getText().trim();
				int scoreLimitCasted = Integer.parseInt(scoreLimit);
				
				if(scoreLimitCasted < 500) {
					JOptionPane.showMessageDialog(null, "El puntaje en centrales de riesgo debe ser por lo menos 500");
					break;
				}
				if(scoreLimitCasted > 1000) {
					JOptionPane.showMessageDialog(null, "El puntaje va hasta 1000");
					break;
				}
				if((scoreLimitCasted == 500 && scoreOperator.equals("Menor que")) || (scoreLimitCasted == 1000 && scoreOperator.equals("Mayor que"))) {
					JOptionPane.showMessageDialog(null, "Un puntaje aceptado está entre 500 y 1000");
					break;
				}
				
				String scoreOptions = JOptionPane.showInputDialog("Si el puntaje de centrales de riesgo del usuario es "+scoreOperator+" "+scoreLimit+": \n"
						+ "1. Conectar con la siguiente premisa\n"
						+ "2. Rechazar\n"
						+ "3. No sé que hacer");
				
				if(!scoreOptions.matches("[1-3]{1}")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor de 1 a 3");
					break;
				}
				
				tree.insertNode("1", "Puntaje centrales de riesgo", scoreOperator, scoreLimitCasted, scoreOptions);
				tree.insertNode("2", "Puntaje centrales de riesgo", "Crédito rechazado", 0, scoreOptions);
				//	tree.insertNode("2", "Puntaje centrales de riesgo", scoreOperator, scoreLimitCasted);
				
				JOptionPane.showMessageDialog(null, "Definiciones del árbol creadas correctamente");
				treeDefine = true;
				
			}catch(NumberFormatException ee) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número en el segundo campo");
				break;
			}
			
			break;
		case "Aplicar":
			
			if(treeDefine) {
				tree.showTree();
			}else {
				JOptionPane.showMessageDialog(null, "Debe definir primero el árbol");
			}
			
			break;
		case "Salir":
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		
		}
	
	}
	
	public void setListeners() {
		mv.getApplyTree().addActionListener(this);
		mv.getDefineTree().addActionListener(this);
		mv.getGoOut().addActionListener(this);
	}

}
