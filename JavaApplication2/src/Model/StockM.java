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
public class StockM {
  public   int N_prod;
   public String designation;
 

    public float prixachat;
    public float prixvent;
 
    public float qnt;

    public StockM(int N_prod, String designation,   float prixachat,float prixvent, float qnt) {
     this.N_prod=N_prod;
     this.designation=designation;
     this.prixachat=prixachat;
    this. prixvent=prixvent;
 
  this.qnt=qnt;

    }
 public StockM( String designation,   float prixachat,float prixvent, float qnt) {
    
     this.designation=designation;
     this.prixachat=prixachat;
    this. prixvent=prixvent;
 
  this.qnt=qnt;

    }
   
    public void setQnt(float qnt) {
        this.qnt = qnt;
    }

    public void setPrixvent(float prixvent) {
        this.prixvent = prixvent;
    }

    public void setN_prod(int N_prod) {
        this.N_prod = N_prod;
    }

    public void setPrixachat(float prixachat) {
        this.prixachat = prixachat;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getQnt() {
        return qnt;
    }

    public float getPrixvent() {
        return prixvent;
    }

    public float getPrixachat() {
        return prixachat;
    }

    public int getN_prod() {
        return N_prod;
    }

    public String getDesignation() {
        return designation;
    }
}
