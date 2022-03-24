/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akinator;

/**
 * Clase que es encargará de guardar los animales y sus respectivas preguntas
 * @author Sergionx
 */
public class ArbolBinarioDesicion {
    private Nodo root;
    
    /**
    * Inicializa el arbol
    * @author Sergionx
    */
    public ArbolBinarioDesicion() {
        this.root = null;
    }
    
    /**
    * @return boolean
    * Determina si el nodo es un animal o no (equivalente si es una hoja)
    * @author Sergionx
    */
    public boolean isAnaimal(Nodo aux){
        if (aux.getHijoDer() == null &&
                aux.getHijoIzq() == null) {
            return true;
        } else {
            return  false;
        }
    }
    
    /**
    * @return Nodo
    * Dado un nodo cualquiera (e inicialmente la raíz del arbol) 
    * se le devolverá su padre
    * @author Sergionx
    */
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
    
    /**
    * Dado el valor del nodo (ya sea pregunta o animal) y sus 2 hijos
    * lo insertará si alguno de los otros nodos ya tenían como hijo su valor
    * (inicialmente recibe root)
    * @author Sergionx
    */
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

    /**
    * @return Nodo
    * @author Sergionx
    */
    public Nodo getRoot() {
        return root;
    }
    
    /**
    * Dado un nodo, cambia el valor de root
    * @author Sergionx
    */
    public void setRoot(Nodo root) {
        this.root = root;
    }
    
   
    
}
