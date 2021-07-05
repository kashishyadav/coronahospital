/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dto;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class SalesProductDTO {
    
   // private int sid;
    private int sales_id;
    private String prod_id;
    private int sellprice;
    private int quantity;
    private int total;

    public SalesProductDTO() {
    }

    @Override
    public String toString() {
        return "SalesProductDTO{" + ", sales_id=" + sales_id + ", prod_id=" + prod_id + ", sellprice=" + sellprice + ", quantity=" + quantity + ", total=" + total + '}';
    }


    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
