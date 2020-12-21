package dam.psp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//------------------------Marco con panel y botones---------------------------
//-----------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private PanelPelota panelDeLaPelota;
    private Thread hilo1, hilo2, hilo3;
    private JButton arrancar1, arrancar2, arrancar3;
    private JButton detener1, detener2, detener3;

    //Constructor
    public MarcoRebote() {

        setBounds(600, 300, 600, 350);

        setTitle("Rebotes");

        panelDeLaPelota = new PanelPelota();    // <-- Creamos el panel de la pelota

        add(panelDeLaPelota, BorderLayout.CENTER);  // <-- Añadimos al marco (JFrame) el panel de la pelota

        JPanel panelBotones = new JPanel();     // <-- Creamos el panel de los botones  

        //Botones para iniciar los hilos
        arrancar1 = new JButton("Hilo 1");
        arrancar2 = new JButton("Hilo 2");
        arrancar3 = new JButton("Hilo 3");
        //Botones para parar los hilos
        detener1 = new JButton("Detener 1");
        detener2 = new JButton("Detener 2");
        detener3 = new JButton("Detener 3");

        arrancar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        arrancar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        arrancar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        detener1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });

        detener2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });

        detener3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });

        panelBotones.add(arrancar1);
        panelBotones.add(arrancar2);
        panelBotones.add(arrancar3);
        panelBotones.add(detener1);
        panelBotones.add(detener2);
        panelBotones.add(detener3);

        add(panelBotones, BorderLayout.SOUTH);   // <-- Añadimos al marco (JFrame) el panel de los botones
    }

    //Añade pelota y la mueve 3000 veces
    public void comienza_el_juego(ActionEvent e) {

        Pelota pelota = new Pelota();
        panelDeLaPelota.add(pelota);

        Runnable ph = new PelotaHilos(pelota, panelDeLaPelota);

        JButton button = (JButton) e.getSource(); // Obtenemos información sobre el botón accionado

        if (button.equals(arrancar1)) {
            hilo1 = new Thread(ph);
            hilo1.start();
        } else if (button.equals(arrancar2)) {
            hilo2 = new Thread(ph);
            hilo2.start();
        } else if (button.equals(arrancar3)) {
            hilo3 = new Thread(ph);
            hilo3.start();
        }
    }

    public void detener(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // Obtenemos información sobre el botón accionado

        if (button.equals(detener1)) {
            hilo1.interrupt();
        } else if (button.equals(detener2)) {
            hilo2.interrupt();
        } else if (button.equals(detener3)) {
            hilo3.interrupt();
        }
    }
} //Fin clase MarcoRebote
