/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.regex.*;
import javax.swing.JOptionPane;
import lab01_camilocespedes_eduardorey_luisaescobar.*;


/**
 * Clase CommentJSON que interpreta la información del archivo TXT correspondiente a los Comments
 * 
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class CommentJSON implements Extraccion{
    File ruta;//Variable que indica la ruta hacia el archivo a interpretar

    /**
     * Constructor de la clase CommentJSON
     */
    public CommentJSON(String ruta) {
        this.ruta = new File(ruta);
    }
    
    /**
     * Método que extrae los atributos de cada comentario y los agrupa para crear objetos de tipo Comment e irlos agregando al arreglo de comentarios que se retornará
     * @return Primer elemento de una lista enlazada con elementos Comment
     */
    public Lista<Comment> GroupProperties() {
        Lista<Integer> postIDs = ExtraerInts(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"postId\": )[\\d]{1,3}");
        Lista<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=,\\s{1,10}\"id\": )[\\d]{1,3}");
        Lista<String> emails = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"email\": \")[a-zA-Z-_\\.]+@[a-zA-Z-]+.[a-z]{2,4}");
        Lista<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"name\": \")[\\w]+(\\s\\w+)*");
        Lista<String> bodies = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"body\": \")[\\w]+((\\s|\\\\)\\w+)*");
        
        Lista<Comment> comments = new Lista();
        Lista<Integer> i = ids, pi = postIDs;
        Lista<String> e = emails, n = names, b = bodies;
        try{
            while (i.linkOb != null) {
                comments.add(new Comment(pi.getObject(), i.getObject(), n.getObject(), e.getObject(), b.getObject()));
                i = i.linkOb; pi = pi.linkOb; e = e.linkOb; n = n.linkOb; b = b.linkOb;
            }
            comments.add(new Comment(pi.getObject(), i.getObject(), n.getObject(), e.getObject(), b.getObject()));
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "El archivo de comentarios escogido es inválido. Ingrese uno nuevamente", "ERROR", 0);
        }
            
        return comments;
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
