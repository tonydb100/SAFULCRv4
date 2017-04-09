package Login;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class LoginDialog extends javax.swing.JDialog {

    ManagerLoginUI ml = new ManagerLoginUI();
    
    public LoginDialog() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ml.UpdateComboUsername(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("UIElements/icon.png")));
    }

    public JComboBox<String> getCmbUsernameLogin() {
        return cmbUsernameLogin;
    }

    public void setCmbUsernameLogin(JComboBox<String> cmbUsernameLogin) {
        this.cmbUsernameLogin = cmbUsernameLogin;
    }

    public JPasswordField getFldPasswordLogin() {
        return fldPasswordLogin;
    }

    public void setFldPasswordLogin(JPasswordField fldPasswordLogin) {
        this.fldPasswordLogin = fldPasswordLogin;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        fldPasswordLogin = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbUsernameLogin = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAFULCR - Inicio de Sesión");
        setMinimumSize(new java.awt.Dimension(290, 195));
        getContentPane().setLayout(null);

        btnExit.setText("Cancelar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnExit);
        btnExit.setBounds(190, 130, 80, 23);

        btnLogin.setText("Aceptar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionListener(evt);
            }
        });
        jLayeredPane1.add(btnLogin);
        btnLogin.setBounds(100, 130, 80, 23);

        fldPasswordLogin.setMinimumSize(new java.awt.Dimension(5, 20));
        fldPasswordLogin.setPreferredSize(new java.awt.Dimension(5, 20));
        jLayeredPane1.add(fldPasswordLogin);
        fldPasswordLogin.setBounds(90, 90, 180, 20);

        jLabel3.setText("Contraseña:");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(10, 90, 70, 20);

        jLabel2.setText("Usuario:");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(10, 50, 40, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/clear.png"))); // NOI18N
        jLayeredPane1.add(jLabel6);
        jLabel6.setBounds(7, 50, 60, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/clear.png"))); // NOI18N
        jLayeredPane1.add(jLabel7);
        jLabel7.setBounds(7, 90, 60, 20);

        jLayeredPane1.add(cmbUsernameLogin);
        cmbUsernameLogin.setBounds(90, 50, 180, 20);

        jLabel1.setFont(new java.awt.Font("Open Sans Extrabold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 94, 52));
        jLabel1.setText("SAFULCR");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(100, 10, 108, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/logo2.png"))); // NOI18N
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(0, 50, 120, 120);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/favicon.png"))); // NOI18N
        jLayeredPane1.add(jLabel5);
        jLabel5.setBounds(40, 0, 50, 50);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(4, 1, 270, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void actionListener(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionListener
        try {
            ml.validateStartSession(this);
        } catch (Exception ex) {}
        
    }//GEN-LAST:event_actionListener

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
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbUsernameLogin;
    private javax.swing.JPasswordField fldPasswordLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
