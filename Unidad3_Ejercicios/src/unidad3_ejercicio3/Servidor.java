package unidad3_ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        int port = 50000;
        /*Necesitamos crearnos un ArrayList de objetos de tipo Socket donde alamacenaremos nuestras conexiones
        **con cada uno de nuestros clientes*/
        ArrayList<Socket> listaDeSockets = new ArrayList<>();

        try {
            ServerSocket socketLadoServidor = new ServerSocket(port);
            while (true) {
                System.out.println("Esperando a un cliente nuevo: ");
                listaDeSockets.add(socketLadoServidor.accept()); //Espera a que un cliente se conecte con el servidor

                //Cremos un variable que nos permita apuntar al último Socket añadido
                Socket ultimoSocked = listaDeSockets.get(listaDeSockets.size() - 1);
                System.out.println("Comunicación establecida con: " + ultimoSocked.getRemoteSocketAddress());

                //Creamos un hilo por cada cliente que se conecte a nuestro servidor
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hilo construido");
                        try {
                            boolean hayUnAsterisco = false;
                            //Cremos un varaible de tipo Socket cuyo ámbito o Scope sea el de cada hilo creado
                            Socket socketActual = ultimoSocked;

                            //Creamos nuestros Streams
                            InputStream is = socketActual.getInputStream();
                            OutputStream os = socketActual.getOutputStream();
                            ObjectOutputStream objetoSalida = new ObjectOutputStream(os);
                            ObjectInputStream objetoEntrada = new ObjectInputStream(is);

                            while (!hayUnAsterisco) {
                                //Leemos nuestro objeto a través del InputStream usando una envoltura de ObjectInputStream y comprobamos si algún campo es un '*'
                                Saludo saludoEntrante = (Saludo) objetoEntrada.readObject(); //Espera a leer
                                hayUnAsterisco = saludoEntrante.contieneAsterisco();

                                //System.out.println(is); //Para comprobar cada Stream
                                System.out.println("Saludo recibido de [" + socketActual.getRemoteSocketAddress() + "]: " + saludoEntrante);

                                //Enviamos nuestro objeto a través del OutputStream usando una envoltura de ObjectOutputStream
                                objetoSalida.writeObject(!hayUnAsterisco ? saludoEntrante : null); //Si el objeto recibido tiene un campo con asterisco, enviamos un nulo
                            }
                            System.out.println("Programa de cliente: " + socketActual.getRemoteSocketAddress() + " Terminado");

                            //Cerramos nuestros Steams
                            objetoSalida.close();
                            os.close();
                            objetoEntrada.close();
                            is.close();
                            socketActual.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
