package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainView extends JFrame{
	
	private JPanel panelAux;
	private JTextField fieldForOptionDefine;
	private JLabel labelInputVar;
	
	private JPanel panel;
	private JLabel title;
	private JButton defineTree;
	private JButton applyTree;
	private JButton goOut;
	private JComboBox<String> optionsDefine;
	private String arrForOptionsDefine[] = {"Mayor que", "Menor que", "Mayor o igual que", "Menor o igual que", "Diferente de"};
	
	private Font font = new Font("Tahoma", Font.BOLD, 15);
	
	public MainView() {
		execute();
		getContentPane().setLayout(null);
		setTitle("Creditos financieros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void execute() {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		
		title = new JLabel("Creditos financieros");
	//	title.setFont(font);
		title.setBounds(250, 20, 280, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(title);
		
		defineTree = new JButton("Definir");
		defineTree.setBounds(120, 400, 100, 30);
		defineTree.setFont(font);
		defineTree.setBackground(Color.BLACK);
		defineTree.setForeground(Color.WHITE);
		panel.add(defineTree);
		
		applyTree = new JButton("Aplicar");
		applyTree.setBounds(330, 400, 100, 30);
		applyTree.setFont(font);
		applyTree.setBackground(Color.BLACK);
		applyTree.setForeground(Color.WHITE);
		panel.add(applyTree);
		
		goOut = new JButton("Salir");
		goOut.setBounds(540, 400, 100, 30);
		goOut.setFont(font);
		goOut.setBackground(Color.BLACK);
		goOut.setForeground(Color.WHITE);
		panel.add(goOut);
		
		optionsDefine = new JComboBox<>(arrForOptionsDefine);
		panel.add(optionsDefine);
		
		//Panel para la opción definir árbol
		panelAux = new JPanel();
		fieldForOptionDefine = new JTextField();
		fieldForOptionDefine.setSize(40, 40);
		labelInputVar = new JLabel();
		
		panelAux.add(labelInputVar);
		panelAux.add(optionsDefine);
		panelAux.add(fieldForOptionDefine);
		
	}
	
	public JButton getDefineTree() {
		return defineTree;
	}

	public void setDefineTree(JButton defineTree) {
		this.defineTree = defineTree;
	}

	public JButton getApplyTree() {
		return applyTree;
	}

	public void setApplyTree(JButton applyTree) {
		this.applyTree = applyTree;
	}

	public JButton getGoOut() {
		return goOut;
	}

	public void setGoOut(JButton goOut) {
		this.goOut = goOut;
	}

	public JComboBox<String> getOptionsDefine() {
		return optionsDefine;
	}

	public void setOptionsDefine(JComboBox<String> optionsDefine) {
		this.optionsDefine = optionsDefine;
	}

	public String[] getArrForOptionsDefine() {
		return arrForOptionsDefine;
	}

	public void setArrForOptionsDefine(String[] arrForOptionsDefine) {
		this.arrForOptionsDefine = arrForOptionsDefine;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanelAux() {
		return panelAux;
	}

	public void setPanelAux(JPanel panelAux) {
		this.panelAux = panelAux;
	}

	public JTextField getFieldForOptionDefine() {
		return fieldForOptionDefine;
	}

	public void setFieldForOptionDefine(JTextField fieldForOptionDefine) {
		this.fieldForOptionDefine = fieldForOptionDefine;
	}

	public JLabel getLabelInputVar() {
		return labelInputVar;
	}

	public void setLabelInputVar(JLabel labelInputVar) {
		this.labelInputVar = labelInputVar;
	}

}
