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
public class Principal {

    public static void main(String[] args) {

        Usuario U = new Usuario("Mario", 0, 0);
        Basura User1 = new Basura(U.getBasura(),U.getPeso(),"Mariana");
        Basura User2 = new Basura(U.getBasura(),U.getPeso(),"Jose");
        Basura User3 = new Basura(U.getBasura(),U.getPeso(),"Gabriel");
        System.out.println("Gabriel Ernesto Rios Sanchez");

        User1.start();
        User2.start();
        User3.start();

    }

}
