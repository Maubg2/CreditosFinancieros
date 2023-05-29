package co.edu.unbosque.model;

public class Tree {
	
	private Node root;

	public Tree() {
		root = null;
	}
	
	public void insertNode(String str) {
		if(root == null) {
			root = new Node(str);
		}else {
			insertNode(str, root);
		}
	}
	
	public void insertNode(String str, Node node) {
		
	}
	
}
