/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import javax.swing.JOptionPane;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 * Clase que actúa como interprete de los archivos que contienen la información
 * que se debe incluir en el árbol
 *
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class InterJSON {

    private UserJSON userJ;
    private PostJSON postJ;
    private CommentJSON commentJ;

    /**
     * Constructor de la clase InterJSON
     */
    public InterJSON(String rutaU, String rutaP, String rutaC) {
        this.userJ = new UserJSON(rutaU);
        this.postJ = new PostJSON(rutaP);
        this.commentJ = new CommentJSON(rutaC);
    }

    /**
     * Método que relaciona cada objeto Comment con su correspondiente Post
     *
     * @param posts Primer elemento de lista enlazada de objetos Post a los
     * cuales se agregarán objetos Comment
     * @param comments Primer elemento de lista enlazada de objetos Comment que
     * serán agregados a objetos Post
     * @return Primer elemento de una lista enlazada que contiene objetos Post
     * con sus respectivos objetos Comment agregados
     */
    public Lista<Post> IncluirComments(Lista<Post> posts, Lista<Comment> comments) {
        Lista<Post> po = posts;
        Lista<Comment> c = comments;
        while (po != null) {
            c = comments;
            while (c != null) {
                try{
                    if (po.getObject().getId() == c.getObject().getPostID()) {
                        po.getObject().addComment(c.getObject());
                    }
                }catch(Exception e){
                    
                }
                c = c.linkOb;
            }
            po = po.linkOb;
        }
        return posts;
    }

    /**
     * Método que unifica las listas enlazadas de User y Post de forma que los
     * elementos Post queden relacionados con sus correspondientes User
     *
     * @return Lista enlazada de elementos User, los cuales tienen cada uno sus
     * respectivos Post relacionados, y estos a su vez tienen sus respectivos
     * Comment relacionados
     */
    public Lista<User> Transformar() {
        Lista<User> usersT = userJ.GroupProperties();
        Lista<Post> postsT = postJ.GroupProperties();
        Lista<Comment> commentsT = commentJ.GroupProperties();
        
        postsT = IncluirComments(postsT, commentsT);
        Lista<User> u = usersT;
        Lista<Post> p = postsT;
        while (u != null) {
            p = postsT;
            while (p != null) {
                try{
                    if (u.getObject().getId() == p.getObject().getUserID()) {
                    u.getObject().addPost(p.getObject());
                    }
                }catch(NullPointerException ex){
                    
                }
                p = p.linkOb;
            }
            u = u.linkOb;
        }
        return usersT;
    }

    public UserJSON getUserJ() {
        return userJ;
    }

    public PostJSON getPostJ() {
        return postJ;
    }

    public CommentJSON getCommentJ() {
        return commentJ;
    }

    public void printComments() {
        Lista<Comment> c = commentJ.GroupProperties();
        Lista<Comment> p = c;
        while (p.linkOb != null) {
            p.getObject().show();
            p = p.linkOb;
        }
        p.getObject().show();
    }

    public void printUsers() {
        Lista<User> u = userJ.GroupProperties();
        Lista<User> p = u;
        while (p.linkOb != null) {
            p.getObject().show();
            p = p.linkOb;
        }
        p.getObject().show();
    }

    public void printPosts() {
        Lista<Post> po = postJ.GroupProperties();
        Lista<Post> p = po;
        while (p.linkOb != null) {
            p.getObject().show();
            p = p.linkOb;
        }
        p.getObject().show();
    }
}
