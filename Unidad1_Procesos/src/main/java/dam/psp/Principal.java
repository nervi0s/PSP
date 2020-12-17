package dam.psp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();
        long actualPID = ph.pid();
        System.out.print("Mensaje enviado desde el proceso cuyo ID es: " + actualPID + ": ");

        if (args.length == 0) {
            System.out.println("Debes pasar un parámetro 'abuelo' al programa.");
        } else {
            String argValue = args[0];

            File dir = new File("C:\\Users\\wdal9\\Documents\\NetBeansProjects\\ProcessPractices\\target\\classes");
            try {
                if (argValue.equalsIgnoreCase("abuelo")) {
                    ProcessBuilder child1 = new ProcessBuilder("java", "pack_01.Principal", "hijo1");
                    child1.directory(dir);
                    ProcessBuilder child2 = new ProcessBuilder("java", "pack_01.Principal", "hijo2");
                    child2.directory(dir);

                    Process child1Process = child1.start();
                    Process child2Process = child2.start();

                    System.out.println("Soy el Abuelo y tengo dos hijos: Padre 1 con PID = " + child1Process.pid() + " y Padre 2 con PID = "
                            + child2Process.pid() + ". Mi PID es: " + actualPID);

                    InputStream is_child1Process = child1Process.getInputStream();
                    int c;
                    while ((c = is_child1Process.read()) != -1) {
                        System.out.print((char) c);
                    }
                    is_child1Process.close();

                    InputStream is_child2Process = child2Process.getInputStream();
                    int c2;
                    while ((c2 = is_child2Process.read()) != -1) {
                        System.out.print((char) c2);
                    }
                    is_child2Process.close();

                } else if (argValue.equalsIgnoreCase("hijo1")) {
                    System.out.println("Soy el Padre 1 y mi PID es: " + actualPID + ". El PID de mi padre es: " + ph.parent().get().pid());

                    ProcessBuilder child1 = new ProcessBuilder("java", "pack_01.Principal", "nieto1");
                    Process child1Process = child1.start();

                    InputStream is_child1Process = child1Process.getInputStream();
                    int c;
                    while ((c = is_child1Process.read()) != -1) {
                        System.out.print((char) c);
                    }
                    is_child1Process.close();

                } else if (argValue.equalsIgnoreCase("hijo2")) {
                    System.out.println("Soy el Padre 2 y mi PID es: " + actualPID + ". El PID de mi padre es: " + ph.parent().get().pid());

                    ProcessBuilder child1 = new ProcessBuilder("java", "pack_01.Principal", "nietos_gemelos");
                    ProcessBuilder child2 = new ProcessBuilder("java", "pack_01.Principal", "nietos_gemelos");

                    Process child1Process = child1.start();
                    Process child2Process = child2.start();

                    InputStream is_child1Process = child1Process.getInputStream();
                    int c;
                    while ((c = is_child1Process.read()) != -1) {
                        System.out.print((char) c);
                    }
                    is_child1Process.close();

                    InputStream is_child2Process = child2Process.getInputStream();
                    int c2;
                    while ((c2 = is_child2Process.read()) != -1) {
                        System.out.print((char) c2);
                    }
                    is_child2Process.close();
                } else if (argValue.equalsIgnoreCase("nieto1")) {
                    System.out.println("Yo soy el hijo del Padre 1, su PID es: " + ph.parent().get().pid() + " y mi PID es: " + actualPID);
                } else if (argValue.equalsIgnoreCase("nietos_gemelos")) {
                    System.out.println("Yo soy el hijo del Padre 2, su PID es: " + ph.parent().get().pid() + " y mi PID es: " + actualPID);
                } else {
                    System.out.println("Parámerto incorrecto");
                }
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
