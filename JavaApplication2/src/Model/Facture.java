/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Facture {
   public   int Id_client;
  public String date;
  public String houre;
  public int montant ;


    public Facture(int Id_client, String date, String houre, int montant) {
        this.Id_client = Id_client;
        this.date = date;
        this.houre = houre;
        this.montant = montant;
    }
  
}
