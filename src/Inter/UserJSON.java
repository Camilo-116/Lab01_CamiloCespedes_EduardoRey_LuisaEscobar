/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inter;

import java.io.*;
import java.util.Queue;
import java.util.regex.*;
import javax.swing.JOptionPane;
import lab01_camilocespedes_eduardorey_luisaescobar.*;

/**
 *Clase que interpreta la información del archivo TXT correspondiente a los Usuarios
 * @author Camilo Cespedes, Luisa Escobar, Eduardo Rey
 */
public class UserJSON implements Extraccion {

    private File ruta;// Variable que indica la ruta hacia el archivo a interpretar

    /**
     * Constructor de la clase UserJSON 
     * @param ruta direccion del archivo a interpretar
     */
    public UserJSON(String ruta) {
        this.ruta = new File(ruta);
    }

    /**
     * Método que extrae los atributos de cada usuario y los agrupa para crear objetos de tipo User e irlos agregando a la lista enlazada de usuarios que se retornará
     * 
     * @return Primer elemento de una lista enlazada que continene objetos User
     */ 
    public Lista<User> GroupProperties() {
        Lista<Integer> ids = ExtraerInts(LeerTexto(ruta), "(?<=\"id\": )[\\d]{1,2}");
        Lista<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"name\": \")([\\w\\.]+([\\s\\w]+)?)");
        Lista<String> userNames = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"username\": \")([\\w\\.]+([\\s\\.-_\\w]+)?)");
        Lista<String> emails = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"email\": \")[a-z-A-Z.-_]+@[a-z]+.[a-z]{2,4}");
        Lista<String> phones = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"phone\": \")(\\(?[\\d]{1,3}\\)?(-|\\.)?)?([\\d]{2,3}(-|\\.)){1,2}[\\d]{3,4}(\\sx[\\d]{3,5})?");
        Lista<String> webSites = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"website\": \")[\\w-_]+\\.[\\w]{2,3}");
        Lista<Address> addresses = GroupAddresses();
        Lista<Company> companies = GroupCompanies();

        Lista<User> u = new Lista();
        Lista<Integer> i = ids;
        Lista<String> n = names, un = userNames, e = emails, p = phones, w = webSites;
        Lista<Address> a = addresses;
        Lista<Company> c = companies;
        try{
            while (i.linkOb != null) {
                u.add(new User(i.getObject(), n.getObject(), un.getObject(), e.getObject(), (Address) a.getObject(), p.getObject(), w.getObject(), (Company) c.getObject()));
                i = i.linkOb; n = n.linkOb; un = un.linkOb; e = e.linkOb; a = a.linkOb; p = p.linkOb; w = w.linkOb; c = c.linkOb;
            }
            u.add(new User(i.getObject(), n.getObject(), un.getObject(), e.getObject(), (Address) a.getObject(), p.getObject(), w.getObject(), (Company) c.getObject()));
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "El archivo de usuarios escogido es inválido. Ingrese uno nuevamente", "ERROR", 0);
        }
        return u;
    }

    /**
     * Método que extrae los atributos de cada direccion y los agrupa para crear objetos de tipo Address e irlos agregando a la lista enlazada de direcciones que se retornará
     * 
     * @return Primer elemnto de una lista enlazada de objetos Address
     */ 
    public Lista<Address> GroupAddresses() {
        Lista<String> streets = ExtraerTXT(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"street\": \")[a-zA-Z]+((\\s{1,2}|-|_|\\.)[a-zA-Z]+)?");
        Lista<String> suites = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"suite\": \")(Apt\\.|Suite)\\s[\\d]{2,4}");
        Lista<String> cities = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"city\": \")[a-zA-Z]+(\\s[a-zA-Z]+)?");
        Lista<String> zipcodes = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"zipcode\": \")[\\d]{3,5}((\\s|-)[\\d]{3,5})?");
        Lista<Geo> geos = GroupGeos();

        Lista<Address> addresses = new Lista();
        Lista<String> st = streets, su = suites, c = cities, z = zipcodes;
        Lista<Geo> g = geos;
        try{
            while (st.linkOb != null) {
                addresses.add(new Address(st.getObject(), su.getObject(), c.getObject(), z.getObject(), (Geo) g.getObject()));
                st = st.linkOb; su = su.linkOb; c = c.linkOb; z = z.linkOb; g = g.linkOb;
            }
            addresses.add(new Address(st.getObject(), su.getObject(), c.getObject(), z.getObject(), (Geo) g.getObject()));
        }catch(NullPointerException ex){
            
        }
        return addresses;
    }

    /**
     * Metodo que agrupa los atributos de cada coordenada geografica y los agrupa para crear objetos de tipo Geo e irlos agregando a la lista enlazada de coordenadas que se retornará
     * 
     * @return Primer elemento de una lista enlazada de objetos Geo
     */
    public Lista<Geo> GroupGeos() {
        Lista<Float> latitudes = ExtraerFloat(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"lat\": \")-?[\\d]{1,3}.[\\d]{3,5}");
        Lista<Float> longitudes = ExtraerFloat(LeerTexto(ruta), "(?<=,\\s{1,10}\"lng\": \")-?[\\d]{1,3}.[\\d]{3,5}");

        Lista<Geo> geos = new Lista();
        Lista<Float> la = latitudes, lo = longitudes;
        try{
            while (la.linkOb != null) {
                geos.add(new Geo(la.getObject(), lo.getObject()));
                la = la.linkOb; lo = lo.linkOb;
            }
             geos.add(new Geo(la.getObject(), lo.getObject()));
        }catch(NullPointerException ex){
            
        }
        return geos;
    }

    /**
     * Metodo que agrupa los atributos de cada compañia y los agrupa para crear objetos de tipo Company e irlos agregando a la lista de compañias que se retornará
     * 
     * @return Primer elemento de una lista enlazada de objetos Company
     */
    public Lista<Company> GroupCompanies() {
        Lista<String> names = ExtraerTXT(LeerTexto(ruta), "(?<=\\{\\s{1,10}\"name\": \")[a-zA-Z]+((\\s|-|_)[a-zA-Z]+)?");
        Lista<String> catchPhrases = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"catchPhrase\": \")[a-zA-Z]+((\\s|-)[a-zA-Z]+)*");
        Lista<String> bss = ExtraerTXT(LeerTexto(ruta), "(?<=,\\s{1,10}\"bs\": \")[a-zA-Z]+((\\s|-)[a-zA-Z]+)*");

        Lista<Company> companies = new Lista();
        Lista<String> n = names, cp = catchPhrases, b = bss;
        try{
            while (n.linkOb != null) {
                companies.add(new Company(n.getObject(), cp.getObject(), b.getObject()));
                n = n.linkOb; cp = cp.linkOb; b = b.linkOb;
            }
            companies.add(new Company(n.getObject(), cp.getObject(), b.getObject()));
        }catch(NullPointerException ex){
            
        }
        return companies;
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
    
    /**
     * Metodo para extraer las coincidencias de objetos Float de cierta cadena de texto respecto a un patrón dado 
     * @param texto Texto a interpretar
     * @param pattern Patrón establecido para hallar coincidencias en el texto
     * @return Primer elemento de una lista enlazada de objetos Integer
     */
    public Lista<Float> ExtraerFloat(StringBuffer texto, String pattern) {
        Lista<Float> floats = new Lista();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(texto);
        while (m.find()) {
            floats.add(Float.parseFloat(m.group()));
        }
        return floats;
    }
}
