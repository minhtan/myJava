/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverkarogame;

import apj.rmi.server.ConectionGame;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class LoginGameServer extends javax.swing.JFrame{
    public static final int MAX_ROWS = 15;
    public static final int MAX_COLS = 15;
    String nameServer,nameClient ;
    XOButton[][] btnXO = new XOButton[MAX_ROWS][MAX_COLS];
    private JPanel panelMenu2;
    ConectionGame conection;
    private JPanel panelGame;
    private PlayerKaro playerServer;
    
    public LoginGameServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelMenu1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karo Game");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        panelMenu.setPreferredSize(new java.awt.Dimension(800, 500));
        panelMenu.setLayout(new java.awt.BorderLayout());

        panelMenu1.setPreferredSize(new java.awt.Dimension(300, 500));

        jLabel1.setText("Name Player :");

        jButton1.setText("Create Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Port Conect :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Choice :");

        jButton2.setText("Conection");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(panelMenu1Layout.createSequentialGroup()
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(txtName))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(97, 97, 97)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        panelMenu.add(panelMenu1, java.awt.BorderLayout.EAST);

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karogame/image/karo-img.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Karo Game ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel5)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addGap(27, 27, 27))
        );

        panelMenu.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean ConectStart(){
        try {
            conection = new ConectionGame();
            int port = Integer.parseInt(txtPort.getText());
            Registry regis = LocateRegistry.createRegistry(port);
            Naming.rebind("rmi://localhost:" + port+"/GetName", conection);
            String name = txtName.getText();
            conection.SetNameServer(name);
            //nameClient =conection.GetNameClient();
            this.SetNamePlayerClient(nameClient);
            
            System.out.println("server running");
            return true;
            
        } catch (RemoteException ex) {
            Logger.getLogger(LoginGameServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginGameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String GetNamePlayerClient(){
        return this.nameClient;
    }
    
    public void SetNamePlayerClient(String name){
        nameClient = name;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String nameClient = conection.GetNameClient();
            panelGame = new PanelGame();
            nameServer = txtName.getText();
            String name = GetNamePlayerClient();
            panelMenu2 = new PanelMenu2(nameClient, nameServer);
            panelMenu.removeAll();
            panelMenu.add(panelGame,BorderLayout.CENTER);
            panelMenu.add(panelMenu2,BorderLayout.EAST);
            panelMenu.validate();
            int value = 1;
            playerServer = new PlayerKaro();
        } catch (RemoteException ex) {
            Logger.getLogger(LoginGameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(true)
        ConectStart();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             new LoginGameServer().setVisible(true);
               
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenu1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables



}
