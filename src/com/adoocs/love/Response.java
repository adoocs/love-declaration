package com.adoocs.love;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;

public class Response extends javax.swing.JPanel {

    private char array[];
    private String paint = "";
    private ScheduledExecutorService executorService;
    private int size = 0, i = 0;

    public Response() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {
        array = "SABÍA QUE IBAS A ACEPTAR <3".toCharArray();
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::paint, 0, 150, TimeUnit.MILLISECONDS);
        close();
    }

    private void paint() {
        paint += array[i];
        i++;
        size -= 7;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#1d2671"), 0, getHeight(), Color.decode("#c33764"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setPaint(new Color(255, 255, 255, 40));
        g2.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 20, 20);
        g2.setPaint(Color.WHITE);
        g2.setFont(new Font("Consolas", 1, 25));
        g2.drawString(paint, getWidth() / 2 + size, 50);
        if (i > 26) {
            g2.setFont(new Font("Consolas", 1, 30));
            g2.drawString("TE AMO ♥", getWidth() / 2 + size + 40, 120);
            g2.drawImage(new ImageIcon("src/com/adoocs/love/love.png").getImage(), 250, 60, 110, 110, new Color(0, 0, 0, 0), this);
        }
        super.paintComponent(g);
    }

    private void close() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if (count < 10) {
                    count++;
                } else {
                    System.exit(0);
                }
            }
        }, 0, 1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(400, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
