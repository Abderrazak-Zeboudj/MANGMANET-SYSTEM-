package com.raven.component;

import com.raven.shadow.ShadowRenderer;
import com.raven.swing.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

public class PanelDetail extends javax.swing.JPanel {

    public PanelDetail() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new com.raven.swing.List<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        cmdBuy = new com.raven.swing.Button();

        list.setOpaque(false);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        cmdBuy.setText("Heureux de vous servir");
        cmdBuy.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmdBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addGap(18, 18, 18)
                .addComponent(cmdBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmdBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdBuyActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BufferedImage img = new BufferedImage(getWidth() - 10, 250, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = img.getWidth();
        int height = img.getHeight() - 1;
        int radius = 25;
        g2.setColor(new Color(250, 250, 250));
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, radius);
        f.curveTo(0, radius, 0, 0, radius, 0);
        f.lineTo(width - radius, 0);
        f.curveTo(width - radius, 0, width, 0, width - 5, radius);
        f.lineTo(width - 50, height - radius);
        f.curveTo(width - 50, height - radius, width - 50 - 5, height, width - radius - 60, height);
        f.lineTo(0, height);
        g2.fill(f);
        int px[] = {0, 25, 25};
        int py[] = {height, height + 30, height};
        g.setColor(new Color(250, 250, 250));
        g.fillPolygon(px, py, px.length);
        //  Create Shadow
        g.drawImage(new ShadowRenderer(10, 0.5f, Color.BLACK).createShadow(img), -5, 5, width + 10, height + 5, null);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }

    public List getList() {
        return list;
    }

    public void setButtonColor(Color color) {
        cmdBuy.setBackground(color);
    }

    public void addEventBuy(ActionListener event) {
        cmdBuy.addActionListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button cmdBuy;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.raven.swing.List<String> list;
    // End of variables declaration//GEN-END:variables
}
