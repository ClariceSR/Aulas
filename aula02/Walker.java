/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

public interface Walker {
    void walk();
    default void saySomething(){
        System.out.println("I know how to walk (implemented in Interface)");
    }
    
}
