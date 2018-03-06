/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;


public class TypeCastConversao {
    public static void typecastConversaoExplicita(){
        int numInt = Integer.MAX_VALUE;
        long numLong = 0;
        System.out.println("int = " + numInt);
        System.out.println("long = " + numLong);
        numInt = (int) numLong;
        System.out.println("int apos receber long = " + numInt + "\n");
        
    }
    public static void typecastConversaoImplicita(){
        int numInt = Integer.MAX_VALUE;
        long numLong = Long.MAX_VALUE;
        System.out.println("int = " + numInt);
        System.out.println("long = " + numLong);
        numLong =  numInt;
        System.out.println("long apos receber int = " + numInt + "\n");
        
    }
    
    
    public static void main(String[] args){
        typecastConversaoExplicita();
        typecastConversaoImplicita();
        
        
    }
    
    
}
