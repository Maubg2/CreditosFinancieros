package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Tree;
import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener {
	
	private MainView mv;
	private Tree tree;
	
	public Controller() {
		
		mv = new MainView();
		tree = new Tree();
		setListeners();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "Definir":
			
			try {
				
				String ageOperator, ageLimit;
				String incomeOperator, incomeLimit;
				String amountOperator, amountLimit;
				String scoreOperator, scoreLimit;
				
				mv.getFieldForOptionDefine().setText("Ejemplo: 18");
				mv.getLabelInputVar().setText("Edad: ");
				
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine());
				ageOperator = (String)mv.getOptionsDefine().getSelectedItem();
				ageLimit = mv.getFieldForOptionDefine().getText();
				int ageLimitCasted = Integer.parseInt(ageLimit);
				
				if(ageLimitCasted < 18 || ageLimitCasted > 75) {
					JOptionPane.showMessageDialog(null, "La edad debe estar entre los 18 y 75 años");
					break;
				}
				if((ageLimitCasted == 18 && ageOperator.equals("Menor que")) || (ageLimitCasted == 75 && ageOperator.equals("Mayor que"))) {
					JOptionPane.showMessageDialog(null, "La edad debe estar entre los 18 y 75 años");
					break;
				}
				tree.insertNode("1", "Edad", ageOperator, ageLimit);
				
				
				
				
				mv.getFieldForOptionDefine().setText("Ejemplo: 1500000");
				mv.getLabelInputVar().setText("Ingresos: ");
				
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				incomeOperator = (String)mv.getOptionsDefine().getSelectedItem();
				incomeLimit = mv.getFieldForOptionDefine().getText();
				int incomeLimitCasted = Integer.parseInt(incomeLimit);
				
				if(incomeLimitCasted < 1300000) {
					JOptionPane.showMessageDialog(null, "Debe ganar por lo menos un salario minimo");
					break;
				}
				if(incomeLimitCasted == 1300000 && incomeOperator.equals("Menor que")) {
					JOptionPane.showMessageDialog(null, "Debe ganar por lo menos un salario minimo");
					break;
				}
				if(incomeLimitCasted > 100000000) {
					JOptionPane.showMessageDialog(null, "Ingresos exagerados");
					break;
				}
				tree.insertNode("1", "Ingresos", incomeOperator, incomeLimit);
				
				
				
				mv.getFieldForOptionDefine().setText("Ejemplo: 7500000");
				mv.getLabelInputVar().setText("Monto solicitado: ");
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				amountOperator = (String)mv.getOptionsDefine().getSelectedItem();
				amountLimit = mv.getFieldForOptionDefine().getText();
				int amountLimitCasted = Integer.parseInt(amountLimit);
				
				if(amountLimitCasted > incomeLimitCasted*5) {
					JOptionPane.showMessageDialog(null, "El monto solicitado debe ser menor a cinco veces los ingresos del solicitante ("+(incomeLimitCasted*5)+")");
					break;
				}
				if(amountLimitCasted == incomeLimitCasted*5 && amountOperator.equals("Menor que")) {
					JOptionPane.showMessageDialog(null, "El monto solicitado debe ser menor a cinco veces los ingresos del solicitante ("+(incomeLimitCasted*5)+")");
					break;
				}
				if(amountLimitCasted < 1300000) {
					JOptionPane.showMessageDialog(null, "No se puede solicitar menos de un salario minimo");
					break;
				}
				tree.insertNode("1", "Monto solicitado", amountOperator, amountLimit);
				
				
				//0-500 riesgo alto
				//501-600 riesgo medio alto
				//601-750 riesgo medio
				//751-1000 bajo riesgo 
				mv.getFieldForOptionDefine().setText("Ejemplo: 500");
				mv.getLabelInputVar().setText("Ptos centrales de riesgo: ");
				JOptionPane.showOptionDialog(null, mv.getPanelAux(), "Requisitos para el crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, mv.getArrForOptionsDefine()[0]);
				scoreOperator = (String)mv.getOptionsDefine().getSelectedItem();
				scoreLimit = mv.getFieldForOptionDefine().getText();
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
				
				tree.insertNode("1", "Puntaje centrales de riesgo", scoreOperator, scoreLimit);
				tree.insertNode("2", "Puntaje centrales de riesgo", scoreOperator, scoreLimit);
				
				
			}catch(NumberFormatException ee) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número en el segundo campo");
				break;
			}
			
			break;
		case "Aplicar":
			
			tree.showInOrder();
			
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
