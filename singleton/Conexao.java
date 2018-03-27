
package singleton;

public class Conexao {
    public static Conexao instancia;
    public static Conexao getInstance(){
     if(instancia == null){
         System.out.println("criou instancia");
     }   
     return instancia;
    }
    private Conexao(){
        
    }
    
    public void conectar(){
        System.out.println("Conectado ao banco de dados");
    }
    
    public void desconectar(){
        System.out.println("Desconectado do banco de dados");
    }
    
}
