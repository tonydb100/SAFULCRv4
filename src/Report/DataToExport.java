package Report;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DataToExport extends javax.swing.JFrame {

//    private JFileChooser FileChooser=new JFileChooser(); 
    Vector columna = new Vector(); 
    Vector filas = new  Vector();  
    static int tabla_ancho = 0; 
    static int tabla_alto = 0; 
    
    
    public DataToExport() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("UIElements/icon.png")));
        setResizable(false);
    }

    public JTable getTblData() {
        return tblData;
    }

    public void setTblData(JTable tblData) {
        this.tblData = tblData;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogSearch = new javax.swing.JDialog();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        fldPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnCancelDialog = new javax.swing.JButton();
        btnSaveFile = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        DialogSearch.setTitle("Exportar Datos");
        DialogSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("UIElements/icon.png")));

        fldPath.setEnabled(false);
        fldPath.setFocusable(false);
        jLayeredPane2.add(fldPath);
        fldPath.setBounds(120, 40, 230, 20);

        btnBrowse.setText("Buscar");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnBrowse);
        btnBrowse.setBounds(40, 40, 65, 23);

        btnCancelDialog.setText("Cancelar");
        btnCancelDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDialogActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnCancelDialog);
        btnCancelDialog.setBounds(280, 110, 75, 23);

        btnSaveFile.setText("Guardar");
        btnSaveFile.setEnabled(false);
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnSaveFile);
        btnSaveFile.setBounds(200, 110, 71, 23);

        jLabel4.setFont(new java.awt.Font("Open Sans Extrabold", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(8, 94, 52));
        jLabel4.setText("XLS");
        jLayeredPane2.add(jLabel4);
        jLabel4.setBounds(20, 80, 140, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/logo1.png"))); // NOI18N
        jLayeredPane2.add(jLabel3);
        jLabel3.setBounds(10, 10, 130, 140);

        javax.swing.GroupLayout DialogSearchLayout = new javax.swing.GroupLayout(DialogSearch.getContentPane());
        DialogSearch.getContentPane().setLayout(DialogSearchLayout);
        DialogSearchLayout.setHorizontalGroup(
            DialogSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        DialogSearchLayout.setVerticalGroup(
            DialogSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogSearchLayout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte");
        setPreferredSize(new java.awt.Dimension(837, 380));

        tblData.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblData);

        jLayeredPane1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 780, 260);

        btnExport.setText("Exportar");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnExport);
        btnExport.setBounds(660, 300, 75, 23);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnClose);
        btnClose.setBounds(740, 300, 63, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIElements/logob.png"))); // NOI18N
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(650, 160, 180, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser dialog = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hojas de cálculo (*.xls)", "xls");
        dialog.setFileFilter(filter);
        int opcion = dialog.showSaveDialog(this);

        if(opcion == JFileChooser.APPROVE_OPTION){

            File dir = dialog.getSelectedFile();
            String name = dir.getName();
            String path = dir.getParent();
            String[] pars = name.split("\\.",-1);
            if(pars[(pars.length-1)].equalsIgnoreCase("xls")){
                name = pars[0];
                for(int i = 1; i < (pars.length-1) ; i++){
                    name = name + "." + pars[i];
                    System.out.println(name);
                }
            }
            name = name + ".xls";
            this.fldPath.setText(path+"\\"+name);
        }
        
        if(this.fldPath.getText().length() > 0){
            this.btnSaveFile.setEnabled(true);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        try {      	 
            List<JTable> tb = new ArrayList<JTable>();
            tb.add(this.tblData);
           
            Export excelExporter = new Export(tb, new File(this.fldPath.getText()));
            if (excelExporter.export()) {
                JOptionPane.showMessageDialog(null, "Documento generado con éxito!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.OpenExcel();
        this.DialogSearch.dispose();
    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
//        JFileChooser fileChooser = new JFileChooser();
//        Component modalToComponent = null;
//        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            // save to file
//        }
        this.CallDialog();
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCancelDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDialogActionPerformed
        this.DialogSearch.dispose();
    }//GEN-LAST:event_btnCancelDialogActionPerformed

    private void CallDialog() {
        this.DialogSearch.setLocationRelativeTo(null);
        this.DialogSearch.setModal(true);
        this.DialogSearch.setMinimumSize(new Dimension(393, 190));
        this.DialogSearch.setTitle("Exportar a Excel");
        this.DialogSearch.setVisible(true);
    }
    
    public void OpenExcel() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+this.fldPath.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public void CreateTable(File file) throws IOException {
//		
//        Workbook workbook = null;
//
//        try { 
//            workbook = Workbook.getWorkbook(file); 	
//
//            Sheet sheet = workbook.getSheet(0); 
//            columna.clear(); 
//
//            for (int i = 0; i < sheet.getColumns(); i++) { 
//                Cell cell1 = sheet.getCell(i, 0);
//                columna.add(cell1.getContents()); 
//            } 
//            filas.clear(); 
//
//            for (int j = 1; j < sheet.getRows(); j++) {
//                Vector d = new Vector(); 
//                for (int i = 0; i < sheet.getColumns(); i++) {
//
//                        Cell cell = sheet.getCell(i, j); 
//                        d.add(cell.getContents());
//                }
//                d.add("\n");
//                filas.add(d); 
//            } 
//        } catch (BiffException e) { 
//            e.printStackTrace(); 
//        }
//    }
    
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
            java.util.logging.Logger.getLogger(DataToExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataToExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataToExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataToExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataToExport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogSearch;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancelDialog;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JTextField fldPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
