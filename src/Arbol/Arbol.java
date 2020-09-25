/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import lab01_camilocespedes_eduardorey_luisaescobar.*;
/**
 *Clase que describe la estructura general de un árbol
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public abstract class Arbol {

    Lista<User> users;  //Primer elemento de una lista enlazada de objetos User, los cuales corresponden a aquellos que serán agregados al árbol
    NodoRaiz NR;   //Primero nodo del árbol, su raíz

    /**
     * Constructor de la clase Arbol
     * @param ptrUsers Primer elemento de una lista enlazada de objetos User 
     */
    public Arbol(Lista<User> ptrUsers) {
        users = ptrUsers;
        this.NR = new NodoRaiz();
    }
    
    /**
     * Clase que describe la estructura de un NodoRaiz, primer nodo de un Arbol
     * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
     */
    public class NodoRaiz {

        NodoUser linkU;   //Apuntador correspondiente al primer objeto NodoUser de la lista de hijos del NodoRaiz

        /**
         * COnstructor de la clase NodoRaiz
         */
        public NodoRaiz() {
            linkU = null;
        }
        
        /**
         * Método mediante el cual se asigna un NodoUser al atributo linkU del la raiz del Arbol
         * @param user Objeto User que se interpretará para traducirse en un NodoUser y ser agregado a la lista
         * @return Raiz del Arbol
         */
        public NodoRaiz setNodoU(User user) {
            if (linkU == null) {
                linkU = new NodoUser(user);
            }else{
                NodoUser p = linkU;
                while (p.linkU != null){
                    p = p.linkU;
                }
                p.linkU = new NodoUser(user);
            }
            return this;
        }
        
        /**
         * Método que permite conocer el número de hijos de un NodoUser
         * @param NU NodoUser del cual se quiere conocer su número de hijos
         * @return Entero correspondiente al número de hijos del NodoUser
         */
        public int numNodos(NodoUser NU){
            if (NU.linkU == null){
                return 0;
            }else{
                return 1 + numNodos(NU.linkU);
            }
        }

        /**
         * Metodo que permite acceder a un NodoUser perteneciente a los hijos de la raiz, por medio de su posicion en la lista
         * @param i Índice de la lista en el cual se encuentra el NodoUser buscado
         * @return NodoUser objetivo
         */
        public NodoUser getUser(int i) {
            NodoUser u = this.linkU;
            int cont = 0;
            while (u != null && cont < i){
                u = u.linkU;
                cont++;
            }
            return u;
        }

        /**
         * Metodo que permite acceder al primer NodoUser hijo de la raiz
         * @return NodoUser hijo
         */
        public NodoUser getLinkU() {
            return linkU;
        }
        
    }

    /**
     * Clase que describe la estructura de un NodoUser
     */
    public class NodoUser {
        
        /*
        Variables que representan los atributos de un objeto User, para poderlo traducir en un objeto NodoUser
        */
        int id;
        String name, userName, email, phone, webSite;
        Address address;
        Company company;
        NodoUser linkU;   //Apuntador correspondiente al siguiente elemento NodoUser de la lista enlazada
        NodoPost linkP;   //Apuntador correspondiente al primer hijo NodoPost del NodoUser

        /**
         * Constructor vacío de la clase NodoUser
         */
        public NodoUser() {
        }

        /**
         * Constructor no vacío de la clase NodoUser, usado para agregar nuevos elementos a la lista enlazada
         * @param user Objeto User que se interpretará para traducirse en un NodoUser
         */
        public NodoUser(User user) {
            linkP = new NodoPost((Post)user.getPosts().getObject());
            linkP = linkP.hermanosPost(user.getPosts().linkOb);
            linkU = null;
            this.id = user.getId();
            this.name = user.getName();
            this.userName = user.getUserName();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.webSite = user.getWebSite();
            this.address = user.getAddress();
            this.company = user.getCompany();
        }

        /**
         * Metodo que permite acceder a un NodoPost de la lista de publicaciones de un usuario, por medio de su posición en la lista
         * @param i Índice en el que se encuentra la publicación dentro de la lista
         * @return NodoPost objetivo
         */
        public NodoPost getPost(int i) {
            NodoPost p = this.linkP;
            int cont = 0;
            while (p != null && cont < i){
                p = p.linkP;
                cont++;
            }
            return p;
        }

        /**
         * Metodo que permite acceder al NodoUser hermano de un usuario
         * @return NodoUser hermano
         */
        public NodoUser getLinkU() {
            return linkU;
        }

        /**
         * Metodo que permite acceder a un hijo NodoPost de un usuario
         * @return NodoPost hijo
         */
        public NodoPost getLinkP() {
            return linkP;
        }

       /**
         * Metodo que permite acceder al ID de un usuario
         * @return Entero correspondiente al ID de un usuario
         */
        public int getId() {
            return id;
        }

        /**
         * Metodo que permite acceder al nombre de un usuario
         * @return String correspondiente a la nombre de un usuario
         */
        public String getName() {
            return name;
        }

        /**
         * Metodo que permite acceder al nombre de usuario de un usuario
         * @return String correspondiente al nombre de usuario de un usuario
         */
        public String getUserName() {
            return userName;
        }

        /**
         * Metodo que permite acceder al email de un usuario
         * @return String correspondiente al email de un usuario
         */
        public String getEmail() {
            return email;
        }

        /**
         * Metodo que permite acceder al teléfono de un usuario
         * @return String correspondiente al teléfono de un usuario
         */
        public String getPhone() {
            return phone;
        }

        /**
         * Metodo que permite acceder al WebSite de un usuario
         * @return String correspondiente al WebSite de un usuario
         */
        public String getWebSite() {
            return webSite;
        }

        /**
         * Metodo que permite acceder a la direccion de un usuario
         * @return Address correspondiente a la direccion de un usuario
         */
        public Address getAddress() {
            return address;
        }

        /**
         * Metodo que permite acceder a la compañia de un usuario
         * @return Company correspondiente a la compañia de un usuario
         */
        public Company getCompany() {
            return company;
        }
        
        /**
         * Método mediante el cual se añade un NodoUser cierta lista que contiene elementos User
         * @param user Objeto User que se interpretará para traducirse en un NodoUser y ser agregado a la lista
         * @return Primer elemento de la lista de NodoUser, hijos de la raíz
         */
        public NodoUser addNodoU(User user) {
            if (linkU == null) {
                linkU = new NodoUser(user);
            }else{
                NodoUser p = linkU;
                while (p.linkU != null){
                    p = p.linkU;
                }
                p.linkU = new NodoUser(user);
            }
            return this;
        }
        
        /**
         * Método mediante el cual se añade un NodoPost cierta lista que contiene elementos Post
         * @param post Objeto Post que se interpretará para traducirse en un NodoPost que se agregará a la lista
         * @return Primer elemento de una lista enlazada de elementos Post
         */
        public void setNodoP(Post post) {
            if (linkP == null) {
                linkP = new NodoPost(post);
            }else{
                NodoPost p = linkP;
                while (p.linkP != null){
                    p = p.linkP;
                }
                p.linkP = new NodoPost(post);
            }
        }
        
        /**
         * Método que permite conocer el número de hijos de un NodoUser
         * @param NP Primer elemento de la lista enlazada correspondiente a los hijos del NodoUser
         * @return Entero correspondiente al número de hijos de un NodoUser
         */
        public int numNodos(NodoPost NP){
            if (NP.linkP == null){
                return 0;
            }else{
                return 1 + numNodos(NP.linkP);
            }
        }

        /**
         * Metodo que condensa la información de un usuario no general
         * @return StringBuffer que contiene la información no general de un usuario condensada y ordenada
         */
        public StringBuffer show() {
            StringBuffer sb = new StringBuffer("");
            sb.append("Phone:\t"+phone+"\n");
            sb.append("WebSite:\t"+webSite+"\n");
            sb.append(address.show()+"\n");
            sb.append(company.show());
            return sb;
        }
    }

    /**
     * Clase que representa la estructura de un NodoPost
     */
    public class NodoPost {
        
        /*
        Variables que representan los atributos de un objeto Post, para poderlo traducir en un objeto NodoPost
        */
        int id, userID;   
        String tittle, body;
        NodoPost linkP;   //Apuntador correspondiente al siguiente NodoPost de la lista enlazada
        NodoComment linkC;   //Apuntador correspondiente al primer hijo NodoCommet del NodoPost

        /**
         * Constructor vacío de la clase NodoPost
         */
        public NodoPost() {
        }

        /** 
         * Constructor no vacío de la clase NodoPost, usado para agregar nuevos elementos a la lista Enlazada
         * @param post Objeto Post que se interpretará para traducirse en un NodoPost
         */
        public NodoPost(Post post) {
            try{
                linkC = new NodoComment((Comment)post.getComments().getObject());
                linkC = linkC.hermanosComment(post.getComments().linkOb);
                linkP = null;
                this.id = post.getId();
                this.userID = post.getUserID();
                this.tittle = post.getTittle();
                this.body = post.getBody();
            }catch(NullPointerException ex){
                
            }
        }

        /**
         * Metodo que permite acceder al ID de una publicacion
         * @return Entero correspondiente al ID de una publicación
         */
        public int getId() {
            return id;
        }

        /**
         * Metodo que permite acceder a un NodoComment hijo
         * @return NodoComment hijo
         */
        public NodoComment getLinkC() {
            return linkC;
        }

        /**
         * Metodo que permite acceder al hermano NodoPost 
         * @return NodoPost hermano
         */
        public NodoPost getLinkP() {
            return linkP;
        }

        /**
         * Metodo que permite acceder al ID del usuario que realizó la publicación
         * @return Entero correspondiente al ID del usuario que realizó la publicación
         */
        public int getUserID() {
            return userID;
        }

        /**
         * Metodo que permite acceder al título de una publicacion
         * @return String correspondiente al titulo de una publicación
         */
        public String getTittle() {
            return tittle;
        }

        /**
         * Metodo que permite acceder al cuerpo de una publicacion
         * @return String correspondiente al cuerpo de una publicacion
         */
        public String getBody() {
            return body;
        }
        
        /**
         * Método mediante el cual se añade un NodoPost cierta lista que contiene elementos Post
         * @param post Objeto Post que se interpretará para traducirse en un NodoPost que se agregará a la lista
         * @return Primer elemento de una lista enlazada de elementos Post
         */
        public NodoPost addNodoP(Post post) {
            if (linkP == null) {
                linkP = new NodoPost(post);
            }else{
                NodoPost p = linkP;
                while (p.linkP != null){
                    p = p.linkP;
                }
                p.linkP = new NodoPost(post);
            }
            return this;
        }
        
        /**
         * Método mediante el cual se añade un NodoComment a cierta lista que contiene elementos Comment
         * @param comment Objeto Comment que se interpretará para traducirse en un NodoComment que se agregará a al lista
         * @return Primer elemento de una lista enlazada de elementos Comment
         */
        public NodoPost setNodoC(Comment comment) {
            if (linkC == null) {
                linkC = new NodoComment(comment);
            }else{
                NodoComment p = linkC;
                while (p.linkC != null){
                    p = p.linkC;
                }
                p.linkC = new NodoComment(comment);
            }
            return this;
        }
        
        /**
         * Método que permite conocer le número de hijos de un NodoPost
         * @param NC Primer elemento de la lista enlazada correspondiente a los hijos de un NodoPost
         * @return Entero correspondiente al número de hijos de un NodoPost
         */
        public int numNodos(NodoComment NC){
            if (NC == null){
                return 0;
            }else{
                return 1 + numNodos(NC.linkC);
            }
        }
        
        /**
         * Método que añade a un NodoPost, sus hermanos
         * @param comments Primer elemento de la lista de publicaciones Post que se añadirá
         * @return NodoComment correspondiente al inicio de la lista de elementos NodoPost
         */
        public NodoPost hermanosPost(Lista<Post> posts) {
            Lista<Post> p = posts;
            try{
                while (p.linkOb != null){
                    this.addNodoP((Post)p.getObject());
                    p = p.linkOb;
                }
                this.addNodoP((Post)p.getObject());
            }catch(NullPointerException ex){
                
            }
            return this;
        }

        /**
         * Metodo que permite acceder a un NodoComment, por medio de su posición en la lista
         * @param i Índice del NodoComment en la lista de comentarios
         * @return NodoComment objetivo
         */
        public NodoComment getComment(int i) {
            NodoComment c = this.linkC;
            int cont = 0;
            while (c != null && cont < i){
                c = c.linkC;
                cont++;
            }
            return c;
        }
        
        /**
         * Método que condensa la información de un NodoPost
         * @param As Arbol con el cual se está trabajando
         * @return StringBuffer que contiene la información condensada y organizada de un NodoPost
         */
        public StringBuffer showPost(ArbolNA As){
            StringBuffer sb = new StringBuffer("");
            sb.append("Post's Tittle:\t"+tittle+"\n\n");
            sb.append(body+"\n");
            return sb;
        }

        /**
         * Método que condensa la información de varios Comment de una lista de elementos Comment
         * @param As Arbol con el cual se está trabajando
         * @param NC Primer elemento de una lista de NodoComment
         * @return StringBuffer que contiene la información condensada y organizada de todos los NodoComment a partir de NC
         */
        public StringBuffer showComments(ArbolNA As, NodoComment NC) {
            StringBuffer sb = new StringBuffer("");
            NodoComment c = NC;
            while (c != null) {
                sb.append("|Email:    "+c.email+"\n");
                sb.append("|Comment Name:    "+c.name+"\n");
                sb.append("|"+c.body+"\n");
                sb.append("\t___________________________________________________"+"\n\n");
                c = c.linkC;
            }
                
            return sb;
        }

        
    }

    /**
     * Clase que representa la estructura de un NodoComment
     */
    public class NodoComment {

        /*
        Variables que representan los atributos de un objeto Comment, para poderlo traducir en un objeto NodoComment
        */
        int id, postID;
        String name, email, body;
        NodoComment linkC;   //Apuntador correspondiente al siguiente elemento de la lista de elementos NodoComment

        
        /**
         * Constructor vacío de la clase NodoComment
         */
        public NodoComment() {
        }

        /**
         * Constructor no vacío de la clase NodoComment, usado para agregar nuevos elementos a la lista
         * @param comment Objeto Comment que se interpretará para ser traducido en un NodoComment
         */
        public NodoComment(Comment comment) {
            linkC = null;
            if (comment != null){
                this.id = comment.getId();
                this.postID = comment.getPostID();
                this.name = comment.getName();
                this.email = comment.getEmail();
                this.body = comment.getBody();
            }
        }

        /**
         * Metodo que retorna el ID de un Comment
         * @return Entero correspondiente a un ID de Comment
         */
        public int getId() {
            return id;
        }
        
        /**
         * Metodo que retorna el ID del post al que pertenece un Comment
         * @return Entero correspondiente al ID de un post
         */
        public int getPostID() {
            return postID;
        }

        /**
         * Metodo que retorna el nombre de un Comment
         * @return String correspondiente al nombre de un Comment
         */
        public String getName() {
            return name;
        }

        /**
         * Metodo que retorna el email de un Comment
         * @return String correspondiente al email de un Comment
         */
        public String getEmail() {
            return email;
        }

        /**
         * Metodo que retorna el cuerpo de un Comment   
         * @return String correspondiente al cuerpo de un Comment
         */
        public String getBody() {
            return body;
        }
        
        /**
         * Método mediante el cual se añade un NodoComment a cierta lista enlazada que contiene elementos Comment
         * @param comment Objeto Comment que se interpretará para traducirse en un NodoComment y ser agregado a la lista
         * @return Primer elemento de una lista enlazada de elementos Comment
         */
        public NodoComment addNodoC(Comment comment) {
            if (linkC == null) {
                linkC = new NodoComment(comment);
            }else{
                NodoComment p = linkC;
                while (p.linkC != null){
                    p = p.linkC;
                }
                p.linkC = new NodoComment(comment);
            }
            return this;
        }

        /**
         * Método que añade a un NodoComment, sus hermanos
         * @param comments Primer elemento de la lista de comentarios Comment que se añadirá
         * @return NodoComment correspondiente al inicio de la lista de elementos NodoComment
         */
        private NodoComment hermanosComment(Lista<Comment> comments) {
            try{
                Lista<Comment> p = comments;
                while (p.linkOb != null){
                this.addNodoC((Comment)p.getObject());
                p = p.linkOb;
                }
                this.addNodoC((Comment)p.getObject());
            }catch (Exception e){
                
            }
            return this;
        }
        
    }

    /**
     * Metodo que permite acceder a la lista enlazada de elementos User relacionada al Arbol
     * @return Primer elemento de una lista enlazada de elementos User
     */
    public Lista<User> getUsers() {
        return users;
    }

    /**
     * Metodo que permite acceder a la raíz de un Arbol
     * @return NodoRaiz de un Arbol
     */
    public NodoRaiz getNR() {
        return NR;
    }

}
