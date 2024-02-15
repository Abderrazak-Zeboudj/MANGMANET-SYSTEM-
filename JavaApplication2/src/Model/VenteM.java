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
public class VenteM {

    int N_produit;
    String desginastion ;
 String service ;
     int qnt;
    String marchendise;
    int Prixvent;
    int benefice;
    String date;
    int Montant_HT;
     int Montant_TVA;
      int Montant_TTC;
      int PrixService;
      int ID_DETAILS;
    public Object test;

    public VenteM(int N_vente, String nom_prenom, String  service, String marchendise, int Prixvent, int benefice, String date) {
        this.N_produit = N_vente;
        this.desginastion = desginastion;
        this.service = service;
        this.marchendise = marchendise;
        this.Prixvent = Prixvent;
        this.benefice = benefice;
        this.date = date;
        
    }
    public VenteM(int N_produit,String desginastion,String service,int PrixService,int qnt,int Prixvent ,int Montant_HT,int Montant_TVA,int Montant_TTC ){
        this.N_produit = N_produit;
        this.desginastion = desginastion;
        this.service = service;
        this.qnt = qnt;
        this.Prixvent = Prixvent;
   
       this. Montant_HT=Montant_HT;
          this. Montant_TVA=Montant_TVA;
        this. Montant_TTC=Montant_TTC;
        this.PrixService=PrixService;
        this.ID_DETAILS=ID_DETAILS;
    }

    public int getMontant_HT() {
        return Montant_HT;
    }

    public int getID_DETAILS() {
        return ID_DETAILS;
    }

    public int getPrixService() {
        return PrixService;
    }

    public int getMontant_TVA() {
        return Montant_TVA;
    }

    public int getMontant_TTC() {
        return Montant_TTC;
    }

    public void setN_produit(int N_produit) {
        this.N_produit = N_produit;
    }
    

    public String getMarchendise() {
        return marchendise;
    }

    public void setDesginastion(String desginastion) {
        this.desginastion = desginastion;
    }

    public int getBenefice() {
        return benefice;
    }

   

    public String getDate() {
        return date;
    }

    public String getDesginastion() {
        return desginastion;
    }

    public int getN_produit() {
        return N_produit;
    }

    public int getPrixvent() {
        return Prixvent;
    }

    public String getService() {
        return service;
    }

    public void setBenefice(int benefice) {
        this.benefice = benefice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMarchendise(String marchendise) {
        this.marchendise = marchendise;
    }

   

    public void setPrixvent(int Prixvent) {
        this.Prixvent = Prixvent;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
 


}