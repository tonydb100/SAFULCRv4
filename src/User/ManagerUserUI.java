package User;

import Connection.DataBaseConnection;
import Connection.Encryption;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerUserUI extends DataBaseConnection {

    DefaultTableModel model;
    Encryption en = new Encryption();
    
    void Disable(ManageUser rd){
        rd.getFieldIdCard().setEnabled(false);
        rd.getFieldFirstName().setEnabled(false);
        rd.getFieldLastName().setEnabled(false);
        rd.getFieldLastName2().setEnabled(false);
        rd.getFieldPhone1().setEnabled(false);
        rd.getFieldPhone2().setEnabled(false);
        rd.getTextAddress().setEnabled(false);
        rd.getFieldEmail().setEnabled(false);
        rd.getComboRole().setEnabled(false);
        rd.getLblUsername().setEnabled(false);
        rd.getFieldPassword().setEnabled(false);        
    }
    
    void Enable(ManageUser rd){
        rd.getFieldIdCard().setEnabled(true);
        rd.getFieldFirstName().setEnabled(true);
        rd.getFieldLastName().setEnabled(true);
        rd.getFieldLastName2().setEnabled(true);
        rd.getFieldPhone1().setEnabled(true);
        rd.getFieldPhone2().setEnabled(true);
        rd.getTextAddress().setEnabled(true);
        rd.getFieldEmail().setEnabled(true);
        rd.getComboRole().setEnabled(true);
        rd.getLblUsername().setEnabled(true);
        rd.getFieldPassword().setEnabled(true);  
    }
    
    void Clear(ManageUser rd){
        rd.getFieldIdCard().setText("");
        rd.getFieldFirstName().setText("");
        rd.getFieldLastName().setText("");
        rd.getFieldLastName2().setText("");
        rd.getFieldPhone1().setText("");
        rd.getFieldPhone2().setText("");
        rd.getTextAddress().setText("");
        rd.getFieldEmail().setText("");
        rd.getFieldPassword().setText("");
        rd.getComboRole().setSelectedIndex(0);
    }
    
    void UploadData(ManageUser rd){
        
        try{
        Connection Conn = this.ConnectToDb();
        Statement sent;
        
        String [] titles = {"Id", "Cédula", "Nombre", "Apellido", "Apellido 2", "Teléfono 1", "Teléfono 2", 
            "Dirección", "Correo", "Rol", "Usuario", "Contraseña", "Fecha de Registro"};
        String sql="SELECT * FROM user";
        model=new DefaultTableModel(null, titles);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String row []= new String [13];

        while(rs.next()){
            row[0]=rs.getString("user_id");
            row[1]=rs.getString("user_idCard");
            row[2]=rs.getString("user_firstName");
            row[3]=rs.getString("user_lastName");  
            row[4]=rs.getString("user_lastName2");
            row[5]=rs.getString("user_phone1");
            row[6]=rs.getString("user_phone2");
            row[7]=rs.getString("user_address");
            row[8]=rs.getString("user_email");
            row[9]=rs.getString("user_role");
            row[10]=rs.getString("user_username");
            row[11]="********";
            row[12]=rs.getString("user_registrationDate");
            
            model.addRow(row);
        }
        rd.getTblReadUser().setModel(model);
        rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadUser().getRowCount() );
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    void DeleteUser(ManageUser rd) throws SQLException{
        
        try{
            Connection Conn = this.ConnectToDb();
            Statement sent;
            
            int row = rd.getTblReadUser().getSelectedRow();
            String sql = "DELETE FROM user WHERE user_id=" + rd.getTblReadUser().getValueAt(row,0);
            sent = Conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                this.UploadData(rd);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                this.Clear(rd);
            }
            rd.getLblMessage().setText( "Registros Existentes: " + rd.getTblReadUser().getRowCount() );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        finally{
            this.CloseConnection();
        }
        
    }
    
    void New(ManageUser rd) throws SQLException, ClassNotFoundException{
        
        this.Enable(rd);
        
        String idCard = rd.getFieldIdCard().getText().trim();
        String firstName = rd.getFieldFirstName().getText().toUpperCase().trim();
        String lastName = rd.getFieldLastName().getText().toUpperCase().trim();
        String lastName2 = rd. getFieldLastName2().getText().toUpperCase().trim();
        String phone1 = rd.getFieldPhone1().getText().trim();
        String phone2 = rd.getFieldPhone2().getText().trim();
        String address = rd.getTextAddress().getText().toUpperCase();
        String email = rd.getFieldEmail().getText().toUpperCase().trim();
        String role = rd.getComboRole().getSelectedItem().toString().toUpperCase();
        String userName = rd.getFieldFirstName().getText().substring(0, 1).toLowerCase().trim() 
                    + rd.getFieldLastName().getText().toLowerCase().trim();
        String pass = new String( rd.getFieldPassword().getPassword() ).trim().toLowerCase();
        String cypher = en.Cifrado(pass, userName);
        
        Calendar c1 = GregorianCalendar.getInstance();      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String registrationDate = formato.format(c1.getTime());
        
        if(idCard.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phone1.isEmpty() || email.isEmpty() 
                || role.isEmpty() || userName.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por Favor, Complete los espacios requeridos.");
        }else{
            switch(this.uniqueID(idCard)){
                case 0:
                    JOptionPane.showMessageDialog(null,"Cédula existente.\nIntente de nuevo.");
                    rd.getFieldIdCard().setText("");
                    break;
                case 1:
                    try{
                        Connection Conn = this.ConnectToDb();

                        String sql="INSERT INTO user (user_idCard, user_firstName, user_lastName, user_lastName2, user_phone1, "
                    + "user_phone2, user_address, user_email, user_role, user_username, user_password, user_registrationDate) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?) ";
                        PreparedStatement ps = Conn.prepareCall(sql);
                        ps.setString(1, idCard);
                        ps.setString(2, firstName);
                        ps.setString(3, lastName);
                        ps.setString(4, lastName2);
                        ps.setString(5, phone1);
                        ps.setString(6, phone2);
                        ps.setString(7, address);
                        ps.setString(8, email);
                        ps.setString(9, role);
                        ps.setString(10, userName);
                        ps.setString(11, cypher);
                        ps.setString(12, registrationDate);

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
    
    void Update(ManageUser rd) throws SQLException{
        try{
            Connection Conn = this.ConnectToDb();
            
            String sql = "Update user SET user_idCard=?, user_firstName=?, user_lastName=?, user_lastName2=?, user_phone1=?, "
                    + "user_phone2=?, user_address=?, user_email=?, user_role=?, user_password=? WHERE user_id=?";
            
            int row = rd.getTblReadUser().getSelectedRow();
            String dao = (String)rd.getTblReadUser().getValueAt(row,0);
            PreparedStatement ps = Conn.prepareCall(sql);
            ps.setString(1,rd.getFieldIdCard().getText().toUpperCase());
            ps.setString(2,rd.getFieldFirstName().getText().toUpperCase());
            ps.setString(3,rd.getFieldLastName().getText().toUpperCase());
            ps.setString(4,rd.getFieldLastName2().getText().toUpperCase());
            ps.setString(5,rd.getFieldPhone1().getText());
            ps.setString(6,rd.getFieldPhone2().getText());
            ps.setString(7,rd.getTextAddress().getText().toUpperCase());
            ps.setString(8,rd.getFieldEmail().getText().toUpperCase());
            ps.setString(9,rd.getComboRole().getSelectedItem().toString().toUpperCase());
            ps.setString(10,rd.getFieldPassword().getText());

            ps.setString(11,dao);

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
    
    void ClickMouse(ManageUser rd, java.awt.event.MouseEvent evt) throws SQLException {
        
        if(evt.getButton()==1){
            try{
                Connection Conn = this.ConnectToDb();
                Statement sent;
                
                this.Enable(rd);
                int fila = rd.getTblReadUser().getSelectedRow();
                String sql = "SELECT * FROM user WHERE user_id=" + rd.getTblReadUser().getValueAt(fila,0);
                sent = Conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                
                rd.getFieldIdCard().setText(rs.getString("user_idCard"));
                rd.getFieldFirstName().setText(rs.getString("user_firstName"));
                rd.getFieldLastName().setText(rs.getString("user_lastName"));
                rd.getFieldLastName2().setText(rs.getString("user_lastName2"));
                rd.getFieldPhone1().setText(rs.getString("user_phone1"));
                rd.getFieldPhone2().setText(rs.getString("user_phone2"));
                rd.getTextAddress().setText(rs.getString("user_address"));
                rd.getFieldEmail().setText(rs.getString("user_email"));
                rd.getFieldPassword().setText(rs.getString("user_password"));;

            }catch(Exception e){}
            finally{
                this.CloseConnection();
            }
        }
        
    }
    
    public int uniqueID(String idCard) throws ClassNotFoundException, SQLException{
       
        int num = 0;
        ResultSet rs;
        try {
            this.ConnectToDb();
            PreparedStatement st = this.getCn().prepareStatement("SELECT * FROM user WHERE user_idCard = '" + idCard + "'");
            rs = st.executeQuery();
            String cap = "";
            
            while(rs.next()) {
                cap = rs.getString("user_idCard");
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
 
    public void UpdateComboRole(ManageUser dd) {
        ResultSet rs;
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            Connection conn = this.ConnectToDb();
            Statement st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT DISTINCT role_name FROM role");
            
            comboModel.addElement("Seleccione Rol");
            dd.getComboRole().setModel(comboModel);
            
            while (rs.next()) {
                comboModel.addElement(rs.getObject("role_name"));
                dd.getComboRole().setModel(comboModel);
            }
 
            st.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {}
    }
    
    public void validateNumbers(JFrame ui, JTextField j){
        
        j.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if( !Character.isDigit(c) ){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo NÚMEROS en el espacio Teléfono.");
                }
            }
        });
        
    }
    
    public void validateLetters(JFrame ui, JTextField j){
        
        j.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if( Character.isDigit(c) ){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo LETRAS en el espacio Contraseña.");
                }
            }
        });
        
    }
    
}
