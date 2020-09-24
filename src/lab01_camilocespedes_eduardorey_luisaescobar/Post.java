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

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getTittle() {
        return tittle;
    }

    public String getBody() {
        return body;
    }

    public Lista<Comment> getComments() {
        return ptrComments;
    }
    
    public Lista<Comment> get(int i) {
        Lista<Comment> c = ptrComments;
        int cont = 0;
        while( cont<i && c != null){
            c = c.linkOb;
            cont++;
        }
        return c;
    }

    public void addComment(Comment comment) {
        this.ptrComments.add(comment);
    }

    public void show() {
        System.out.println(this.userID);
        System.out.println(this.id);
        System.out.println(this.tittle);
        System.out.println(this.body);
    }
    
}
