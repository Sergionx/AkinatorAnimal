/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akinator;

/**
 *
 * @author Usuario
 */
public class HashTable {
    private Nodo tabla[];
    private int size;
    
    public HashTable(int size) {
        this.size = size;
        this.tabla = new Nodo[size];
        for (int i = 0; i < size; i++) {
            this.tabla[i] = null;
        }
    }   
     
    //para vaciar
    
    public void vaciado() {
        for (int i = 0; i < size; i++) {
        this.tabla[i] = null;
        }
    }
    
    //Funcion hash
    
    public int hashing(String clave) {
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < clave.length(); i++) {
            if (clave.codePointAt (i) == 32) {
            valor += 0;
            } else if (clave.codePointAt (i) >= 48 && clave.codePointAt (i) <= 57) {
            valor += ((clave.codePointAt (i) - 47) * posicion);
            } else if (clave.codePointAt (i) >= 65 && clave.codePointAt (i) <= 90) {
            valor += ((clave.codePointAt (i) - 54) * posicion);
            } else if (clave.codePointAt (i) >= 97 && clave.codePointAt (i) <= 122) {
            valor += ((clave.codePointAt (i) - 60) * posicion);
            }
            posicion++;
            }
        return (valor % size);}
    
    
    public void insertar(String nuevo) {
        int posicion = hashing(nuevo);
        boolean existe = false;
        if (this.tabla[posicion] != null) {
            Nodo temp = this.tabla[posicion];
            //String temp = this.tabla[posicion].getData();
            
        if (temp.getData().equals(nuevo)) {
            existe = true;
        }
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getData().equals(nuevo)) {
                existe = true;
            }
        }
        if (!existe) {
            Nodo nuevo2 = new Nodo(nuevo);
            temp.setNext(nuevo2);
            }
        } else {
        Nodo nuevo2 = new Nodo(nuevo);
        this.tabla[posicion] = nuevo2;
    } }
        
    public Nodo buscar(String nombre) {
        int posicion = hashing(nombre);
        Nodo temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null) {
            if (temp.getNext() == null) {
                existe = true;
        } else {
                while (temp.getNext() != null && !existe) {
                    if (temp.getData().equals(nombre)) {
                        existe = true;
                    } else {
                        temp = temp.getNext();
                    }
                }
            
            }
        
        }
        if (existe) {
            return temp;}
        else {
            return null;}
  
    }
     
}
