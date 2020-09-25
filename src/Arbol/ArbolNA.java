/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 * Clase que representa un Arbol n-ario
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class ArbolNA extends Arbol {

    /**
     * Constructor no vacío de la clase ArbolNA
     * @param ptrUsers Primer elemento de una lista de elementos User
     */
    public ArbolNA(Lista<User> ptrUsers) {
        super(ptrUsers);
        NR = LlenarArbol(NR);
    }

    /**
     * Método que permite llenar los nodos de un árbol n-ario al tiempo que se establecen las relaciones de parentezco entre estos
     * @param NR NodoRaiz de un Arbol
     * @return NodoRaiz de un Arbol
     */
    public NodoRaiz LlenarArbol(NodoRaiz NR) {
        Lista<User> p = this.getUsers();
        NR.setNodoU((User)p.getObject());
        p = p.linkOb;
        while (p != null) {
            NR.linkU.addNodoU((User)p.getObject());
            p = p.linkOb;
        }
        return NR;
    }

    /**
     * Metodo para realizar la búsqueda de un usuario en el árbol por medio de su ID
     * @param id ID del usuario buscado
     * @return NodoUser objetivo
     */
    public NodoUser BuscarUsuario (int id){
        NodoUser u = NR.linkU;
        while (u  != null) {
            if (u.id == id){
                return u;
            }
            u = u.linkU;
        }
        return null;
    }
    
    /**
     * Metodo para realizar la búsqueda de un usuario en el árbol por medio de su nombre de usuario
     * @param userName nombre de usuario del usuario buscado
     * @return NodoUser objetivo
     */
    public NodoUser BuscarUsuario (String userName){
        NodoUser u = NR.linkU;
        while (u != null) {
            try{
                if (u.userName.equals(userName)){
                    return u;
                }
            }catch(NullPointerException ex){
                
            }
            u = u.linkU;
        }
        return null;
    }
    
    /**
     * Metodo para realizar la búsqueda de un usuario en el árbol por medio de su email
     * @param email email del usuario buscado
     * @return NodoUser objetivo
     */
    public NodoUser BuscarUsuarioEmail (String email){
        NodoUser u = NR.linkU;
        while (u != null) {
            try{
                if (u.email.equals(email)){
                return u;
                }
            }catch(NullPointerException ex){
                
            }
            u = u.linkU;
        }
        return null;
    }
    
    /**
     * Metodo para realizar la búsqueda de una publicacion en el árbol por medio de su ID
     * @param id ID de la publicacion buscada
     * @return NodoPost objetivo
     */
    public NodoPost BuscarPost(int id){
        NodoUser u = NR.linkU;
        NodoPost p;
        while (u  != null) {
            p = u.linkP;
            while (p  != null){
                if (p.id == id){
                    return p;
                }
                p = p.linkP;
            }
            u = u.linkU;
        }
        return null;
    }
    
    /**
     * Metodo para realizar la búsqueda de una publicación en el árbol por medio de su titulo
     * @param title titulo de la publicacion buscada
     * @return NodoPost objetivo
     */
    public NodoPost BuscarPost(String title){
        NodoUser u = NR.linkU;
        NodoPost p;
        while (u != null) {
            p = u.linkP;
            while (p != null){
                try{
                    if (p.tittle.equals(title)){
                        return p;
                    }
                }catch(NullPointerException ex){
                    
                }
                p = p.linkP;
            }
            u = u.linkU;
        }
        return null;
    }
    
}
