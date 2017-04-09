package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public Connection ConnectToDb() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=root");
        return cn;
    }
    
    public void CloseConnection() throws SQLException{
        if (cn != null){
            if (cn.isClosed() == false){
                cn.close();
            }
        } 
    }
    
}
