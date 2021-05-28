/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeller.adjazenliste;

/**
 *
 * @author zelle
 */
public class NewClass {

    public static void main(String[] args) {

        
        Node Michael = new Node("Michael");
        Node Jonas = new Node("Jonas");
        Node Patrick = new Node("Patrick");
        Node Anne = new Node("Anne");
        Node Leonie = new Node("Leonie");
        
        Michael.addVerbinung(Leonie);
        Michael.addVerbinung(Jonas);
        Michael.addVerbinung(Patrick);
        
        Jonas.addVerbinung(Anne);
        Patrick.addVerbinung(Leonie);
        
        for(Node el: Leonie.getVerbindungen()){
            System.out.println(el.getName());
        }
        
    }
    
}
