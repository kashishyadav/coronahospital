/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import coronahospital.dbutil.DBConnection;
import coronahospital.dto.DoctorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class DoctorDao {
    
    static Statement s,sid,slist;
    static PreparedStatement padd,pdelete,pupdate,sidget;
    
    public static boolean addDoctor(DoctorDTO d)throws SQLException
    {
        System.out.println("doctor object inside dao...:"+d);
        String sql="insert into doctor(doctor_no,name,specialization,qualification,channelfee,phone,room,log_id)values(?,?,?,?,?,?,?,?)";
        padd=DBConnection.getConnection().prepareStatement(sql);
        padd.setString(1,d.getDoctor_no());
        padd.setString(2,d.getName());
        padd.setString(3,d.getSpecialization());
        padd.setString(4,d.getQualification());
        padd.setInt(5,d.getChannelfee());
        padd.setInt(6,d.getPhone());
        padd.setInt(7,d.getRoom());
        padd.setInt(8,d.getLog_id());
        int c=padd.executeUpdate();
        
        return c!=0;
    }
     public static boolean updateDoctor(DoctorDTO d)throws SQLException
    {
        String sql="update doctor set doctor_no=?,name=?,specialization=?,qualification=?,channelfee=?,phone=?,room=? where log_id=?";
         System.out.println("doctor object to update inside dao...:"+d);
        pupdate=DBConnection.getConnection().prepareStatement(sql);
        pupdate.setString(1,d.getDoctor_no());
        pupdate.setString(2,d.getName());
        pupdate.setString(3,d.getQualification());
        pupdate.setString(4,d.getSpecialization());
        pupdate.setInt(5,d.getChannelfee());
        pupdate.setInt(6,d.getPhone());
        pupdate.setInt(7,d.getRoom());
        pupdate.setInt(8,d.getLog_id());
        int c=pupdate.executeUpdate();
        return c!=0;
    }
      public static boolean deleteDoctor(String d)throws SQLException
    {
        String sql="delete from doctor where doctor_no=?";
        pdelete=DBConnection.getConnection().prepareStatement(sql);
        pdelete.setString(1,d);
        int c=pdelete.executeUpdate();
        System.out.println("doctorid: "+d+" c after execute  update: "+c);
        return c!=0;
    }
    public static ArrayList<DoctorDTO> doctorList()throws SQLException
    {
        String sql="select * from doctor";
        ArrayList<DoctorDTO> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
            DoctorDTO d=new DoctorDTO();
            d.setDoctor_no(rs.getString(1));
            d.setName(rs.getString(2));
            d.setSpecialization(rs.getString(3));
            d.setQualification(rs.getString(4));
            d.setChannelfee(rs.getInt(5));
            d.setPhone(rs.getInt(6));
            d.setRoom(rs.getInt(7));
            d.setLog_id(rs.getInt(8));
            al.add(d);
        }
        return al;
    }
    public static String autoIdGenerate()throws SQLException
    {
        String sql="select max(doctor_no) as idcount from doctor";
        sid=DBConnection.getConnection().createStatement();
        ResultSet rs=sid.executeQuery(sql);
        
        ResultSetMetaData rsm=rs.getMetaData();
        rs.next();
        String s=rs.getString("idcount");
        String drid="";
        int count=rsm.getColumnCount();
        if(s==null)
        {
            drid= "DN001";
        }
        else
        {
            long id=Long.parseLong(s.substring(2,s.length()));
            id++;
            drid="DN"+String.format("%03d",id);
        }
        return drid;
        
    }
    public static ArrayList<DoctorDTO> doctorShowList()throws SQLException
    {
        String sql="select * from doctor";
        slist=DBConnection.getConnection().createStatement();
        ResultSet rs=slist.executeQuery(sql);
        ArrayList<DoctorDTO> al=new ArrayList<>();
        while(rs.next())
        {
            DoctorDTO d=new DoctorDTO(rs.getString(1),rs.getString(2));
            al.add(d);
        }
        
        
        return al;
    }
    public static String getidbyName(String name) throws SQLException
    {
        String id="";
        String sql="select doctor_no from doctor where name=?";
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
