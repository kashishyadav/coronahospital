/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import coronahospital.dbutil.DBConnection;
import coronahospital.dto.ItemDTO;
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
public class ItemDao {
     static Statement s,sid,slist;
    static PreparedStatement padd,pdelete,pupdate,sidget,pquan;
    
    public static boolean addItem(ItemDTO item)throws SQLException
    {
        System.out.println("item object inside dao...:"+item);
        String sql="insert into item(item_no,item_name,description,sellprice,buyprice,quantity)values(?,?,?,?,?,?)";
        padd=DBConnection.getConnection().prepareStatement(sql);
        padd.setString(1,item.getItem_no());
        padd.setString(2,item.getItem_name());
        padd.setString(3,item.getDescription());
        padd.setInt(4,item.getSellprice());
        padd.setInt(5,item.getBuyprice());
        padd.setInt(6,item.getQuantity());
        int c=padd.executeUpdate();
        
        return c!=0;
    }
     public static boolean updateItem(ItemDTO item)throws SQLException
    {
        String sql="update item set item_name=?,description=?,sellprice=?,buyprice=?,quantity=? where item_no=?";
         System.out.println("item object to update inside dao...:"+item);
       pupdate=DBConnection.getConnection().prepareStatement(sql);
        
        pupdate.setString(1,item.getItem_name());
        pupdate.setString(2,item.getDescription());
        pupdate.setInt(3,item.getSellprice());
        pupdate.setInt(4,item.getBuyprice());
        pupdate.setInt(5,item.getQuantity());
        pupdate.setString(6,item.getItem_no());
        int c=pupdate.executeUpdate();
        return c!=0;
    }
      public static boolean deleteItem(String itemno)throws SQLException
    {
        String sql="delete from item where item_no=?";
        pdelete=DBConnection.getConnection().prepareStatement(sql);
        pdelete.setString(1,itemno);
        int c=pdelete.executeUpdate();
        System.out.println("itemid: "+itemno+" c after execute  update: "+c);
        return c!=0;
    }
    public static ArrayList<ItemDTO> itemList()throws SQLException
    {
        String sql="select * from item";
        ArrayList<ItemDTO> al=new ArrayList<>();
        s=DBConnection.getConnection().createStatement();
        ResultSet rs=s.executeQuery(sql);
        ResultSetMetaData rsm=rs.getMetaData();
        
        while(rs.next())
        {
            ItemDTO item=new ItemDTO();
            item.setItem_no(rs.getString(1));
            item.setItem_name(rs.getString(2));
            item.setDescription(rs.getString(3));
            item.setSellprice(rs.getInt(4));
            item.setBuyprice(rs.getInt(5));
            item.setQuantity(rs.getInt(6));
            
            al.add(item);
        }
        return al;
    }
    public static String autoIdGenerate()throws SQLException
    {
        String sql="select max(item_no) as idcount from item";
        sid=DBConnection.getConnection().createStatement();
        ResultSet rs=sid.executeQuery(sql);
        
        ResultSetMetaData rsm=rs.getMetaData();
        rs.next();
        String s=rs.getString("idcount");
        String drid="";
        int count=rsm.getColumnCount();
        if(s==null)
        {
            drid= "IT001";
        }
        else
        {
            long id=Long.parseLong(s.substring(2,s.length()));
            id++;
            drid="IT"+String.format("%03d",id);
        }
        return drid;
        
    }

    public static String getdrugbyName(String drugid) throws SQLException
    {
        String drugname="";
        String sql="select item_name from item where item_no=?";
        sidget=DBConnection.getConnection().prepareStatement(sql);
        sidget.setString(1,drugid);
        ResultSet rs=sidget.executeQuery();
        if(rs.next())
        {
            drugname=rs.getString(1);
        }
        return drugname;
        
    }
    public static int quantityCheck(int selectedQuantity,String itemid) throws SQLException
    {
        String sql="select * from item where item_no=?";
        pquan=DBConnection.getConnection().prepareStatement(sql);
        pquan.setString(1,itemid);
        ResultSet rs=pquan.executeQuery();
        int sellingprice=0;
        int quantity=0;
        System.out.println("selected quantity:"+selectedQuantity+" item no "+itemid);
        while(rs.next())
        {
            sellingprice=rs.getInt("sellprice");
            quantity=rs.getInt("quantity");
            System.out.println("selling bprive in loop :"+sellingprice);
            System.out.println("quantity:"+quantity);
        }
        if(quantity<selectedQuantity)
        {
            System.out.println("selling in if:"+sellingprice);
            System.out.println("quantity in if :"+quantity);
            return 0;
        }
        else
        {
            System.out.println("selling bprive:"+sellingprice);
        return sellingprice;
        }
    }
}
