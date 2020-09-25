/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;


/**
 * Clase que representa una publicación hecha por un User
 * @author Camilo Cespedes
 */
public class Post {
    /*
    Atributos
    */
    private int id, userID;
    private String tittle, body;
    private Lista<Comment> ptrComments;   //Primer elemento de la lista de elementos Comment de un Post

    /**
     * Constructor no vacío de la clase Post
     * @param userID id del usuario que publicó el Post
     * @param id id del Post
     * @param tittle titulo del Post
     * @param body cuerpo del Post
     */
    public Post(int userID, int id, String tittle, String body) {
        this.id = id;
        this.userID = userID;
        this.tittle = tittle;
        this.body = body;
        ptrComments = new Lista();
    }

    /**
     * Metodo que permite acceder al ID de un Post
     * @return Entero correspondiente al ID de un Post
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que permite acceder al ID del usuario que publicó el Post
     * @return Entero correspondiente al ID del usuario que publicó el Post
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Metodo que permite acceder al titulo de un Post
     * @return String correspondiente al titulo de un Post
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * Metodo que permite acceder al cuerpo de un Post
     * @return String correspondiente al cuerpo de un Post
     */
    public String getBody() {
        return body;
    }

    /**
     * Metodo que permite acceder al primer elemento de la lista de comentarios de un Post
     * @return Lista correspondiente al primer elemento de la lista de comentarios de un Post
     */
    public Lista<Comment> getComments() {
        return ptrComments;
    }

    /**
     * Metodo que agrega un Comment a la lista de elementos Comment de un Post
     * @param comment comentario que se agregará a la lista
     */
    public void addComment(Comment comment) {
        this.ptrComments.add(comment);
    }
    
}
