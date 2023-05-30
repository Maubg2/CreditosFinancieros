package co.edu.unbosque.model;

public class Node {
	
	private String inputVar;
	private String operator;
	private String value;
	
	private String condition;
	
	private Node left;
	private Node right;
	
	public Node(String condition, String inputVar, String operator, String value) {
		this.condition = condition;
		this.inputVar = inputVar;
		this.operator = operator;
		this.value = value;
		left = null;
		right = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getInputVar() {
		return inputVar;
	}

	public void setInputVar(String inputVar) {
		this.inputVar = inputVar;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
