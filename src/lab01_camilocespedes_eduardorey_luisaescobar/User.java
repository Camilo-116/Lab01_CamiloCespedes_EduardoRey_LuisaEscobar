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

    /**
     * Metodo que permite acceder al ID de un User
     * @return Entero correspondiente al ID de un User
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que permite acceder al nombre de un User
     * @return String correspondiente al nombre de un User
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite acceder al nombre de usuario de un User
     * @return String correspondiente al nombre de usuario de un User
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Metodo que permite acceder al email de un User
     * @return String correspondiente al email de un User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que permite acceder al teléfono de un User
     * @return String correspondiente al teléfono de un User
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Metodo que permite acceder al sitio web de un User
     * @return String correspondiente al sitio web de un User
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * Metodo que permite acceder a la direccion de un User
     * @return Address correspondiente a la direccion de un User
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Metodo que permite acceder a la compañia de un User
     * @return Company correspondiente a la compañia de un User
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Metodo que permite acceder a la lista de publicaciones de un User
     * @return Primer elemento de una lista de elementos Post
     */
    public Lista<Post> getPosts() {
        return ptrPosts;
    }

    /**
     * Metodo que permite añadir una publicacion a la lista de publicaciones de un User
     * @param post publicacion que se añadirá a la lista
     */
    public void addPost(Post post) {
        this.ptrPosts.add(post);
    }

    
}
