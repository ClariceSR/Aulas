package leilao;

import java.util.ArrayList;
import java.util.Scanner;

public class Leilao {
	public static void main(String [] args) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String jaFoi = null;
		float maior = 0;
		Scanner leitor = new Scanner(System.in);
		int opc = 0;
		while (opc < 4) {
			System.out.println("1 - Cadastrar Usuario");
			System.out.println("2 - Cadastrar Produto");
			System.out.println("3 - Realizar Lance");
			System.out.println("4 - Ver resultado");
			opc = leitor.nextInt();
			switch(opc) {
			case 1:
				Usuario usuario = new Usuario();
				usuario.cadastrarUsuario(usuario);
				usuarios.add(usuario);
				break;
			case 2:
				Produto produto = new Produto();
				produto.cadastrarProduto(produto);
				produtos.add(produto);
				break;
			case 3:
				for(Produto p : produtos) {
					System.out.println("Informe o nome do usuario para realizar o lance");
					String nome = leitor.next();
					for(Usuario user : usuarios) {
						if(user.getNome().equals(nome)) {
							if(user.getNome() != jaFoi) {
							user.lance();
							jaFoi = user.getNome();
							}
							else {
								System.out.println("Esse usuário ja deu o lance");
								break;
							}
							if(user.lance()>maior) {
								if(user.lance() > p.getPreco() ) {
								 maior = user.lance();
						}
					}else {
						System.out.println("Lance invalido");
					}
						}
	
				  }
				}
				break;
			case 4:
				System.out.println(maior);
				break;
		 }
	   }
	}
}
