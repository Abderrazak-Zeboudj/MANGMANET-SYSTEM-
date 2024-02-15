                   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;
import IHM.Achat;
import IHM.Fournniseur;
import IHM.Home;
import Model.AchatM;
import Model.ClientM;
import Model.Facture;
import Model.FournisseurM;
import Model.ServiceM;
import Model.StockM;
import Model.Utlisateur;
import Model.VenteM;
import Model.bonrecu;
import Model.detailsAchat;
import Model.detailsFcture;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.Debug.id;
import net.proteanit.sql.DbUtils;

public class ConnectDB {

          
    private final String User = "postgres";
    private final String password = "qwqw";
    String ipLocal = "localhost";

    private String url = "jdbc:postgresql://" + ipLocal + ":5432/bahaibh";
    private Connection cnx;
    private PreparedStatement st, jt;
    private ResultSet rst;

    public void DeleteAllElementTab(JTable T, int column, int row) {
        int i = 0;
        int j = 0;
        while (i < row) {
            while (j <= column) {
                T.setValueAt("", i, j);
                j++;
            }
            j = 0;
            i++;
        }

    }
 ArrayList<String> Rplace(ArrayList<String> ar) {
        ArrayList<String> rpl = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < ar.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (ar.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(ar.get(K));
            }
            K++;
        }

        return rpl;
    }
    public String showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" YYYY-MM-dd");
        return sdf.format(d);

    }

    public String showDateTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);

    }

    public void ConnexionIntoDataBase() {
 
        try {
            Class.forName("org.postgresql.Driver");
       
            try {
                  System.out.println("Driver OK");
                cnx = DriverManager.getConnection(url, User, password);
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
                exit();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public int FindUser(String admin,String user, String pass) {
         int r=0;
        try {
           
            String sql="select * from login where nom=? and pass=? and type=? ";
           st=cnx.prepareStatement(sql);
            st.setString(1,user);
            st.setString(2,pass);
             st.setString(3,admin);
          rst=st.executeQuery();
            if(rst.next()){
              r=1;
            }else {
               r=0;
               
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }        return r;
}
                      public void FindNomusr(JComboBox combo) {
        try {
           
            String sql = "select nom from login";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
 public void ALLUsers(JTable T) {
        try {
           String sql = "select idu AS \"N°UTILISATEUR\" ,nom AS \"Nom UTILISATEUR\",pass AS \"MOTS DE PASS\",type AS \"TYPE UTILISATEUR\" from public.login";
//            String sql = "select*from login";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
                 T.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }

        public void insertUser(Utlisateur M) {
       
        try {
                         String sql1 = " INSERT INTO login (" +
" nom, pass, type)" +
"	VALUES  ('"+M.Name+"','"+M.password+"','"+M.types+"') ";

           
//            String sql1 = " INSERT INTO Client VALUES ('"+cl.nom+ "'," + cl.mobile + "," +cl.email + ","+cl.adresse +","+cl.nrc +","+cl.ai +","+cl.aif +","+cl.nis +","+cl.tin +") ";
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
         public void UpdatUser(int ID, Utlisateur M) {
         
        try { 
             
            
              String sql = "UPDATE public.login set nom='"+M.Name+"', pass=" + M.password + ", type='" +M.types + "'  where idu="+ID+"";

              st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
            public void Deleteuser(int id) {
        String sql = "DELETE FROM login WHERE idu=" + id;
        try {
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
                      public void FindUser(JTable T, String word) {
        try {
           
            String sql = "SELECT * FROM login WHERE nom like '" + word + "%'  ";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
  //*****************************************************************************************
      
    public void insertClient(ClientM cl) {
       
        try {
                         String sql1 = " INSERT INTO Client (" +
" nom, mobile, email, adrasse, nrc, ai, aif, nis, tin)" +
"	VALUES  ('"+cl.nom+ "'," + cl.mobile + ",'" +cl.email + "','"+cl.adresse +"','"+cl.nrc +"','"+cl.ai +"','"+cl.aif +"','"+cl.nis +"','"+cl.tin +"') ";

           
//            String sql1 = " INSERT INTO Client VALUES ('"+cl.nom+ "'," + cl.mobile + "," +cl.email + ","+cl.adresse +","+cl.nrc +","+cl.ai +","+cl.aif +","+cl.nis +","+cl.tin +") ";
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
      public void AllClient(JTable T) {
        try {
            System.err.println("requte ");
            
            String sql = "select nc AS \"N°Client\", nom AS \"Nom Client\", mobile AS \"N°Telephone\", email AS \"Email\", adrasse AS \"Adrasse\", nrc AS \"N°RC\", ai AS \"NCB\", aif AS \"AIF\", nis AS \"NIS\", tin AS \"TIN\" from client";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
                 T.setModel(DbUtils.resultSetToTableModel(rst));
            


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
      public void FindClient(JTable T, String word) {
        try {
           
            String sql = "SELECT * FROM client WHERE nom like '" + word + "%'  ";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    
      public void UpdatClient(int ID, ClientM cl) {
         
        try { 
             
            
              String sql = "UPDATE public.client set nom='"+cl.nom+"', mobile=" + cl.mobile + ", email='" +cl.email + "', adrasse='"+cl.adresse +"', nrc='"+cl.nrc +"', ai='"+cl.ai +"', aif='"+cl.aif +"', nis='"+cl.nis +"', tin='"+cl.tin +"' where nc="+ID+"" ;

              st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void DeleteClient(int ID) {
       
        try {
             String sql = "DELETE FROM public.client WHERE  nc="+ID+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     


            public void insertFornisseur(FournisseurM forn) {

        try {
        
            String sql1 = " INSERT INTO public.fournisseur (" +
" nom, mobile, email, adrasse, nrc, ai, aif, nis, tin)" +
"	VALUES  ('"+forn.nom+ "'," + forn.mobile + ",'" +forn.email + "','"+forn.adresse +"','"+forn.nrc +"','"+forn.ai +"','"+forn.aif +"','"+forn.nis +"','"+forn.tin +"') ";
           st=cnx.prepareStatement(sql1);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
            
            
              public void AllFOURNISEUR(JTable T) {
        try {
            System.err.println("requte ");
            String sql = "select nf AS \"N°FOURNISEUR\" ,nom AS \"Nom Client\",mobile AS \"N°Telephone\", email AS \"Email\", adrasse AS \"Adrasse\", nrc AS \"N°RC\", ai AS \"NCB\", aif AS \"AIF\", nis AS \"NIS\", tin AS \"TIN\" from public.fournisseur";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
                 T.setModel(DbUtils.resultSetToTableModel(rst));
            


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
            
            
        public void UpdatFourniseur(int ID, FournisseurM forn) {
         
        try { 
             
            
              String sql = "UPDATE public.fournisseur set nom='"+forn.nom+"', mobile=" + forn.mobile + ", email='" +forn.email + "', adrasse='"+forn.adresse +"', nrc='"+forn.nrc +"', ai='"+forn.ai +"', aif='"+forn.aif +"', nis='"+forn.nis +"', tin='"+forn.tin +"' where nf="+ID+"" ;

              st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }      
            
            
            
            public void DeleteFourniseur(int ID) {
       
        try {
             String sql = "DELETE FROM public.fournisseur WHERE  nf="+ID+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
            
              public void FindFourniseur(JTable T, String word) {
        try {
           
            String sql = "SELECT * FROM fournisseur WHERE nom  like '" + word + "%'  ";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
            
            
  
                public void FindNomPrenomFornis(JComboBox combo) {
        try {
           
            String sql = "select nom from fournisseur";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
         public int FindIDFornis(String nom ) {
   
                     
                        int code = 0 ;
        try {
           
            String sql = "select nf from public.fournisseur where nom='"+nom+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

                code=(rst.getInt("nf"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    
   
    }


 public void ALLService(JTable T) {
        try {
           System.err.println("requte ");
            String sql = "select id_ser AS \"N°SERVICE\" ,nom AS \"Nom SERVICE\",prixs AS \"PRIX\" from public.servise";
//             
//            String sql = "select * from servise";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
              T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
 }
//All
            public void FindNomService(JComboBox combo) {
        try {
           
            String sql = "select nom from servise";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
            
            
            
              public void UpdatServices(int ID, ServiceM  M) {
         
        try { 
             
            
              String sql = "UPDATE public.servise set nom='"+M.name+"', prixs=" + M.prix + " where id_ser="+ID+"" ;

              st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }      
            
            
            
            public void DeleteServices(int ID) {
       
        try {
             String sql = "DELETE FROM public.servise WHERE  id_ser="+ID+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             
            
            
            public void insertServices(ServiceM  M) {
       
        try {
                         String sql1 = " INSERT INTO public.servise(" +
	" nom, prixs) VALUES  ('"+M.name+ "'," + M.prix + ")";
	
           
//            String sql1 = " INSERT INTO Client VALUES ('"+cl.nom+ "'," + cl.mobile + "," +cl.email + ","+cl.adresse +","+cl.nrc +","+cl.ai +","+cl.aif +","+cl.nis +","+cl.tin +") ";
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }   
            
 public void FDSERV(JTable T, String word) {
        try {
           
            String sql = "SELECT *FROM public.servise WHERE nom like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
            

            
             public void FindNomMatier(JComboBox combo) {
        try {
           
            String sql = "select Disgnation from public.produit";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("Disgnation").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
              public void FindNomClient(JComboBox combo) {
        try {
           
            String sql = "select nom from client";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
                    public void FindNomFournisseur(JComboBox combo) {
        try {
             String sql = "select nom from public.fournisseur";
          st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
              
    public int FindIDProduit(String Desgination ) {
                       
                            int code = 0  ;
        try {
       
            String sql = "select id_mt from public.produit where disgnation='"+Desgination+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

              code=(rst.getInt("id_mt"));
             
            
           return code ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
     
       return code ;

    }
                   
                  /// get id of the  consuemer 
                    public int FindIDClient(String nom ) {
                       
                            int code = 0  ;
        try {
       
            String sql = "select nc from public.client where nom='"+nom+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

              code=(rst.getInt("nc"));
             
            
           return code ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
     
       return code ;

    }
                         
                   
public  float  Findprixvent(String Desgination ) {
                        String idm ;
                        float code = 0 ;
        try {
           
            String sql = "select Prixvent from public.produit where disgnation='"+Desgination+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

               code=(rst.getInt("prixvent"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
public  float  FindPRIXSERVICE(String name ) {
                   float code = 0 ;
        try {
           
            String sql = "SELECT  prixs FROM public.servise where nom='"+name+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

               code=(rst.getInt("prixs"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
   public  int  Findqntiteproduit(String Desgination ) {
                     
                        int code = 0 ;
        try {
           
            String sql = "select qnt from public.produit where disgnation='"+Desgination+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

                code=(rst.getInt("qnt"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    } 
   
   public void changeQnt(int id,int qnt){
        try {
            System.out.println("ConnectionDB.ConnectDB.changeQnt()"+qnt);
            String sql = "Update public.produit set qnt="+qnt+" where id_mt="+ id;
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
       
   }
//       cast
   
  public void AllStock(JTable T) {
    try {
        String sql = "SELECT CAST(id_mt AS text) AS \"N°PRODUIT\", disgnation AS \"DISAGNATION\", prixvent AS \"PRIXVENT\", prixachat AS \"PRIXACHAT\", qnt AS \"Métrage\" FROM public.produit";
        st = cnx.prepareStatement(sql);
        rst = (ResultSet) st.executeQuery();

        DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(rst);
        model.addColumn("Etat");

        // Add values to the custom column based on the quantity column
        for (int i = 0; i < model.getRowCount(); i++) {
            Long quantite = (Long) model.getValueAt(i, 4);
            String etat = quantite > 0 ? "NORMAL" : "ALERT";
            model.setValueAt(etat, i, model.getColumnCount() - 1);
        }

        T.setModel(model);
    } catch (SQLException e) {
        System.err.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
    }
}


//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
//       
//   }} 
        
//public void AllStock(JTable T) throws SQLException {
//   
//        // Retrieve data from the produit table
//        String sql = "SELECT * FROM public.produit";
//        st = cnx.prepareStatement(sql);
//        rst = st.executeQuery();
//
//        // Convert the ResultSet to a DefaultTableModel
//        DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(rst);
//
//        // Add a custom column for "Etat"
//        model.addColumn("Etat");
//
//        // Add values to the custom column based on the quantity column
//        for (int i = 0; i < model.getRowCount(); i++) {
//            int quantite = (int) model.getValueAt(i, 4);
//            String etat = quantite > 0 ? "NURMAL" : "ALERT";
//            model.setValueAt(etat, i, model.getColumnCount() - 1);
//
//            // Add the custom cell renderer to the Etat column based on etat value
//           
//
//        T.setModel(model);
//
//   
//}}
//   
//   
   
   
   
   
       public void inserttoSTock(StockM m ) {
       
        try {
                         String sql1 = " INSERT INTO public.produit (" +
"	 disgnation, prixvent, Prixachat, qnt)"+
"	VALUES  ('"+m.designation+"',"+m.prixvent+","+m.prixachat+","+m.qnt+" ) ";

           
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
   
   
   
   
   
   
   
    public void UpdatSTock(float id , StockM m) {

        try { 
            String sql = "UPDATE public.produit SET disgnation='"+m.designation+"', prixvent="+m.prixvent+", prixachat="+m.prixachat+",qnt="+m.qnt+" where id_mt="+id+"" ;
  st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   public void DeleteStock(float id ) {
       
        try {
             String sql = "DELETE FROM public.produit where id_mt="+id+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   //insert
     public  int  FindqntitClient(String nom ) {
                     
                        int code = 0 ;
        try {
           
            String sql = "select nc from public.client where nom='"+nom+"'";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

                code=(rst.getInt("nc"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
   
    public void FindStock(JTable T, String word) {
        try {
            System.out.println("ConnectionDB.ConnectDB.FindStock()");
            
            String sql = "SELECT *FROM produit WHERE disgnation like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            System.out.println("ConnectionDB.ConnectDB.FindStock() jjjjj");
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    
   
   
   

   
   
   
   
       public void inserttoFacture(Facture F) {
       
        try {
              System.err.println("dans la fcture  facture ");
                         String sql1 =  " INSERT INTO public.facturs( datefacture, heuer, id_Client, montant)"+
                                 "VALUES  ('"+F.date+"','"+F.houre+"',"+F.Id_client+","+F.montant+") ";

           
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
   
       public  int  FindidFacture() {
                     
                        int code = 0 ;
        try {
           
            String sql = "SELECT id_facture FROM public.facturs ORDER BY id_facture DESC LIMIT 1";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

                code=(rst.getInt("id_facture"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
       //id_detailsfacture                  
         public  int  FindidAchat(int id_client ) {
                     
                        int code = 0 ;
        try {
           
            String sql = "select id_achat from  public.achat where id_fournisser="+id_client+"";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

                code=(rst.getInt("id_achat"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
   
         
         
         
         
         
         
         
         
         
         
         
         
         
         
public double RMDAJ() throws SQLException {
     double sommeMontant=0;
    
            
 String date =showDate(); 

        // Préparation de la requête SQL
        String sql = "SELECT SUM(montant) AS total_montant FROM public.detailsachat WHERE dateachate = ?";
        st = cnx.prepareStatement(sql);
        st.setString(1, date);
        rst = st.executeQuery();



if (rst.next()) {
    sommeMontant = rst.getDouble(1);
}

   st.close();
            rst.close();

    return sommeMontant;
}

public double RMDVJ() throws SQLException {
     double sommeMontant=0;
    
            
 String date =showDate(); 

        // Préparation de la requête SQL
        String sql = "SELECT SUM(montant) AS total_montant FROM public.deatilsfactures WHERE dateachat = ?";
        st = cnx.prepareStatement(sql);
        st.setString(1, date);
        rst = st.executeQuery();



if (rst.next()) {
    sommeMontant = rst.getDouble(1);
}

   st.close();
            rst.close();

    return sommeMontant;
}

         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
       public void inserttoDtailsFacture( detailsFcture dF) {
        String D=showDate();
       String h=showDateTime();
        try {
   
                         String sql1 =  " INSERT INTO public.deatilsfactures(  id_facture, id_produit, quntite, prixvente,montant,utilisateur, produit,\"client \", dateachat, heureachat)"+
                                 "VALUES  ('"+dF.id_facture+"','"+dF.id_produit+"',"+dF.Qnt+","+dF.prixvent+","+dF.montant+",'"+dF.user+"','"+dF.Produit+"','"+dF.client+"','"+D+"','"+h+"') ";

           
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
 
  
    private void Catch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public void inserttoAchat(bonrecu F) {
       
        try {
              System.err.println("dans la fcture  facture ");
                         String sql1 =  " INSERT INTO public.achat(  id_fournisser, houreachat, totale, dateachat)"+
                                 "VALUES  ('"+F.Id_fournisseur+"','"+F.houre+"',"+F.montant+","+F.date+") ";

           
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
   
    /**
     *
     * @param dF
     */
    public void inserttoDtailsAchat( detailsAchat dF) {
       String D=showDate();
       String h=showDateTime();
        try {
   
                         String sql1 =  " INSERT INTO public.detailsachat( id_produit, id_achat, prixacaht, qnte, montant, prixvente, utilisateur, produit, founisseur, dateachate, heureachat)\n" +
                                 "VALUES  ("+dF.id_produit+","+dF.id_Achat+","+dF.prixuntaire+","+dF.quntite+","+dF.monatnt+","+dF.prixvente+",'"+dF.utilisateur+"','"+dF.produit+"','"+dF.founisseur+"','"+D+"','"+h+"') ";

           
           
             st=cnx.prepareStatement(sql1);
             System.out.println("ConnectionDB.ConnectDB.insertClient()  1");
          rst = st.executeQuery();
          
        } catch (SQLException ex) {

            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
   

public  String  GETUSER() {
                   String code =null ;
        try {
           
            String sql ="SELECT nom FROM public.login";
             st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
          

            while (rst.next()) {

               code=(rst.getString("nom"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
return code ;
    }
 public void DetailsFacture(JTable T) {
        try {
            String sql = "select id_datailsfacture AS \"N°DETAILSFACTURE\" ,id_facture AS \"N°FACTURE\",id_produit AS \"N°PRODUIT\",produit  AS \"DESINITION\",quntite AS \"QANTITE\",prixvente AS \"PRIXVENT\",montant AS \"MONTANT\",utilisateur AS \"UTILISATEUR\",\"client \" AS \"CLIENT\",dateachat AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.deatilsfactures";
//            String sql = "SELECT * FROM public.deatilsfactures  ";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
  public void DetailsAchat(JTable T) {
        try {
            String sql = "select id_detailsachat AS \"N°DETAILSACHAT\" ,id_produit AS \"N°PRODUIT\",produit AS \"DESINITION\",id_achat AS \"N°ACHAT\",prixacaht AS \"PRIXACHAT\",qnte AS \"QANTITE\",montant AS \"MONTANT\",prixvente AS \"PRIXVENT\",utilisateur AS \"UTILISATEUR\",founisseur AS \"FOURNISSEUR\",dateachate AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.detailsachat";

//            String sql = "SELECT * FROM public.detailsachat  ";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
 public void DeleteVENT(int ID) {
       
        try {
             String sql = "DELETE FROM public.deatilsfactures WHERE  id_datailsfacture="+ID+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void DeleteAchat(int ID) {
       
        try {
             String sql = "DELETE FROM public.detailsachat WHERE  id_detailsachat="+ID+"";
            st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 
 
 
 
 
 
 
 
 
    
 
    public void FDPIDF(JTable T, int vleu) {
        try {
           
         String sql = "select id_datailsfacture AS \"N°DETAILSFACTURE\" ,id_facture AS \"N°FACTURE\",id_produit AS \"N°PRODUIT\",produit  AS \"DESINITION\",quntite AS \"QANTITE\",prixvente AS \"PRIXVENT\",montant AS \"MONTANT\",utilisateur AS \"UTILISATEUR\",\"client \" AS \"CLIENT\",dateachat AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.deatilsfactures WHERE CAST(id_facture AS text) LIKE '"+vleu+"%'";


           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
 
 
 
   
 
    public void FNDPU(JTable T, String word) {
        try {
           
            String sql = "select id_datailsfacture AS \"N°DETAILSFACTURE\" ,id_facture AS \"N°FACTURE\",id_produit AS \"N°PRODUIT\",produit  AS \"DESINITION\",quntite AS \"QANTITE\",prixvente AS \"PRIXVENT\",montant AS \"MONTANT\",utilisateur AS \"UTILISATEUR\",\"client \" AS \"CLIENT\",dateachat AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.deatilsfactures WHERE utilisateur like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
         public void FDPP(JTable T, String word) {
        try {
           
            String sql = "select id_datailsfacture AS \"N°DETAILSFACTURE\" ,id_facture AS \"N°FACTURE\",id_produit AS \"N°PRODUIT\",produit  AS \"DESINITION\",quntite AS \"QANTITE\",prixvente AS \"PRIXVENT\",montant AS \"MONTANT\",utilisateur AS \"UTILISATEUR\",\"client \" AS \"CLIENT\",dateachat AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.deatilsfactures WHERE produit like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
         
         
         
         
         
             public void FDC(JTable T, String word) {
        try {
           
            String sql = "select id_datailsfacture AS \"N°DETAILSFACTURE\" ,id_facture AS \"N°FACTURE\",id_produit AS \"N°PRODUIT\",produit  AS \"DESINITION\",quntite AS \"QANTITE\",prixvente AS \"PRIXVENT\",montant AS \"MONTANT\",utilisateur AS \"UTILISATEUR\",\"client \" AS \"CLIENT\",dateachat AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.deatilsfactures WHERE \"client \" like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
             
             
             
             
             
 public void SPRIX( AchatM dF,String word) {
        try {
           
            String sql = "UPDATE public.produit SET prixvent="+dF.prix_unitaire+", prixachat="+dF.PV+" WHERE disgnation like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
         


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
 
 
	
	
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    public void FDPIDFA(JTable T, int vleu) {
        try {
           
         String sql = "select id_detailsachat AS \"N°DETAILSACHAT\" ,id_produit AS \"N°PRODUIT\",produit AS \"DESINITION\",id_achat AS \"N°ACHAT\",prixacaht AS \"PRIXACHAT\",qnte AS \"QANTITE\",montant AS \"MONTANT\",prixvente AS \"PRIXVENT\",utilisateur AS \"UTILISATEUR\",founisseur AS \"FOURNISSEUR\",dateachate AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.detailsachat WHERE CAST(id_achat AS text) LIKE '"+vleu+"%'";


           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
 
 
 
   
 
    public void FNDPUA(JTable T, String word) {
        try {
           
            String sql = "select id_detailsachat AS \"N°DETAILSACHAT\" ,id_produit AS \"N°PRODUIT\",produit AS \"DESINITION\",id_achat AS \"N°ACHAT\",prixacaht AS \"PRIXACHAT\",qnte AS \"QANTITE\",montant AS \"MONTANT\",prixvente AS \"PRIXVENT\",utilisateur AS \"UTILISATEUR\",founisseur AS \"FOURNISSEUR\",dateachate AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.detailsachat WHERE utilisateur like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
         public void FDPPA(JTable T, String word) {
        try {
           
            String sql = "select id_detailsachat AS \"N°DETAILSACHAT\" ,id_produit AS \"N°PRODUIT\",produit AS \"DESINITION\",id_achat AS \"N°ACHAT\",prixacaht AS \"PRIXACHAT\",qnte AS \"Métrage\",montant AS \"MONTANT\",prixvente AS \"PRIXVENT\",utilisateur AS \"UTILISATEUR\",founisseur AS \"FOURNISSEUR\",dateachate AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.detailsachat WHERE produit like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
      public void FDF(JTable T, String word) {
        try {
           
            String sql = "select id_detailsachat AS \"N°DETAILSACHAT\" ,id_produit AS \"N°PRODUIT\",produit AS \"DESINITION\",id_achat AS \"N°ACHAT\",prixacaht AS \"PRIXACHAT\",qnte AS \"Métrage\",montant AS \"MONTANT\",prixvente AS \"PRIXVENT\",utilisateur AS \"UTILISATEUR\",founisseur AS \"FOURNISSEUR\",dateachate AS \"DATEACHAT\",heureachat AS \"HEUREACHAT\" from public.detailsachat WHERE founisseur like '" + word + "%'  ";
           st=cnx.prepareStatement(sql);
            rst = (ResultSet) st.executeQuery();
            T.setModel(DbUtils.resultSetToTableModel(rst));


        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
     
}
