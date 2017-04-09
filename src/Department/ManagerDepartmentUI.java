package Department;

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

public class ManagerDepartmentUI extends DataBaseConnection {
    
    DefaultTableModel model;
    
    void Disable(ManageDepartment rd){
        rd.getFldNameDepartment().setEnabled(false);
        rd.getTxtDetail().setEnabled(false);
        rd.getCmbHead().setEnabled(false);
    }
    
    void Enable(ManageDepartment rd){
        rd.getFldNameDepartment().setEnabled(true);
        rd.getTxtDetail().setEnabled(true);
        rd.getCmbHead().setEnabled(true);
    }
    
    void Clear(ManageDepartment rd){
        rd.getFldNameDepartment().setText("");
        rd.getTxtDetail().setText("");
        rd.getCmbHead().setSelectedIndex(0);
    }
    
    void UploadData(ManageDepartment rd){
        
        try{
        Connection Conn = this.ConnectToDb();
        Statement sent;
        
        String [] titles ={"Id", "Nombre", "Detalle", "Sede", "Fecha Registro"};
        String sql="SELECT * FROM department";
        model=new DefaultTableModel(null, titles);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String row []= new String [5];

        while(rs.next()){
            row [0]=rs.getString("department_id");
            row [1]=rs.getString("department_name");
            row [2]=rs.getString("department_detail");
            row [3]=rs.getString("department_headquarter");
            row [4]=rs.getString("department_registrationDate");

            model.addRow(row);

        }
        rd.getTblReadDepartment().setModel(model);
        rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadDepartment().getRowCount() );
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    void DeleteDepartment(ManageDepartment rd) throws SQLException{
        
        try{
            Connection Conn = this.ConnectToDb();
            Statement sent;
            
            int row = rd.getTblReadDepartment().getSelectedRow();
            String sql = "DELETE FROM department WHERE department_id=" + rd.getTblReadDepartment().getValueAt(row,0);
            sent = Conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                this.UploadData(rd);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                this.Clear(rd);
            }
            rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadDepartment().getRowCount() );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        finally{
            this.CloseConnection();
        }
        
    }
    
    void New(ManageDepartment rd) throws SQLException, ClassNotFoundException{
        
        this.Enable(rd);
        
        Calendar c1 = GregorianCalendar.getInstance();      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String registrationDate = formato.format(c1.getTime());
        
        String name = rd.getFldNameDepartment().getText().toUpperCase();
        String head = rd.getCmbHead().getSelectedItem().toString().toUpperCase();
        String detail = rd.getTxtDetail().getText().toUpperCase();
        
        if(name.isEmpty() || head.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor, Complete los espacios requeridos.");
        }else{
            switch(this.uniqueName(name)){
                case 0:
                    JOptionPane.showMessageDialog(null,"Nombre de Departamento Existente.\nIntente de nuevo.");
                    rd.getFldNameDepartment().setText("");
                    break;
                case 1:
                    try{
                        Connection Conn = this.ConnectToDb();

                        String sql="INSERT INTO department ( department_name, department_detail, department_headquarter, department_registrationDate)" +
                               "Values (?,?,?,?) ";
                        PreparedStatement ps = Conn.prepareCall(sql);
                        ps.setString(1, name);
                        ps.setString(2, detail);
                        ps.setString(3, head);
                        ps.setString(4, registrationDate);

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
    
    void Update(ManageDepartment rd) throws SQLException{
        try{
            Connection Conn = this.ConnectToDb();
            
            String sql = "Update department SET department_name=?, department_detail=?, department_headquarter=?"+
                    "WHERE department_id=?";
            int row = rd.getTblReadDepartment().getSelectedRow();
            String dao = (String)rd.getTblReadDepartment().getValueAt(row,0);
            PreparedStatement ps = Conn.prepareCall(sql);
            ps.setString(1,rd.getFldNameDepartment().getText().toUpperCase());
            ps.setString(2,rd.getTxtDetail().getText().toUpperCase());
            ps.setString(3,rd.getCmbHead().getSelectedItem().toString().toUpperCase());

            ps.setString(4,dao);

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
    
    void ClickMouse(ManageDepartment rd, java.awt.event.MouseEvent evt) throws SQLException {
        
        if(evt.getButton()==1){
            try{
                Connection Conn = this.ConnectToDb();
                Statement sent;
                
                this.Enable(rd);
                int fila = rd.getTblReadDepartment().getSelectedRow();
                String sql = "SELECT * FROM department WHERE department_id=" + rd.getTblReadDepartment().getValueAt(fila,0);
                sent = Conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                rd.getFldNameDepartment().setText(rs.getString("department_name"));
                rd.getTxtDetail().setText(rs.getString("department_detail"));

            }catch(Exception e){}
            finally{
                this.CloseConnection();
            }
        }
        
    }
    
    int uniqueName(String name) throws ClassNotFoundException, SQLException{
       
        int num = 0;
        ResultSet rs;
        try {
            Connection conn = this.ConnectToDb();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM department WHERE department_name = '" + name + "'");
            rs = st.executeQuery();
            String cap = "";
            
            while(rs.next()) {
                cap = rs.getString("department_name");
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
    
    public void UpdateComboHead(ManageDepartment dd) {
        ResultSet rs;
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            Connection conn = this.ConnectToDb();
            Statement st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT DISTINCT department_headquarter FROM department");
            
            comboModel.addElement("Seleccione Sede");
            dd.getCmbHead().setModel(comboModel);
            
            while (rs.next()) {
                comboModel.addElement(rs.getObject("department_headquarter"));
                dd.getCmbHead().setModel(comboModel);
            }
 
            st.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {}
    }
    
}
