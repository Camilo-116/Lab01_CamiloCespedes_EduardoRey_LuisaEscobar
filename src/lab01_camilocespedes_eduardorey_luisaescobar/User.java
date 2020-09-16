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
        posts = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    void show() {
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.userName);
        System.out.println(this.email);
        System.out.println(this.address.show());
        System.out.println(this.phone);
        System.out.println(this.webSite);
        System.out.println(this.company.show());
        for (Post post : posts) {
            post.show();
        }
    }

    
}
