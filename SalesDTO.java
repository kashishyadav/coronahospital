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
public class SalesDTO {
   
    private String date;
    private int subtotal;
    private int pay;
    private int balance;

    public SalesDTO() {
    }

    @Override
    public String toString() {
        return "SalesDTO{"+"date=" + date + ", subtotal=" + subtotal + ", pay=" + pay + ", balance=" + balance + '}';
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
