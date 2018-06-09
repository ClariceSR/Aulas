package jogo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class Game extends JFrame{
	
	public Game(){
	
		add(new JogoEspaco());
		setTitle("Meu Primeiro Jogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,420);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	
}
