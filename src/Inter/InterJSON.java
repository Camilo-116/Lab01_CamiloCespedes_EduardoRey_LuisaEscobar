/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.util.ArrayList;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 *
 * @author Camilo Cespedes
 */
public class InterJSON {
    private UserJSON userJ;
    private PostJSON postJ;
    private CommentJSON commentJ;

    public InterJSON() {
        this.userJ = new UserJSON();
        this.postJ = new PostJSON();
        this.commentJ = new CommentJSON();
    }
    
    public ArrayList<User> Transformar(){
        ArrayList<User> usersT = userJ.GroupProperties();
        ArrayList<Post> postsT = postJ.GroupProperties();
        ArrayList<Comment> commentsT = commentJ.GroupProperties();
        for (User user : usersT) {
            for (Post post : postsT) {
                for (Comment comment : commentsT) {
                    if (comment.getPostID()== post.getId())
                        post.addComment(comment);
                }
                if(post.getUserID() == post.getId())
                    user.addPost(post);
            }
        }
        return usersT;
    }
}
