package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener {
	
	private MainView mv;
	
	public Controller() {
		
		mv = new MainView();
		setListeners();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "Definir":
			System.out.println("Def");
			break;
		case "Aplicar":
			System.out.println("Apli");
			break;
		case "Salir":
			System.out.println("Sali");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		
		}
		
	}
	
	public void setListeners() {
		mv.getApplyTree().addActionListener(this);
		mv.getDefineTree().addActionListener(this);
		mv.getGoOut().addActionListener(this);
	}

}
