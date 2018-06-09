package jogo;


import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Objetos {
	private Image imgCenoura;
	private Image imgRaposa;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private Objetos cenoura;
	private Objetos raposa;

	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 1;

	private static int contador = 0;
	
	
	public Objetos inicializaCenoura(int x, int y) {
		this.x = x;
		this.y = y;
		
		
		ImageIcon referencia;
		referencia = new ImageIcon("res\\cenoura.png");
	
	    imgCenoura = referencia.getImage();
	
    	this.largura = imgCenoura.getWidth(null);
	    this.altura = imgCenoura.getHeight(null);
	    isVisivel = true;
	    
	    return this;

	}
	
	public Objetos inicalizaRaposa(int x, int y) {
		this.x = x;
		this.y = y;
		
		ImageIcon referencia2;
		referencia2 = new ImageIcon("res\\raposa.png");
	
	   imgRaposa = referencia2.getImage();
	
	   this.largura = imgRaposa.getWidth(null);
	   this.altura = imgRaposa.getHeight(null);

		
		isVisivel = true;
		
		return this;
		
	}
/*public Objetos(int x, int y) {

		this.x = x;
		this.y = y;
		
		
		ImageIcon referencia;
		referencia = new ImageIcon("res\\cenoura.png");
	
	    imgCenoura = referencia.getImage();
	
    	this.largura = imgCenoura.getWidth(null);
	    this.altura = imgCenoura.getHeight(null);

	    ImageIcon referencia2;
		referencia2 = new ImageIcon("res\\raposa.png");
	
	   imgRaposa = referencia2.getImage();
	
	   this.largura = imgRaposa.getWidth(null);
	   this.altura = imgRaposa.getHeight(null);

		
		isVisivel = true;
	}*/





	public void mexer(){

		if(this.x < 0){
			this.x = LARGURA_TELA;
		} else {
			this.x -= VELOCIDADE;
		}
		
	}
	
	public boolean isVisivel() {
		return isVisivel;	
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getImgCenoura() {
		return imgCenoura;
	}



	public Image getImgRaposa() {
		return imgRaposa;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

}
