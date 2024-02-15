/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import ConnectionDB.ConnectDB;
import Model.AchatM;
import Model.Facture;
import Model.VenteM;
import Model.detailsFcture;
import button.Button;
import static com.itextpdf.kernel.pdf.PdfName.Page;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.PageSize;
import java.awt.print.PrinterJob;
import java.io.File;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.print.PrintService;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.PageSize;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
  
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.PdfContentByte;
import javax.print.event.PrintJobListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author Abderrazak
 */
public class Vent extends javax.swing.JFrame {

    /**
     * Creates new form Vent
     */
    public Vent() {
        initComponents();
        AutoCompleteDecorator.decorate(Matier);
        showDate();
        icon();
       showTime();
        
    }ConnectDB db; 
    
    public int FACTURE;
      void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("iconapp.png")));
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
    public void getSum()
    {
        int sum = 0;
        for(int i = 0; i < TBV.getRowCount(); i++)
        {
                sum = sum+Integer.parseInt(TBV.getValueAt(i,5).toString());
               
        }
        
       totale.setText(Integer.toString(sum));
  
    }
  public void getMontant_HT()
    {
        int sum = 0;
        for(int i = 0; i < TBV.getRowCount(); i++)
        {
                sum = sum+Integer.parseInt(TBV.getValueAt(i,8).toString());
               
        }
        
       totale.setText(Integer.toString(sum));
  
    }
//  public void getNMontant_HT()
//    {
//         totale.setText(Integer.toString(sum));
//        for(int i = 0; i < TBV.getRowCount(); i++)
//        {
//                sum = sum-Integer.parseInt(TBV.getValueAt(i,8).toString());
//               
//        }
//        
//       totale.setText(Integer.toString(sum));
//  
//    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cmdClose = new com.raven.swing.win_button.Button();
        cmdMi = new com.raven.swing.win_button.Button();
        jLabel8 = new javax.swing.JLabel();
        Valid = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Matier = new combobox.Combobox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        servise = new combobox.Combobox();
        Client = new combobox.Combobox();
        np = new button.Button();
        qnt = new textfield.TextField();
        totale = new button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBV = new tabledark.TableDark();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1610, 963));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(17, 114, 169));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\soulaimane\\Downloads\\icons8-shopping-cart-promotion-48 (1).png")); // NOI18N
        jLabel2.setText("Ventes");

        jLabel16.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("date");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("time");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clock (1).png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(17, 114, 169));

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 60));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel8.setText("Servise:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        Valid.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Valid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addnew.png"))); // NOI18N
        Valid.setText("Ajoute");
        Valid.setContentAreaFilled(false);
        Valid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Valid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Valid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Valid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidActionPerformed(evt);
            }
        });
        jPanel3.add(Valid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 100, -1, -1));

        jButton4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clipboard.png"))); // NOI18N
        jButton4.setText("Liste FACTURE");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 90, -1, 89));

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
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 460, -1, -1));

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
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 610, -1, -1));

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel9.setText("Métrage :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        Matier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Matier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAISISSEZ VOTRE CHOIIX" }));
        Matier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Matier.setLabeText("");
        Matier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatierActionPerformed(evt);
            }
        });
        jPanel3.add(Matier, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 260, -1));

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel10.setText("Desigantion:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel11.setText("Client:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        servise.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        servise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAISISSEZ VOTRE CHOIIX" }));
        servise.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        servise.setLabeText("");
        servise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviseActionPerformed(evt);
            }
        });
        jPanel3.add(servise, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 260, -1));

        Client.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Client.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAISISSEZ VOTRE CHOIIX" }));
        Client.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Client.setLabeText("");
        Client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientActionPerformed(evt);
            }
        });
        jPanel3.add(Client, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 260, -1));

        np.setBackground(new java.awt.Color(0, 0, 0));
        np.setForeground(new java.awt.Color(255, 255, 255));
        np.setText("N°Produit");
        np.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        np.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npActionPerformed(evt);
            }
        });
        jPanel3.add(np, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 90, 105, -1));

        qnt.setForeground(new java.awt.Color(0, 0, 0));
        qnt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        qnt.setSelectionColor(new java.awt.Color(0, 0, 0));
        qnt.setShadowColor(new java.awt.Color(0, 0, 0));
        qnt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                qntPropertyChange(evt);
            }
        });
        jPanel3.add(qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 212, -1));

        totale.setBackground(new java.awt.Color(0, 0, 0));
        totale.setForeground(new java.awt.Color(255, 255, 255));
        totale.setText("Totale");
        totale.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        totale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaleActionPerformed(evt);
            }
        });
        jPanel3.add(totale, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 830, 268, 75));

        TBV.setAutoCreateRowSorter(true);
        TBV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°produit", "Designation", "Service", "Prix Service", "Métrage", "PrixUntaire", "Montant_HT", "Montant_TVA", "Montant_TTC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBV.setDropMode(javax.swing.DropMode.ON);
        TBV.setFillsViewportHeight(true);
        TBV.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        TBV.getTableHeader().setReorderingAllowed(false);
        TBV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBV);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 1340, 460));

        jButton7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trash_1.png"))); // NOI18N
        jButton7.setText("Suprimme");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 100, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AAch.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\soulaimane\\Downloads\\icons8-service-50.png")); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, 80, 70));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addplus.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 90, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

MessageFormat header = new MessageFormat("FACTURE : \n");
MessageFormat footer = new MessageFormat("Page {0,number,integer}");
try {
    // Créez une instance de JTable.PrintMode pour spécifier le mode d'impression
    JTable.PrintMode mode = JTable.PrintMode.FIT_WIDTH;

   // Créez un objet PrinterJob pour gérer l'impression
    PrinterJob printerJob = PrinterJob.getPrinterJob();

    // Obtenez la JTable que vous souhaitez imprimer (remplacez TBV par votre propre JTable)
   JTable table = TBV;

    // Ajoutez une ligne vide à la fin de la table pour afficher le total des ventes
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[] {"","","","", "TOTAL =", totale.getText(), }); // Remplacez calculateTotalSales() par la logique de calcul du total des ventes

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

DefaultTableModel model = (DefaultTableModel) TBV.getModel();
int rowCount = model.getRowCount();
for (int i = rowCount - 1; i >= 0; i--) {
    model.removeRow(i);
}
model.setColumnCount(9);

FACTURE=db.FindidFacture();
 System.out.println("IHM.Vent.ValidActionPerformed123()"+FACTURE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 Detailsvent d=new Detailsvent();
       d.setVisible(true);  
           
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidActionPerformed
String ncbPatternString = "^[0-9]+$";


Pattern ncbPattern = Pattern.compile(ncbPatternString);


Matcher ncbMatcher = ncbPattern.matcher(qnt.getText());

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
        int valeur= checkJTable(TBV,(String)Matier.getSelectedItem());
        int valeur1= checkJTable(TBV,(String)servise.getSelectedItem());
        
        if(valeur==0 || valeur1==0){

  int IDProduit =db.FindIDProduit((String) Matier.getSelectedItem());
           String MatierM =  (String)Matier.getSelectedItem();
       int prixvent = (int) db. Findprixvent((String) Matier.getSelectedItem());

       String sevice = (String) servise.getSelectedItem();
       int PRixSERvice=(int) db.FindPRIXSERVICE(sevice);
     int quntite = Integer.parseInt(qnt.getText()); 
            ArrayList<VenteM> list = new ArrayList<VenteM>();
         int Montant_HT=(prixvent*quntite);
int Montant_TVA=(int) (Montant_HT*0.19);
int Montant_TTC=Montant_TVA+Montant_HT+PRixSERvice;
        VenteM V = new VenteM(IDProduit,MatierM,sevice,PRixSERvice,quntite,prixvent,Montant_HT,Montant_TVA,Montant_TTC);
                list.add(V);
            

            DefaultTableModel mo = (DefaultTableModel) TBV.getModel();
       
         
            Object  row[] = new Object[9];
            int i=0;
//            mo.setRowCount(ABORT);
            for (int k = 0; k < list.size(); k++) {
               
                row[0] = list.get(k).getN_produit();
                row[1] = list.get(k).getDesginastion();
               
                row[2] = list.get(k).getService();
                
                row[3] = list.get(k).getPrixService();
             row[4] = list.get(k).getQnt();
                row[5] = list.get(k).getPrixvent();
              
                row[6] = list.get(k).getMontant_HT();
                 row[7] = list.get(k).getMontant_TVA();
                row[8] = list.get(k).getMontant_TTC();
                
//                row[6] = /*df.format(*/ list.get(k).getDate()/*)*/;
                

               mo.addRow(row);
 }
             
getMontant_HT();


          

        System.out.println("IHM.Vent.ValidActionPerformed()"+ db.Findqntiteproduit(MatierM));    
 int qnt=   db.Findqntiteproduit(MatierM)-quntite;
 db.changeQnt(IDProduit, qnt);
            System.err.println("facture");
            int id_client=db.FindqntitClient((String) Client.getSelectedItem());
   Facture f= new Facture(id_client,db.showDate(),db.showDateTime(),Montant_HT); 
      System.err.println("insert to facture ");
   db.inserttoFacture(f);
        System.out.println("IHM.Vent.ValidActionPerformed()"+FACTURE);
        String user =db.GETUSER();
            System.out.println("IHM.Vent.ValidActionPerformed()"+user);
   detailsFcture df=new  detailsFcture(FACTURE ,IDProduit, prixvent, quntite,Montant_TTC,user,(String) Matier.getSelectedItem(),(String) Client.getSelectedItem());
   db.inserttoDtailsFacture(df);
            
            
        
   
        

} else {
        
        
       erourserviceetproduit dialog = new erourserviceetproduit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        
        
        if(dialog.getReturnStatus()==ErreurVent.RET_CANCEL){
      
       Matier.requestFocus();
        }
        }
       
}
    }//GEN-LAST:event_ValidActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            db =new ConnectDB();
       db.ConnexionIntoDataBase();
          db.FindNomService(servise);
          db.FindNomMatier(Matier);
          db.FindNomClient(Client);
  FACTURE=db.FindidFacture();
       try {
            File songFile = new File("C:\\Users\\soulaimane\\Desktop\\DispalyBAhai\\JavaApplication2\\src\\son\\vent.wav"); // Replace with the actual path to your song file

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

    private void MatierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatierActionPerformed

    private void serviseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviseActionPerformed

    private void ClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientActionPerformed

    private void npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npActionPerformed

    }//GEN-LAST:event_npActionPerformed

    private void TBVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBVMouseClicked
 int i;

        try{
            i= TBV.getSelectedRow();
            np.setText( TBV.getValueAt(i, 0)+"");
           

        }catch(Exception e){

        }


     
    }//GEN-LAST:event_TBVMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void totaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totaleActionPerformed

    private void qntPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_qntPropertyChange

    }//GEN-LAST:event_qntPropertyChange

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 int quntite; String MatierM =  (String)Matier.getSelectedItem();
         int i;

       
            i= TBV.getSelectedRow();
          
           quntite= (int) TBV.getValueAt(i, 4);
             
        
int IDProduit =db.FindIDProduit((String) Matier.getSelectedItem());
         
                 suprime dialog = new suprime(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        if(dialog.getReturnStatus()==suprime.RET_OK){
        int qnt=   db.Findqntiteproduit(MatierM)+quntite;
 db.changeQnt(IDProduit, qnt);
        int valeur = (int) TBV.getValueAt(TBV.getSelectedRow(),8);
    int  montant = Integer.parseInt(totale.getText());
int sum;
sum = montant-valeur;

totale.setText(Integer.toString(sum));
        DefaultTableModel model = (DefaultTableModel) TBV.getModel();
 
       try{
       int SelectedRowIndex = TBV.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }  
       ;
        }
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
  Home c=new Home();
        c.setVisible(true);            // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            File songFile = new File("C:\\Users\\soulaimane\\Desktop\\DispalyBAhai\\JavaApplication2\\src\\son\\quitte fournisseur (1).wav"); // Replace with the actual path to your song file

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
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_cmdMiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Produit p = new Produit();
p.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Client p = new Client();
p.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
Service p = new Service();
p.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Vent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private combobox.Combobox Client;
    private combobox.Combobox Matier;
    private tabledark.TableDark TBV;
    private javax.swing.JButton Valid;
    private com.raven.swing.win_button.Button cmdClose;
    private com.raven.swing.win_button.Button cmdMi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private button.Button np;
    private textfield.TextField qnt;
    private combobox.Combobox servise;
    private button.Button totale;
    // End of variables declaration//GEN-END:variables
}
