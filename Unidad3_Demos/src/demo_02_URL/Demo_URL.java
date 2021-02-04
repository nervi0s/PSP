package demo_02_URL;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo_URL {

    public static void main(String[] args) {
        URL url;

        try {
            System.out.println("Constructor simple con parámetro URL:");
            url = new URL("http://docs.oracle.com");
            visualizar(url);

            System.out.println("Otro constructor simple con parámetro URL:");
            url = new URL("http://localhost/PFC/gest/_cli_gestion.php?S=3");
            visualizar(url);

            System.out.println("Constructor simple con FTP:");
            url = new URL("ftp://ftp.rediris.es");
            visualizar(url);

            System.out.println("Constructor simple con parámetros protocolo, URL y directorio:");
            url = new URL("http", "docs.oracle.com", "/javase/15");
            visualizar(url);

            System.out.println("Constructor simple con parámetros protocolo, URL, puertp directorio:");
            url = new URL("https://www.google.com/search?q=java+15&oq=java+15&aqs=chrome..69i57j69i65l2.1395j0j1&sourceid=chrome&ie=UTF-8");
            visualizar(url);

            System.out.println("Constructor para URL a partir de una URL base: ");
            URL urlBase = new URL("http://docs.oracle.com");
            url = new URL(urlBase, "/javase/9/docs/api/java/net/URL.html");
            visualizar(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("\tgetDefaultPort(): " + url.getDefaultPort());
        System.out.println("----------------------------------------------");
    }
}
