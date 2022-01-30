/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mizan Saputro
 */
public class MenuBarang extends javax.swing.JFrame {
    int no;
    DefaultTableModel model;
    /**
     * Creates new form MenuBarang
     */
    public MenuBarang() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Barang");
        no = 0;
        model = (DefaultTableModel)tableBarang.getModel();
    }
  
    public JButton getCaribarang() {
        return cariBarang;
    }

    public JButton getHapusbarang() {
        return hapusBarang;
    }
    public JButton getMainmenu() {
        return mainMenu;
    }
    public JButton getTambahbarang() {
        return tambahBarang;
    }
    public JButton getPerbaharuibarang(){
        return perbaharuiBarang;
    }
    public JButton getBatal(){
        return batal;
    }
    public JTable getTableBarang(){
        return tableBarang;
    }
    public String getKategori(){
        if(buttonFurniture.isSelected())
        {
            return "Perabotan";
        }
        else if(buttonKaca.isSelected())
        {
            return "Kaca";
        }
        else if(buttonPerhiasan.isSelected())
        {
            return "Perhiasan";
        }
        else
        {
            return null;
        }        
    }
    public JTextField getTFcari() {
        return textCari;
    }
    public JTextField getTFnama() {
        return textNama;
    }
    public JTextField getTFharga() {
        return textHarga;
    }
    public JTextField getTFjumlah() {
        return textJumlah;
    }
    public JTextField getTFberat() {
        return textBerat;
    }
    public JTextField getTFpanjang(){
        return textPanjang;
    }
    public JTextField getTFlebar(){
        return textLebar;
    }
    public JTextField getTFtinggi(){
        return textTinggi;
    }
    public JTextField getTFjenis(){
        return textJenis;
    }
    public JTextField getTFketebalan(){
        return textKetebalan;
    }
    public String getTextCari(){
        return getTFcari().getText();
    }
    public String getTextNama(){
        return getTFnama().getText();
    }
    public String getTextHarga(){
        return getTFharga().getText();
    }
    public String getTextJumlah(){
        return getTFjumlah().getText();
    }
    public String getTextBerat(){
        return getTFberat().getText();
    }
    public String getTextPanjang(){
        return getTFpanjang().getText();
    }
    public String getTextLebar(){
        return getTFlebar().getText();
    }
    public String getTextTinggi(){
        return getTFtinggi().getText();
    }
    public String getTextJenis(){
        return getTFjenis().getText();
    }
    public String getTextKetebalan(){
        return getTFketebalan().getText();
    }
    
    
    public void setTextCari(String s){
        textCari.setText(s);
    }    
    public void setTextNama(String s){
        textNama.setText(s);
    }
    public void resetKategori(){
        BG_KategoriBarang.clearSelection();
    }
    public void setTextHarga(String s){
        textHarga.setText(s);
    }
    public void setTextJumlah(String s){
        textJumlah.setText(s);
    }
    public void setTextBerat(String s){
        textBerat.setText(s);
    }
    public void setTextPanjang(String s){
        textPanjang.setText(s);
    }
    public void setTextLebar(String s){
        textLebar.setText(s);
    }
    public void setTextTinggi(String s){
        textTinggi.setText(s);
    }
    public void setTextJenis(String s){
        textJenis.setText(s);
    }
    public void setTextKetebalan(String s){
        textKetebalan.setText(s);
    }
    public void setValueTable(ArrayList<Barang> b){
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
    @SuppressWarnings("empty-statement")
    public void addValueTable(Barang b){
        String kategori;
        if (b instanceof Furniture){
            kategori = "Perabotan";
        }else if (b instanceof Kaca){
            kategori = "Kaca";
        }else{
            kategori = "Perhiasan";
        }
        ++no;
        Object[] data = {no, b.getNama(), kategori, b.getHarga(), 
            b.getJumlah(), b.getBerat()};
        this.model.addRow(data);
    }
    public void addListener(ActionListener ae){
        tambahBarang.addActionListener(ae);
        cariBarang.addActionListener(ae);
        hapusBarang.addActionListener(ae);
        perbaharuiBarang.addActionListener(ae);
        batal.addActionListener(ae);
        buttonFurniture.addActionListener(ae);
        buttonKaca.addActionListener(ae);
        buttonPerhiasan.addActionListener(ae);
        mainMenu.addActionListener(ae);  
    }  
    public void addAdapter(MouseAdapter e){
        textCari.addMouseListener(e);
        textNama.addMouseListener(e);
        textHarga.addMouseListener(e);
        textJumlah.addMouseListener(e);
        textBerat.addMouseListener(e);
        textPanjang.addMouseListener(e);
        textLebar.addMouseListener(e);
        textTinggi.addMouseListener(e);
        textJenis.addMouseListener(e);
        textKetebalan.addMouseListener(e);
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

        BG_KategoriBarang = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        tambahBarang = new javax.swing.JButton();
        cariBarang = new javax.swing.JButton();
        hapusBarang = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        textCari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textBerat = new javax.swing.JTextField();
        buttonFurniture = new javax.swing.JRadioButton();
        buttonKaca = new javax.swing.JRadioButton();
        buttonPerhiasan = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        perbaharuiBarang = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        textPanjang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textLebar = new javax.swing.JTextField();
        textTinggi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textJenis = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textKetebalan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("MENU BARANG");

        tambahBarang.setText("Tambah Barang");
        tambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBarangActionPerformed(evt);
            }
        });

        cariBarang.setText("Cari Barang");
        cariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBarangActionPerformed(evt);
            }
        });

        hapusBarang.setText("Hapus Barang");
        hapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBarangActionPerformed(evt);
            }
        });

        mainMenu.setText("Menu Utama");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama", "Kategori", "Harga", "Jumlah", "Berat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableBarang);

        jLabel5.setText("Harga   :");

        textHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHargaActionPerformed(evt);
            }
        });

        jLabel6.setText("Jumlah :");

        textJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJumlahActionPerformed(evt);
            }
        });

        jLabel7.setText("Berat    :");

        jLabel3.setText("Kategori :");

        textBerat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBeratActionPerformed(evt);
            }
        });

        BG_KategoriBarang.add(buttonFurniture);
        buttonFurniture.setText("Perabotan");
        buttonFurniture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFurnitureActionPerformed(evt);
            }
        });

        BG_KategoriBarang.add(buttonKaca);
        buttonKaca.setText("Kaca");
        buttonKaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKacaActionPerformed(evt);
            }
        });

        BG_KategoriBarang.add(buttonPerhiasan);
        buttonPerhiasan.setText("Perhiasan");
        buttonPerhiasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPerhiasanActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama    :");

        textNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaActionPerformed(evt);
            }
        });

        perbaharuiBarang.setText("Perbaharui Barang");
        perbaharuiBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perbaharuiBarangActionPerformed(evt);
            }
        });

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        textPanjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPanjangActionPerformed(evt);
            }
        });
        textPanjang.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textPanjangVetoableChange(evt);
            }
        });

        jLabel8.setText("Panjang:");

        jLabel9.setText("Lebar    :");

        textLebar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLebarActionPerformed(evt);
            }
        });
        textLebar.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textLebarVetoableChange(evt);
            }
        });

        textTinggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTinggiActionPerformed(evt);
            }
        });
        textTinggi.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textTinggiVetoableChange(evt);
            }
        });

        jLabel10.setText("Tinggi    :");

        jLabel11.setText("Jenis     :");

        textJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJenisActionPerformed(evt);
            }
        });
        textJenis.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textJenisVetoableChange(evt);
            }
        });

        jLabel12.setText("Ketebalan:");

        textKetebalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKetebalanActionPerformed(evt);
            }
        });
        textKetebalan.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textKetebalanVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(497, 497, 497))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(514, 514, 514))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(textCari))
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tambahBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapusBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(batal))
                                .addComponent(perbaharuiBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonKaca)
                            .addComponent(buttonFurniture)
                            .addComponent(buttonPerhiasan)
                            .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textLebar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textKetebalan, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariBarang)
                    .addComponent(jLabel4)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(buttonFurniture))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(buttonKaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hapusBarang)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(buttonPerhiasan)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tambahBarang)
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(perbaharuiBarang))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(batal))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textLebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textKetebalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(mainMenu)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahBarangActionPerformed

    private void cariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariBarangActionPerformed

    private void hapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBarangActionPerformed
        if (tableBarang.getSelectedRowCount()==1){
            model.removeRow(tableBarang.getSelectedRow());   
            viewErrorMsg("SISTEM: Barang Berhasil Dihapus!");
        }else if (!getTextNama().isEmpty()){
            for (int i = 0; i < model.getRowCount(); i++) {
                if (((String)model.getValueAt(i, 1)).equals(getTextNama())) {
                   model.removeRow(i);
                   break;
                }
            }
        }else{
            if (tableBarang.getRowCount()==0){
                viewErrorMsg("Table Kosong!");
            }else{
                viewErrorMsg("Pilih data yang ingin dihapus!");
            }
        }
    }//GEN-LAST:event_hapusBarangActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainMenuActionPerformed

    private void textHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHargaActionPerformed

    private void textJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJumlahActionPerformed

    private void textBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBeratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBeratActionPerformed

    private void buttonFurnitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFurnitureActionPerformed
        // Perabotan
        textPanjang.setEnabled(true);
        textLebar.setEnabled(true);
        textTinggi.setEnabled(true);
        textKetebalan.setEnabled(false);
        textJenis.setEnabled(false);
    }//GEN-LAST:event_buttonFurnitureActionPerformed

    private void buttonKacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKacaActionPerformed
        // Kaca
        textPanjang.setEnabled(false);
        textLebar.setEnabled(false);
        textTinggi.setEnabled(false);
        textKetebalan.setEnabled(true);
        textJenis.setEnabled(false);
    }//GEN-LAST:event_buttonKacaActionPerformed

    private void buttonPerhiasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPerhiasanActionPerformed
        // Perhiasan
        textPanjang.setEnabled(false);
        textLebar.setEnabled(false);
        textTinggi.setEnabled(false);
        textKetebalan.setEnabled(false);
        textJenis.setEnabled(true);
    }//GEN-LAST:event_buttonPerhiasanActionPerformed

    private void textNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaActionPerformed

    private void textPanjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPanjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPanjangActionPerformed

    private void textPanjangVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textPanjangVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textPanjangVetoableChange

    private void textLebarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLebarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLebarActionPerformed

    private void textLebarVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textLebarVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textLebarVetoableChange

    private void textTinggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTinggiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTinggiActionPerformed

    private void textTinggiVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textTinggiVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textTinggiVetoableChange

    private void textJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJenisActionPerformed

    private void textJenisVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textJenisVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textJenisVetoableChange

    private void textKetebalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKetebalanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKetebalanActionPerformed

    private void textKetebalanVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textKetebalanVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_textKetebalanVetoableChange

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        int selectedrow = tableBarang.getSelectedRow();
        
        textPanjang.setEnabled(false);
        textLebar.setEnabled(false);
        textTinggi.setEnabled(false);
        textKetebalan.setEnabled(false);
        textJenis.setEnabled(false);
        textBerat.setEnabled(false);
        buttonFurniture.setEnabled(false);
        buttonKaca.setEnabled(false);
        buttonPerhiasan.setEnabled(false);
        
        getTFnama().setText(model.getValueAt(selectedrow, 1).toString());
        getTFharga().setText(model.getValueAt(selectedrow, 3).toString());
        getTFjumlah().setText(model.getValueAt(selectedrow, 4).toString());
    }//GEN-LAST:event_tableBarangMouseClicked

    private void perbaharuiBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perbaharuiBarangActionPerformed
        int i = getTableBarang().getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)getTableBarang().getModel();
                if (i>=0){
                    model.setValueAt(getTextNama(), i, 1);
                    model.setValueAt(getTextHarga(), i, 3);
                    model.setValueAt(getTextJumlah(), i, 4);
                }
    }//GEN-LAST:event_perbaharuiBarangActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // reset
        textPanjang.setEnabled(true);
        textLebar.setEnabled(true);
        textTinggi.setEnabled(true);
        textKetebalan.setEnabled(true);
        textJenis.setEnabled(true);
        textBerat.setEnabled(true);
        buttonFurniture.setEnabled(true);
        buttonKaca.setEnabled(true);
        buttonPerhiasan.setEnabled(true);
    }//GEN-LAST:event_batalActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_KategoriBarang;
    private javax.swing.JButton batal;
    private javax.swing.JRadioButton buttonFurniture;
    private javax.swing.JRadioButton buttonKaca;
    private javax.swing.JRadioButton buttonPerhiasan;
    private javax.swing.JButton cariBarang;
    private javax.swing.JButton hapusBarang;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton perbaharuiBarang;
    private javax.swing.JTable tableBarang;
    private javax.swing.JButton tambahBarang;
    private javax.swing.JTextField textBerat;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textJenis;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textKetebalan;
    private javax.swing.JTextField textLebar;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textPanjang;
    private javax.swing.JTextField textTinggi;
    // End of variables declaration//GEN-END:variables
}
