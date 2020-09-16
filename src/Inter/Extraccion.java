/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Camilo Cespedes
 */

//Interfaz Extraccion que indica los métodos a usar para realizar acciones con los archivos a interpretar
public interface Extraccion {
    public ArrayList<Integer> ExtraerInts(StringBuffer texto, String pattern); //Metodo para extraer las coincidencias de enteros de cierta cadena de texto coincidentes con un patrón. Retorna un arreglo de objetos de tipo Integer
    public ArrayList<String> ExtraerTXT(StringBuffer texto, String pattern);//Metodo para extraer las coincidencias de cadenas de texto coincidentes con un patrón. Retorna un arreglo de objetos tipo String
    public StringBuffer LeerTexto(File file);//Método que realiza la lectura de un archivo de texto ubicado en la direccion <<file>> de tipo File, para su posterior conversión a StringBuffer, conservando su estructura y saltos de línea
}
