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

    public ArrayList<Post> IncluirComments(ArrayList<Post> posts, ArrayList<Comment> comments) {
        for (Post post : posts) {
            for (Comment comment : comments) {
                if (comment.getPostID() == post.getId()) {
                    post.addComment(comment);
                }
            }
        }
        return posts;
    }

    public ArrayList<User> Transformar() {
        ArrayList<User> usersT = userJ.GroupProperties();
        ArrayList<Post> postsT = postJ.GroupProperties();
        ArrayList<Comment> commentsT = commentJ.GroupProperties();
        postsT = IncluirComments(postsT, commentsT);
        for (User user : usersT) {
            for (Post post : postsT) {
                if (post.getUserID() == user.getId()) {
                    user.addPost(post);
                }
            }
        }
        return usersT;
    }
}
