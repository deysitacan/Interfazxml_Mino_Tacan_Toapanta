package interfazxml;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Conexion {
           /**** Variables para la coneccion a la base de datos ****/
    public static String bd;
    public static String user;
    public static String password;
    public static String url;
    
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public static Connection conn = null;
    
    /**** Constructor que abre la conexion a la bade de datos ****/
  public void Conexion(){
    bd="Organizador_Facturas";
    user="root";
    password="Dnstuff26";
    url="jdbc:mysql://localhost:3306/" + bd;
      System.out.println("r");
      try { 
          System.out.println("entro");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          conn = (Connection) DriverManager.getConnection(url,user,password); 
          if (conn != null) { 
              stmt = (Statement) conn.createStatement();
              
              System.out.println("Conexion exitosa");
          } 
      } catch(SQLException ex) { 
          JOptionPane.showMessageDialog(null,"Hubo un problema al intentar conectarse con la base de datos "+url);
      } catch(ClassNotFoundException ex) { 
          System.out.println(ex); 
          JOptionPane.showMessageDialog(null,ex);
      } 
    } 
    
    public void ejecutarSQL(String Sql){
        System.out.println(Sql);
    try{
     stmt.execute(Sql);
     
    // JOptionPane.showMessageDialog(null,"El registro fue guardado correctamente.");
    }catch(HeadlessException | SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al guardar el registro en la Base de Datos.\n" + ex);
    }
    }
    
       public static void main(String args[]) {
        Conexion asd=new Conexion();
        asd.Conexion();
    }
}



