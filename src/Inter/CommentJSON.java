/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
import lab01_camilocespedes_eduardorey_luisaescobar.Comment;

/**
 *
 * @author Camilo Cespedes
 */

//Clase CommentJSON que interpreta la información del archivo TXT correspondiente a los Comments
public class CommentJSON implements Extraccion{
    File ruta;//Variable que indica la ruta hacia el archivo a interpretar

    //COnstructor de la clase CommentJSON
    public CommentJSON() {
        ruta = new File("src" + File.separator + "TXTs" + File.separator + "Comments.txt");
    }
    
    //Método que extrae los atributos de cada comentario y los agrupa para crear objetos de tipo Comment e irlos agregando al arreglo de comentarios que se retornará
    public ArrayList<Comment> GroupProperties() {
        ArrayList<Integer> postIDs = ExtraerInts(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"postId\": )[\\d]{1,3}");
        ArrayList<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=,\\s{1,10}\"id\": )[\\d]{1,3}");
        ArrayList<String> emails = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"email\": \")[a-zA-Z-_\\.]+@[a-zA-Z-]+.[a-z]{2,4}");
        ArrayList<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"name\": \")[\\w]+(\\s\\w+)*");
        ArrayList<String> bodies = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"body\": \")[\\w]+((\\s|\\\\)\\w+)*");
        
        ArrayList<Comment> comments = new ArrayList();
        for (int i = 0; i < ids.size() - 1; i++) {
            comments.add(new Comment(postIDs.get(i), ids.get(i), names.get(i), emails.get(i), bodies.get(i)));
        }
        return comments;
    }

    @Override
    public ArrayList<Integer> ExtraerInts(StringBuffer texto, String pattern) {
        ArrayList<Integer> integers = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while (m.find()) {
            integers.add(Integer.parseInt(m.group()));
        }
        return integers;
    }

    @Override
    public ArrayList<String> ExtraerTXT(StringBuffer texto, String pattern) {
        ArrayList<String> txt = new ArrayList();
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
