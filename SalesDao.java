/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import static coronahospital.dao.DoctorDao.s;
import coronahospital.dbutil.DBConnection;
import coronahospital.dto.SalesDTO;
import coronahospital.dto.SalesDTO1;
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
public class SalesDao {
    private static PreparedStatement ps;
    private static Statement slist;
    public static int addSales(SalesDTO s)throws SQLException
    {
        int lastid=0;
        String sql="insert into sales(date,subtotal,pay,balance) values(?,?,?,?)";
        ps=DBConnection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,s.getDate());
        ps.setInt(2,s.getSubtotal());
        ps.setInt(3,s.getPay());
        ps.setInt(4,s.getBalance());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();//return auto generated key...
        if(rs.next())
        {
            lastid=rs.getInt(1);
            System.out.println("last i9d:"+lastid);
            return lastid;
        }
        return lastid;
    }
    public static ArrayList<SalesDTO1> showList()throws SQLException
    {
        String sql="select * from sales";
        ArrayList<SalesDTO1> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
            SalesDTO1 s=new SalesDTO1();
            s.setBalance(rs.getInt("balance"));
            s.setDate(rs.getString("date"));
            s.setPay(rs.getInt("pay"));
            s.setSubtotal(rs.getInt("subtotal"));
            s.setId(rs.getInt("id"));
            al.add(s);
        }
        return al;
    }
}
