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
public class Usuario extends Thread {

    private String Nom;
    private int basura = 0;
    private int peso = 0;

    public Usuario() {
    }

    public Usuario(String Nom, int basura, int peso) {
        this.Nom = Nom;
        this.basura = basura;
        this.peso = peso;
    }

    public synchronized void basura(int num_B, int peso) {
        this.basura = this.basura + num_B;
        this.peso = this.peso + peso;
    }

    public synchronized void vaciar() {
        this.basura = 0;
        this.peso = 0;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getBasura() {
        return basura;
    }

    public void setBasura(int basura) {
        this.basura = basura;
    }


    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

 

}
