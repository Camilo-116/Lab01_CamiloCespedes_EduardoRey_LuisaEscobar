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

    public class NodoRaiz {

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

        public NodoUser[] getNodosU() {
            return nodosU;
        }

        
    }

    public class NodoUser {

        int id;
        String name, userName, email, phone, webSite;
        Address address;
        Company company;
        NodoPost[] nodosP;

        public NodoUser() {
        }

        
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

        public NodoPost[] getNodosP() {
            return nodosP;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getWebSite() {
            return webSite;
        }

        public Address getAddress() {
            return address;
        }

        public Company getCompany() {
            return company;
        }
        
        public NodoPost getNodoP(int i) {
            return nodosP[i];
        }
        
        public void setNodoP(int i, NodoPost nodoP) {
            this.nodosP[i] = nodoP;
        }

        public StringBuffer show() {
            StringBuffer sb = new StringBuffer("");
            sb.append("Phone:\t"+phone+"\n");
            sb.append("WebSite:\t"+webSite+"\n");
            sb.append(address.show()+"\n");
            sb.append(company.show());
            return sb;
        }
    }

    public class NodoPost {

        int id, userID;
        String tittle, body;
        NodoComment[] nodosC;

        public NodoPost() {
        }

        public NodoPost(int commentsLenght, int id, int userID, String tittle, String body) {
            nodosC = new NodoComment[commentsLenght];
            this.id = id;
            this.userID = userID;
            this.tittle = tittle;
            this.body = body;
        }

        public int getId() {
            return id;
        }

        public int getUserID() {
            return userID;
        }

        public NodoComment[] getNodosC() {
            return nodosC;
        }
        
        public NodoComment getNodoC(int i) {
            return nodosC[i];
        }
        
        public void setNodoC(int i, NodoComment nodoC) {
            this.nodosC[i] = nodoC;
        }
        
        public StringBuffer showPost(ArbolNA As){
            StringBuffer sb = new StringBuffer("");
            sb.append("Posted by:\t"+As.BuscarUsuario(userID).userName+"\n");
            sb.append("Post's Tittle:\t"+tittle+"\n");
            sb.append(body+"\n");
            return sb;
        }

        public StringBuffer showComments(ArbolNA As, NodoComment[] NC) {
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < NC.length; i++) {
                sb.append("|Email:    "+NC[i].email+"\n");
                sb.append("|Comment Name:    "+NC[i].name+"\n");
                sb.append("|"+NC[i].body+"\n\n");
            }
                
            return sb;
        }
    }

    public class NodoComment {

        int id, postID;
        String name, email, body;

        public NodoComment() {
        }

        
        public NodoComment(int id, int postID, String name, String email, String body) {
            this.id = id;
            this.postID = postID;
            this.name = name;
            this.email = email;
            this.body = body;
        }
    }

    public NodoRaiz getNR() {
        return NR;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

}
