/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Abderrazak
 */
public class detailsAchat {
    
    public int id_Achat;
    public int id_produit;
 
    public int prixuntaire;
    public int quntite ;
    public int monatnt;
     public int prixvente;
    public String utilisateur ;
    public String produit;
     public String founisseur;

    public detailsAchat(int id_Achat,int id_produit,int prixuntaire,int quntite,int monatnt ,int prixvente, String utilisateur,String produit,String founisseur){
        this.id_Achat=id_Achat;
        this.id_produit=id_produit;
        this.prixuntaire=prixuntaire;
        this.quntite=quntite;
        this.monatnt=monatnt;
          this.prixvente=prixvente;
        this.utilisateur=utilisateur;
        this.produit=produit;
        this.founisseur=founisseur;
        
      
        
    }
        
    
    
    
}
