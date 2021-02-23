package unidad3_ejercicio3;

import java.io.Serializable;

public class Saludo implements Serializable {

    private String ciudad;
    private String pais;
    private String saludo;

    public Saludo() {

    }

    public Saludo(String pais, String ciudad, String saludo) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.saludo = saludo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public boolean contieneAsterisco() {
        if (ciudad.equals("*") || pais.equals("*") || saludo.equals("*")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pais=" + pais + ", Ciudad=" + ciudad + ", Saludo=" + saludo + ".";
    }

}
