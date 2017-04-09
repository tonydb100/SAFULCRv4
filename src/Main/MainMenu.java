package Main;

import Asset.ManageAsset;
import Department.ManageDepartment;
import Login.LoginDialog;
import Login.ManagerLoginUI;
import Report.DataToExport;
import Report.UploadData;
import User.*;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class MainMenu extends javax.swing.JFrame implements ComponentListener {

        
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setIcon();
        addComponentListener(this);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    

    public JLabel getLblSession() {
        return lblSession;
    }

    public void setLblSession(JLabel lblSession) {
        this.lblSession = lblSession;
    }

    public JMenu getMenuReports() {
        return MenuReports;
    }

    public void setMenuReports(JMenu MenuReports) {
        this.MenuReports = MenuReports;
    }

    public JMenu getMenuUser() {
        return MenuUser;
    }

    public void setMenuUser(JMenu MenuUser) {
        this.MenuUser = MenuUser;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblLogoLatina = new javax.swing.JLabel();
        panel_log = new javax.swing.JPanel();
        lblSession = new javax.swing.JLabel();
        lblLogoProdImg = new javax.swing.JLabel();
        lblLogoProd = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuItemAssets = new javax.swing.JMenuItem();
        MenuUser = new javax.swing.JMenu();
        mnuItemListEditUsers = new javax.swing.JMenuItem();
        MenuDepartment = new javax.swing.JMenu();
        mnuItemManageDep = new javax.swing.JMenuItem();
        MenuReports = new javax.swing.JMenu();
        mnuItemRepSessions = new javax.swing.JMenuItem();
        mnuItemRepDepartment = new javax.swing.JMenuItem();
        mnuItemRepUser = new javax.swing.JMenuItem();
        mnuItemRepAsset = new javax.swing.JMenuItem();
        MenuOptions = new javax.swing.JMenu();
        mnuItemLogOut = new javax.swing.JMenuItem();
        mnuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAFULCR 2.0");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(665, 400));

        jLayeredPane1.setAlignmentY(0.0F);

        lblLogoLatina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/logo-latina-2015.png"))); // NOI18N
        jLayeredPane1.add(lblLogoLatina);
        lblLogoLatina.setBounds(360, 0, 300, 70);

        panel_log.setBackground(new java.awt.Color(0, 102, 51));

        lblSession.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSession.setForeground(new java.awt.Color(255, 255, 255));
        lblSession.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel_logLayout = new javax.swing.GroupLayout(panel_log);
        panel_log.setLayout(panel_logLayout);
        panel_logLayout.setHorizontalGroup(
            panel_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_logLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSession, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_logLayout.setVerticalGroup(
            panel_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_logLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSession, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane1.add(panel_log);
        panel_log.setBounds(450, 300, 190, 30);

        lblLogoProdImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/logo.png"))); // NOI18N
        jLayeredPane1.add(lblLogoProdImg);
        lblLogoProdImg.setBounds(20, 120, 190, 190);

        lblLogoProd.setFont(new java.awt.Font("Open Sans Extrabold", 0, 36)); // NOI18N
        lblLogoProd.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoProd.setText("SAFULCR");
        jLayeredPane1.add(lblLogoProd);
        lblLogoProd.setBounds(20, 300, 190, 40);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/background.png"))); // NOI18N
        lblBackground.setAlignmentY(0.0F);
        jLayeredPane1.add(lblBackground);
        lblBackground.setBounds(0, 0, 2002, 1130);

        jMenu1.setText("Activo");

        mnuItemAssets.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemAssets.setText("Administrar");
        mnuItemAssets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemAssetsActionPerformed(evt);
            }
        });
        jMenu1.add(mnuItemAssets);

        jMenuBar1.add(jMenu1);

        MenuUser.setText("Usuario");

        mnuItemListEditUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemListEditUsers.setText("Administrar");
        mnuItemListEditUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemListEditUsersActionPerformed(evt);
            }
        });
        MenuUser.add(mnuItemListEditUsers);

        jMenuBar1.add(MenuUser);

        MenuDepartment.setText("Departamento");

        mnuItemManageDep.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemManageDep.setText("Administrar");
        mnuItemManageDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemManageDepActionPerformed(evt);
            }
        });
        MenuDepartment.add(mnuItemManageDep);

        jMenuBar1.add(MenuDepartment);

        MenuReports.setText("Reporte");

        mnuItemRepSessions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemRepSessions.setText("Sesiones");
        mnuItemRepSessions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemRepSessionsActionPerformed(evt);
            }
        });
        MenuReports.add(mnuItemRepSessions);

        mnuItemRepDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemRepDepartment.setText("Departamentos");
        mnuItemRepDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemRepDepartmentActionPerformed(evt);
            }
        });
        MenuReports.add(mnuItemRepDepartment);

        mnuItemRepUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemRepUser.setText("Usuarios");
        mnuItemRepUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemRepUserActionPerformed(evt);
            }
        });
        MenuReports.add(mnuItemRepUser);

        mnuItemRepAsset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemRepAsset.setText("Activos");
        mnuItemRepAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemRepAssetActionPerformed(evt);
            }
        });
        MenuReports.add(mnuItemRepAsset);

        jMenuBar1.add(MenuReports);

        MenuOptions.setText("Opciones");

        mnuItemLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemLogOut.setText("Cerrar Sesión");
        mnuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLogOutActionPerformed(evt);
            }
        });
        MenuOptions.add(mnuItemLogOut);

        mnuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_MASK));
        mnuItemExit.setText("Salir");
        mnuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemExitActionPerformed(evt);
            }
        });
        MenuOptions.add(mnuItemExit);

        jMenuBar1.add(MenuOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        jLayeredPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuItemExitActionPerformed

    private void mnuItemManageDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemManageDepActionPerformed
        ManageDepartment rd = new ManageDepartment();
        rd.show();
    }//GEN-LAST:event_mnuItemManageDepActionPerformed

    private void mnuItemRepSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemRepSessionsActionPerformed
        UploadData u = new UploadData();
        u.UploadData(1);
    }//GEN-LAST:event_mnuItemRepSessionsActionPerformed

    private void mnuItemRepDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemRepDepartmentActionPerformed
        UploadData u = new UploadData();
        u.UploadData(2);
    }//GEN-LAST:event_mnuItemRepDepartmentActionPerformed

    private void mnuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLogOutActionPerformed
        ManagerLoginUI m = new ManagerLoginUI();
        try {
            m.SetLogOut();
        } catch (Exception ex) {}
        this.dispose();
        LoginDialog ld = new LoginDialog();
        ld.show();
    }//GEN-LAST:event_mnuItemLogOutActionPerformed

    private void mnuItemListEditUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemListEditUsersActionPerformed
        ManageUser re = new ManageUser();
        re.show();
    }//GEN-LAST:event_mnuItemListEditUsersActionPerformed

    private void mnuItemRepUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemRepUserActionPerformed
        UploadData u = new UploadData();
        u.UploadData(3);
    }//GEN-LAST:event_mnuItemRepUserActionPerformed

    private void mnuItemRepAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemRepAssetActionPerformed
        UploadData u = new UploadData();
        u.UploadData(4);
    }//GEN-LAST:event_mnuItemRepAssetActionPerformed

    private void mnuItemAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemAssetsActionPerformed
        ManageAsset ma = new ManageAsset();
        ma.show();
    }//GEN-LAST:event_mnuItemAssetsActionPerformed

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("UIElements/icon.png")));
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuDepartment;
    private javax.swing.JMenu MenuOptions;
    private javax.swing.JMenu MenuReports;
    private javax.swing.JMenu MenuUser;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLogoLatina;
    private javax.swing.JLabel lblLogoProd;
    private javax.swing.JLabel lblLogoProdImg;
    private javax.swing.JLabel lblSession;
    private javax.swing.JMenuItem mnuItemAssets;
    private javax.swing.JMenuItem mnuItemExit;
    private javax.swing.JMenuItem mnuItemListEditUsers;
    private javax.swing.JMenuItem mnuItemLogOut;
    private javax.swing.JMenuItem mnuItemManageDep;
    private javax.swing.JMenuItem mnuItemRepAsset;
    private javax.swing.JMenuItem mnuItemRepDepartment;
    private javax.swing.JMenuItem mnuItemRepSessions;
    private javax.swing.JMenuItem mnuItemRepUser;
    private javax.swing.JPanel panel_log;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void componentResized(ComponentEvent e) {
        updateUI();
    }
    
    private void updateUI(){
        int ancho = this.getWidth();
        int alto = this.getHeight();
        lblLogoLatina.setBounds(ancho - 305, 0, 300, 70);
        lblLogoProdImg.setBounds(20, alto - 280, 190, 190);
        lblLogoProd.setBounds(20, alto - 100, 190, 40);
        panel_log.setBounds(ancho - 215, alto - 100, 190, 30);
    }

}
