package User;

import Connection.DataBaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataUser extends DataBaseConnection {
    
    public void insert(User per) throws Exception{
        
        try {
            this.ConnectToDb();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO user (user_idCard, user_firstName, user_lastName, user_lastName2, user_phone1, "
                            + "user_phone2, user_address, user_email, user_role, user_username, user_password, user_registrationDate) "
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, per.getIdCard());
            st.setString(2, per.getFirstName());
            st.setString(3, per.getLastName());
            st.setString(4, per.getLastName2());
            st.setString(5, per.getPhone1());
            st.setString(6, per.getPhone2());
            st.setString(7, per.getAddress());
            st.setString(8, per.getEmail());
            st.setString(9, per.getRole());
            st.setString(10, per.getUserName());
            st.setString(11, per.getPassword());
            st.setString(12, per.getRegistrationDate());
            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.CloseConnection();
        }
    }
    
}
