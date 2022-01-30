/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Barang;
import Model.Furniture;
import Model.Kaca;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mizan Saputro
 */
public class MenuPembayaran extends javax.swing.JFrame {
    int no;
    public DefaultTableModel model;
    /**
     * Creates new form MenuPembayaran
     */
    public MenuPembayaran() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Pembayaran");
        this.no = 0;
        model = (DefaultTableModel) tablePesanan.getModel();
    }
    
    public JRadioButton getTunai(){
        return tunai;
    }
    public JRadioButton getDigital(){
        return digital;
    }
    
    public JButton getLihatdetail(){
        return lihatDetail;
    }
    public JButton getCari(){
        return Cari;
    }
    public JButton getUbahmetode(){
        return ubah;
    }
    public JButton getBayar(){
        return bayar;
    }
    public String getMetode(){
        if (tunai.isSelected()){
            return "Tunai";
        }else{
            return "Digital";
        }
    }
    public void resetMetode(){
        BG_MetodePembayaran.clearSelection();
    }
    
    public JTextField getTFnama(){
        return textNama;
    }
    public JTextField getTFid(){
        return textId;
    }
    public JTextField getTFharga(){
        return textHarga;
    }
    public JTextField getTFppn(){
        return textPpn;
    }
    public JTextField getTFbiayaadmin(){
        return textBiayaadmin;
    }
    public JTextField getTFongkir(){
        return textOngkir;
    }
    public JTextField getTFtotal(){
        return textTotal;
    }
    public String getTextnama(){
        return getTFnama().getText();
    }
    public String getTextid(){
        return getTFid().getText();
    }
    public String getTextharga(){
        return getTFharga().getText();
    }
    public String getTextppn(){
        return getTFppn().getText();
    }
    public String getTextbiayaadmin(){
        return getTFbiayaadmin().getText();
    }
    public String getTextongkir(){
        return getTFbiayaadmin().getText();
    }
    public String getTexttotal(){
        return getTFtotal().getText();
    }
    public void setTextnama(String s){
        textNama.setText(s);
    }
    public void setTextid(String s){
        textId.setText(s);
    }
    public void setTextharga(String s){
        textHarga.setText(s);
    }
    public void setTextppn(String s){
        textPpn.setText(s);
    }
    public void setTextbiayaadmin(String s){
        textBiayaadmin.setText(s);
    }
    public void setTextongkir(String s){
        textOngkir.setText(s);
    }
    public void setTexttotal(String s){
        textTotal.setText(s);
    }
    public void setTablepesanan(ArrayList<Barang> b){
        this.no = 0;
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        for (Barang o: b){
            String kategori;
            if (o instanceof Furniture){
                kategori = "Perabotan";
            }else if (o instanceof Kaca){
                kategori = "Kaca";
            }else{
                kategori ="Perhiasan";
            }
            ++no;
            Object[] data = {no, o.getNama(), kategori, o.getHarga(), 
                o.getJumlah(), o.getBerat()};
            this.model.addRow(data);    
        }
    }
    public void setMetode(String s){
        if (s.equals("Tunai")){
            getTunai().setSelected(true);
        }else{
            getDigital().setSelected(true);
        }
    }
    public JButton getBatal(){
        return batal;
    }
   public void addListener(ActionListener ae){
        lihatDetail.addActionListener(ae);
        tunai.addActionListener(ae);
        digital.addActionListener(ae);
        ubah.addActionListener(ae);
        bayar.addActionListener(ae);
        Cari.addActionListener(ae);
        mainMenu.addActionListener(ae);  
        textPpn.addActionListener(ae);
        textBiayaadmin.addActionListener(ae);
        batal.addActionListener(ae);
    }  
    public void addAdapter(MouseAdapter e){
        textId.addMouseListener(e);
        textNama.addMouseListener(e);
        textHarga.addMouseListener(e);
        textPpn.addMouseListener(e);
        textBiayaadmin.addMouseListener(e);
        textOngkir.addMouseListener(e);
        textTotal.addMouseListener(e);
    }
    public void viewErrorMsg(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_MetodePembayaran = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        ubah = new javax.swing.JButton();
        bayar = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePesanan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tunai = new javax.swing.JRadioButton();
        digital = new javax.swing.JRadioButton();
        textHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textOngkir = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        lihatDetail = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        textPpn = new javax.swing.JTextField();
        textBiayaadmin = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        batal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("MENU PEMBAYARAN");

        ubah.setText("Ubah Metode Pembayaran");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        bayar.setText("Bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        mainMenu.setText("Menu Utama");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        tablePesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama", "Kategori", "Harga", "Jumlah", "Berat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePesanan);

        jLabel2.setText("Harga Pesanan");

        jLabel4.setText("Metode Pembayaran");

        BG_MetodePembayaran.add(tunai);
        tunai.setText("Tunai");
        tunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunaiActionPerformed(evt);
            }
        });

        BG_MetodePembayaran.add(digital);
        digital.setText("Digital");

        jLabel5.setText("Total Harga : ");

        textTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalActionPerformed(evt);
            }
        });

        jLabel6.setText("Ppn");

        jLabel7.setText("Ongkir");

        jLabel8.setText("Biaya Admin");

        jLabel9.setText("Detail Pembayaran");

        jLabel10.setText("Nama");

        jLabel11.setText("ID");

        lihatDetail.setText("Lakukan Transaksi");
        lihatDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatDetailActionPerformed(evt);
            }
        });

        jLabel12.setText("List Pesanan");

        Cari.setText("Lihat Transaksi");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        batal.setText("Clear");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel1))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(398, 398, 398))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(textId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel9))
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel2))
                                            .addGap(21, 21, 21)
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                    .addComponent(tunai)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(digital))
                                                .addComponent(textOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textPpn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textBiayaadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ubah))))
                                .addGap(4, 4, 4)))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lihatDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lihatDetail)
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal))
                .addGap(3, 3, 3)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(5, 5, 5))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tunai)
                            .addComponent(digital))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textPpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textBiayaadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bayar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)))
                .addComponent(mainMenu)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainMenuActionPerformed

    private void tunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tunaiActionPerformed

    private void textTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTotalActionPerformed

    private void lihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lihatDetailActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_MetodePembayaran;
    private javax.swing.JButton Cari;
    private javax.swing.JButton batal;
    private javax.swing.JButton bayar;
    private javax.swing.JRadioButton digital;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton lihatDetail;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTable tablePesanan;
    private javax.swing.JTextField textBiayaadmin;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textOngkir;
    private javax.swing.JTextField textPpn;
    private javax.swing.JTextField textTotal;
    private javax.swing.JRadioButton tunai;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
