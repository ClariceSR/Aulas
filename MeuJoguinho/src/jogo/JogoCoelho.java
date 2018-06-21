package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JogoCoelho extends JPanel implements ActionListener {

	private Image fundo;
	private Image imgRaposa;
	private Image imgCenoura;
	private Image imgCoelho;
	private Timer timer;//p atualizar a tela
	private Coelho coelho;
	
	private int pontos = 0;
	private int contador = 0;
	private boolean active;
	
	private List<Personagem> cenouras;
	private List<Personagem> raposas;
	

	public JogoCoelho() {

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon referencia = new ImageIcon("res\\background.png");
		fundo = referencia.getImage();
		coelho = new Coelho();

		active = true;

		inicializaPersonagens();

		timer = new Timer(5, this);//delay 5 milisegundo ele chama uma ação dessa classe
		timer.start();	// precisa actionlistener		
	}
	
	public int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}
	

	public void inicializaPersonagens() {

		cenouras = new ArrayList<Personagem>();
		raposas = new ArrayList<Personagem>();

		for (int i = 0; i < 18; i++) {
			Personagem cenoura = new Personagem();
			cenouras.add(cenoura.inicializaCenoura(random(0,500), random(0,400)));
		}
		
	
		for(int a = 0; a < 3; a++) {
			Personagem raposa = new Personagem();
			raposas.add(raposa.inicializaRaposa(random(0,500), random(0,400)));
		}

	}

	public void paint(Graphics g) {//pintar a tela
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);//0 0 preence a tela toda

		if (active) {
			graficos.drawImage(coelho.getImagem(), coelho.getX(), coelho.getY(), this);
			for (int i = 0; i < cenouras.size(); i++) {

				Personagem in = cenouras.get(i);
				graficos.drawImage(in.getImgCenoura(), in.getX(), in.getY(), this);

			}
			
			for(int k = 0 ; k < raposas.size(); k++) {
				Personagem raposa = raposas.get(k);
				graficos.drawImage(raposa.getImgRaposa(), raposa.getX(), raposa.getY(), this);
			}

			graficos.setColor(Color.WHITE);
			graficos.drawString("Pontos: " + pontos, 5, 15);
			if(pontos >=10) {
				ImageIcon referencia = new ImageIcon("res\\fundo2.png");
				fundo = referencia.getImage();
				graficos.drawImage(fundo, 500,400, null);
				graficos.setColor(Color.RED);
				graficos.drawString("SEGUNDA FASE " , 5, 35);
			}
			
			
		} else {
			
			ImageIcon fimJogo = new ImageIcon("res\\fim_jogo.jpg");
			
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			
			
		}
		contador++;
		g.dispose();//limpar p proxima pintura

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (cenouras.size() == 0) {
			active = false;
		}

		for (int i = 0; i < cenouras.size(); i++) {
			Personagem in = cenouras.get(i);
			if (in.isVisivel()) {
				in.mexer();
			}else{ 
			 {
			   cenouras.remove(i);
			}
		}
		}
		
		if(contador >= 100) {
		for (int i = 0; i < raposas.size(); i++) {

			Personagem ra = raposas.get(i);

			if (ra.isVisivel()) {
				ra.mexer();
			}
			
		}
		}
		
		if(pontos >= 10) {
			if(cenouras.size()==0) {
				active = false;
			}
			ImageIcon img = new ImageIcon("res\\coelhinho2.png");
			imgCoelho = img.getImage();
			coelho.setImagem(imgCoelho);
			for(int i = 0; i < cenouras.size(); i++) {
				Personagem cen = cenouras.get(i);
				cen.setVELOCIDADE(2);
				cen.mexer();
			}
			
		}
		coelho.mexer();
		checarColisoes();
		repaint();
		
	}
	
	

	public void checarColisoes() {

		Rectangle recCoelho = coelho.getBounds();
		Rectangle recCenoura;
		Rectangle recRaposa;

		for (int i = 0; i < cenouras.size(); i++) {

			Personagem cen = cenouras.get(i);
			recCenoura = cen.getBounds();
			if (recCoelho.intersects(recCenoura)) {

				coelho.setVisivel(true);
				cen.setVisivel(false);
				pontos++;
			}

		}
		
		for(int a = 0; a < raposas.size(); a++) {
			Personagem rap = raposas.get(a);
			recRaposa = rap.getBounds();
			if (recCoelho.intersects(recRaposa)) {
				active = false;
				
			}
			
		}
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				active = true;
				coelho = new Coelho();
				inicializaPersonagens();
			}
			
			coelho.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			coelho.keyReleased(e);
		}

	}

}
