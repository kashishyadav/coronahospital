/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.gui;

import coronahospital.dao.ChannelDao;
import coronahospital.dao.PrescriptionDao;
import coronahospital.dto.ChannelDTO;
import coronahospital.dto.PrescriptionDTO;
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
public class ViewPrescription extends javax.swing.JFrame {

    /**
     * Creates new form ViewChannel
     */
   private static String username;
   private static  int logid;
    public ViewPrescription() {
        initComponents();
    }
    public ViewPrescription(String username,int logid) {
        initComponents();
        this.username=username;
        this.logid=logid;
        showPrescription();
    }
     public void showPrescription()
    {
      ArrayList<PrescriptionDTO> al;
        try {
           al = PrescriptionDao.channelList();
////            for(PatientDTO k:al)
////         {
////             System.out.println(k);
////         }
        if(al.isEmpty()==true)
        {   
            DefaultTableModel df=(DefaultTableModel)prescriptiontable.getModel();//table model is return by get model
            df.setRowCount(0);
            JOptionPane.showMessageDialog(null, "No patient...!","Error!",JOptionPane.INFORMATION_MESSAGE);
             return;
         }
           DefaultTableModel df=(DefaultTableModel)prescriptiontable.getModel();//table model is return by get model
            df.setRowCount(0);//it will delete all the previous row of the table and insert all the new record from database
           Object obj[]=new Object[5];
            for(PrescriptionDTO p:al)
            {
             obj[0]=p.getPre_id();
             obj[1]=p.getChannel_id();
             obj[2]=p.getDoctorname();
             obj[3]=p.getDetype();
             obj[4]=p.getPrescription();
               df.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChannelRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
        prescriptiontable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        prescriptiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PrescriptionId", "ChannelId", "Doc_Name", "DisceaseType", "Prescription"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prescriptiontable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 90, 420, 290);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VIEW PRESCRIPTION");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 30, 260, 28);

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setText("Inventory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(121, 410, 110, 23);

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(310, 410, 120, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("LOGOUT");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 20, 60, 17);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       DefaultTableModel f=(DefaultTableModel)prescriptiontable.getModel();
       int index=prescriptiontable.getSelectedRow();
       String pid=f.getValueAt(index,0).toString();
       Inventory i=new Inventory(pid,username,logid);
       i.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PharmacistDashboard d=new PharmacistDashboard(username,logid);
        d.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable prescriptiontable;
    // End of variables declaration//GEN-END:variables
}
