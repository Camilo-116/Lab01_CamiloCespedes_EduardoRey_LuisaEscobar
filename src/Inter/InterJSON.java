/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.util.ArrayList;
import lab01_camilocespedes_eduardorey_luisaescobar.User;

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
        ArrayList<User> usersT = new ArrayList();
        return usersT;
    }
}
