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
					if(ageCasted > node.getValue() && ageCasted <= 75) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							//se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser de 18 a "+node.getValue()+" años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							// no se que hacer 
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser de "+(node.getValue()+1)+" a 75 años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							//SIguiemte premisa
							if(ageCasted >= 18 && ageCasted <= 75) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "No tiene una edad apta para obtener el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
						
					}
				}else if(node.getOperator().equals("Menor que")) {
					if(ageCasted < node.getValue() && ageCasted >= 18) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "La edad debe ser de "+node.getValue()+" a 75 años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser de 18 a "+node.getValue()+" años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(ageCasted >=18 && ageCasted <= 75) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "No tiene una edad apta para obtener el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
				}else if(node.getOperator().equals("Mayor o igual que")) {
					
					if(ageCasted >= node.getValue() && ageCasted <= 75) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "La edad debe ser de 18 a "+(node.getValue()-1)+" años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser de "+node.getValue()+" a 75 años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(ageCasted >= 18 && ageCasted <= 75) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Edad no apta para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
				/*	if(ageCasted >= node.getValue() && ageCasted < 76) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe estar entre "+node.getValue()+" y 75 años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
					
				}else if(node.getOperator().equals("Menor o igual que")) {
					
					if(ageCasted <= node.getValue() && ageCasted >= 18) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "La edad debe ser de "+(node.getValue()+1)+" a 75 años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser de 18 a "+(node.getValue())+" años");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(ageCasted >= 18 && ageCasted <= 75) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "La edad no es apta para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
			/*		if(ageCasted <= node.getValue() && ageCasted >= 18) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y "+node.getValue()+" años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Diferente de")) {
					
					if(ageCasted != node.getValue() && ageCasted >= 18 && ageCasted <= 75) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "La edad debe ser "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "La edad debe ser diferente de "+node.getValue()+" y en el rango permitido (18 a 75 años)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(ageCasted >= 18 && ageCasted <= 75) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Edad no apta para obtener el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}	
					
				/*	if(ageCasted != node.getValue() && ageCasted >= 18 && ageCasted <= 75) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "La edad debe ser diferente de "+node.getValue()+" y entre los 18 y 75 años");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}
				
				String income = JOptionPane.showInputDialog(null, "Escriba sus ingresos al mes: ");
				
				try {
					incomeCasted = Integer.parseInt(income);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				if(node.getOperator().equals("Mayor que")) {
					
					if(incomeCasted > node.getValue() && incomeCasted < 100000000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "Sus ingresos mensuales deben ser de 1300.000 a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "Sus ingresos mensuales deben ser mayores a "+(node.getValue()+1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(incomeCasted >= 1300000 && incomeCasted <= 100000000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Sus ingresos no son aptos para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(incomeCasted > node.getValue() && incomeCasted < 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes por lo menos "+(node.getValue()+1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor que")) {
					
					if(incomeCasted < node.getValue() && incomeCasted >= 1300000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser mayores o iguales a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser de 1300.000 a "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(incomeCasted >= 1300000 && incomeCasted <= 100000000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Sus ingresos no son aptos para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(incomeCasted < node.getValue() && incomeCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes entre 1300.000 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Mayor o igual que")) {
					
					if(incomeCasted >= node.getValue() && incomeCasted < 100000000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser de 1300.000 a "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser desde "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(incomeCasted >= 1300000 && incomeCasted <= 100000000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Sus ingresos no son aptos para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(incomeCasted >= node.getValue() && incomeCasted < 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes por lo menos "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor o igual que")) {
					
					if(incomeCasted <= node.getValue() && incomeCasted >= 1300000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser de por lo menos "+(node.getValue()+1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "Sus ingresos deben ser de 1300.000 a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(incomeCasted >= 1300000 && incomeCasted <= 100000000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Sus ingresos no son aptos para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(incomeCasted <= node.getValue() && incomeCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Debe ganar al mes entre 1300.000 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Diferente de")) {
					
					if(incomeCasted != node.getValue() && incomeCasted >= 1300000 && incomeCasted <= 100000000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "Su salario debe ser "+node.getValue()+ " y mayor a 1300.000 (salario minimo)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "Su salario debe ser diferente de "+node.getValue()+" y mayor a 1300.000");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(incomeCasted >= 1300000 && incomeCasted <= 100000000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Sus ingresos no son aptos para recibir el crédito");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(incomeCasted != node.getValue() && incomeCasted >= 1300000 && incomeCasted <= 100000000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El ingreso mensual debe ser diferente de "+node.getValue()+" y mayor a 1300.000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}
				
				
				
				String amount = JOptionPane.showInputDialog(null, "Escriba el valor del crédito: ");
				
				try {
					amountCasted = Integer.parseInt(amount);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				if(node.getOperator().equals("Mayor que")) {
					
					if(amountCasted > node.getValue() && amountCasted <= (incomeCasted*5)) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El monto debe ser de 1300.000 a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El monto debe ser de "+(node.getValue()+1)+" a "+(incomeCasted*5)+" (cinco veces su salario)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Monto solicitado no permitido");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(amountCasted > node.getValue() && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
						System.out.println("sisi");
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre "+(node.getValue()+1)+" y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor que")) {
					
					if(amountCasted < node.getValue() && amountCasted >= 1300000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de "+node.getValue()+" a "+(incomeCasted*5)+" (cinco veces su salario)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de 1300000 a "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Monto solicitado no permitido");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(amountCasted < node.getValue() && amountCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre 1300.000 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Mayor o igual que")) {
					
					if(amountCasted >= node.getValue() && amountCasted <= (incomeCasted*5)) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de 1300.000 a "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de "+node.getValue()+" a "+(incomeCasted*5)+" (cinco veces su salario)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Monto solicitado no permitido");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(amountCasted >= node.getValue() && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre "+node.getValue()+" y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor o igual que")) {
					
					if(amountCasted <= node.getValue() && amountCasted >= 1300000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de "+(node.getValue()+1)+" a "+(incomeCasted*5)+" (cinco veces su salario)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser de 1300.000 a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Monto solicitado no permitido");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(amountCasted <= node.getValue() && amountCasted >= 1300000) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito entre 1300.000 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Diferente de")) {
					
					if(amountCasted != node.getValue() && amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser "+amountCasted+ " y en el rango permitido (1300.000 a "+(incomeCasted*5)+")");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El monto solicitado debe ser diferente de "+node.getValue()+" y en el rango permitido (1300.000 a "+(incomeCasted*5)+")");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Monto solicitado no permitido");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(amountCasted != node.getValue() && amountCasted >= 1300000 && amountCasted <= (incomeCasted*5)) {
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "Puede pedir el crédito diferente de "+node.getValue()+" y entre 1300.000 y "+(incomeCasted*5));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}
				
				String score = JOptionPane.showInputDialog(null, "Escriba su puntaje en centrales de riesgo: ");
				
				try {
					scoreCasted = Integer.parseInt(score);
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				}
				
				Node aux = node;
				
				if(node.getOperator().equals("Mayor que")) {
					
					if(scoreCasted > node.getValue() && scoreCasted <= 1000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El puntaje debe estar entre "+(node.getValue()+1)+" y 1000");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(scoreCasted >= 500 && scoreCasted <= 1000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Puntaje fuera de los limites permitidos");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(scoreCasted > node.getValue() && scoreCasted <= 1000) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre "+(node.getValue()+1)+" y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor que")) {
					
					if(scoreCasted < node.getValue() && scoreCasted >= 500) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El puntaje debe estar de "+node.getValue()+" a 1000");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(scoreCasted >= 500 && scoreCasted <= 1000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Puntaje fuera de los limites permitidos");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(scoreCasted < node.getValue() && scoreCasted >= 500) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+(node.getValue()-1));
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Mayor o igual que")) {
					
					if(scoreCasted >= node.getValue() && scoreCasted <= 1000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El puntaje debe ser de 500 a "+(node.getValue()-1));
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El puntaje debe ser de "+node.getValue()+" a 1000");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(scoreCasted >= 500 && scoreCasted <= 1000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Puntaje fuera de los limites permitidos");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(scoreCasted >= node.getValue() && scoreCasted <= 1000) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre "+node.getValue()+" y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Menor o igual que")) {
					
					if(scoreCasted <= node.getValue() && scoreCasted >= 500) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El puntaje debe ser de "+(node.getValue()+1)+" a 1000");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El puntaje debe ser de 500 a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(scoreCasted >= 500 && scoreCasted <= 1000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Puntaje fuera de los limites permitidos");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
					/*
					if(scoreCasted <= node.getValue() && scoreCasted >= 500) {
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje debe estar entre 500 y "+node.getValue());
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
				}else if(node.getOperator().equals("Diferente de")) {
					
					if(scoreCasted != node.getValue() && scoreCasted >= 500 && scoreCasted <= 1000) {
						if(node.getRule().equals("1")) {
							node = node.getLeft();
						}else if(node.getRule().equals("2")) {
							JOptionPane.showMessageDialog(null, "El puntaje debe ser "+node.getValue()+ " y estar en el rango permitido (500 a 1000)");
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("3")) {
							node = node.getRight();
							node.setOperator("No sé que hacer");
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}else {
						if(node.getRule().equals("1")) {
							//Se rechaza
							JOptionPane.showMessageDialog(null, "El puntaje debe ser diferente a "+node.getValue());
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}else if(node.getRule().equals("2")) {
							if(scoreCasted >= 500 && scoreCasted <= 1000) {
								node = node.getLeft();
							}else {
								JOptionPane.showMessageDialog(null, "Puntaje fuera de los limites permitidos");
								break;
							}
						}else if(node.getRule().equals("3")) {
							//Rechazar
							node = node.getRight();
							JOptionPane.showMessageDialog(null, node.getOperator());
							break;
						}
					}
					
				/*	if(scoreCasted != node.getValue() && scoreCasted >= 500 && scoreCasted <= 1000) {
						
						insertNode("1", "Crédito aprobado con el valor de "+amountCasted, null, amountCasted, null);
						node = node.getLeft();
					}else {
						JOptionPane.showMessageDialog(null, "El puntaje no puede ser "+node.getValue()+" y debe estar entre 500 y 1000");
						node = node.getRight();
						JOptionPane.showMessageDialog(null, node.getOperator());
						break;
					}*/
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
