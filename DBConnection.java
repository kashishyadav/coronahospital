/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class DBConnection {
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    static String url="jdbc:mysql://localhost:3306/coronahospital?useSSL=false";
    static String user="root";
    static String password="kashish123";
    
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Connected succesfully!");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("sql...Exception");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("sql...Exception");
        }
         catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception...");
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection successfully closed!");
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Cannot close the Connecton!");
        }
    }
    
}
