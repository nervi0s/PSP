/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.psp;

/**
 *
 * @author CFGS
 */
public class HilosPrioridades extends Thread {

    private int counter;

    @Override
    public void run() {
        while (true) {

            counter++;
        }
    }

    public void msg() {
        System.out.println(this.getPriority() + " " + counter);
    }

}
