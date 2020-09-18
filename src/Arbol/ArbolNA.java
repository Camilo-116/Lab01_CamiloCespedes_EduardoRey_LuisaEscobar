/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 *
 * @author Camilo Cespedes
 */
public class ArbolNA extends Arbol {

    public ArbolNA(ArrayList<User> users) {
        super(users);
        NR.setNodosU(users.size());
        NR = LlenarArbol(NR);
    }

    public NodoRaiz LlenarArbol(NodoRaiz NR) {
        for (int i = 0; i < users.size(); i++) {
            NR.setNodoU(i, new NodoUser(users.get(i).getPosts().size(), users.get(i).getId(), users.get(i).getName(), users.get(i).getUserName(), users.get(i).getEmail(), users.get(i).getPhone(), users.get(i).getWebSite(), users.get(i).getAddress(), users.get(i).getCompany()));
            for (int j = 0; j < users.get(i).getPosts().size(); j++) {
                NR.getNodoU(i).setNodoP(j, new NodoPost(users.get(i).getPosts().get(j).getComments().size(), users.get(i).getPosts().get(j).getId(), users.get(i).getPosts().get(j).getUserID(), users.get(i).getPosts().get(j).getTittle(), users.get(i).getPosts().get(j).getBody()));
                for (int k = 0; k < users.get(i).getPosts().get(j).getComments().size(); k++) {
                    NR.getNodoU(i).getNodoP(j).setNodoC(k, new NodoComment(users.get(i).getPosts().get(j).getComments().get(k).getId(), users.get(i).getPosts().get(j).getComments().get(k).getPostID(), users.get(i).getPosts().get(j).getComments().get(k).getName(), users.get(i).getPosts().get(j).getComments().get(k).getEmail(), users.get(i).getPosts().get(j).getComments().get(k).getBody()));
                }
            }
        }
        return NR;
    }

    public NodoUser BuscarUsuario (int id){
        for (int i = 0; i < NR.nodosU.length; i++) {
            if (NR.nodosU[i].id == id){
                return NR.nodosU[i];
            }
        }
        return null;
    }
    
    public NodoUser BuscarUsuario (String userName){
        for (int i = 0; i < NR.nodosU.length; i++) {
            if (NR.nodosU[i].userName.equals(userName)){
                return NR.nodosU[i];
            }
        }
        return null;
    }
    
    public NodoUser BuscarUsuarioEmail (String email){
        for (int i = 0; i < NR.nodosU.length; i++) {
            if (NR.nodosU[i].email.equals(email)){
                return NR.nodosU[i];
            }
        }
        return null;
    }
    
    public NodoPost BuscarPost(int id){
        for (int i = 0; i < NR.nodosU.length; i++) {
            for (int j = 0; j < NR.nodosU[i].nodosP.length; j++) {
                if (NR.nodosU[i].nodosP[j].id == id){
                    return NR.nodosU[i].nodosP[j];
                }
            }
                
        }
        return null;
    }

}
