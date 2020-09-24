/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;


/**
 * Clase que representa un usuario
 * @author Camilo Cespedes
 */
public class User {
    /*
    Atributos
    */
    private int id;
    private String name, userName, email, phone, webSite;
    private Address address;
    private Company company;
    private Lista<Post> ptrPosts;   //Primer elemento de la lista de elementos Post correspondientes al usuario
    
    /**
     * Constructor no vacío de la clase User
     * @param id id del User
     * @param name nombre del User
     * @param userName nombre de usuario del User
     * @param email email del User
     * @param address direccion del User
     * @param phone telefono del User
     * @param webSite sitio web del user
     * @param company compañía del User
     */
    public User(int id, String name, String userName, String email, Address address, String phone, String webSite, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.webSite = webSite;
        this.address = address;
        this.company = company;
        ptrPosts = new Lista();
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

    public Lista<Post> getPosts() {
        return ptrPosts;
    }

    public void addPost(Post post) {
        this.ptrPosts.add(post);
    }

    public void show() {
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.userName);
        System.out.println(this.email);
        System.out.println(this.address.show());
        System.out.println(this.phone);
        System.out.println(this.webSite);
        System.out.println(this.company.show());
        /*for (Post post : ptrPosts) {
            post.show();
        }*/
    }

    
}
