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
public class detailsFcture {
    public int id_facture;
    public int id_produit;
 
    public int prixvent;
    public int Qnt ;
    public int montant ;
    public String user;
    public String Produit;
    public String client; 


    public detailsFcture(int FindidFacture, int IDProduit, int prixvent, int quntite,int montant,String user,String Produit,String client) {
     this.prixvent=prixvent;
        this.id_produit=IDProduit;
        this.Qnt=quntite;
        this.id_facture=FindidFacture;
        this.montant=montant;
        this.user=user;
        this.Produit=Produit;
        this.client=client;
       
    }
        
    
    
    
}
