/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author Mizan Saputro
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/pemesananbarang?zeroDateTimeBehavior=convertToNull";
    private String dbuser = "root";
    private String dbpass = "";
    private Statement st;
    private Connection con;
    
    public Database() {
    
    }
    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void saveBarang(Barang b) {
        try {
            String query;
            if (b instanceof Furniture){
                query = "INSERT INTO barang (nama, kategori, harga, jumlah, berat, panjang, lebar, tinggi) VALUES ("
                        + "'" + b.getNama() + "',"
                        + "'" + "Perabotan" + "',"
                        + "'" + b.getHarga() + "',"
                        + "'" + b.getJumlah() + "',"
                        + "'" + b.getBerat() + "',"
                        + "'" + ((Furniture) b).getPanjang() + "',"
                        + "'" + ((Furniture) b).getLebar() + "',"
                        + "'" + ((Furniture) b).getTinggi() + "'"
                        + ")";
                st.execute(query);
            }else if (b instanceof Kaca){
                query = "INSERT INTO barang (nama,kategori, harga, jumlah, berat, ketebalan) VALUES ("
                        + "'" + b.getNama() + "',"
                        + "'" + "Kaca" + "',"
                        + "'" + b.getHarga() + "',"
                        + "'" + b.getJumlah() + "',"
                        + "'" + b.getBerat() + "',"
                        + "'" + ((Kaca) b).getKetebalan() + "'"
                        + ")";
                st.execute(query);                
            }else if (b instanceof Perhiasan){
                query = "INSERT INTO barang (nama, kategori, harga, jumlah, berat, jenis) VALUES ("
                        + "'" + b.getNama() + "',"
                        + "'" + "Perhiasan" + "',"
                        + "'" + b.getHarga() + "',"
                        + "'" + b.getJumlah() + "',"
                        + "'" + b.getBerat() + "',"
                        + "'" + ((Perhiasan) b).getJenis()+ "'"
                        + ")";
                st.execute(query); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Barang getBarang(String nama) {
        Barang b = null;
        try {
            String query = "SELECT * FROM barang WHERE nama = '" +nama+"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {    
                if (rs.getString("kategori").equals("Perabotan")){
                    b = new Furniture(rs.getString("nama"),rs.getInt("harga"),rs.getInt("jumlah"),
                            rs.getFloat("berat"),rs.getFloat("panjang"),rs.getFloat("lebar"),
                            rs.getFloat("tinggi"));
                }else if (rs.getString("kategori").equals("Kaca")){
                    b = new Kaca(rs.getString("nama"),rs.getInt("harga"),rs.getInt("jumlah"),
                            rs.getFloat("berat"),rs.getFloat("ketebalan"));                   
                }else if (rs.getString("kategori").equals("Perhiasan")){
                    b = new Perhiasan(rs.getString("nama"),rs.getInt("harga"),rs.getInt("jumlah"),
                            rs.getFloat("berat"),rs.getString("jenis"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
    public void updateBarang(String nama, int jumlah, int harga){
        try {
            String query;
            query = "update barang set jumlah =" + jumlah +  ","
                    + "harga="+ harga  
                    + " where nama='" + nama +"';";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateBarang(int id_pemesan, String nama_pemesan, String nama, int jumlah, int harga) throws ParseException{
            updateBarang(nama,jumlah,harga);
            updatePemesanan(id_pemesan,nama_pemesan,harga,nama);
    }
    public void hapusBarang(String nama){
        try {
            String query = "delete from barang where nama = '"+nama+"'";
            st.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getListBarang() {
        String s = "Daftar Barang : \n";
        try {
            String query = "SELECT *FROM barang";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("kategori").equals("Kaca")){
                    s += rs.getString("id")+", ";
                    s += rs.getString("kategori")+", ";
                    s += rs.getString("nama")+", ";
                    s += rs.getString("harga")+", ";
                    s += rs.getString("jumlah")+", ";
                    s += rs.getString("berat")+", ";
                    s += rs.getString("ketebalan")+"\n";
                }else if (rs.getString("kategori").equals("Perhiasan")){
                    s += rs.getString("id")+", ";
                    s += rs.getString("kategori")+", ";
                    s += rs.getString("nama")+", ";
                    s += rs.getString("harga")+", ";
                    s += rs.getString("jumlah")+", ";
                    s += rs.getString("berat")+", ";
                    s += rs.getString("jenis")+"\n";                    
                }else{
                    s += rs.getString("id")+", ";
                    s += rs.getString("kategori")+", ";
                    s += rs.getString("nama")+", ";
                    s += rs.getString("harga")+", ";
                    s += rs.getString("jumlah")+", ";
                    s += rs.getString("berat")+", ";
                    s += rs.getString("panjang")+", ";
                    s += rs.getString("lebar")+", ";
                    s += rs.getString("tinggi")+"\n";
                }
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public void tambahPemesanan(int id_pemesan, String nama_pemesan, Barang b) throws ParseException{
        try {
            String query;
            
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = 
            new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            
            query = "INSERT INTO pemesanant (id_pemesan,tanggal,nama,pesanan,harga) VALUES ("
                    + "'" + id_pemesan + "',"
                    + "'" + currentTime + "',"
                    + "'" + nama_pemesan + "',"
                    + "'" + b.getNama() + "',"
                    + "'" + b.getHarga() + "'"
                    + ")";
                    st.execute(query);    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Pemesanan getPemesanan(int id_pemesan, String nama_pemesan) throws ParseException{
        Pemesanan pem = null;
        Pelanggan pel = null;
        try {
            String query = "SELECT * FROM pemesanant WHERE nama='" + nama_pemesan+"'"
                    + " AND id_pemesan='"+id_pemesan+"';";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) { 
                pel = new Pelanggan(nama_pemesan,id_pemesan);
                java.sql.Date date = rs.getDate("tanggal");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = dateFormat.format(date);
                pem = new Pemesanan(pel,dateStr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pem;  
    }
    public void updatePemesanan(int id_pemesan,String nama_pemesan, int harga, String pesanan) throws ParseException{
        try {
            String query;
            Pemesanan pem = getPemesanan(id_pemesan,nama_pemesan);
            if (pem!=null){
                query = "update pemesanant set harga =" + harga
                        + " where nama='" + nama_pemesan +"'and id_pemesan= "
                        + "id_pemesan" + " and pesanan='"+ pesanan +"' and status='"
                        + 0 + "';";
                st.executeUpdate(query);    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    public void updatePemesanan(int id_pemesan,String nama_pemesan) throws ParseException{
        try {
            String query;
            Pemesanan pem = getPemesanan(id_pemesan,nama_pemesan);
            if (pem!=null){
                query = "update pemesanant set status =" + true
                        + " where nama='" + nama_pemesan +"' and id_pemesan='"
                        + id_pemesan +"';";
                st.executeUpdate(query);    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    public void hapusPemesanan(int id_pemesan,String nama_pemesan,String pesanan){
        try {
            String query = "delete from pemesanant where id_pemesan='"+id_pemesan+"'"
                    +" And nama='"+nama_pemesan+"' And pesanan='"+pesanan+"';";
            st.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     
    }
    public String getListPemesanan() {
        String s = "Daftar Pemesanan : \n";
        try {
            String query = "SELECT *FROM pemesanant";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                s += rs.getString("tanggal")+",";
                s += rs.getString("id_pesanan")+",";
                s += rs.getString("id_pemesan")+",";
                s += rs.getString("nama")+",";
                s += rs.getString("pesanan")+",";
                s += rs.getString("harga")+",";
                s += rs.getBoolean("status")+"\n";
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    
    public void tambahPembayaran(Pelanggan pel, int harga, String metode, int ongkir, int ppn, int biaya_admin, int total) throws ParseException{
        try {
            String query;
            System.out.println("cek");
            if ("Tunai".equals(metode)){
                    query = "INSERT INTO pembayarant (id_pemesan,metode,harga,ongkir,ppn,total) VALUES ("
                    + "'" + pel.getId() + "',"
                    + "'" + metode + "',"
                    + "'" + harga + "',"
                    + "'" + ongkir + "',"
                    + "'" + ppn + "',"
                    + "'" + total + "'"
                    + ")";
                    st.execute(query);     
            }  else if ("Digital".equals(metode)){
                    query = "INSERT INTO pembayarant (id_pemesan,metode,harga,ongkir,biaya_admin,total) VALUES ("
                    + "'" + pel.getId() + "',"
                    + "'" + metode + "',"
                    + "'" + harga + "',"
                    + "'" + ongkir + "',"
                    + "'" + biaya_admin + "',"
                    + "'" + total + "'"
                    + ")";
                    st.execute(query); 
            }
            updatePemesanan(pel.getId(),pel.getNama());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }      
    }
    public  Cash getPembayaranC(int id_pemesan,String nama) throws ParseException {
        Cash data = null;
        Pemesanan pem = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM pembayarant WHERE id_pemesan='" + id_pemesan+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("metode").equals("Tunai")){
                    pem = getPemesanan(id_pemesan,nama);
                    data = new Cash(pem);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                    
                } catch (SQLException e) {

                }
            }
        }
        return data;  
    }
    public Digital getPembayaranD(int id_pemesan,String nama) throws ParseException {
        Digital data = null;
        Pemesanan pem = getPemesanan(id_pemesan,nama);
        try {
            String query = "SELECT * FROM pembayarant WHERE id_pemesan='" + id_pemesan+"';";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) { 
                if (rs.getString("metode").equals("Digital")){
                    data = new Digital(pem);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;  
    }
    public void updatePembayaran(Cash c, String metode){
        Digital d = new Digital(c.getKeranjang());
        try {
            String query;
            query = "update pembayarant set metode='" + metode +  "',"
                    + "ppn="+ 0 +"," 
                    + " biaya_admin=" + 5000 +","
                    + " total=" + d.getTotalbayar() 
                    + " where id_pemesan='" + c.getKeranjang().getPemesan().getId() +"';";
            st.executeUpdate(query);    
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updatePembayaran(Digital d, String metode){
        Cash c = new Cash(d.getKeranjang());
        try {
            String query;
            query = "update pembayarant set metode='" + metode +  "',"
                    + "ppn="+ c.getPpn() +"," 
                    + " biaya_admin=" + 0 +","
                    + " total='" + c.getTotalbayar() 
                    + " where id_pemesan='" + d.getKeranjang().getPemesan().getId() +"';";
            st.executeUpdate(query);    
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void hapusPembayaran(int id_pemesan){
        try {
            String query;
            query = "delete from pembayarant where id_pemesan='"+id_pemesan+"';";
            st.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     
    }    
    public String getListPembayaran() {
        String s = "Daftar Pembayaran : \n";
        try {
            String query = "SELECT *FROM pembayarant";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                s += rs.getString("id_pemesan")+",";
                s += rs.getString("metode")+",";
                s += rs.getString("harga")+",";
                s += rs.getString("ongkir")+",";
                s += rs.getString("ppn")+",";
                s += rs.getString("biaya_admin")+",";
                s += rs.getBoolean("total")+"\n";
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public String getNominal(int id_pemesan, String nama_pemesan) throws SQLException{
        String sum = null; 
        try {
            String query;
            query = "SELECT SUM(harga) as nominal " +
                    "FROM pemesanant " + 
                    "WHERE id_pemesan='"+id_pemesan+"' AND nama='"+nama_pemesan+"';";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            sum =  rs.getString("nominal");
            
        }catch (SQLException ex) {
                ex.printStackTrace();
        }
        return sum;
    }
    public void deleteAllrow() throws SQLException{
        String query1 = "DELETE FROM pemesanant;";
        String query2 = "DELETE FROM barang;";
        String query3 = "DELETE FROM pembayarant;";
        st.execute(query1);
        st.execute(query2);
        st.execute(query3);
    }
}
