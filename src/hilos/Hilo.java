/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

/**
 *
 * @author DELL
 */
public class Hilo{
    public static void main(String[] args) {
Cuenta C = new Cuenta("Mario",100);
Usuario User1 = new Usuario(C, "Mario");
Usuario User2 = new Usuario(C, "Jose");
Usuario User3 = new Usuario(C, "Pepe");
     System.out.println("Gabriel Ernesto Rios Sanchez"); 

User1.start();
User2.start();
User3.start(); 
     
     
     
    }
    
}

