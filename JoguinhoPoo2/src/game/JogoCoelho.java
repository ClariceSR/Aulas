package game;

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
	private Coelho coelho;
	private Timer timer;
	private Raposa raposa;

	private boolean active;

	private List<Cenoura> cenouras;
	private List<Raposa> raposas;
	
	int contador = 0;
	int pontos = 0;


	public JogoCoelho() {

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon referencia = new ImageIcon("res\\background.png");
		fundo = referencia.getImage();
		coelho = new Coelho();

		active = true;

		inicializaPersonagens();

		timer = new Timer(5, this);
		timer.start();

	}
	
	public int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public void inicializaPersonagens() {

		cenouras = new ArrayList<Cenoura>();
		raposas = new ArrayList<Raposa>();

		for (int i = 0; i < 20; i++) {
			cenouras.add(new Cenoura(random(0,500), random(0,400)));

		}
		
		for(int j = 0; j < 3; j++) {
			raposas.add(new Raposa(random(0,500), random(0,400)));
		}

	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);

		if (active) {

			graficos.drawImage(coelho.getImagem(), coelho.getX(), coelho.getY(), this);


			/*List<Raposa> raposas = nave.getMisseis();

			for (int i = 0; i < misseis.size(); i++) {

				Missel m = (Missel) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

			}*/

			for (int i = 0; i < cenouras.size(); i++) {

				Cenoura in = cenouras.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

			}
			
			for(int j = 0; j < raposas.size(); j++) {
				Raposa ra = raposas.get(j);
				graficos.drawImage(ra.getImagem(), ra.getX(), ra.getY(), this);
			}

			graficos.setColor(Color.WHITE);
			graficos.drawString("PONTOS: " + pontos, 5, 15);
			
		} else {
			
			ImageIcon fimJogo = new ImageIcon("res\\game_over.jpg");
			
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			
			
		}
		contador++;
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (cenouras.size() == 0) {
			active = false;
		}

		/*List<Missel> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missel m = (Missel) misseis.get(i);

			if (m.isVisivel()) {
				m.mexer();
			} else {
				misseis.remove(i);
			}

		}*/

		for (int i = 0; i < cenouras.size(); i++) {

			Cenoura in = cenouras.get(i);

			if (in.isVisivel()) {
				in.mexer();
			} else {
				cenouras.remove(i);
			}

		}
		
		if(contador >= 20) {
		for(int j = 0; j < raposas.size(); j++) {
			Raposa ra = raposas.get(j);
			
			if(ra.isVisivel()) {
				ra.mexer();
			}else {
				raposas.remove(j);
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
		Rectangle formaMissel;

		for (int i = 0; i < cenouras.size(); i++) {

			Cenoura tempInimigo = cenouras.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {

				coelho.setVisivel(true);
				tempInimigo.setVisivel(false);
				pontos++;

				//emJogo = false;

			}

		}
		
		for(int j = 0; j < raposas.size(); j++) {
			
			Raposa temRaposa = raposas.get(j);
			formaMissel = temRaposa.getBounds();
			
			if(formaNave.intersects(formaMissel)) {
				active = false;
			}
			
		}

		/*List<Missel> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missel tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {

				Inimigo tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {

					tempInimigo.setVisivel(false);
					tempMissel.setVisivel(false);

				}

			}

		}
*/
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
