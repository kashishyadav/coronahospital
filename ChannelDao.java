/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import coronahospital.dbutil.DBConnection;
import coronahospital.dto.ChannelDTO;
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
public class ChannelDao {
     static Statement s,sid;
    static PreparedStatement padd,pdelete,pupdate;
    
    public static boolean addChannel(ChannelDTO channel)throws SQLException
    {
        int c=0;
        System.out.println("channel object inside dao...:"+channel);
        String sql="insert into channel(channel_no,doctorno,patientno,roomno,date)values(?,?,?,?,?)";
        padd=DBConnection.getConnection().prepareStatement(sql);
        if(channel!=null)
        { padd.setString(1,channel.getChannel_no());
          padd.setString(2,channel.getDoctorno());
          padd.setString(3,channel.getPatientno());
          padd.setString(4,channel.getRoomno());
          padd.setString(5,channel.getDate());
       
         c=padd.executeUpdate();
        }
        return c!=0;
    }
    
     public static boolean updateChannel(ChannelDTO c)throws SQLException
    {
        String sql="update channel set date=? where channel_no=?";
        System.out.println("channel object to update inside dao...:"+c);
        pupdate=DBConnection.getConnection().prepareStatement(sql);
     
        pupdate.setString(1,c.getDate());
        pupdate.setString(2,c.getChannel_no());
        int ch=pupdate.executeUpdate();
        return ch!=0;
    }
      public static boolean deleteChannel(String channelid)throws SQLException
    {
        String sql="delete from channel where channel_no=?";
        pdelete=DBConnection.getConnection().prepareStatement(sql);
        pdelete.setString(1,channelid);
        int c=pdelete.executeUpdate();
        System.out.println("channe;id: "+channelid+" c after execute  update: "+c);
        return c!=0;
    }
    public static ArrayList<ChannelDTO> channelList()throws SQLException
    {
        String sql="select * from channel";
        ArrayList<ChannelDTO> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
            ChannelDTO c=new ChannelDTO();
            c.setChannel_no(rs.getString(1));
            c.setDoctorno(rs.getString(2));
            c.setPatientno(rs.getString(3));
            c.setRoomno(rs.getString(4));
            c.setDate(rs.getDate(5).toString());
            al.add(c);
        }
        return al;
    }
        public static ArrayList<ChannelDTO> channelListDoctor(int logid)throws SQLException
    {
        //inner join on 3 table to get patient name specific to channel specific doctor,....
        String sql=" select c.channel_no,d.name,p.name,c.roomno,c.date from channel c inner join doctor d on c.doctorno=d.doctor_no Inner join patient p on c.patientno=p.patient_no;";
        ArrayList<ChannelDTO> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
            ChannelDTO c=new ChannelDTO();
            c.setChannel_no(rs.getString(1));
            c.setDoctorno(rs.getString(2));
            c.setPatientno(rs.getString(3));
            c.setRoomno(rs.getString(4));
            c.setDate(rs.getDate(5).toString());
            al.add(c);
        }
        return al;
    }
    public static String autoIdGenerate()throws SQLException
    {
        String sql="select max(channel_no) as idcount from channel";
        sid=DBConnection.getConnection().createStatement();
        ResultSet rs=sid.executeQuery(sql);
        
        ResultSetMetaData rsm=rs.getMetaData();
        rs.next();
        String s=rs.getString("idcount");
        String chid="";
        int count=rsm.getColumnCount();
        if(s==null)
        {
            chid= "CH001";
        }
        else
        {
            long id=Long.parseLong(s.substring(2,s.length()));
            id++;
            chid="CH"+String.format("%03d",id);
        }
        return chid;
        
    }
    
    
}
