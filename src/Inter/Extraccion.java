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
public interface Extraccion {
    public ArrayList<Integer> ExtraerInts(StringBuffer texto, String pattern);
    public ArrayList<String> ExtraerTXT(StringBuffer texto, String pattern);
    public StringBuffer LeerTexto(File file);
}
