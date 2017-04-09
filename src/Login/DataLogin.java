package Login;

import Connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataLogin extends DataBaseConnection {
    
    
    public int validateUserSession(String user, String pass){
       
        Connection reg = this.getCn();
        int num = 0;
        String cap = "";
        String querySql = "SELECT * FROM user WHERE `user_username` = '" + user + "' AND `user_password` = '" + pass + "'";
        
        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            
            while(rs.next()) {
                cap = rs.getString("user_role");
            }
            switch(cap){
                case "ADMIN":
                    num = 1;
                    break;
                case "USER":
                    num = 2;
                    break;
                default:
                    num = 3;
                    break;
            }
        } catch (SQLException ex) {}   
        return num;
    }
    
    public void insertStart(String username, String start) throws Exception{

        try {
            this.ConnectToDb();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO session (session_username, session_start) "
                    + "values ('" + username + "', '" + start + "')");
            
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.CloseConnection();
        }
    }
    
    public void InsertEnd(String end) throws Exception{

        try {
            this.ConnectToDb();
            PreparedStatement st = this.getCn().prepareStatement( "UPDATE session S SET S.session_end = '" + end + "' WHERE S.session_id IN (" +
                                                            "SELECT tempP.tempId FROM ( (SELECT (SELECT MAX(session_id) FROM session) AS tempId)) AS tempP)" );
            
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.CloseConnection();
        }
    }
    
    public String getRole(String user){
       
        Connection reg = this.getCn();
        String cap = "";
        String querySql = "SELECT * FROM user WHERE `user_username` = '" + user + "'";
        
        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            
            while(rs.next()) {
                cap = rs.getString("user_role");
            }
            
        } catch (SQLException ex) {}   
        return cap;
    }
    
}
