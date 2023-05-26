package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame{
	
	private JPanel panel;
	private JLabel title;
	
	public MainView() {
		execute();
		getContentPane().setLayout(null);
		setTitle("Creditos financieros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void execute() {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 665, 389);
		getContentPane().add(panel);
		
		title = new JLabel("Creditos financieros");
		title.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(title);
		
	}

}
