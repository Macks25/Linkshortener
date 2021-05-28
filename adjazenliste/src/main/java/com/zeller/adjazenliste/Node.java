/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeller.adjazenliste;

import java.util.ArrayList;

/**
 *
 * @author zelle
 */
public class Node {
    
    String name;
    int id;
    ArrayList<Node> Verbindungen = new ArrayList<Node>();

    public ArrayList<Node> getVerbindungen() {
        return Verbindungen;
    }
    
    public void addVerbinung(Node node){
        Verbindungen.add(node);
        node.Verbindungen.add(this);
    }
    public void removeVerbinung(Node node){
        Verbindungen.remove(node);
        node.Verbindungen.remove(this);
    }
    
    
    public void setVerbindungen(ArrayList<Node> Verbindungen) {
        this.Verbindungen = Verbindungen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Node(String name){
        this.name = name;
    }
    
}
