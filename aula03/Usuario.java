
package aula03;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    
    private String nome;
    private ArrayList<Lance> lances;

    public ArrayList<Lance> getLances() {
        return lances;
    }

    public void setLances(ArrayList<Lance> lances) {
        this.lances = lances;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Usuario cadastrarUsuario(Usuario usuario){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o nome do usuario");
        usuario.nome = leitor.nextLine();
        return usuario;
    }
     public float lance(){
         Scanner leitor = new Scanner(System.in);
         Lance lance = new Lance();
         System.out.println("Informe o lance");
         lance.setValor(leitor.nextFloat());
         return lance.getValor();
     }
 
    
}
