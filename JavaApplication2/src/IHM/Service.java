/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import ConnectionDB.ConnectDB;
import Model.ServiceM;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;

/**
 *
 * @author soulaimane
 */
public class Service extends javax.swing.JFrame {

    /**
     * Creates new form Service
     */
    public Service() {
     initComponents();
         icon();
       showDate();
       showTime();
    }ConnectDB db;

     void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("iconapp.png")));
    }
       public int checkJTable(JTable TBV, String element) {
    boolean found = false;
    for (int i = 0; i < TBV.getRowCount(); i++) {
        for (int j = 0; j < TBV.getColumnCount(); j++) {
            if (TBV.getValueAt(i, j).equals(element)) {
                found = true;
                break;
            }
        }
        if (found) {
            break;
        }
    }
    if (found) {
      return 1;
    } else {
       return 0;
    }
}
      void showDate(){
    Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("E dd-MM-YYYY");
    jLabel16.setText(sdf.format(d));
            
}
void showTime(){
    new Timer(0,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date d=new Date();
             SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
   jLabel13.setText(sdf.format(d));
        }
    }).start();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmdClose = new com.raven.swing.win_button.Button();
        cmdMi = new com.raven.swing.win_button.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBS = new tabledark.TableDark();
        nbrserv = new button.Button();
        nom = new textfield.TextField();
        prix = new textfield.TextField();
        srch = new textfield.TextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 114, 169));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\soulaimane\\Downloads\\2720641 (1).png")); // NOI18N
        jLabel1.setText("service");

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("time");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clock (1).png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("date");

        jPanel3.setBackground(new java.awt.Color(17, 114, 169));

        cmdClose.setBackground(new java.awt.Color(240, 61, 61));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdMi.setBackground(new java.awt.Color(227, 226, 68));
        cmdMi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(495, 495, 495)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 70));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel3.setText("Nom :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel4.setText("Prix  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 200, -1, -1));

        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editnew.png"))); // NOI18N
        jButton1.setText("Modife");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1334, 146, -1, -1));

        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addnew.png"))); // NOI18N
        jButton3.setText("Ajoute");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1242, 146, -1, -1));

        jButton4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trash_1.png"))); // NOI18N
        jButton4.setText("Suprimme");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1426, 146, -1, -1));

        jButton5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refrach.png"))); // NOI18N
        jButton5.setText("Actuliser");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1426, 523, -1, -1));

        jButton6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
        jButton6.setText("Imprime");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 670, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/charche.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 350, -1, -1));

        TBS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBS.setFillsViewportHeight(true);
        TBS.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        TBS.getTableHeader().setReorderingAllowed(false);
        TBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 422, 1326, -1));

        nbrserv.setBackground(new java.awt.Color(0, 0, 0));
        nbrserv.setForeground(new java.awt.Color(255, 255, 255));
        nbrserv.setText("N°CLIENT");
        nbrserv.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        nbrserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbrservActionPerformed(evt);
            }
        });
        jPanel1.add(nbrserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 105, -1));

        nom.setForeground(new java.awt.Color(0, 0, 0));
        nom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nom.setSelectionColor(new java.awt.Color(0, 0, 0));
        nom.setShadowColor(new java.awt.Color(0, 0, 0));
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 192, 212, -1));

        prix.setForeground(new java.awt.Color(0, 0, 0));
        prix.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        prix.setSelectionColor(new java.awt.Color(0, 0, 0));
        prix.setShadowColor(new java.awt.Color(0, 0, 0));
        prix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixActionPerformed(evt);
            }
        });
        prix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prixKeyPressed(evt);
            }
        });
        jPanel1.add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 192, 214, -1));

        srch.setForeground(new java.awt.Color(0, 0, 0));
        srch.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        srch.setSelectionColor(new java.awt.Color(0, 0, 0));
        srch.setShadowColor(new java.awt.Color(0, 0, 0));
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });
        srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srchKeyReleased(evt);
            }
        });
        jPanel1.add(srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 350, 214, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel2.setText("Nom:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i ;
        try {

           ServiceM  cl=new ServiceM(nom.getText(),Integer.parseInt(prix.getText()));

            db.UpdatServices(Integer.parseInt(nbrserv.getText()),cl);

            db.ALLService(TBS);
 nom.setText("");
                  prix.setText("");
        }  catch(Exception e){
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

String ncbPatternString = "^[0-9]+$";


Pattern ncbPattern = Pattern.compile(ncbPatternString);


Matcher ncbMatcher = ncbPattern.matcher(prix.getText());

if ( !ncbMatcher.matches()  ) {
    // L'adresse e-mail ou le numéro de téléphone n'est pas au bon format, affichez un message d'erreur ou une notification appropriée
     ERREUR dialog = new ERREUR(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
}else{
        int valeur= checkJTable(TBS,(String)nom.getText());
        
        if(valeur==0){
        confiramation dialog = new confiramation(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
 if(dialog.getReturnStatus()==confiramation.RET_OK){
        ServiceM  cl=new ServiceM(nom.getText(),Integer.parseInt(prix.getText()));

        db.insertServices(cl);
       db.ALLService(TBS);
 }
                  nom.setText("");
                  prix.setText("");
       } else {
        
              erourservice dialog = new erourservice(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            
      
        
        
        if(dialog.getReturnStatus()==ErreurVent.RET_CANCEL){
      
       nom.requestFocus();
        }
        }
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        suprime dialog = new suprime(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
        if(dialog.getReturnStatus()==suprime.RET_OK){

            db.DeleteServices(Integer.parseInt(nbrserv.getText()));
          db.ALLService(TBS);
 nom.setText("");
                  prix.setText("");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        db.ALLService(TBS);
         nom.setText("");
                  prix.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

MessageFormat header = new MessageFormat("Liste des SERVICES : \n");
MessageFormat footer = new MessageFormat("Page {0,number,integer}");
try {
    // Créez une instance de JTable.PrintMode pour spécifier le mode d'impression
    JTable.PrintMode mode = JTable.PrintMode.FIT_WIDTH;

    // Créez un objet PrinterJob pour gérer l'impression
    PrinterJob printerJob = PrinterJob.getPrinterJob();

    // Obtenez la JTable que vous souhaitez imprimer (remplacez TBS par votre propre JTable)
    JTable table = TBS;

    // Créez un objet Printable à partir de la JTable
    Printable printable = table.getPrintable(mode, header, footer);

    // Définissez le document à imprimer sur l'objet Printable
    printerJob.setPrintable(printable);

    // Affichez la boîte de dialogue de paramètres d'impression (optionnel)
    if (printerJob.printDialog()) {
        // Lancez l'impression
        printerJob.print();
    }
} catch (PrinterException e) {
    System.err.println("Erreur d'impression : " + e.getMessage());
}

        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        db.FDSERV(TBS, srch.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TBSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBSMouseClicked
        int i;

        try{
            i= TBS.getSelectedRow();
         nbrserv.setText( TBS.getValueAt(i, 0)+"");
            nom.setText( TBS.getValueAt(i, 1)+"");
               prix.setText( TBS.getValueAt(i, 2)+"");
           
        }catch(Exception e){

        }
    }//GEN-LAST:event_TBSMouseClicked

    private void nbrservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrservActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbrservActionPerformed

    private void prixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixActionPerformed

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        db =new ConnectDB();
        db.ConnexionIntoDataBase();
       
        db.ALLService(TBS);
        try {
            File songFile = new File("C:\\Users\\soulaimane\\Desktop\\DispalyBAhai\\JavaApplication2\\src\\son\\servic.wav"); // Replace with the actual path to your song file

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(songFile));
            clip.start();
             Thread.sleep(1500);
//            JOptionPane.showMessageDialog(this, "Song is playing. Click OK to stop.");
            clip.stop();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error playing song: " + e.getMessage());
        }     
    }//GEN-LAST:event_formWindowOpened

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
try {
            File songFile = new File("C:\\Users\\soulaimane\\Desktop\\DispalyBAhai\\JavaApplication2\\src\\son\\bay.wav"); // Replace with the actual path to your song file

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(songFile));
            clip.start();
             Thread.sleep(800);
//            JOptionPane.showMessageDialog(this, "Song is playing. Click OK to stop.");
            clip.stop();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error playing song: " + e.getMessage());
        } 
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdMiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMiActionPerformed
try {
            File songFile = new File("C:\\Users\\soulaimane\\Desktop\\DispalyBAhai\\JavaApplication2\\src\\son\\quitte service.wav"); // Replace with the actual path to your song file

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(songFile));
            clip.start();
             Thread.sleep(800);
//            JOptionPane.showMessageDialog(this, "Song is playing. Click OK to stop.");
            clip.stop();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error playing song: " + e.getMessage());
        } 
        this.setState(JFrame.ICONIFIED);    
        this.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_cmdMiActionPerformed

    private void srchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyReleased
int p=srch.getCaretPosition();
       srch.setText(srch.getText().toUpperCase());
       srch.setCaretPosition(p);        // TODO add your handling code here:
    }//GEN-LAST:event_srchKeyReleased

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased
int p=nom.getCaretPosition();
       nom.setText(nom.getText().toUpperCase());
       nom.setCaretPosition(p);        // TODO add your handling code here:
    }//GEN-LAST:event_nomKeyReleased

    private void nomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyPressed
  int key=evt.getKeyCode();
     if((key!=10)){
     } else {
         prix.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_nomKeyPressed

    private void prixKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prixKeyPressed
  int key=evt.getKeyCode();
     if((key!=10)){
     } else {
           jButton3.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_prixKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Service().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tabledark.TableDark TBS;
    private com.raven.swing.win_button.Button cmdClose;
    private com.raven.swing.win_button.Button cmdMi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private button.Button nbrserv;
    private textfield.TextField nom;
    private textfield.TextField prix;
    private textfield.TextField srch;
    // End of variables declaration//GEN-END:variables
}
