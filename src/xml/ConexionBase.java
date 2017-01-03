
package xml;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionBase {
    /**** Variables para la coneccion a la base de datos ****/
    public static String bd;
    public static String user;
    public static String password;
    public static String url;
    
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public static Connection conn = null;
    
    /**** Constructor que abre la conexion a la bade de datos ****/
    public ConexionBase(){
    bd="organizador_facturas";
    user="root";
    password="Dnstuff26";
    url="jdbc:mysql://localhost:3306/" + bd;
    
      try { 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
          conn = (Connection) DriverManager.getConnection(url,user,password); 
          if (conn != null) { 
              stmt = (Statement) conn.createStatement();
          } 
      } catch(SQLException ex) { 
          JOptionPane.showMessageDialog(null,"Hubo un problema al intentar conectarse con la base de datos "+url);
      } catch(ClassNotFoundException ex) { 
          System.out.println(ex); 
          JOptionPane.showMessageDialog(null,ex);
      } 
    } 
    
    public void InsertDB(String Sql){
    try{
     stmt.execute(Sql);
     JOptionPane.showMessageDialog(null,"El registro fue guardado correctamente.");
     conn.close();
    }catch(HeadlessException | SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al guardar el registro en la Base de Datos.\n" + ex);
    }
    }
    
     public void UpdateDB(String Sql){
    try{
        int executeUpdate = stmt.executeUpdate(Sql);
     JOptionPane.showMessageDialog(null,"El registro fue actualizado correctamente.");
     conn.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error al actualizar el registro en la Base de Datos.\n" + ex);
        }
    }
    
     public void DeleteDB(String Sql){
    try{
     stmt.execute(Sql);
     JOptionPane.showMessageDialog(null,"El registro fue Borrado correctamente.");
     conn.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error al Borrar el registro en la Base de Datos.\n" + ex);
        }
    }
    
    /*public void SelectDB(String Sql) throws SQLException{
    try{
        ResultSet resul = stmt.executeQuery(Sql);
        JOptionPane.showMessageDialog(null,"El registro fue encontrado correctamente.");
        int con =0;
        while(resul.next()){
               JOptionPane.showMessageDialog(null, resul.getString("CLI_NOMBRE"));
                }  
           } catch (SQLException ex) {
           Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        conn.close();
        }    
    }*/
     
      public ResultSet SelectDB1(String Sql) throws SQLException{
        ResultSet resul = stmt.executeQuery(Sql);
        return resul;
    }    
}

