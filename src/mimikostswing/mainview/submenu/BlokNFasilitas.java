/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimikostswing.mainview.submenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mimikostswing.Config;
import mimikostswing.Konek;

/**
 *
 * @author Alkin PC
 */
public class BlokNFasilitas extends javax.swing.JFrame {

    /**
     * Creates new form BlokNFasilitas
     */
    public BlokNFasilitas() {
        initComponents();
        ShowTableBlok();
//        ShowTableFasilitas();
//        comboBox();
    }

    
//     public void ShowTableFasilitas(){
//        DefaultTableModel tb = new DefaultTableModel();
//        tb.addColumn("id_fasilitas");
//        tb.addColumn("Nama Fasilitas");
//        tb.addColumn("Kode Blok");
//        tb.addColumn("Banyak Fasilitas");
//        tb.addColumn("Tagihan Perbulan");
//        jTable_Fasilitas.setModel(tb);
//        try {
//            String sql ="SELECT tb_fasilitas.id_fasilitas, tb_fasilitas.nama_fasilitas, tb_blok.kode_blok, tb_fasilitas.banyak_fasilitas, tb_fasilitas.tagihan_perbulan FROM tb_fasilitas, tb_blok WHERE tb_fasilitas.kode_blok = tb_blok.kode_blok";
//            Statement stm = (Statement)Konek.getConnection().createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            while (rs.next()) {                
//                tb.addRow(new Object[]{
//                    rs.getString("id_fasilitas"),
//                    rs.getString("nama_fasilitas"),
//                    rs.getString("kode_blok"),
//                    rs.getString("banyak_fasilitas"),
//                    rs.getString("tagihan_perbulan")
//                });
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this,"Error: "+ e.getMessage());
//        }
//    }
       public void ShowTableBlok(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Kode Blok");
        tb.addColumn("Jumlah Kamar");
        tb.addColumn("Harga");
        jTable_Blok.setModel(tb);
        //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
        
        try {
            String sql="SELECT tb_blok.kode_blok, COUNT(tb_kamar.no_kamar) AS jumlah_kamar, tb_blok.harga FROM tb_blok LEFT JOIN tb_kamar ON tb_blok.kode_blok = tb_kamar.kode_blok GROUP BY tb_blok.kode_blok";
            
            java.sql.Statement statemeeent =(Statement)Konek.getConnection().createStatement();
            java.sql.ResultSet ress = statemeeent.executeQuery(sql);
            while (ress.next()) {                
                tb.addRow(new Object[]{
                    ress.getString("kode_blok"),
                    ress.getString("jumlah_kamar"),
                    ress.getString("harga")
                });
            }
           // java.sql.ResultSet ress = stm.executeQuery(sql);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error:"+ e.getMessage());
        }
       }
       
//        public void comboBox(){
//        try {
//            // String sql="SELECT tb_blok.id_blok, tb_blok.kode_blok FROM tb_blok, tb_fasilitas WHERE tb_blok.id_blok = tb_fasilitas.id_blok";
//       String sql ="SELECT kode_blok FROM tb_blok";
//       Statement stm =(Statement)Konek.getConnection().createStatement();
//       ResultSet rs =stm.executeQuery(sql);
//        while (rs.next()) {            
//            jComboBox_kdBlok.addItem(rs.getString("kode_blok"));
//            jComboBox1.addItem(rs.getString("kode_blok"));
//        }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this,"Error:"+ e.getMessage());
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelRound3 = new model.panelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Blok = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        panelRound2 = new model.panelRound();
        jTextField_kdBlok = new javax.swing.JTextField();
        panelRound4 = new model.panelRound();
        jTextField_Harga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelRound5 = new model.panelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Desc = new javax.swing.JTextArea();
        jButton_EditBlok = new javax.swing.JButton();
        jButton_Hps = new javax.swing.JButton();
        jButton_tmbhBlok = new javax.swing.JButton();
        jButton_BatEdit = new javax.swing.JButton();
        jButton_KonfEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(41, 148, 0));

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
        jLabel1.setText("Kelola Blok");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound3.setBackground(new java.awt.Color(236, 236, 236));
        panelRound3.setRoundBottomLeft(100);
        panelRound3.setRoundBottomRight(100);
        panelRound3.setRoundTopRight(100);
        panelRound3.setRoundedTopLeft(100);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Atur Blok");

        jTable_Blok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Blok", "Jumlah Kamar", "Harga"
            }
        ));
        jTable_Blok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BlokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Blok);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Kode Blok");

        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setRoundedTopLeft(30);

        jTextField_kdBlok.setEditable(false);
        jTextField_kdBlok.setBackground(new java.awt.Color(229, 229, 229));
        jTextField_kdBlok.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField_kdBlok.setBorder(null);
        jTextField_kdBlok.setOpaque(false);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_kdBlok, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField_kdBlok, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopRight(30);
        panelRound4.setRoundedTopLeft(30);

        jTextField_Harga.setEditable(false);
        jTextField_Harga.setBackground(new java.awt.Color(229, 229, 229));
        jTextField_Harga.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField_Harga.setBorder(null);
        jTextField_Harga.setOpaque(false);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField_Harga, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Harga");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Deskripsi");

        panelRound5.setRoundBottomLeft(45);
        panelRound5.setRoundBottomRight(45);
        panelRound5.setRoundTopRight(45);
        panelRound5.setRoundedTopLeft(45);

        jTextArea_Desc.setEditable(false);
        jTextArea_Desc.setBackground(new java.awt.Color(229, 229, 229));
        jTextArea_Desc.setColumns(20);
        jTextArea_Desc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea_Desc.setRows(5);
        jTextArea_Desc.setBorder(null);
        jTextArea_Desc.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea_Desc);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton_EditBlok.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_EditBlok.setText("Edit");
        jButton_EditBlok.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_EditBlok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditBlokActionPerformed(evt);
            }
        });

        jButton_Hps.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_Hps.setText("Hapus");
        jButton_Hps.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Hps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HpsActionPerformed(evt);
            }
        });

        jButton_tmbhBlok.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_tmbhBlok.setText("Tambah");
        jButton_tmbhBlok.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_tmbhBlok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tmbhBlokActionPerformed(evt);
            }
        });

        jButton_BatEdit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_BatEdit.setText("Batalkan Edit");
        jButton_BatEdit.setEnabled(false);
        jButton_BatEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BatEditActionPerformed(evt);
            }
        });

        jButton_KonfEdit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_KonfEdit.setText("Konfirmasi Edit");
        jButton_KonfEdit.setEnabled(false);
        jButton_KonfEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KonfEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_tmbhBlok, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_KonfEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(jButton_EditBlok, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Hps, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRound3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(248, 248, 248)))
                                .addGap(46, 46, 46))))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jButton_BatEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_KonfEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_BatEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_tmbhBlok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_EditBlok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Hps, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EditBlokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditBlokActionPerformed
        // TODO add your handling code here:
        jButton_EditBlok.setEnabled(false);
        jButton_Hps.setEnabled(false);
        jButton_tmbhBlok.setEnabled(false);
        jButton_KonfEdit.setEnabled(true);
        jButton_BatEdit.setEnabled(true);
        jTextArea_Desc.setEditable(true);
        jTextField_Harga.setEditable(true);
        jTextField_kdBlok.setEditable(true);
    }//GEN-LAST:event_jButton_EditBlokActionPerformed

    private void jTable_BlokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BlokMouseClicked
        // TODO add your handling code here:
          int row =jTable_Blok.getSelectedRow();
        String kodeBlok=jTable_Blok.getValueAt(row, 0).toString();
        String jumlah = jTable_Blok.getValueAt(row, 1).toString();
        String harga = jTable_Blok.getValueAt(row, 2).toString();
        
        jTextField_kdBlok.setText(kodeBlok);
        jTextField_Harga.setText(harga);
        try {
            String SQL ="SELECT deskripsi FROM tb_blok WHERE kode_blok='"+kodeBlok+"'";
            java.sql.Statement statement =(Statement)Konek.getConnection().createStatement();
            java.sql.ResultSet rs = statement.executeQuery(SQL);
            if (rs.next()) {
                jTextArea_Desc.setText(rs.getString("deskripsi"));
            } else{
                jTextArea_Desc.setText("-----Tidak ada deskripsi-----");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jTable_BlokMouseClicked

    private void jButton_KonfEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KonfEditActionPerformed
        // TODO add your handling code here:
         try {
            int row = jTable_Blok.getSelectedRow();
            String id = jTable_Blok.getValueAt(row, 0).toString();
            String SQL ="UPDATE tb_blok SET kode_blok='"+jTextField_kdBlok.getText()+"', deskripsi='"+jTextArea_Desc.getText()+"', harga='"+jTextField_Harga.getText()+"' WHERE kode_blok='"+id+"'";
            Connection conn=(Connection)mimikostswing.Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(SQL);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data telah berhasil diubah");
            ShowTableBlok();
            
//            jButton_konfEdit.setEnabled(false);
//             jTextField_kodeBlok.setEnabled(false);
//        jTextField_harga.setEnabled(false);
//        jTextArea_Deskripsi.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
//             jTextField_kodeBlok.setEnabled(false);
//        jTextField_harga.setEnabled(false);
//        jTextArea_Deskripsi.setEnabled(false);
        }
        jButton_BatEdit.setEnabled(false);
        jButton_KonfEdit.setEnabled(false);
        jButton_EditBlok.setEnabled(true);
        jButton_Hps.setEnabled(true);
        //jButton_Edit.setEnabled(true);
        jButton_tmbhBlok.setEnabled(true);
        jTextArea_Desc.setEditable(false);
        jTextField_Harga.setEditable(false);
        jTextField_kdBlok.setEditable(false);
    }//GEN-LAST:event_jButton_KonfEditActionPerformed

    private void jButton_BatEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BatEditActionPerformed
        // TODO add your handling code here:
        jButton_BatEdit.setEnabled(false);
        jButton_KonfEdit.setEnabled(false);
        jButton_EditBlok.setEnabled(true);
        jButton_Hps.setEnabled(true);
       // jButton_Edit.setEnabled(true);
        jButton_tmbhBlok.setEnabled(true);
        jTextArea_Desc.setEditable(false);
        jTextField_Harga.setEditable(false);
        jTextField_kdBlok.setEditable(false);
    }//GEN-LAST:event_jButton_BatEditActionPerformed

    private void jButton_tmbhBlokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tmbhBlokActionPerformed
        // TODO add your handling code here:
         try {
            String SQL ="INSERT INTO `tb_blok` (`kode_blok`, `deskripsi`, `harga`) VALUES('"+jTextField_kdBlok.getText()+"','"+jTextArea_Desc.getText()+"','"+jTextField_Harga.getText()+"')";
            Connection conn = mimikostswing.Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(SQL);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data blok berhasil ditambahkan");
            ShowTableBlok();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error: " +e.getMessage());
        }
    }//GEN-LAST:event_jButton_tmbhBlokActionPerformed

    private void jButton_HpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HpsActionPerformed
        // TODO add your handling code here:
        int row = jTable_Blok.getSelectedRow();
        String blok =jTable_Blok.getValueAt(row, 0).toString();
        try {
            String sql="DELETE FROM tb_blok WHERE kode_blok='"+blok+"'";
            Connection conn =(Connection)mimikostswing.Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Blok telah berhasil dihapus");
            ShowTableBlok();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error: "+ e.getMessage());
        }
    }//GEN-LAST:event_jButton_HpsActionPerformed

   public String getid(){
       String idd = null;
        String sql="select id_fasilitas, @rowid:=@rowid+1 as myrow from tb_fasilitas, (SELECT @rowid:=0) as init ORDER BY myrow desc LIMIT 1;";
        try {
           Statement s =(Statement)Konek.getConnection().createStatement();
           ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                 idd =r.getString("id_fasilitas");
            }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
       return idd;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
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
            java.util.logging.Logger.getLogger(BlokNFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlokNFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlokNFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlokNFasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlokNFasilitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_BatEdit;
    private javax.swing.JButton jButton_EditBlok;
    private javax.swing.JButton jButton_Hps;
    private javax.swing.JButton jButton_KonfEdit;
    private javax.swing.JButton jButton_tmbhBlok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Blok;
    private javax.swing.JTextArea jTextArea_Desc;
    private javax.swing.JTextField jTextField_Harga;
    private javax.swing.JTextField jTextField_kdBlok;
    private model.panelRound panelRound2;
    private model.panelRound panelRound3;
    private model.panelRound panelRound4;
    private model.panelRound panelRound5;
    // End of variables declaration//GEN-END:variables
}
