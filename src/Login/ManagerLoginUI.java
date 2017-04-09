package Login;

import Connection.Encryption;
import Main.MainMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ManagerLoginUI extends DataLogin {
    
    public String username, password, cypher, start;
    
    Encryption EN = new Encryption();
    MainMenu mm = new MainMenu();
    
    public void validateStartSession(LoginDialog ML) throws Exception{
        
        username = ML.getCmbUsernameLogin().getSelectedItem().toString();
        password = new String (ML.getFldPasswordLogin().getPassword()).trim();
        
        Calendar c1 = GregorianCalendar.getInstance();      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        start = formato.format(c1.getTime()); 
        
        cypher = EN.Cifrado(password, username);
        
        int numero = this.validateUserSession(username, cypher);
        
        switch(numero){
            case 1: //ADMIN
                JOptionPane.showMessageDialog(null, "Bienvenido al SAFULCR ADMIN: "  + username + "!");
                ML.dispose();
                this.StartSession(username, start);
                break;
            case 2: //USER
                this.setUserLayout();
                JOptionPane.showMessageDialog(null, "Bienvenido al SAFULCR USER: " + username + "!");
                ML.dispose();
                this.StartSession(username, start);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta \nIntente de nuevo");
                ML.getFldPasswordLogin().setText("");
                break;
        }
        
    }
    public void setUserLayout() {
        mm.getMenuReports().setVisible(false);
        mm.getMenuUser().setVisible(false);
    }
    
    public void StartSession(String user, String startS) throws Exception{
        this.insertStart(user, startS);
        mm.getLblSession().setText(user + ", " + startS );
        mm.show();
    }
    
    public void SetLogOut() {
        
        Calendar c1 = GregorianCalendar.getInstance();      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String end = formato.format(c1.getTime());
        
        try {
            this.InsertEnd(end);
        } catch (Exception ex) {}
        
    }
    
    public void UpdateComboUsername(LoginDialog dd) {
        
        ResultSet rs;
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            this.ConnectToDb();
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT * FROM user");
            
            comboModel.addElement("Seleccione su Usuario");
            dd.getCmbUsernameLogin().setModel(comboModel);
            
            while (rs.next()) {
                comboModel.addElement(rs.getObject("user_username"));
                dd.getCmbUsernameLogin().setModel(comboModel);
            }
 
            st.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {}
    }
    
    public String ReturnRole(String User){
        String role = this.getRole(User);
        return role;
    }

   
}
