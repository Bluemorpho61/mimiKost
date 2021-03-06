/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimikostswing.mainview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mimikostswing.Config;
import mimikostswing.Konek;
import mimikostswing.mainview.submenu.LunasiTagihan;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Alkin PC
 */
public class TagihanFasilitas extends javax.swing.JFrame {

    /**
     * Creates new form TagihanFasilitas
     */
    public TagihanFasilitas() {
        initComponents();
        //showChart();
        comboBox();
        showTables();
        showTotal();
    }
    
    
    
    public void showTotal(){
        Date d = new Date();
        try {
            if (jComboBox_bulan.getSelectedItem() =="Bulan Ini") {
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                int idBln = c.get(Calendar.MONTH);
                 String sql ="SELECT SUM(jumlah_tagihan) AS jumlah_tagihan FROM tb_tagihan_fasilitas WHERE tb_tagihan_fasilitas.status='Belum Dibayarkan' AND tb_tagihan_fasilitas.id_bulan="+idBln;
        Statement st =(Statement)Konek.getConnection().createStatement();
        ResultSet r =st.executeQuery(sql);
            if (r.next()) {
                jLabel_totalTagihan.setText(r.getString("jumlah_tagihan"));
            }
                }
            
//        String sql ="SELECT SUM(jumlah_tagihan) AS jumlah_tagihan FROM tb_tagihan_fasilitas";
//        Statement st =(Statement)Konek.getConnection().createStatement();
//        ResultSet r =st.executeQuery(sql);
//            if (r.next()) {
//                jLabel_totalTagihan.setText(r.getString("jumlah_tagihan"));
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }
    public void showTableCustomed(){
           DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Nama Fasilitas");
        t.addColumn("Banyak");
        t.addColumn("Kode Blok");
        t.addColumn("Biaya Per-bulan");
        t.addColumn("Status");
        t.addColumn("Bulan");
        jTable1.setModel(t);
        try {
            String sql="SELECT tb_fasilitas.nama_fasilitas, tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan AND tb_bulan.bulan ='"+jComboBox_bulan.getSelectedItem()+"'";
            String sqll="SELECT tb_fasilitas.nama_fasilitas, COUNT(tb_fasilitas.nama_fasilitas) AS banyak ,tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan AND tb_bulan.bulan='"+jComboBox_bulan.getSelectedItem()+"' GROUP BY tb_fasilitas.nama_fasilitas, tb_blok.kode_blok HAVING banyak>1";
            Connection c =(Connection)Config.configDB();
            Statement s = c.prepareStatement(sqll);
            ResultSet r = s.executeQuery(sqll);
            while (r.next()) {                
                t.addRow(new Object[]{
                    r.getString("nama_fasilitas"),
                    r.getString("banyak"),
                    r.getString("kode_blok"),
                    r.getString("tagihan_perbulan"),
                    r.getString("status"),
                    r.getString("bulan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void showTables(){
         Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int bln =c.get(Calendar.MONTH);
        DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Nama Fasilitas");
        t.addColumn("Banyak Fasilitas");
        t.addColumn("Kode Blok");
        t.addColumn("Biaya Per-bulan");
        t.addColumn("Status");
        t.addColumn("Bulan");
        jTable1.setModel(t);
        try {
            String sql="SELECT tb_fasilitas.nama_fasilitas, tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas  ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan AND tb_bulan.id_bulan ='"+bln+"'";
            String sqll="SELECT tb_fasilitas.nama_fasilitas, COUNT(tb_fasilitas.nama_fasilitas) AS banyak ,tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan GROUP BY tb_fasilitas.nama_fasilitas, tb_blok.kode_blok HAVING banyak>1";
            Connection con =(Connection)Config.configDB();
            Statement s = con.prepareStatement(sqll);
            ResultSet r = s.executeQuery(sqll);
            while (r.next()) {                
                t.addRow(new Object[]{
                    r.getString("nama_fasilitas"),
                    r.getString("banyak"),
                    r.getString("kode_blok"),
                    r.getString("tagihan_perbulan"),
                    r.getString("status"),
                    r.getString("bulan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
}
    public void comboBox(){
        try {
            String sql ="SELECT * FROM tb_bulan GROUP BY id_bulan ORDER BY id_bulan ASC";
            Statement s =(Statement)Konek.getConnection().createStatement();
            ResultSet r =s.executeQuery(sql);
            while (r.next()) {                
                jComboBox_bulan.addItem(r.getString("bulan"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }
//  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_bulan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel_totalTagihan = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(41, 148, 0));

        jButton1.setBackground(new java.awt.Color(41, 148, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mimikostswing/images/akar-icons_arrow-back-thick-fill (1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tagihan Fasilitas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Fasilitas", "Banyak", "Kode Blok", "Biaya Per-bulan", "Status", "Bulan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Daftar Fasilitas");

        jComboBox_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan Ini" }));
        jComboBox_bulan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_bulanItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total tagihan Bulan Ini");

        jLabel_totalTagihan.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel_totalTagihan.setForeground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Berikan Catatan Lunas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Dibayarkan", "Sudah Dibayarkan" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_totalTagihan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_totalTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_bulanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_bulanItemStateChanged
        // TODO add your handling code here:
        showTableCustomed();
        if (jComboBox_bulan.getSelectedItem()=="Bulan Ini") {
           Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            int bln =c.get(Calendar.MONTH);
        DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Nama Fasilitas");
        t.addColumn("Banyak Fasilitas");
        t.addColumn("Kode Blok");
        t.addColumn("Biaya Per-bulan");
        t.addColumn("Status");
        t.addColumn("Bulan");
        jTable1.setModel(t);
        try {
            String sql="SELECT tb_fasilitas.nama_fasilitas, tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas  ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan AND tb_bulan.id_bulan ='"+bln+"'";
            String sqll="SELECT tb_fasilitas.nama_fasilitas, COUNT(tb_fasilitas.nama_fasilitas) AS banyak ,tb_blok.kode_blok, tb_fasilitas.tagihan_perbulan, tb_tagihan_fasilitas.status, tb_bulan.bulan FROM tb_blok LEFT JOIN tb_fasilitas ON tb_blok.kode_blok = tb_fasilitas.kode_blok INNER JOIN tb_tagihan_fasilitas ON tb_fasilitas.id_fasilitas = tb_tagihan_fasilitas.id_fasilitas INNER JOIN tb_bulan ON tb_bulan.id_bulan = tb_tagihan_fasilitas.id_bulan GROUP BY tb_fasilitas.nama_fasilitas, tb_blok.kode_blok HAVING banyak>1";
            Connection con =(Connection)Config.configDB();
            Statement s = con.prepareStatement(sqll);
            ResultSet r = s.executeQuery(sqll);
            while (r.next()) {                
                t.addRow(new Object[]{
                    r.getString("nama_fasilitas"),
                    r.getString("banyak"),
                    r.getString("kode_blok"),
                    r.getString("tagihan_perbulan"),
                    r.getString("status"),
                    r.getString("bulan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
    }//GEN-LAST:event_jComboBox_bulanItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        new LunasiTagihan().setVisible(true);
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
            java.util.logging.Logger.getLogger(TagihanFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TagihanFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TagihanFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TagihanFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TagihanFasilitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox_bulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_totalTagihan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
