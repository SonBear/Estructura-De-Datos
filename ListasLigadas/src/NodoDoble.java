/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class NodoDoble extends Nodo{
    private NodoDoble prev;
    
    public NodoDoble(int dato) {
        super(dato);
        prev = null;
        
    }

    @Override
    public NodoDoble getNext() {
        return (NodoDoble)super.getNext();
    }

    public NodoDoble getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = (NodoDoble) prev;
    }

  
    
}
