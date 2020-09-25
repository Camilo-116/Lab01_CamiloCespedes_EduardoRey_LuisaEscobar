/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 *
 * @authors Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */

/**
 * Clase PostJSON que interpreta la información del archivo TXT correspondiente a los Posts
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class PostJSON implements Extraccion {

    File ruta;//Variable que indica la ruta hacia el arhivo a interpretar

    /**
     * Constructor de la clase PostJSON 
     */
    public PostJSON(String ruta) {
        this.ruta = new File(ruta);
    }

    /**
     * Método que extrae los atributos de cada post y los agrupa para crear objetos de tipo Post e irlos agregando a la lista enlazada de posts que se retornará
     * 
     * @return Primer elemento de una lista enlazada que contiene objetos Post
     */
    public Lista<Post> GroupProperties() {
        Lista<Integer> userIDs = ExtraerInts(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"userId\": )[\\d]{1,2}");
        Lista<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=,\\s{1,10}\"id\": )[\\d]{1,3}");;
        Lista<String> tittles = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"title\": \")[\\w]+(\\s\\w+)*");
        Lista<String> bodies = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"body\": \")[\\w]+((\\s|\\\\)\\w+)*");;
        
        Lista<Post> posts = new Lista();
        Lista<Integer> ui = userIDs, i = ids;
        Lista<String> t = tittles, b = bodies;
        try{
            while(i.linkOb != null) {
                posts.add(new Post(ui.getObject(), i.getObject(), t.getObject(), b.getObject()));
                ui = ui.linkOb; i = i.linkOb; t = t.linkOb; b = b.linkOb;
            }
            posts.add(new Post(ui.getObject(), i.getObject(), t.getObject(), b.getObject()));
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "El archivo de publicaciones escogido es inválido. Ingrese uno nuevamente", "ERROR", 0);
        }
        return posts;
    }

    @Override
    public Lista<Integer> ExtraerInts(StringBuffer texto, String pattern) {
        Lista<Integer> integers = new Lista();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while (m.find()) {
            integers.add(Integer.parseInt(m.group()));
        }
        return integers;
    }

    @Override
    public Lista<String> ExtraerTXT(StringBuffer texto, String pattern) {
        Lista<String> txt = new Lista();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while (m.find()) {
            txt.add(m.group());
        }
        return txt;
    }

    @Override
    public StringBuffer LeerTexto(File file) {
        StringBuffer sb = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea = br.readLine();
            while (linea != null) {
                sb.append(linea + "\n");
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return sb;
    }

}
