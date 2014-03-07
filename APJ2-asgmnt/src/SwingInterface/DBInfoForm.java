/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingInterface;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author tannm_b01522
 */
public class DBInfoForm extends java.awt.Dialog {
    private boolean signal;
    
    /**
     * Creates new form ConnectForm
     */
    public DBInfoForm(java.awt.Frame parent, boolean modal) { 
        super(parent, modal);
        this.signal = false;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogPane = new javax.swing.JPanel();
        txtServer = new javax.swing.JTextField();
        lblServer1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPsw = new javax.swing.JLabel();
        txtPsw = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();

        setResizable(false);
        setTitle("Database Information");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        txtServer.setText("LAB2_SERVER\\SQL2008");

        lblServer1.setText("Server name");

        lblUserName.setText("User name");

        txtUserName.setText("sa");
        txtUserName.setToolTipText("");

        lblPsw.setText("Password");

        txtPsw.setText("fat123456");

        btnExit.setText("Close");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogPaneLayout = new javax.swing.GroupLayout(dialogPane);
        dialogPane.setLayout(dialogPaneLayout);
        dialogPaneLayout.setHorizontalGroup(
            dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPaneLayout.createSequentialGroup()
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dialogPaneLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblServer1)
                            .addComponent(lblUserName)
                            .addComponent(lblPsw))))
                .addGap(18, 18, 18)
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServer)
                    .addComponent(txtUserName)
                    .addComponent(txtPsw)
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addComponent(btnConnect)))
                .addGap(71, 71, 71))
        );
        dialogPaneLayout.setVerticalGroup(
            dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPaneLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName))
                .addGap(45, 45, 45)
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPsw))
                .addGap(32, 32, 32)
                .addGroup(dialogPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConnect))
                .addGap(43, 43, 43))
        );

        add(dialogPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        this.signal = true;
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_btnConnectActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel dialogPane;
    private javax.swing.JLabel lblPsw;
    private javax.swing.JLabel lblServer1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtPsw;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    public String getTxtPsw() {
        return txtPsw.getText();
    }

    public String getTxtServer() {
        return txtServer.getText();
    }

    public String getTxtUserName() {
        return txtUserName.getText();
    } 

    public boolean getSignal() {
        return signal;
    }

}

