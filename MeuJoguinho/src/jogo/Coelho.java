package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Coelho {

	private int x, y;//coordenadas
	private int dx, dy;//aumentar ou diminuir p cda coordenada
	private int altura, largura;
	private boolean isVisivel;

	private Image imagem; 
	
	//private List<Missel> misseis;
	
	public Coelho(){
		
		ImageIcon referencia = new ImageIcon("res\\coelho.png");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
	
		//onde o coelho vai ficar na tela
		this.x = 100;
		this.y = 100;
		
	}
	
	public void mexer(){
		x += dx; // 1 e 462
		y += dy; // 1 e 340

		if(this.x < 1){
			x = 1;
		}
		
		if(this.x > 430){
			x = 430;
		}
		
		if(this.y < 1){
			y = 1;
		}

		if(this.y > 310){
			y = 310;
		}
		
	}
	//
	/*public List<Missel> getMisseis() {
		return misseis;
	}*/

	public int getX() {
		return x;
	}
	
	public int getY() {	
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}
	

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	/*public void atira(){
		this.misseis.add(new Missel(x+largura, y + altura/2 ));
	}*/

	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
	
	public void keyPressed(KeyEvent tecla){//aperta na teclaa
		
		int codigo = tecla.getKeyCode();
		
		/*if(codigo == KeyEvent.VK_SPACE){
			atira();
		}*/

		if(codigo == KeyEvent.VK_UP){
			dy = -1;// quando menor o y ele sobre, o coelho sobre devagar pq ta -1
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			dy = 1;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = -1;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 1;
		}
		
	}
	
	public void keyReleased(KeyEvent tecla){ //solta a tela
		
		int codigo = tecla.getKeyCode(); // recebe o codigo da tabela asc, armazena e sabe qual tecla o usuario apertou 
		
		if(codigo == KeyEvent.VK_UP){
			dy = 0;// pq qnd solta a tecla tem q anular o valor q recebeu no heypressed
		}
 
		if(codigo == KeyEvent.VK_DOWN){
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = 0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		
	}
	
	
}
