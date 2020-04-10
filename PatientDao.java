/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import static coronahospital.dao.DoctorDao.sidget;
import static coronahospital.dao.DoctorDao.slist;
import coronahospital.dbutil.DBConnection;
import coronahospital.dto.DoctorDTO;
import coronahospital.dto.PatientDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class PatientDao {
    
    private static Statement pid,pshowtable,plist;
    private static PreparedStatement padd,pupdate,pdelete,sidget;
    
    public static boolean addPatient(PatientDTO p)throws SQLException
    {
        String sql="insert into patient(patient_no,name,phone,address) values(?,?,?,?)";
        padd=DBConnection.getConnection().prepareStatement(sql);
        padd.setString(1,p.getPatient_no());
        padd.setString(2,p.getName());
        padd.setString(3,p.getPhone());
        padd.setString(4,p.getAddress());
        int c=padd.executeUpdate();//used for dml command like insert update delete
        return c!=0;
        
       // return true;
        
    }
    public static boolean updatePatient(PatientDTO p)throws SQLException
    {
        String sql1="update patient set name=?,phone=?,address=? where patient_no=?";
        pupdate=DBConnection.getConnection().prepareStatement(sql1);
        System.out.println("obj in updatePatient...DAO : "+p);
      
        pupdate.setString(1,p.getName());
        pupdate.setString(2,p.getPhone());
        pupdate.setString(3,p.getAddress());
        pupdate.setString(4,p.getPatient_no());
        System.out.println("pup"+pupdate);
        int c=pupdate.executeUpdate();//used for dml command like insert update delete
        System.out.println("c value: "+c);
        return c!=0;
        
       // return true;
        
    }
     public static boolean deletePatient(String p_no)throws SQLException
    {
        String sql="delete from patient where patient_no=?";
        pdelete=DBConnection.getConnection().prepareStatement(sql);
        pdelete.setString(1,p_no);
        int c=pdelete.executeUpdate();//used for dml command like insert update delete
        return c!=0;
        
       // return true;
        
    }
     public static String autoIdGnerate()
     {
         String idr="";
         String sql="select max(patient_no) as rowCount from patient";
         try{
             pid=DBConnection.getConnection().createStatement();
             ResultSet rs=pid.executeQuery(sql);
             rs.next();
             String s=rs.getString("rowCount");
             ResultSetMetaData rsm=rs.getMetaData();
// the ResultSetMetaData object rsmd, and uses rsmd to find out how many columns rs has

            int rowCount=rsm.getColumnCount();//return no. of colm in return by rs..
            
            if(s==null)
            {
                idr= "PS001";
            }
            else
            {
                long id=Long.parseLong(rs.getString(rowCount).substring(2,rs.getString(rowCount).length()));
                /*
                
                
                */
                id++;
                idr="PS"+String.format("%03d",id);
                
            }
         }
         catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,"exception in db"+e,"Error!!!",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
         }
        return idr;
         
     }
     public static ArrayList<PatientDTO> patientList() throws SQLException
     {
         String sql="select * from patient";
         ArrayList<PatientDTO> al=new ArrayList<>();
         pshowtable=DBConnection.getConnection().createStatement();
         ResultSet rs=pshowtable.executeQuery(sql);
         ResultSetMetaData rsm=rs.getMetaData();
         int c=rsm.getColumnCount();
         while(rs.next())
         {
             PatientDTO p=new PatientDTO();
             p.setAddress(rs.getString("address"));
             p.setName(rs.getString("name"));
             p.setPatient_no(rs.getString("patient_no"));
             p.setPhone(rs.getString("phone"));
             al.add(p);
         }
         for(PatientDTO k:al)
         {
             System.out.println(k);
         }
         return al;
     }
         public static ArrayList<PatientDTO> patientShowList()throws SQLException
    {
        String sql="select * from patient";
        plist=DBConnection.getConnection().createStatement();
        ResultSet rs=plist.executeQuery(sql);
        ArrayList<PatientDTO> al=new ArrayList<>();
        while(rs.next())
        {
            PatientDTO p=new PatientDTO(rs.getString(1),rs.getString(2));
            al.add(p);
        }
        
        
        return al;
    }
     public static String getidbyName(String name) throws SQLException
    {
        String id="";
        String sql="select patient_no from patient where name=?";
        sidget=DBConnection.getConnection().prepareStatement(sql);
        sidget.setString(1,name);
        ResultSet rs=sidget.executeQuery();
        if(rs.next())
        {
            id=rs.getString(1);
        }
        return id;
        
    }
    
    
}
