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
public class FournisseurM {
    public String nom;
   public int mobile ;
   public String email;
     public String adresse;
   public String nrc ;
   public String ai;
       public String aif;
   public String nis ;
   public String tin;

    public FournisseurM(String nom, int mobile, String email,String adresse,String nrc,String ai,String aif,String nis,String tin) {
        this.nom=nom;
   this.mobile=mobile;
    this.email=email;
    this.adresse=adresse;
   this.nrc=nrc;
   this.ai=ai;
    this.aif=aif;
    this.nis=nis ;
   this.tin=tin;
    }
    
    
}
