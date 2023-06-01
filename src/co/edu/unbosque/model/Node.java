package co.edu.unbosque.model;

public class Node {
	
	private String inputVar;
	private String operator;
	private int value;
	private String rule;
	
	private String condition;
	
	private Node left;
	private Node right;
	
	public Node(String condition, String inputVar, String operator, int value, String rule) {
		this.condition = condition;
		this.inputVar = inputVar;
		this.operator = operator;
		this.value = value;
		this.rule = rule;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

}
