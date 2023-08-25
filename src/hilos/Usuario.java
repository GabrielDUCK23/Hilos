/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Thread {

    private Cuenta C;
    private String nom;

    public Usuario(Cuenta C, String nom) {
        this.C = C;
        this.nom = nom;
    }

    @Override
    public void run() {

        for (int i = 0; i < 2; i++) {
            switch ((int) ((Math.random() * 2) + 1)) {

                case 1:
                    synchronized (C) {

                        System.out.println(nom);
                        System.out.println("Saldo Inicial " + C.getSaldo());
                        int Monto = (int) (Math.random() * 50);
                        System.out.println("Monto a depositar " + Monto);
                        C.Depositar(Monto);
                        System.out.println("Saldo Actual " + C.getSaldo() + "\n");
                        C.notifyAll();
                    }
                    break;
                case 2:
                    synchronized (C) {
                        System.out.println("");
                        System.out.println(nom);
                        System.out.println("Saldo Inicial " + C.getSaldo());
                        int Monto2 = (int) (Math.random() * 100);

                        System.out.println("Monto a Retirar " + Monto2);

                        while (C.getSaldo() < Monto2) {
                            System.out.println("No se pudo retirar ya que tu saldo es insuficiente");
                            System.out.println("Tu saldo es: " + C.getSaldo() + " Tu monto a retirar es de:" + Monto2);
                            int Restante=C.getSaldo()- Monto2;
                            System.out.println("Tu saldo es: " + Restante + " Tu monto a retirar es de:" + Monto2);

                            System.out.println("-----------"+ "Proceso en espera "+nom+"--------------");
                            
                            try {
                             C.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("-----------"+ "Proceso de reanuracion "+nom+"--------------");
                        }
                    
                    C.Retirar(Monto2);
                    System.out.println("Saldo Actual " + C.getSaldo());
                        System.out.println("");
                    break;
            }
        }

    }
    }
}


