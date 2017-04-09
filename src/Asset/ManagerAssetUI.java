package Asset;

import Connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManagerAssetUI extends DataBaseConnection {

    DefaultTableModel model;
    
    void Disable(ManageAsset rd){
        rd.getFieldCode().setEnabled(false);
        rd.getFieldName().setEnabled(false);
        rd.getCmbDepartment().setEnabled(false);
        rd.getCmbHeadquarter().setEnabled(false);
        rd.getTextDescription().setEnabled(false);
    }
    
    void Enable(ManageAsset rd){
        rd.getFieldCode().setEnabled(true);
        rd.getFieldName().setEnabled(true);
        rd.getCmbDepartment().setEnabled(true);
        rd.getCmbHeadquarter().setEnabled(true);
        rd.getTextDescription().setEnabled(true);
    }
    
    void Clear(ManageAsset rd){
        rd.getFieldCode().setText("");
        rd.getFieldName().setText("");
        rd.getCmbDepartment().setSelectedIndex(0);
        rd.getCmbHeadquarter().setSelectedIndex(0);
        rd.getTextDescription().setText("");
    }
    
    void UploadData(ManageAsset rd){
        
        try{
        Connection Conn = this.ConnectToDb();
        Statement sent;
        
        String [] titles = {"Id", "Nombre", "Departamento", "Sede", "Código", "Fecha Registro", "Usuario Registro", "Descripción"};
        String sql="SELECT * FROM asset";
        model=new DefaultTableModel(null, titles);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String row []= new String [8];

        while(rs.next()){
            row[0]=rs.getString("asset_id");
            row[1]=rs.getString("asset_name");
            row[2]=rs.getString("asset_department");
            row[3]=rs.getString("asset_headquarter");  
            row[4]=rs.getString("asset_code");
            row[5]=rs.getString("asset_registrationDate");
            row[6]=rs.getString("asset_user");
            row[7]=rs.getString("asset_description");
            
            model.addRow(row);
        }
        rd.getTblReadAsset().setModel(model);
        rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadAsset().getRowCount() );
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    void DeleteAsset(ManageAsset rd) throws SQLException{
        
        try{
            Connection Conn = this.ConnectToDb();
            Statement sent;
            
            int row = rd.getTblReadAsset().getSelectedRow();
            String sql = "DELETE FROM asset WHERE asset_id=" + rd.getTblReadAsset().getValueAt(row,0);
            sent = Conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                this.UploadData(rd);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                this.Clear(rd);
            }
            rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadAsset().getRowCount() );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        finally{
            this.CloseConnection();
        }
        
    }
    
    void New(ManageAsset rd) throws SQLException, ClassNotFoundException{
        
        this.Enable(rd);
        
        String Name = rd.getFieldName().getText().toUpperCase().trim();
        String Department = rd.getCmbDepartment().getSelectedItem().toString().toUpperCase();
        String Headquarter = rd.getCmbHeadquarter().getSelectedItem().toString().toUpperCase();
        String Code = rd.getFieldCode().getText().trim().toUpperCase();
        
        Calendar c1 = GregorianCalendar.getInstance();      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String registrationDate = formato.format(c1.getTime());
        
        String User = this.getLastUser();
        
        String Description = rd.getTextDescription().getText().toUpperCase();
        
        if(Name.isEmpty() || Code.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor, Complete los espacios requeridos.");
        }else{
            switch(this.uniqueCode(Code)){
                case 0:
                    JOptionPane.showMessageDialog(null,"Código existente.\nIntente de nuevo.");
                    rd.getFieldCode().setText("");
                    break;
                case 1:
                    try{
                        Connection Conn = this.ConnectToDb();

                        String sql="INSERT INTO asset (asset_name, asset_department, asset_headquarter, asset_code, asset_registrationDate, "
                    + "asset_user, asset_description) values (?,?,?,?,?,?,?) ";
                        PreparedStatement ps = Conn.prepareCall(sql);
                        ps.setString(1, Name);
                        ps.setString(2, Department);
                        ps.setString(3, Headquarter);
                        ps.setString(4, Code);
                        ps.setString(5, registrationDate);
                        ps.setString(6, User);
                        ps.setString(7, Description);

                        int n = ps.executeUpdate();
                        if(n>0){
                            this.UploadData(rd);
                            JOptionPane.showMessageDialog(null, "Registro Almacenado");
                            this.Clear(rd);
                        }
                    }catch(SQLException es){}
                    finally{
                        this.CloseConnection();
                    }
                    break;
            }
            
        }
            
    }
    
    public String getLastUser(){
       
        Connection reg = this.getCn();
        String cap = "";
        String querySql = "Select * from session order by session_id DESC LIMIT 1";
        
        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            
            while(rs.next()) {
                cap = rs.getString("session_username");
            }
            
        } catch (SQLException ex) {}   
        return cap;
    }
    
    void Update(ManageAsset rd) throws SQLException{
        try{
            Connection Conn = this.ConnectToDb();
            
            String sql = "Update asset SET asset_name=?, asset_department=?, asset_headquarter=?, "
                    + "asset_code=?, asset_description=? WHERE asset_id=?";
            
            int row = rd.getTblReadAsset().getSelectedRow();
            String dao = (String)rd.getTblReadAsset().getValueAt(row,0);
            PreparedStatement ps = Conn.prepareCall(sql);
            ps.setString(1,rd.getFieldName().getText().trim().toUpperCase());
            ps.setString(2,rd.getCmbDepartment().getSelectedItem().toString().toUpperCase());
            ps.setString(3,rd.getCmbHeadquarter().getSelectedItem().toString().toUpperCase());
            ps.setString(4,rd.getFieldCode().getText().trim().toUpperCase());
            ps.setString(5,rd.getTextDescription().getText().toUpperCase());
            ps.setString(6,dao);

            int n = ps.executeUpdate();
            if(n>0){
                this.UploadData(rd);
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                this.Clear(rd);

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        finally{
            this.CloseConnection();
        }
    }
    
    void ClickMouse(ManageAsset rd, java.awt.event.MouseEvent evt) throws SQLException {
        
        if(evt.getButton()==1){
            try{
                Connection Conn = this.ConnectToDb();
                Statement sent;
                
                this.Enable(rd);
                int fila = rd.getTblReadAsset().getSelectedRow();
                String sql = "SELECT * FROM asset WHERE asset_id=" + rd.getTblReadAsset().getValueAt(fila,0);
                sent = Conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                
                rd.getFieldName().setText(rs.getString("asset_name"));
                rd.getFieldCode().setText(rs.getString("asset_code"));
                rd.getTextDescription().setText(rs.getString("asset_description"));

            }catch(Exception e){}
            finally{
                this.CloseConnection();
            }
        }
        
    }
    
    public int uniqueCode(String idCard) throws ClassNotFoundException, SQLException{
       
        int num = 0;
        ResultSet rs;
        try {
            this.ConnectToDb();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM asset WHERE asset_code = '" + idCard + "'");
            rs = st.executeQuery();
            String cap = "";
            
            while(rs.next()) {
                cap = rs.getString("asset_code");
            }
            if(!cap.equals("")){
                num = 0;
            }else{
                num = 1;
            }
            
        } catch (SQLException ex) {} 
        finally{
            this.CloseConnection();
        }
        
        return num;
    }
 
    public void UpdateComboDepartment(ManageAsset dd) {
        
        ResultSet rs;
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            Connection conn = this.ConnectToDb();
            Statement st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT DISTINCT department_name FROM department");
            
            comboModel.addElement("Seleccione Departamento");
            dd.getCmbDepartment().setModel(comboModel);
            
            while (rs.next()) {
                comboModel.addElement(rs.getObject("department_name"));
                dd.getCmbDepartment().setModel(comboModel);
            }
 
            st.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {}
    }
    
    public void UpdateComboHeadquarter(ManageAsset dd) {
        
        ResultSet rs;
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            Connection conn = this.ConnectToDb();
            Statement st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT DISTINCT department_headquarter FROM department");
            
            comboModel.addElement("Seleccione Sede");
            dd.getCmbHeadquarter().setModel(comboModel);
            
            while (rs.next()) {
                comboModel.addElement(rs.getObject("department_headquarter"));
                dd.getCmbHeadquarter().setModel(comboModel);
            }
 
            st.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {}
    }
    
}
