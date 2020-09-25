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
