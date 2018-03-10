
package aula02;

public class Principal {
    public static void main(String[] args){
        Object obj = new Maquina();
        Maquina maquina = null;
        
        if(obj instanceof Maquina){
            maquina = (Maquina) obj;
        }
        
        System.out.println("var maquina = " + maquina);
        
        
        Maquina maquina2 = new Smartphone();
        Smartphone s = null;
        if(maquina2 instanceof Maquina){s = (Smartphone) maquina2;}
        System.out.println(s.getClass());
        
        if(Maquina.class == maquina.getClass()){
             System.out.println("var maquina = " + maquina);
        }
        
        if(Smartphone.class.equals(maquina.getClass())){
             System.out.println( s.getClass());
        
        }
        if(s instanceof Maquina){
            System.out.println(s.getClass());
        
        }
    }
    
   
    
}

// .class retorna o nome da classe .getClass tbm = so pega quando é da mesma classe
// instanceof pega da classe pai tbm



