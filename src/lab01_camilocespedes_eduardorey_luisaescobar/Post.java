/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

import java.util.ArrayList;

/**
 *
 * @author Camilo Cespedes
 */
public class Post {
    private int id, userID;
    private String tittle, body;
    private ArrayList<Comment> comments;

    public Post(int userID, int id, String tittle, String body) {
        this.id = id;
        this.userID = userID;
        this.tittle = tittle;
        this.body = body;
        comments = new ArrayList();
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    void show() {
        System.out.println(this.userID);
        System.out.println(this.id);
        System.out.println(this.tittle);
        System.out.println(this.body);
        for (Comment comment : comments) {
            comment.show();
        }
    }
    
}
