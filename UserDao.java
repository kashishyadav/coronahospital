/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import coronahospital.dbutil.DBConnection;
import coronahospital.dto.UserDTO;
import coronahospital.dto.UserProfileDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class UserDao {
   private static Statement s;//for row count
   private static PreparedStatement ps1;//for adding user
   private static PreparedStatement ps2;//for login value check
   
   
   
   
   //these function is used to generatethe autoincremented row in table
   /*
   -> it will call by frame to get exam id..
   ->then it will set the value of exam id/...
   ->then object of dto is passed and add user is get called
   */
   public static int getUserId()throws SQLException
   {
       s=DBConnection.getConnection().createStatement();
       String sql="select count(*) as totalrows from user";
       ResultSet rs=s.executeQuery(sql);//it will insert select the value
       int rowCount=0;
       while(rs.next())
       {
           rowCount=rs.getInt(1);
           System.out.println("row count :"+rowCount);
       }
        System.out.println("row count after while :"+rowCount);

       return rowCount;
   }
   /*
   IT WILL ADD USER TO DATABASE...
   */
   public static boolean addUser(UserDTO u)throws SQLException 
   {
       ps1=DBConnection.getConnection().prepareStatement("insert into user values(?,?,?,?,?)");
       System.out.println("object data: "+u);
       ps1.setInt(1, u.getId());
       ps1.setString(2,u.getName());
       ps1.setString(3,u.getUsername());
       ps1.setString(4,u.getPassword());
       ps1.setString(5,u.getUsertype());
       int rs=ps1.executeUpdate();//it will return integer value after updating
       return rs!=0;
   }
   public static int validUser(UserProfileDTO u) throws SQLException
   {
       int id=0;
       ps2=DBConnection.getConnection().prepareStatement("select id from user where username=? and password=? and usertype=?");
       ps2.setString(1,u.getUsername());
       ps2.setString(2,u.getPassword());
       ps2.setString(3,u.getUsertype().toLowerCase());
       System.out.println("user profile"+u);
       ResultSet rs=ps2.executeQuery();
       while(rs.next())
       {
           System.out.println("id from table: "+rs.getInt(1));
           id=rs.getInt(1);
       return id;
       }
       
       return id;
   }
}
