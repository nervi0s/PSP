package dam.psp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//------------------------Marco con panel y botones---------------------------
//-----------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private PanelPelota panelDeLaPelota;

    //Constructor
    public MarcoRebote() {

        setBounds(600, 300, 400, 350);

        setTitle("Rebotes");

        panelDeLaPelota = new PanelPelota();    // <-- Creamos el panel de la pelota

        add(panelDeLaPelota, BorderLayout.CENTER);  // <-- Añadimos al marco (JFrame) el panel de la pelota

        JPanel panelBotones = new JPanel();     // <-- Creamos el panel de los botones  

        ponerBoton(panelBotones, "¡Comenzar!", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                comienza_el_juego();
            }

        });

        ponerBoton(panelBotones, "Salir", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                System.exit(0);

            }

        });

        add(panelBotones, BorderLayout.SOUTH);   // <-- Añadimos al marco (JFrame) el panel de los botones
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }

    //Añade pelota y la mueve 3000 veces
    public void comienza_el_juego() {

        Pelota pelota = new Pelota();
        panelDeLaPelota.add(pelota);

        Runnable ph = new PelotaHilos(pelota, panelDeLaPelota);
        Thread hilo = new Thread(ph);
        hilo.start();
    }
} //Fin clase MarcoRebote
