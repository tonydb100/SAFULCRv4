package Report;

import Connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class UploadData extends DataBaseConnection {

    DefaultTableModel model;
    
    public void UploadData(int op){
        DataToExport rd = new DataToExport();
        switch(op){
            case 1:
                //Sesiones
                this.UploadDataSession(rd);
                rd.show();
                break;
            case 2:
                //Departamentos
                this.UploadDataDepartment(rd);
                rd.show();
                break;
            case 3:
                //Usuarios
                this.UploadDataUser(rd);
                rd.show();
                break;
            case 4:
                //Activos
                this.UploadDataAsset(rd);
                rd.show();
                break;
        }
    }
    
    private void UploadDataDepartment(DataToExport rd){
        
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
            rd.getTblData().setModel(model);

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    private void UploadDataAsset(DataToExport rd){
        
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
            rd.getTblData().setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    private void UploadDataUser(DataToExport rd){
        
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
            rd.getTblData().setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private void UploadDataSession(DataToExport rd) {
        
        try{
            Connection Conn = this.ConnectToDb();
            Statement sent;

            String [] titles ={"Id", "Usuario", "Inicio", "Final"};
            String sql="SELECT * FROM session";
            model=new DefaultTableModel(null, titles);
            sent=Conn.createStatement();
            ResultSet rs=sent.executeQuery(sql);

            String row []= new String [4];

            while(rs.next()){
                row [0]=rs.getString("session_id");
                row [1]=rs.getString("session_username");
                row [2]=rs.getString("session_start");
                row [3]=rs.getString("session_end");
                
                model.addRow(row);

            }
            rd.getTblData().setModel(model);

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
