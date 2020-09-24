/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.File;
import lab01_camilocespedes_eduardorey_luisaescobar.Lista;



/**
 * Interfaz que indica los métodos a usar para realizar acciones con los archivos a interpretar
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public interface Extraccion {
    /**
     * Metodo para extraer las coincidencias de objetos Integer de cierta cadena de texto respecto a un patrón dado 
     * @param texto Texto a interpretar
     * @param pattern Patrón establecido para hallar coincidencias en el texto
     * @return Primer elemento de una lista enlazada de objetos Integer
     */
    public Lista<Integer> ExtraerInts(StringBuffer texto, String pattern); 
    /**
     * Metodo para extraer las coincidencias de objetos String de cierta cadena de texto respecto a un patrón dado 
     * @param texto Texto a interpretar
     * @param pattern Patrón establecido para hallar coincidencias en el texto
     * @return Primer elemento de una lista enlazada de objetos String
     */
    public Lista<String> ExtraerTXT(StringBuffer texto, String pattern);
    /**
     * Método que realiza la lectura de un archivo de texto ubicado en una direccion de tipo File, para su posterior conversión a StringBuffer, conservando su estructura y saltos de línea
     * @param file Ruta del archivo a leer
     * @return Objeto StringBuffer que contiene la información contenida en el archivo intrpretado
     */
    public StringBuffer LeerTexto(File file);
}
