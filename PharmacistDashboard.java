/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.gui;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class PharmacistDashboard extends javax.swing.JFrame {

    /**
     * Creates new form DoctorDashboard
     */
    private static String username;
    private static int logid;
    private static String utype;
    public PharmacistDashboard() {
        initComponents();
    }
     public PharmacistDashboard(String username,int id) {
        initComponents();
        this.utype=utype;
        this.username=username;
        logid=id;
        lblusername1.setText(username.toUpperCase());
    }
     public PharmacistDashboard(String username,int id,String utype) {
        initComponents();
        this.utype=utype;
        this.username=username;
        logid=id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        VIEWPRESCRIPTION = new javax.swing.JButton();
        CREATEITEMBTN = new javax.swing.JButton();
        VIEWDOCTORBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        lblusername1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VIEWSALES = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        VIEWPRESCRIPTION.setText("VIEW PRESCRIPTION");
        VIEWPRESCRIPTION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWPRESCRIPTIONActionPerformed(evt);
            }
        });

        CREATEITEMBTN.setText("CREATE ITEM");
        CREATEITEMBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEITEMBTNActionPerformed(evt);
            }
        });

        VIEWDOCTORBTN.setText("VIEW DOCTOR");
        VIEWDOCTORBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWDOCTORBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VIEWPRESCRIPTION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CREATEITEMBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VIEWDOCTORBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(VIEWPRESCRIPTION)
                .addGap(32, 32, 32)
                .addComponent(CREATEITEMBTN)
                .addGap(34, 34, 34)
                .addComponent(VIEWDOCTORBTN)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(330, 100, 209, 210);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("PHARMACIST DASHBOARD");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 320, 28);

        lbllogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllogout.setForeground(new java.awt.Color(255, 0, 51));
        lbllogout.setText("LOGOUT");
        jPanel1.add(lbllogout);
        lbllogout.setBounds(570, 20, 59, 17);

        lblusername1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusername1.setForeground(new java.awt.Color(51, 255, 51));
        lblusername1.setText("USERNAME");
        jPanel1.add(lblusername1);
        lblusername1.setBounds(10, 20, 80, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\SUDHANSHU YADAV\\Documents\\NetBeansProjects\\CoronaHospital\\src\\Images\\PHARMACIST.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 100, 220, 210);

        VIEWSALES.setText("VIEW SALES");
        VIEWSALES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWSALESActionPerformed(evt);
            }
        });
        jPanel1.add(VIEWSALES);
        VIEWSALES.setBounds(493, 340, 110, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CREATEITEMBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEITEMBTNActionPerformed
        // TODO add your handling code here:
        ItemAdd i=new ItemAdd(username,logid);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CREATEITEMBTNActionPerformed

    private void VIEWPRESCRIPTIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWPRESCRIPTIONActionPerformed
        // TODO add your handling code here:
        ViewPrescription v=new ViewPrescription(username,logid);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VIEWPRESCRIPTIONActionPerformed

    private void VIEWSALESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWSALESActionPerformed
        // TODO add your handling code here:
        SalesReport s=new SalesReport(username,logid);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VIEWSALESActionPerformed

    private void VIEWDOCTORBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWDOCTORBTNActionPerformed
        // TODO add your handling code here:
        
        ViewDoctor v=new ViewDoctor(username,logid,utype);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VIEWDOCTORBTNActionPerformed

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
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacistDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CREATEITEMBTN;
    private javax.swing.JButton VIEWDOCTORBTN;
    private javax.swing.JButton VIEWPRESCRIPTION;
    private javax.swing.JButton VIEWSALES;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel lblusername1;
    // End of variables declaration//GEN-END:variables
}
