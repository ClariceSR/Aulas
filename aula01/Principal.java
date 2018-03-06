/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;

/**
 *
 * @author suporte
 */
public class Principal {
    public static void main(String[] args){
        Maquina maquina = new Pc();
        Pc pc = (Pc) maquina;
        System.out.println(maquina);
        System.out.println(pc);
        Maquina maquina1 = new Smartphone();
        Smartphone s = (Smartphone) maquina1;
        System.out.println(maquina1);
        System.out.println(s);
        
        Pc pc1 = new Pc();
        Maquina maquina2 = pc1;
        System.out.println(maquina2);
        System.out.println(pc1);
        
        Maquina maquina3 = new Maquina();
        Pc pc2 = (Pc) maquina3;
        
    }
    
}
