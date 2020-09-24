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

    public int getId() {
        return id;
    }

    public int getPostID() {
        return postID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public void show() {
        System.out.println(this.postID);
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.email);
        System.out.println(this.body);
    }
    
}
