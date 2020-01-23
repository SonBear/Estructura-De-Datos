/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author A18016328
 */
public class ListaDobleLigada <E>implements Lista{
    private NodoDoble head;

    public NodoDoble getHead() {
        return head;
    }

    public void setHead(NodoDoble head) {
        this.head = head;
    }
    
    
    @Override
    public void agregarInicio(Nodo n) {
        NodoDoble nodo = (NodoDoble) n;
        if (isEmpty()) {
            head = nodo;
        }else{
            nodo.setNext(head);
            head.setPrev(nodo);
            head = nodo;
        }
    }

    @Override
    public void agregarFinal(Nodo n) {
        NodoDoble nodo = head;
        NodoDoble nodo2 = (NodoDoble) n;
         while(nodo != null){
             if(nodo.getNext() == null){
                 nodo.setNext(nodo2);
                 nodo2.setPrev(nodo);
                 return;
             }
            nodo = (NodoDoble) nodo.getNext();
        }
    }
    
    @Override
    public String toString(){
        String salida = "";
        NodoDoble nodo = head;
        salida += nodo.getPrev() + " <=> ";
        while(nodo != null){
            salida+=nodo.getDato() + " <=> ";
            nodo = (NodoDoble) nodo.getNext();
            if(nodo == null){
                salida+= nodo;
            }
            
        }
        
        return salida;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
}
