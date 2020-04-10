/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.gui;

import coronahospital.dao.DoctorDao;
import coronahospital.dto.DoctorDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class ViewDoctor extends javax.swing.JFrame {

    /**
     * Creates new form ViewChannel
     */
    private static String username;
    private static int logid;
    private static String utype;
    public ViewDoctor() {
        initComponents();
    }
     public ViewDoctor(String uname,int logid, String usertype) {
        initComponents();
        username=uname;
        this.utype=utype;
        this.logid=logid;
        lblusername.setText(username);
        doctorShow();
    }
       public void doctorShow()
    {
        ArrayList<DoctorDTO> al;
        try {
            al = DoctorDao.doctorList();
//            for(PatientDTO k:al)
//         {
//             System.out.println(k);
//         }
         if(al.isEmpty()==true)
         {
            DefaultTableModel df=(DefaultTableModel)doctortable.getModel();//table model is return by get model
            df.setRowCount(0);
           JOptionPane.showMessageDialog(null, "No doctoe...!","Error!",JOptionPane.INFORMATION_MESSAGE);
            return;
          }
            DefaultTableModel df=(DefaultTableModel)doctortable.getModel();//table model is return by get model
            df.setRowCount(0);//it will delete all the previous row of the table and insert all the new record from database
            Object obj[]=new Object[8];
            for(DoctorDTO d:al)
            {
               obj[0]=d.getDoctor_no();
               obj[1]=d.getName();
               obj[2]=d.getSpecialization();
               obj[3]=d.getQualification();
               obj[4]=d.getChannelfee();
               obj[5]=d.getPhone();
               obj[6]=d.getRoom();
               
               df.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctortable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblusername = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        doctortable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc_No", "Doc_Name", "Specialization", "Quallification", "Fee", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(doctortable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 520, 290);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VIEW DOCTOR");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 30, 230, 28);

        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 410, 110, 23);

        lblusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusername.setForeground(new java.awt.Color(51, 255, 0));
        lblusername.setText("USERNAME");
        jPanel1.add(lblusername);
        lblusername.setBounds(30, 30, 80, 17);

        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 0, 0));
        logout.setText("LOGOUT");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(464, 30, 70, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login l=new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(utype.equalsIgnoreCase("receptionalist"))
        {
            ReceptionalistDashboard r=new ReceptionalistDashboard(username,logid,username);
            r.setVisible(true);
             this.dispose();
        }
        else
        {
            PharmacistDashboard r=new PharmacistDashboard(username,logid,username);
            r.setVisible(true);
             this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable doctortable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblusername;
    private javax.swing.JLabel logout;
    // End of variables declaration//GEN-END:variables
}
