package com.adoocs.love;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JDialog;

public class Game extends javax.swing.JPanel {

    private Random random;
    
    public Game() {
        initComponents();
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(new Color(255, 255, 255, 50));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
    
    private void init() {
        random = new Random();
        cmdYes.addActionListener(x -> {
            JDialog e = new JDialog(Form.f, true);
            e.setResizable(false);
            e.setUndecorated(true);
            e.setBackground(new Color(0, 0, 0, 0));
            e.setSize(450, 180);
            e.add(new Response());
            e.setLocationRelativeTo(null);
            Form.f.setVisible(false);
            e.setVisible(true);
        });

        cmdNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setLocation();
            }
        });
    }

    private void setLocation() {
        int x = random.nextInt(0, getWidth() - cmdNo.getWidth());
        int y = random.nextInt(0, getHeight() - cmdNo.getHeight());
        Point p = new Point(x, y);
        if (cmdYes.getBounds().contains(p)) {
            setLocation();
        } else {
            cmdNo.setLocation(p);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdYes = new com.adoocs.love.Button();
        cmdNo = new com.adoocs.love.Button();

        setOpaque(false);

        cmdYes.setText("SI");
        cmdYes.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        cmdYes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cmdNo.setText("NO");
        cmdNo.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        cmdNo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(cmdYes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(cmdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdYes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.adoocs.love.Button cmdNo;
    private com.adoocs.love.Button cmdYes;
    // End of variables declaration//GEN-END:variables
}
