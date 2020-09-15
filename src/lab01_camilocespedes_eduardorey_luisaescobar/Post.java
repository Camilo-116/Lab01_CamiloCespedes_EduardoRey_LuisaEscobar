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
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    
}
