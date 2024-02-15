/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author AmineGasa
 */
public class AchatM {
 
     public int	Id_produit;
      public String designation;
    public String nomfournisseur;
  
    public  int quantité ;		 
 	public int prix_unitaire ;
         public int Montant_HT;
    public  int Montant_TVA;
    public   int Montant_TTC;
   public  int  PV;

    public AchatM(int	Id_produit,String designation,String nomfournisseur, int quantité, int prix_unitaire ,int PV, int Montant_HT, int Montant_TVA,   int Montant_TTC) {
        this.Id_produit=Id_produit;
        this.designation=designation;
        this.nomfournisseur=nomfournisseur;
        this.quantité=quantité;
        this.prix_unitaire=prix_unitaire;
        this.PV=PV;
        this.Montant_HT=Montant_HT;
        this.Montant_TVA=Montant_TVA;
        this.Montant_TTC=Montant_TTC;
       
    }

    public int getMontant_TVA() {
        return Montant_TVA;
    }

    public int getPV() {
        return PV;
    }

    public int getMontant_TTC() {
        return Montant_TTC;
    }

    public int getMontant_HT() {
        return Montant_HT;
    }

    public String getDesignation() {
        return designation;
    }

    public int getId_produit() {
        return Id_produit;
    }

    

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId_produit(int Id_produit) {
        this.Id_produit = Id_produit;
    }

  
    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   
}
