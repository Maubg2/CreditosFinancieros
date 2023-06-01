package co.edu.unbosque.model;

import javax.swing.JOptionPane;

public class Tree {
	
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public void insertNode(String str, String inputVar, String operator, int value, String rule) {
		if(root == null) {
			root = new Node(str, inputVar, operator, value, rule);
		}else {
			insertNode(str, inputVar, operator, value, root, rule);
		}
	}
	
	public void deleteTree() {
		root = null;
	}
	
	public void insertNode(String str, String inputVar, String operator, int value, Node node, String rule) {
		if(str.equals("1")) {
			if(node.getLeft() == null) {
				node.setLeft(new Node(str, inputVar, operator, value, rule));
			}else {
				insertNode(str, inputVar, operator, value, node.getLeft(), rule);
			}
		}
		else if(str.equals("2")) {
			if(node.getLeft().getInputVar().equals(inputVar)) {
				node.getLeft().setRight(new Node(str, inputVar, operator, value, rule));
			}else {
				insertNode(str, inputVar, operator, value, node.getLeft(), rule);
			}
		}else {
			if(node.getRight() == null) {
				node.setRight(new Node(str, inputVar, operator, value, rule));
			}else {
				insertNode(str, inputVar, operator, value, node.getRight(), rule);
			}
		}
	}
	
	public void showTree(Node node) {
		int ageCasted = 0, incomeCasted = 0, amountCasted = 0, scoreCasted = 0;
		boolean finalized = false;
		
		if(node != null) {
			while(!finalized) {
				
				String age = JOptionPane.showInputDialog(null, "Digite su edad: ");
				
				try {
					ageCasted = Integer.parseInt(age);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				if(node.getOperator().equals("Mayor que")) {
					
					if(node.getRule().equals("1")) {
						
						if(ageCasted > node.getValue() && ageCasted <= 75) {
							node = node.getLeft();
						}
						
					}else if(node.getRule().equals("2")) {
						
						if(ageCasted > node.getValue() && ageCasted <= 75) {
							
						}
						
					}else if(node.getRule().equals("3")) {
						
					}
					
				/*	if(ageCasted > node.getValue() && ageCasted < 76) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}
					}else {
						
						JOptionPane.showMessageDialog(null, "Debe tener entre "+(node.getValue()+1)+" y 75 años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor que")) {
					if(ageCasted < node.getValue() && ageCasted >= 18) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y "+(node.getValue()-1)+" años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Mayor o igual que")) {
					if(ageCasted >= node.getValue() && ageCasted < 76) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe estar entre "+node.getValue()+" y 75 años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor o igual que")) {
					if(ageCasted <= node.getValue() && ageCasted >= 18) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y "+node.getValue()+" años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Diferente de")) {
					if(ageCasted != node.getValue() && ageCasted >= 18 && ageCasted <= 75) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe ser diferente de "+node.getValue()+" y entre los 18 y 75 años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else {
					System.out.println("Fallaaaa");
				}
				
				String income = JOptionPane.showInputDialog(null, "Escriba sus ingresos al mes: ");
				
				try {
					incomeCasted = Integer.parseInt(income);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				if(node.getOperator().equals("Mayor que")) {
					if(incomeCasted > node.getValue() && incomeCasted < 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes por lo menos "+(node.getValue()+1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor que")) {
					if(incomeCasted < node.getValue() && incomeCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes entre 1300.000 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Mayor o igual que")) {
					if(incomeCasted >= node.getValue() && incomeCasted < 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes por lo menos "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor o igual que")) {
					if(incomeCasted <= node.getValue() && incomeCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes entre 1300.000 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Diferente de")) {
					if(incomeCasted != node.getValue() && incomeCasted >= 1300000 && incomeCasted <= 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El ingreso mensual debe ser diferente de "+node.getValue()+" y mayor a 1300.000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}
				
				
				
				String amount = JOptionPane.showInputDialog(null, "Escriba el valor del crédito: ");
				
				try {
					amountCasted = Integer.parseInt(amount);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				if(node.getOperator().equals("Mayor que")) {
					if(amountCasted > node.getValue() && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
						System.out.println("sisi");
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre "+(node.getValue()+1)+" y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor que")) {
					if(amountCasted < node.getValue() && amountCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre 1300.000 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Mayor o igual que")) {
					if(amountCasted >= node.getValue() && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre "+node.getValue()+" y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor o igual que")) {
					if(amountCasted <= node.getValue() && amountCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre 1300.000 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Diferente de")) {
					if(amountCasted != node.getValue() && amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito diferente de "+node.getValue()+" y entre 1300.000 y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}
				
				
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String score = JOptionPane.showInputDialog(null, "Escriba su puntaje en centrales de riesgo: ");
				
				try {
					scoreCasted = Integer.parseInt(score);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				Node aux = node;
				
				if(node.getOperator().equals("Mayor que")) {
					if(scoreCasted > node.getValue() && scoreCasted <= 1000) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre "+(node.getValue()+1)+" y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor que")) {
					if(scoreCasted < node.getValue() && scoreCasted >= 500) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Mayor o igual que")) {
					if(scoreCasted >= node.getValue() && scoreCasted <= 1000) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre "+node.getValue()+" y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Menor o igual que")) {
					if(scoreCasted <= node.getValue() && scoreCasted >= 500) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}else if(node.getOperator().equals("Diferente de")) {
					if(scoreCasted != node.getValue() && scoreCasted >= 500 && scoreCasted <= 1000) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje no puede ser "+node.getValue()+" y debe estar entre 500 y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}
				}
				
				JOptionPane.showMessageDialog(null, node.getInputVar());
				finalized = true;
				
			}
			
		}
	}
	
	public void showTree() {
		showTree(root);
	}
	
}
