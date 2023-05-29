package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame{
	
	private JPanel panel;
	private JLabel title;
	private JButton defineTree;
	private JButton applyTree;
	private JButton goOut;
	
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

}
