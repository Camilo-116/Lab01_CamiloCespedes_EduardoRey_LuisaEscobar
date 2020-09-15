/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lab01_camilocespedes_eduardorey_luisaescobar.Post;

/**
 *
 * @author Camilo Cespedes
 */
public class PostJSON implements Extraccion {

    File ruta;

    public PostJSON() {
        File ruta = new File("src" + File.separator + "TXTs" + File.separator + "Posts.txt");
    }

    public ArrayList<Post> GroupProperties() {
        ArrayList<Integer> userIDs = ExtraerInts(LeerTexto(ruta), "(?<={\\s{1,10}\"userId\": )[\\d]{1,2}");
        ArrayList<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=,\\s{1,10}\"id\": )[\\d]{1,2}");;
        ArrayList<String> tittles = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"title\": \")[\\w]+(\\s\\w+)*");
        ArrayList<String> bodies = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"body\": \")[\\w]+((\\s|\\\\)\\w+)*");;
        
        ArrayList<Post> posts = new ArrayList();
        for (int i = 0; i < ids.size() - 1; i++) {
            posts.add(new Post(userIDs.get(i), ids.get(i), tittles.get(i), bodies.get(i)));
        }
        return posts;
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
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            while (linea != null) {
                sb.append(linea + "\n");
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return sb;
    }

}
