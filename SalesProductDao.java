/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dao;

import coronahospital.dbutil.DBConnection;
import coronahospital.dto.SalesProductDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class SalesProductDao {
      private static PreparedStatement ps;
    public static boolean addSalesProduct(SalesProductDTO s)throws SQLException
    {
        int lastid=0;
        String sql="insert into sales_product(sales_id,prod_id,sellprice,quantity,total) values(?,?,?,?,?)";
        ps=DBConnection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,s.getSales_id());
        ps.setString(2,s.getProd_id());
        ps.setInt(3,s.getSellprice());
        ps.setInt(4,s.getQuantity());
        ps.setInt(5,s.getTotal());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();//return auto generated key...
        if(rs.next())
        {
            lastid=rs.getInt(1);
            System.out.println("last sales i9d:"+lastid);
            return true;
        }
        return false;
    }
    
}
