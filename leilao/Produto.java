package leilao;

import java.util.Scanner;

public class Produto {
	private String nome;
	    private double preco;
	
	    public String getNome() {
	        return nome;
	
	}
	
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	
	    public double getPreco() {
	        return preco;
	    }
	
	    public void setPreco(double preco) {
	        this.preco = preco;
	    }
	    
	    public Produto cadastrarProduto(Produto produto){
	        Scanner leitor = new Scanner(System.in);
	        System.out.println("Informe o nome do produto");
	        produto.nome = leitor.next();
	        System.out.println("Informe o preco do produto");
	        produto.preco = leitor.nextDouble();
	        return produto;
	    }
	    
	
}
