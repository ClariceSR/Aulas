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
	
		add(new JogoCoelho());
		setTitle("Joguinho Coelho vs Raposa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fecha a janela qnd o usuario clicar no x
		setSize(511,372);// largura e altura
		setLocationRelativeTo(null);//aonde a janela aprece, colocando null fica no meio da tela
		setResizable(false);// o usuario nao redimeciona minimiza maximiza 
		setVisible(true);//aparecer a janela
		
	}
	
	
}
