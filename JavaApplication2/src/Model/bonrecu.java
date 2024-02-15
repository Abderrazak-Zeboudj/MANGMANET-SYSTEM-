/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Abderrazak
 */
public class bonrecu {
     public   int Id_fournisseur;
  public String date;
  public String houre;
  public int montant ;


    public bonrecu(int Id_fournisseur, String date, String houre, int montant) {
        this.Id_fournisseur = Id_fournisseur;
        this.date = date;
        this.houre = houre;
        this.montant = montant;
    }
}
