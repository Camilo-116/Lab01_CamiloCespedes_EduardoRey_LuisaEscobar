/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;


/**
 *Clase que representa un comentario perteneciente a un Post
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class Comment {
    /*
    Atributos
    */
    private int id, postID;
    private String name, email, body;

    /**
     * Constructor no vacío de la clase Comment
     * @param postID Id del Post en el cual se encuentra el Comment
     * @param id id del Comment
     * @param name nombre del Comment
     * @param email email referente al Comment
     * @param body cuerpo del Comment
     */
    public Comment(int postID, int id, String name, String email, String body) {
        this.id = id;
        this.postID = postID;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    /**
     * Metodo que permite acceder al ID de un comentario
     * @return Entero correspondiente al ID de un comentario
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que permite acceder al ID de la publicacion a la cual pertenece un comentario
     * @return Entero correspondiente al ID de la publicacion a la cual pertenece un comentario
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Metodo que permite acceder al nombre de un comentario
     * @return String correspondiente al nombre de un comentario
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite acceder al email de un comentario
     * @return String correspondiente al email de un comentario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que permite acceder al cuerpo de un comentario
     * @return String correspondiente al cuerpo de un comentario
     */
    public String getBody() {
        return body;
    }

    
}
