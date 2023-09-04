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
       

        for (int i = 0; i < 3; i++) {

            switch ((int) ((Math.random() * 2) + 1)) {

                case 1:
                    synchronized (C) {

                        System.out.println("----------------------------------" + nom + "------------------------------------------");
                        System.out.println("Saldo Inicial " + C.getSaldo());
                        int Monto = (int) (Math.random() * 200);
                        System.out.println("Monto a depositar " + Monto);
                        C.Depositar(Monto);
                        System.out.println("Saldo Actual " + C.getSaldo() + "\n");
                        C.notify();
                        C.notifyAll();
                    }
                    break;
                case 2:
    synchronized (C) {
                        int contador = 0;
                        System.out.println("");
                        System.out.println("----------------------------------" + nom + "------------------------------------------");
                        System.out.println("Saldo Inicial " + C.getSaldo());
                        int Monto2 = (int) (Math.random() * 150);

                        System.out.println("Monto a Retirar " + Monto2);

                        while (C.getSaldo() <= Monto2) {
                            System.out.println("No se pudo retirar ya que tu saldo es insuficiente");
                            System.out.println("Tu saldo es: " + C.getSaldo() + " Tu monto a retirar es de:" + Monto2);
                            int restante = Monto2 - C.getSaldo();
                            int Abono = Monto2 - restante;
                            System.out.println("Saldo Faltante " + restante);
                            System.out.println("se retiro el salto: " + Abono);
                            C.Retirar(Abono);
                            Monto2 = restante;

                            System.out.println("-----------" + "Proceso en espera " + nom + " Saldo faltante: " + restante + "--------------\n");

                            try {

                                C.wait(1000);

                                contador++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("-----------" + "Proceso de reanudación " + nom + "--------------");
                            System.out.println("Saldo: " + C.getSaldo());
                            System.out.println("Monto a Retirar " + Monto2);

                            if (contador >= 3) {
                                if (C.getSaldo() < Monto2) {
                                    System.out.println("El saldo no es suficiente: " + restante);
                                    Monto2 = 0;
                                    System.out.println("Saldo actual después de cobrar: " + C.getSaldo());
                                    contador++;
                                    Monto2 = 0;
                                }
                                System.out.println("Tres intentos realizados, no es posible realizar el retiro.");
                                return;
                            }
                        }

                        C.notify();
                        C.notifyAll();
                        C.Retirar(Monto2);
                        System.out.println("Saldo Actual " + C.getSaldo());
                        System.out.println("");

                        break;
                    }
            }
        }
                System.out.println("Gabriel Ernesto Rios Sanchez"); 



    }
    

}

//
//public void run() {
//    for (int i = 0; i < 2; i++) {
//        switch ((int) ((Math.random() * 2) + 1)) {
//            case 1:
//                synchronized (C) {
//                    // ... código de depósito ...
//                }
//                break;
//            case 2:
//                synchronized (C) {
//                    // ... código de retiro ...
//                }
//                break;
//        }
//    }
//}
//
//// Dentro del bloque de retiro:
//while (C.getSaldo() < Monto2) {
//    System.out.println("No se pudo retirar ya que tu saldo es insuficiente");
//    // ... mostrar detalles del saldo insuficiente ...
//
//    try {
//        System.out.println("Esperando 8 segundos...");
//        C.wait(8000);  // Esperar 8 segundos (8000 ms)
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//
//    // Después de esperar 8 segundos, verificar el saldo nuevamente
//    if (C.getSaldo() < Monto2) {
//        int saldoPendiente = Monto2 - C.getSaldo();
//        System.out.println("Cobrando saldo pendiente: " + saldoPendiente);
//        C.Depositar(saldoPendiente);  // Cobrar saldo pendiente
//        System.out.println("Saldo actual después de cobrar: " + C.getSaldo());
//        return;  // Terminar el hilo después de cobrar saldo pendiente
//    }
//}
