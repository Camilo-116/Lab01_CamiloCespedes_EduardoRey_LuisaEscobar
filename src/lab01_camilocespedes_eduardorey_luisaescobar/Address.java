/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

/**
 * Clase que representa una direccion perteneciente a User
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class Address {
    /*
    Atributos
    */
    private String street, suite, city, zipCode;
    private Geo geo;

    /**
     * Cosntructor no vacío de la clase Address
     * @param street String correspondiente a atributo street
     * @param suite String correspondiente a atributo suite
     * @param city String correspondiente a atributo city
     * @param zipCode String correspondiente a atributo zipCode
     * @param geo Objeto Geo correposndiente a atributo geo
     */
    public Address(String street, String suite, String city, String zipCode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    public StringBuffer show() {
        StringBuffer sb = new StringBuffer("address: {\n");
        sb.append("\t"+this.street+"\n");
        sb.append("\t"+this.suite+"\n");
        sb.append("\t"+this.city+"\n");
        sb.append("\t"+this.zipCode+"\n");
        sb.append("\t"+this.geo.show()+"\n}");
        return sb;
    }
    
}
