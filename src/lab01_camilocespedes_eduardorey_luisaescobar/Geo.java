/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

/**
 * Clase que representa las coordenadas peretenecientes a una dirección
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class Geo {
    /*
    Atributos
    */
    private float latitud, longitud;

    /**
     * Constructor no vacío de la clase Geo
     * @param latitud latitud de la coordenada
     * @param longitud longitud de la coordenada
     */
    public Geo(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * Metodo que permite acceder a la latitud de una coordenada
     * @return String correspondiente a la latitud de una coordenada
     */
    public float getLatitud() {
        return latitud;
    }

    /**
     * Metodo que permite acceder a la longitud de una coordenada
     * @return String correspondiente a la longitud de una coordenada
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * Metodo que condensa la informacion de una coordenada
     * @return StringBuffer que contiene la informacion textual de una coordenada condensada y organizada
     */
    public StringBuffer show() {
        StringBuffer sb = new StringBuffer("Geo: {\n");
        sb.append("\t\t"+this.latitud+"\n");
        sb.append("\t\t"+this.longitud+"\n\t}");
        return sb;
    }
    
}
