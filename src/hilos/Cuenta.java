/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

public class Cuenta {
    private String Nombre;
    private int Saldo;
    private int Num_Cue;

    public Cuenta() {
    }

    public Cuenta(String Nombre, int Saldo) {
        this.Nombre = Nombre;
        this.Saldo = Saldo;
       this.Num_Cue = (int)(Math.random()*100);
        
    }

   public synchronized void Depositar(int Monto){
       this.Saldo =this.Saldo+ Monto;
   }
  public synchronized void Retirar(int Monto){
      
       this.Saldo = this.Saldo-Monto;
 
      }
  
    public synchronized int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNum_Cue() {
        return Num_Cue;
    }

    public void setNum_Cue(int Num_Cue) {
        this.Num_Cue = Num_Cue;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "Nombre=" + Nombre + ", Saldo=" + Saldo + ", Num_Cue=" + Num_Cue + '}';
    }

    
}
