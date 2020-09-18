/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
import lab01_camilocespedes_eduardorey_luisaescobar.Address;
import lab01_camilocespedes_eduardorey_luisaescobar.Company;
import lab01_camilocespedes_eduardorey_luisaescobar.User;

/**
 *
 * @author Camilo Cespedes
 */
public abstract class Arbol {

    ArrayList<User> users;
    NodoRaiz NR;

    public Arbol(ArrayList<User> users) {
        this.users = users;
        this.NR = new NodoRaiz();
    }

    class NodoRaiz {

        NodoUser[] nodosU;

        public NodoRaiz() {
        }

        public void setNodosU(int usersLenght) {
            nodosU = new NodoUser[usersLenght];
        }

        public NodoUser getNodoU(int i) {
            return nodosU[i];
        }
        
        public void setNodoU(int i, NodoUser nodoU) {
            this.nodosU[i] = nodoU;
        }

        
    }

    class NodoUser {

        int id;
        String name, userName, email, phone, webSite;
        Address address;
        Company company;
        NodoPost[] nodosP;

        public NodoUser(int postsLenght, int id, String name, String userName, String email, String phone, String webSite, Address address, Company company) {
            nodosP = new NodoPost[postsLenght];
            this.id = id;
            this.name = name;
            this.userName = userName;
            this.email = email;
            this.phone = phone;
            this.webSite = webSite;
            this.address = address;
            this.company = company;
        }
        
        public NodoPost getNodoP(int i) {
            return nodosP[i];
        }
        
        public void setNodoP(int i, NodoPost nodoP) {
            this.nodosP[i] = nodoP;
        }
    }

    class NodoPost {

        int id, userID;
        String tittle, body;
        NodoComment[] nodosC;

        public NodoPost(int commentsLenght, int id, int userID, String tittle, String body) {
            nodosC = new NodoComment[commentsLenght];
            this.id = id;
            this.userID = userID;
            this.tittle = tittle;
            this.body = body;
        }
        
        public NodoComment getNodoC(int i) {
            return nodosC[i];
        }
        
        public void setNodoC(int i, NodoComment nodoC) {
            this.nodosC[i] = nodoC;
        }
    }

    class NodoComment {

        int id, postID;
        String name, email, body;

        public NodoComment(int id, int postID, String name, String email, String body) {
            this.id = id;
            this.postID = postID;
            this.name = name;
            this.email = email;
            this.body = body;
        }
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

}
