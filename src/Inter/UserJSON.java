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

//Clase UserJSON que interpreta la información del archivo TXT correspondiente a los Usuarios
public class UserJSON implements Extraccion{
    
    private File ruta;// Variable que indica la ruta hacia el archivo a interpretar
    
    //Constructor de la clase UserJSON 
    public UserJSON() {
        ruta = new File("src"+File.separator+"TXTs"+File.separator+"Users.txt");
    }
    
    //Método que extrae los atributos de cada usuario y los agrupa para crear objetos de tipo User e irlos agregando al arreglo de usuarios que se retornará 
    public ArrayList<User> GroupProperties(){      
        ArrayList<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=\"id\": )[\\d]{1,2}");
        ArrayList<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"name\": \")([\\w\\.]+([\\s\\w]+)?)");
        ArrayList<String> userNames = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"username\": \")([\\w\\.]+([\\s\\.-_\\w]+)?)");
        ArrayList<String> emails = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"email\": \")[a-z-A-Z.-_]+@[a-z]+.[a-z]{2,4}");
        ArrayList<String> phones = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"phone\": \")(\\(?[\\d]{1,3}\\)?(-|\\.)?)?([\\d]{2,3}(-|\\.)){1,2}[\\d]{3,4}(\\sx[\\d]{3,5})?");
        ArrayList<String> webSites = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"website\": \")[\\w-_]+\\.[\\w]{2,3}");
        ArrayList<Address> addresses = GroupAddresses();
        ArrayList<Company> companies = GroupCompanies();
        
        ArrayList<User> u = new ArrayList();
        for (int i = 0; i < ids.size()-1; i++) {
            u.add(new User(ids.get(i), names.get(i), userNames.get(i), emails.get(i), addresses.get(i), phones.get(i), webSites.get(i), companies.get(i)));
        }
        return u;
    }
    
    //Método que extrae los atributos de cada direccion y los agrupa para crear objetos de tipo Address e irlos agregando al arreglo de direcciones que se retornará 
    public ArrayList<Address> GroupAddresses(){
        ArrayList<String> streets = ExtraerTXT(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"street\": \")[a-zA-Z]+((\\s{1,2}|-|_|\\.)[a-zA-Z]+)?");
        ArrayList<String> suites = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"suite\": \")(Apt\\.|Suite)\\s[\\d]{2,4}");
        ArrayList<String> cities = ExtraerTXT(LeerTexto(ruta),"(?<=,\\s{1,10}\"city\": \")[a-zA-Z]+(\\s[a-zA-Z]+)?");
        ArrayList<String> zipcodes = ExtraerTXT(LeerTexto(ruta),"(?<=,\\s{1,10}\"zipcode\": \")[\\d]{3,5}((\\s|-)[\\d]{3,5})?");
        ArrayList<Geo> geos = GroupGeos();
        ArrayList<Address> addresses = new ArrayList();
        for (int i = 0; i < streets.size()-1; i++) {
            addresses.add(new Address(streets.get(i), suites.get(i), cities.get(i), zipcodes.get(i), geos.get(i)));
        }
        return addresses;
    }
    
    //Metodo que agrupa los atributos de cada coordenada geografica y los agrupa para crear objetos de tipo Geo e irlos agregando al arreglo de coordenadas que se retornará
    public ArrayList<Geo> GroupGeos(){
        ArrayList<Float> latitudes = ExtraerFloat(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"lat\": \")-?[\\d]{1,3}.[\\d]{3,5}");
        ArrayList<Float> longitudes = ExtraerFloat(LeerTexto(ruta), "(?<=,\\s{1,10}\"lng\": \")-?[\\d]{1,3}.[\\d]{3,5}");
        ArrayList<Geo> geos = new ArrayList();
        for (int i = 0; i < latitudes.size()-1; i++) {
            geos.add(new Geo(latitudes.get(i), longitudes.get(i)));
        }
        return geos;
    }
    
    //Metodo que agrupa los atributos de cada compañia y los agrupa para crear objetos de tipo Company e irlos agregando al arreglo de compañias que se retornará
    public ArrayList<Company> GroupCompanies (){
        ArrayList<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"name\": \")[a-zA-Z]+((\\s|-|_)[a-zA-Z]+)?");
        ArrayList<String> catchPhrases = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"catchPhrase\": \")[a-zA-Z]+((\\s|-)[a-zA-Z]+)*");
        ArrayList<String> bss = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"bs\": \")[a-zA-Z]+((\\s|-)[a-zA-Z]+)*");
        ArrayList<Company> companies = new ArrayList();
        for (int i = 0; i < names.size()-1; i++) {
            companies.add(new Company(names.get(i), catchPhrases.get(i), bss.get(i)));
        }
        return companies;
    }
    
    @Override
    public StringBuffer LeerTexto(File file){
        StringBuffer sb = new StringBuffer("");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea = br.readLine();
            while(linea != null){
                sb.append(linea+"\n");
                linea = br.readLine();
            }
            br.close();
        }catch(IOException e){
            System.out.println("File not found");
        }
        
        return sb;
    }
    
    @Override
    public ArrayList<Integer> ExtraerInts(StringBuffer texto, String pattern){
        ArrayList<Integer> integers = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while(m.find())
            integers.add(Integer.parseInt(m.group()));
        return integers;
    }
    
    @Override
    public ArrayList<String> ExtraerTXT(StringBuffer texto, String pattern){
        ArrayList<String> txt = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while(m.find())
            txt.add(m.group());
        return txt;
    }
    public ArrayList<Float> ExtraerFloat(StringBuffer texto, String pattern){
        ArrayList<Float> floats = new ArrayList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while(m.find())
            floats.add(Float.parseFloat(m.group()));
        return floats;
    }
}
