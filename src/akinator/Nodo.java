/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akinator;

/**
 *
 * @author Sergionx
 */
public class Nodo {
    private String data;
    private Nodo next;
    private Nodo node;
    private Nodo padre;
    private Nodo hijoIzq;
    private Nodo hijoDer;
    
    public Nodo(String data) {
        this.data = data.toLowerCase();
        this.next = null;
        this.node = null;
    }

    public Nodo(String data, Nodo hijoIzq, Nodo hijoDer) {
        this.data = data.toLowerCase();
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        
    } 

    public Nodo getPadre() {
        return padre;
    }

    public String getData() {
        return data;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public Nodo getNode() {
        return node;
    }
         
}
