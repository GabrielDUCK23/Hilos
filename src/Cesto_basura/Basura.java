/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cesto_basura;

/**
 *
 * @author netor
 */
public class Basura extends Thread {

    private String nom;
    private int Basura;
    private int peso;

    Usuario U = new Usuario();

    public Basura(int Basura, int peso, String nom) {
        this.Basura = Basura;
        this.peso = peso;
        this.nom = nom;
    }

    @Override
    public void run() {
        int cesto = 0;
        if (U.getBasura() <= 10 || U.getPeso() <= 20) {
            cesto = 2;
        } else {
            cesto = 1;
        }

        for (int i = 0; i < 5; i++) {

            switch (cesto) {

                case 1:
                    synchronized (U) {
                        System.out.println("");
                        System.out.println("----------------------------------" + "Intendente" + "------------------------------------------");
                        System.out.println("El peso de cesto de basura es: " + U.getPeso() + " o el numero de basura es:"+U.getBasura());
                        System.out.println("el cesto de basura sera vaciado");
                        U.vaciar();
                        U.notify();
                        U.notifyAll();
                    }
                    break;
                case 2:
                    synchronized (U) {
                        System.out.println("----------------------------------" + nom + "------------------------------------------");
                        System.out.println("Numero de basura en el cesto " + U.getBasura());
                        int Peso = (int) (Math.random() * 5);
                        int basura = 1;
                        System.out.println("el peso de la basura fue " + Peso);
                        U.basura(basura, Peso);
                        System.out.println("numero de basura " + U.getBasura() + " Peso del cesto de basura: " + U.getPeso());
                        int contador = 0;
                        int PB = U.getBasura() + Peso;
                        int NB = U.getBasura() + basura;
                        
                        while (PB > 20 || NB > 10) {
                            System.out.println("No podras tirar la basura hasta que sea vaciado"+"PB "+PB+" NB "+NB );
                            System.out.println("el peso de tu basura es: " + Peso + "el cesto de basura solo soporta 20" +", el cesto tiene un peso" +U.getPeso()+" actualmente");
                            System.out.println("El cesto de basuras esta lleno:");
                            System.out.println("-----------" + "Proceso en espera: " + nom + " --------------\n");

                            try {

                                U.wait(1000);

                                contador++;

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("-----------" + "Proceso de reanudación " + nom + "--------------");
                            
                            System.out.println("ya puedes tirar tu basura: ");   
                        }

                        U.notify();
                        U.notifyAll();
                        U.basura(1, Peso);
                        System.out.println("el cesto de basura actualmente esta en" +U.getBasura()+"Con un peso de:"+U.getPeso());
                        System.out.println("");

                        break;
                    }
            }
        }
        System.out.println("Gabriel Ernesto Rios Sanchez");

    }

}
