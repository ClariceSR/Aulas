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

public class JogoEspaco extends JPanel {

	private Image fundo;
	private Image imgRaposa;
	private Image imgCenoura;
	private Coelho coelho;
	private int pontos = 0;
	int contador = 0;
	private boolean active;

	//private List<Cenoura> cenouras;
	//private List<Raposa> raposas;
	
	private List<Objetos> cenouras;
	private List<Objetos> raposas;
	

	public JogoEspaco() {

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon referencia = new ImageIcon("res\\background.png");
		fundo = referencia.getImage();
		coelho = new Coelho();

		active = true;

		inicializaInimigos();
			
	}
	
	public int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public void inicializaInimigos() {

		cenouras = new ArrayList<Objetos>();
		raposas = new ArrayList<Objetos>();

		for (int i = 0; i < 15; i++) {
			Objetos cenoura = new Objetos();
			//cenouras.add(new Objetos(random(0,500), random(0,400)));
			cenouras.add(cenoura.inicializaCenoura(random(0,500), random(0,400)));
		}
		
	
		for(int a = 0; a < 3; a++) {
			raposas.add(new Objetos(random(0,500), random(0,400)));
		}

	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);

		if (active) {

			graficos.drawImage(coelho.getImagem(), coelho.getX(), coelho.getY(), this);
			for (int i = 0; i < cenouras.size(); i++) {

				Objetos in = cenouras.get(i);
				graficos.drawImage(in.getImgCenoura(), in.getX(), in.getY(), this);

			}
			
			for(int k = 0 ; k < raposas.size(); k++) {
				Objetos raposa = raposas.get(k);
				graficos.drawImage(raposa.getImgRaposa(), raposa.getX(), raposa.getY(), this);
			}

			graficos.setColor(Color.WHITE);
			graficos.drawString("Pontos: " + pontos, 5, 15);
			
			
		} else {
			
			ImageIcon fimJogo = new ImageIcon("res\\fim.jpg");
			
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			
			
		}
		contador++;
		g.dispose();

	}

		
		public void update() {

		if (cenouras.size() == 0) {
			active = false;
		}


		for (int i = 0; i < cenouras.size(); i++) {

			Objetos in = cenouras.get(i);

			if (in.isVisivel()) {
				in.mexer();
			} else {
				cenouras.remove(i);
			}

		}
		
		
		if(contador >= 100) {
		for (int i = 0; i < raposas.size(); i++) {

			Objetos ra = raposas.get(i);

			if (ra.isVisivel()) {
				ra.mexer();
			}

		}
		}

		coelho.mexer();
		checarColisoes();
		repaint();
	}

	public void checarColisoes() {

		Rectangle formaNave = coelho.getBounds();
		Rectangle formaInimigo;
		Rectangle formaRaposa;

		for (int i = 0; i < cenouras.size(); i++) {

			Objetos tempInimigo = cenouras.get(i);
			formaInimigo = tempInimigo.getBounds();
			if (formaNave.intersects(formaInimigo)) {

				coelho.setVisivel(true);
				tempInimigo.setVisivel(false);
				pontos++;

				//active = false;

			}

		}
		
		for(int a = 0; a < raposas.size(); a++) {
			Objetos tempInimigo = raposas.get(a);
			formaRaposa = tempInimigo.getBounds();
			if (formaNave.intersects(formaRaposa)) {

				//nave.setVisivel(true);
				//tempInimigo.setVisivel(false);

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
				inicializaInimigos();
			}
			
			coelho.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			coelho.keyReleased(e);
		}

	}

}
