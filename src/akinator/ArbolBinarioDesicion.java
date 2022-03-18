/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akinator;

/**
 *
 * @author Sergionx
 */
public class ArbolBinarioDesicion {
    private Nodo root;

    public ArbolBinarioDesicion() {
        this.root = null;
    }
    
    public boolean isAnaimal(Nodo aux){
        if (aux.getHijoDer() == null &&
                aux.getHijoIzq() == null) {
            return true;
        } else {
            return  false;
        }
    }
    
    public Nodo Padre(Nodo myNode, Nodo pRoot){
        if (pRoot == null || myNode == null) {
            return null;
        } else if (pRoot.getHijoDer() != null && pRoot.getHijoDer() == myNode ||
                    pRoot.getHijoIzq()!= null && pRoot.getHijoIzq()== myNode) {
            return pRoot;
        } else {
            Nodo encontrado = Padre(myNode, pRoot.getHijoIzq());
            
            if (encontrado == null) {
                encontrado = Padre(myNode, pRoot.getHijoIzq());
            }
            
            return encontrado;
        }
    }
    
    public void Insertar(String valor, String hijoIzq, String hijoDer, Nodo pRoot){
        if (root == null) {
            Nodo nodoIzq = new Nodo(hijoIzq);
            Nodo nodoDer = new Nodo(hijoDer);
            
            root = new Nodo(valor, nodoIzq, nodoDer);
            
            nodoDer.setPadre(root);
            nodoIzq.setPadre(root);
        } else {
            if (pRoot != null) {
                if (valor.toLowerCase().equals(pRoot.getData())) {
                    Nodo nodoIzq = new Nodo(hijoIzq);
                    Nodo nodoDer = new Nodo(hijoDer);
                    Nodo padre = pRoot.getPadre();
                    Nodo aux =  new Nodo(valor, nodoIzq, nodoDer);

                    if (padre.getHijoIzq().getData().equals(pRoot.getData())) { //Es el hijo izquierdo
                        padre.setHijoIzq(aux);
                    } else { //Es el hijo derecho
                        padre.setHijoDer(aux);
                    }
                    aux.setPadre(padre);
                    nodoIzq.setPadre(aux);
                    nodoDer.setPadre(aux);
                
                } else{
                    Insertar(valor, hijoIzq, hijoDer, pRoot.getHijoIzq());
                    Insertar(valor, hijoIzq, hijoDer, pRoot.getHijoDer());
                }
            }
            
        }
    }

    public Nodo getRoot() {
        return root;
    }
    
    
}
