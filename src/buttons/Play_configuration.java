package buttons;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author technologyrooms
 */
public class Play_configuration extends javax.swing.JFrame {

    /**
     * Creates new form Play_configuration
     */
    public Play_configuration() {
        initComponents();
    }
    public static String Color = null;
    public static String copyColor="";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        elo = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Play = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButton1.setText("White");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Black");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        elo.setModel(new javax.swing.SpinnerNumberModel(1500, 1350, 2850, 50));
        elo.setOpaque(true);
        elo.setValue(1500);

        jLabel1.setText("Color");

        jLabel2.setText("Elo (1350-2850)");

        Play.setText("Play");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton1))
                            .addComponent(jLabel2)
                            .addComponent(elo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Play))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(Play))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        buttonGroup1.add(jRadioButton2);
        if (jRadioButton2.isSelected()) {
            Color = "Black";
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        buttonGroup1.add(jRadioButton1);
        if (jRadioButton1.isSelected()) {
            Color = "White";
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        if (Color != null) {
            if (Color.equals("White")) {
                if (NewJFramePrincipal.action == 0) {
                    int level = (Integer) elo.getValue();
                    Memory.LEVELorELO = level;
                    try {
                        Memory.engine = new UCI("\"C:\\Users\\Mario\\Desktop\\Mario X\\Programación\\Chess-buttons\\src\\resources\\stockfish\\stockfish-windows-x86-64-avx2.exe\"");
                        Memory.engine.init();
                        Memory.engine.setElo(level);
                        Memory.gameId = Memory.engine.createGame();
                        this.setVisible(false);
                        Memory.guardarPosicion();
                        jLabel3.setText("");
                        if (Color.equals("White")) {
                            Memory.PlayView.setVisible(true);
                            //Color = null;
                            Memory.adds.get("labelElo").setText(String.valueOf(Memory.LEVELorELO));
                            //System.out.println(Memory.names.get("e4").getName());
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Play_configuration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    this.setVisible(false);
                    //Color = null;
                    Memory.PlayView.setVisible(true);
                }
            }
            if (Color.equals("Black")) {
                if (TableroNegras.Naction == 0) {
                    int level = (Integer) elo.getValue();
                    NMemory.NLEVELorELO = level;
                    try {
                        NMemory.Nengine = new UCI("\"C:\\Users\\Mario\\Desktop\\Mario X\\Programación\\Chess-buttons\\src\\resources\\stockfish\\stockfish-windows-x86-64-avx2.exe\"");
                        NMemory.Nengine.init();
                        NMemory.Nengine.setElo(level);
                        NMemory.NgameId = NMemory.Nengine.createGame();
                        /////////////////////////FIRSTMOVE
                        NMemory.Nengine.makeMove(NMemory.NgameId, NMemory.Ntext);
                        try {
                     //Memory.engine.makeMove(Memory.gameId, Memory.text);
                     NFunction.Nres = NMemory.Nengine.getBestMove(NMemory.NgameId, 1000);
                     NMemory.Nengine.makeMove(NMemory.NgameId, NFunction.Nres.bestMove);
                     ////DOWN CHANGED TO FALSE
                      NFunction.Nstockfishplayed=false;
            } catch (IOException ex) {
                Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
            }
                        /////////////////////////FIRSTMOVE
                        this.setVisible(false);
                        NMemory.NguardarPosicion();
                        jLabel3.setText("");
                        if (Color.equals("Black")) {
                            NMemory.NPlayView.setVisible(true);
                            //Color = null;
                            NMemory.Nadds.get("NlabelElo").setText(String.valueOf(NMemory.NLEVELorELO));
                            //System.out.println(Memory.names.get("e4").getName());
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Play_configuration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    this.setVisible(false);
                    //Color = null;
                    NMemory.NPlayView.setVisible(true);
                }
            }
        } else {
            jLabel3.setText("(Select a color)");
        }
        copyColor=Color;
        Color="";
    }//GEN-LAST:event_PlayActionPerformed

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
            java.util.logging.Logger.getLogger(Play_configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play_configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play_configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play_configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play_configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Play;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner elo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
