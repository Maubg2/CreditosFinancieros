package co.edu.unbosque.model;

public class Node {
	
	private String inputVar;
	private String operator;
	private String value;
	
	private String condition;
	
	private Node left;
	private Node right;
	
	public Node(String condition) {
		this.condition = condition;
		left = null;
		right = null;
	}

}
