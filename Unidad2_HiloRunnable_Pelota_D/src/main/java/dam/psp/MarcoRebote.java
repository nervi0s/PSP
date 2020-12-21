package dam.psp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

//------------------------Marco con panel y botones---------------------------
//-----------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private PanelPelota panelDeLaPelota;
    private List<Thread> hilos = new ArrayList<>();
    private JButton iniciar;
    private JButton detener;
    private JComboBox listadoCombo;

    //Constructor
    public MarcoRebote() {

        setBounds(600, 300, 600, 350);

        setTitle("Rebotes");

        panelDeLaPelota = new PanelPelota();    // <-- Creamos el panel de la pelota

        add(panelDeLaPelota, BorderLayout.CENTER);  // <-- Añadimos al marco (JFrame) el panel de la pelota

        JPanel panelBotones = new JPanel();     // <-- Creamos el panel de los botones  

        //Boton para iniciar los hilos
        iniciar = new JButton("Iniciar");
        //Botone para parar los hilos
        detener = new JButton("Detener");
        //ComboBox con los hilos creados
        listadoCombo = new JComboBox();
        listadoCombo.setPreferredSize(detener.getPreferredSize());

        detener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener();
            }
        });

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego();
            }
        });

        panelBotones.add(iniciar);
        panelBotones.add(detener);
        panelBotones.add(listadoCombo);

        add(panelBotones, BorderLayout.SOUTH);   // <-- Añadimos al marco (JFrame) el panel de los botones
    }

    //Añade pelota y la mueve 3000 veces
    public void comienza_el_juego() {

        Pelota pelota = new Pelota();
        panelDeLaPelota.add(pelota);

        Runnable ph = new PelotaHilos(pelota, panelDeLaPelota);

        Thread hilo = new Thread(ph);

        hilo.setName("Hilo " + hilo.getId());
        hilo.start();
        hilos.add(hilo);

        listadoCombo.addItem(hilo.getName());

    }

    public void detener() {

        if (!hilos.isEmpty()) {
            String nombreHilo = (String) listadoCombo.getSelectedItem();

            for (Thread hilo : hilos) {
                if (hilo.getName().equals(nombreHilo)) {
                    hilo.interrupt();
                    hilos.remove(hilo);
                    break;
                }
            }
            listadoCombo.removeItem(nombreHilo);
        }

    }
} //Fin clase MarcoRebote
