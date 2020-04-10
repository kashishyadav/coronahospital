/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import static coronahospital.dao.ChannelDao.s;
import coronahospital.dbutil.DBConnection;
import coronahospital.dto.ChannelDTO;
import coronahospital.dto.PrescriptionDTO;
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
public class PrescriptionDao {
    private static PreparedStatement padd;
    private static Statement sid;
    public static boolean addprescription(PrescriptionDTO p)throws SQLException
    {
        String sql="insert into prescription(pre_id,channel_id,doctorname,detype,prescription)values(?,?,?,?,?)";
        padd=DBConnection.getConnection().prepareStatement(sql);
        padd.setString(1,p.getPre_id());
        padd.setString(2,p.getChannel_id());
        padd.setString(3,p.getDoctorname());
        padd.setString(4,p.getDetype());
        padd.setString(5,p.getPrescription());
        int c=padd.executeUpdate();
        return c!=0;
        
    }
     public static ArrayList<PrescriptionDTO> channelList()throws SQLException
    {
        String sql="select * from prescription";
        ArrayList<PrescriptionDTO> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
          PrescriptionDTO p=new PrescriptionDTO();
          p.setPre_id(rs.getString(1));
          p.setChannel_id(rs.getString(2));
          p.setDoctorname(rs.getString(3));
          p.setDetype(rs.getString(4));
          p.setPrescription(rs.getString(5));
            al.add(p);
        }
        return al;
    }
    public static String autoIDGenerate()throws SQLException
    {
     String sql="select max(pre_id) as id from prescription";
     sid=DBConnection.getConnection().createStatement();
     ResultSet rs=sid.executeQuery(sql);
     rs.next();
     String id=rs.getString(1);
     String preid="";
     if(id==null)
     {
         preid="PS001";
     }
     else
     {
         Long ide=Long.parseLong(id.substring(2,id.length()));
         ide++;
         preid="PS"+String.format("%03d",ide);
     }
     
     return preid;
    }
    
}
