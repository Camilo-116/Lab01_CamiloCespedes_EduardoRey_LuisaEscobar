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

    /**
     * Metodo que permite acceder a la calle de una direccion
     * @return String correspondiente a la calle de una direccion
     */
    public String getStreet() {
        return street;
    }

    /**
     * Metodo que permite acceder a la suite de una direccion
     * @return String correspondiente a la suite de una direccion
     */
    public String getSuite() {
        return suite;
    }

    /**
     * Metodo que permite acceder a la ciudad de una direccion
     * @return String correspondiente a la ciudad de una direccion
     */
    public String getCity() {
        return city;
    }

    /**
     * Metodo que permite acceder al codigo postal de una direccion
     * @return String correspondiente al codigo postal de una direccion
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Metodo que permite acceder a las coordenadas de una direccion
     * @return Geo correspondiente a las coordenadas de una direccion
     */
    public Geo getGeo() {
        return geo;
    }
    
    /**
     * Metodo que condensa la información de una direccion Address
     * @return StringBuffer que contiene la información textual de una direccion condensada y organizada
     */
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
