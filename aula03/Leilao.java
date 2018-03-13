
package aula03;

import java.util.ArrayList;
import java.util.Scanner;

public class Leilao {
     public static void main(String args[]){
         Scanner leitor = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Produto produto = new Produto();
        produto.cadastrarProduto(produto);
        produtos.add(produto);
        
        Usuario usuario = new Usuario();
        usuario.cadastrarUsuario(usuario);
        usuarios.add(usuario);
        
        for(Produto p : produtos){
            for(int i=0;i<=usuarios.size();i++){
                String nome;
                System.out.println("Informe o nome do usuario para dar o lance");
                nome = leitor.next();
                final Usuario user = usuarios.get(i);
                if(user.getNome().equals(nome)){
                    user.lance();
                    float maior = user.lance();
                    if(user.lance() > p.getPreco());
                      int resp = 1;
                      while(resp == 1){
                       System.out.println("Existem outro lance 1 - sim 2 - nao ");
                        resp = leitor.nextInt();
                        if(resp == 1){
                        System.out.println("Informe o nome do usuario para dar o lance");
                        nome = leitor.next();
                       }
                       }
                }
              
            }
        }
        
     
        
        
        
    }
    
    
    
}
