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
public class User {
    private int id;
    private String name, userName, email, phone, webSite;
    private Address address;
    private Company company;
    private ArrayList<Post> posts;
    
    
    public User(int id, String name, String userName, String email, Address address, String phone, String webSite, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.webSite = webSite;
        this.address = address;
        this.company = company;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
    
}
