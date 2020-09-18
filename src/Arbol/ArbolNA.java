/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
import lab01_camilocespedes_eduardorey_luisaescobar.User;

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

}
