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

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public StringBuffer show() {
        StringBuffer sb = new StringBuffer("Geo: {\n");
        sb.append("\t\t"+this.latitud+"\n");
        sb.append("\t\t"+this.longitud+"\n\t}");
        return sb;
    }
    
}
