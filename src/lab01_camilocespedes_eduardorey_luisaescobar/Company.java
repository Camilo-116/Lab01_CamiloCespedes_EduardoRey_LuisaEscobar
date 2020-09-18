/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_camilocespedes_eduardorey_luisaescobar;

/**
 *
 * @author Camilo Cespedes
 */
public class Company {
    private String name, catchPhrase, bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public StringBuffer show() {
        StringBuffer sb = new StringBuffer("Company: {\n");
        sb.append("\t"+this.name+"\n");
        sb.append("\t"+this.catchPhrase+"\n");
        sb.append("\t"+this.bs+"\n}");
        return sb;
    }
    
}
