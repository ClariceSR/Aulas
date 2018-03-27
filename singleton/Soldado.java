/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author suporte
 */
public class Soldado {
    private Basuca basuca;
    private Metralhadora metralhadora;
    private Pistola pistola;
    
    public void atirarComMetralhadora(){
       if(metralhadora == null){
          metralhadora = new Metralhadora();
       }
       metralhadora.atirar();
    }
    public void atirarComBasuca(){
        if(basuca == null){
        basuca = new Basuca();
        }
        basuca.atirar();
    }
    public void atirarComPistola(){
        if(pistola == null){
        pistola = new Pistola();
        }
        pistola.atirar();
    }
}
