/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.*;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 *
 * @author Camilo Cespedes
 */
public class UserJSON implements Extraccion{
    private ArrayList<Integer> ids;
    private ArrayList<String> names, userNames, emails, phones, webSites;
    private ArrayList<Address> addresses;
    private ArrayList<Company> companies;
    private File ruta;
    
    public UserJSON() {
        ruta = new File("src"+File.separator+"TXTs"+File.separator+"Users.txt");
        ids = ExtraerInts(LeerTexto(ruta));
        names = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"name\": \")([\\w\\.]+([\\s\\w]+)?)");
        userNames = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"username\": \")([\\w\\.]+([\\s\\.-_\\w]+)?)");
        emails = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"email\": \")[a-z-A-Z.-_]+@[a-z]+.[a-z]{2,4}");
        phones = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"phone\": \")(\\(?[\\d]{1,3}\\)?(-|\\.)?)?([\\d]{2,3}(-|\\.)){1,2}[\\d]{3,4}(\\sx[\\d]{3,5})?");
        webSites = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"website\": \")[\\w-_]+\\.[\\w]{2,3}");
        //addresses = GroupAddresses();
        companies = new ArrayList();
        
    }
    
    public ArrayList<User> GroupProperties(ArrayList<Integer> ids, ArrayList<String> names, ArrayList<String> userNames, ArrayList<String> emails, ArrayList<Address> addresses, ArrayList<String> phones, ArrayList<String> webSites, ArrayList<Company> companies){      
        ArrayList<User> u = new ArrayList();
        for (int i = 0; i < ids.size()-1; i++) {
            u.add(new User(ids.get(i), names.get(i), userNames.get(i), emails.get(i), addresses.get(i), phones.get(i), webSites.get(i), companies.get(i)));
        }
        return u;
    }
    
    public ArrayList<Address> GroupAddresses(ArrayList<String> streets, ArrayList<String> suites, ArrayList<String> cities, ArrayList<String> zipcodes, ArrayList<Geo> geos){
        /*  "street": "Kulas Light",
            "suite": "Apt. 556",
            "city": "Gwenborough",
            "zipcode": "92998-3874",
            "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
            }*/
        ArrayList<Address> addresses = new ArrayList();
        for (int i = 0; i < streets.size()-1; i++) {
            addresses.add(new Address(streets.get(i), suites.get(i), cities.get(i), zipcodes.get(i), geos.get(i)));
        }
        return addresses;
    }
    
    public StringBuffer LeerTexto(File ruta){
        StringBuffer sb = new StringBuffer("");
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea = br.readLine();
            while(linea != null){
                sb.append(linea+"\n");
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return sb;
    }
    public ArrayList<Integer> ExtraerInts(StringBuffer texto){
        ArrayList<Integer> integer = new ArrayList();
        Pattern p = Pattern.compile("(?<=\"id\": )[\\d]{1,2}");
        Matcher m = p.matcher(texto);
        while(m.find())
            ids.add(Integer.parseInt(m.group()));
        return ids;
    }
    public ArrayList<String> ExtraerTXT(StringBuffer texto, String pattern){
        ArrayList<String> txt = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while(m.find())
            txt.add(m.group());
        return txt;
    }
}
