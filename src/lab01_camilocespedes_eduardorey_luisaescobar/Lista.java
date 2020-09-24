/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *Clase Lista que genera una lista enlazada simple
 * 
 * @author Camilo Cespedes
 * @param <E> Clase del objeto con el cual se llenará la lista
 */
public class Lista<E>{
    
    /* 
    *Objeto almacenado en cada nodo de la lista
    */
    E object;   
    /**
     * Dirección de memoria del siguiente objeto de la lista
     */
    public Lista linkOb;

    /**
     * Constructor de la clase Lista que inicia una lista vacía
     */
    public Lista() {
        linkOb = null;
    }
    /**
     * Constructor de la clase Lista que añade un nuevo nodo a la lista, el cual contiene un objeto del tipo E
     * @param object Objeto que será interpretado como instancia de E para ser añadidoa la lsita
     */
    public Lista(Object object) {
        this.object = (E) object;
        linkOb = null;
    }
    
    /**
     * Método para insertar un nuevo nodo a la lista
     * 
     * @param e indica el objeto de tipo E que se añadirá a la lista
     * @return Primer elemento de la lista a la que fue agregado el objeto e de tipo E
     */
    public Lista add(E e) {
        if (object == null) {
            this.object = e;
            linkOb = null;
        } else {
            Lista p = this;
            while (p.linkOb != null) {
                p = p.linkOb;
            }
            p.linkOb = new Lista(e);
        }
        return this;
    }
    
    /**
     * Método que permite conocer cuantos elementos tiene una lista
     * 
     * @return Entero correspondiente al número de elementos de la lista
     */
    public int size() {
        if (this.linkOb == null){
            if (object == null){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1 + this.linkOb.size();
        }
    }
    /**
     * Getter de objeto almacenado
     * 
     * @return Objeto almacenado en el nodo de la lista
     */
    public E getObject() {
        return object;
    }
    

}
