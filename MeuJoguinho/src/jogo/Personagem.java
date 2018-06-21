package jogo;


import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Personagem {
	private Image imgCenoura;
	private Image imgRaposa;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private Personagem cenoura;
	private Personagem raposa;

	private static final int LARGURA_TELA = 511;
	private static int VELOCIDADE = 1;

	private static int contador = 0;
	
	
	public Personagem inicializaCenoura(int x, int y) {
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
	
	public Personagem inicializaRaposa(int x, int y) {
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

		if(this.x < 0){//chegou no final da tela
			this.x = LARGURA_TELA;
		} else {
			this.x -= VELOCIDADE;//pq vai vir do final pro começo
		}
		
		if(this.x > 462){
			x = 462;
		}

		if(this.y > 340){
			y = 340;
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
   
	
    

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
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
