package unidad3_ejercicio1;

import java.io.Serializable;

public class Saludo implements Serializable {

    private String pais;
    private String ciudad;
    private String saludo;

    public Saludo() {

    }

    public Saludo(String pais, String ciudad, String saludo) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.saludo = saludo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    @Override
    public String toString() {
        return "Pais=" + pais + ", ciudad=" + ciudad + ", saludo=" + saludo;
    }

}
