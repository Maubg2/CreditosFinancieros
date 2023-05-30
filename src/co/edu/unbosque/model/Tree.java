package co.edu.unbosque.model;

import javax.swing.JOptionPane;

public class Tree {
	
	private Node root;

	public Tree() {
		root = null;
	}
	
	public void insertNode(String str, String inputVar, String operator, String value) {
		if(root == null) {
			root = new Node(str, inputVar, operator, value);
		}else {
			insertNode(str, inputVar, operator, value, root);
		}
	}
	
	public void insertNode(String str, String inputVar, String operator, String value, Node node) {
		if(str.equals("1")) {
			if(node.getLeft() == null) {
				node.setLeft(new Node(str, inputVar, operator, value));
			}else {
				insertNode(str, inputVar, operator, value, node.getLeft());
			}
		}
		else if(str.equals("2")) {
			if(node.getLeft().getInputVar().equals(inputVar)) {
				node.getLeft().setRight(new Node(str, inputVar, operator, value));
			}else {
				insertNode(str, inputVar, operator, value, node.getLeft());
			}
		}else {
			if(node.getRight() == null) {
				node.setRight(new Node(str, inputVar, operator, value));
			}else {
				insertNode(str, inputVar, operator, value, node.getRight());
			}
		}
	}
	
	public void showInOrder(Node node) {
		if(node != null) {
			String i = JOptionPane.showInputDialog(null, "¿Su edad es "+node.getOperator()+" "+node.getValue()+"?\n"
					+ "1. Si\n"
					+ "2. No\n");
			
			showInOrder(node.getLeft());
		}
	}
	
	public void showInOrder() {
		showInOrder(root);
	}
	
}
