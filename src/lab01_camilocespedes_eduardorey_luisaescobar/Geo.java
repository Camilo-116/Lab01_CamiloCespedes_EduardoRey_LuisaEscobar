/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

/**
 *
 * @author Camilo Cespedes
 */
public class Geo {
    private float latitud, longitud;

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
        sb.append("\t"+this.latitud+"\n");
        sb.append("\t"+this.longitud+"\n");
        return sb;
    }
    
}
