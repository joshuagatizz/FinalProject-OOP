/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Database.Database;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Mizan Saputro
 */
public class Aplikasi {
    public ArrayList<Barang> daftarBarang;
    private ArrayList<Cash> daftarTunai;
    private ArrayList<Digital> daftarDigital;
    public ArrayList<Pemesanan> daftarPemesanan;
    private int nBarang;
    private int nTunai;
    private int nDigital;
    private int nPemesanan;
    private Database con;
    public Aplikasi(){
        this.daftarBarang = new ArrayList<>();
        this.daftarTunai = new ArrayList<>();
        this.daftarDigital = new ArrayList<>();
        this.daftarPemesanan= new ArrayList<>();
        this.nBarang = 0;
        this.nTunai = 0;
        this.nDigital = 0;
        this.nPemesanan = 0;
        this.con = new Database();
        this.con.connect();
    }
    public void addBarang(String nama, int harga, int jumlah, float berat, 
        float panjang,float lebar, float tinggi){
	Barang b = new Furniture(nama,harga,jumlah,berat,panjang,lebar,tinggi);
        this.daftarBarang.add(b);
        this.nBarang++;
        this.con.saveBarang(b);
    }
    public void addBarang(String nama, int harga, int jumlah, float berat, float ketebalan){
	Barang b = new Kaca(nama,harga,jumlah,berat,ketebalan);
        this.daftarBarang.add(b);
        this.nBarang++;
        this.con.saveBarang(b);
    }
    public void addBarang(String nama, int harga, int jumlah, float berat, String jenis){
	Barang b = new Perhiasan(nama,harga,jumlah,berat,jenis);
        this.daftarBarang.add(b);
        this.nBarang++;
        this.con.saveBarang(b);
    }
    public Barang cariBarang(String nama){
        for (Barang b: daftarBarang){
            if (b.getNama().equals(nama)){
                return b;
            }
        }
        return null;
    }
    public void updateBarang(String nama, int jumlah, int harga) throws ParseException{
        boolean cek = false;
        for (int i=0;i<daftarPemesanan.size();i++){
            for (int j=0;j<daftarPemesanan.get(i).getPesanan().size();j++){
                if(nama.equals(daftarPemesanan.get(i).getPesanan().get(j).getNama())
                        && daftarPemesanan.get(i).getStatus()==false){
                    daftarPemesanan.get(i).updatePesanan(daftarPemesanan.get(i).getPesanan().get(j), harga);
                    con.updateBarang(daftarPemesanan.get(i).getPemesan().getId(), daftarPemesanan.get(i).getPemesan().getNama(), 
                            nama, jumlah, harga);
                    cek = true;
                }
            }
        }
        
        for (Barang b: daftarBarang){
            if (b.getNama().equals(nama)){
                b.setHarga(harga);
                b.setJumlah(jumlah);
            }
        }
        if (con.getBarang(nama)!=null && cek==false){
            con.updateBarang(nama,jumlah,harga);
        }
    }
    public void hapusBarang(String nama){
        if (cariBarang(nama)!=null){
            for(int i = 0; i<nBarang; i++){
                if(daftarBarang.get(i).getNama().equals(nama)){
                    con.hapusBarang(nama);
                    this.daftarBarang.remove(i);
                    this.nBarang--;
                    break;
                }
            }
            for (int i = 0;i<daftarPemesanan.size();i++){
                for (int j = 0;j<daftarPemesanan.get(i).getPesanan().size();j++){
                    if (daftarPemesanan.get(i).getPesanan().get(j).getNama().equals(nama)){
                        daftarPemesanan.get(i).deletePesanan(daftarPemesanan.get(i).getPesanan().get(j));
                    }
                }
                con.hapusPemesanan(daftarPemesanan.get(i).getPemesan().getId(), 
                                daftarPemesanan.get(i).getPemesan().getNama(), nama);
            }
        }
    }
    public String lihatBarang(){
        return con.getListBarang();
    }
    public void tambahPemesanan(int id_pemesan, String nama_pemesan, Barang b) throws ParseException{
        Pelanggan pel = new Pelanggan(nama_pemesan,id_pemesan);
        Pemesanan pem = new Pemesanan(pel);
        boolean cek = false;
        for (Pemesanan o: daftarPemesanan){
            if (o.getPemesan().getId()==id_pemesan && o.getPemesan().getNama().equals(nama_pemesan)){
                Barang a = cariBarang(b.getNama());
                if (a!=null){
                    System.out.println("Di sini");
                    o.addPesanan(b);
                    cek = true;
                    break;
                }else{
                    break;
                }
            }
        }
        if (cek==false){
            this.daftarPemesanan.add(pem);
            pem.addPesanan(b);
            this.nPemesanan++;
        }
        this.con.tambahPemesanan(id_pemesan, nama_pemesan, b);
        updateBarang(b.getNama(), b.getJumlah(), b.getHarga());
    }
    public Pemesanan cariPemesanan(int id_pemesan, String nama_pemesan) throws ParseException{
        Pemesanan pem = null;
        for (Pemesanan o: daftarPemesanan){
            if (o.getPemesan().getId()==id_pemesan){
                return o;
            }
        }   
        return pem;
    }
    public void hapusPemesanan(int id_pemesan,String nama_pemesan,String pesanan) throws ParseException{
        for (int i=0; i<daftarPemesanan.size();i++){
            if (daftarPemesanan.get(i).getPemesan().getId()==id_pemesan && 
                    daftarPemesanan.get(i).getPemesan().getNama().equals(nama_pemesan)){
                for (int j=0;j<daftarPemesanan.get(i).getPesanan().size();j++){
                    if (daftarPemesanan.get(i).getPesanan().get(j).getNama().equals(pesanan)){
                        daftarPemesanan.get(i).deletePesanan(daftarPemesanan.get(i).getPesanan().get(j));
                        nPemesanan--;
                        j = 0;
                    }
                }
            }
        }
        if (cariPemesanan(id_pemesan,nama_pemesan)!=null){
            con.hapusPemesanan(id_pemesan, nama_pemesan, pesanan);
        }
    }
    public String lihatPemesanan(){
        return con.getListPemesanan();
    }
    
    public void tambahPembayaran(Pelanggan pel,String metode) throws ParseException{
        for (Pemesanan o: daftarPemesanan){
            if (o.getPemesan().getId()==pel.getId()){
                o.setStatus(true);
                if ("Tunai".equals(metode)){
                    Cash data = new Cash(o);
                    daftarTunai.add(data);
                    nTunai++;
                    con.tambahPembayaran(o.getPemesan(), o.getNominal(), metode, data.getOngkir(), data.getPpn(),0, 
                            data.getTotalbayar());
                }else if ("Digital".equals(metode)){
                    Digital data = new Digital(o);
                    daftarDigital.add(data);
                    nDigital++;
                    con.tambahPembayaran(o.getPemesan(), o.getNominal(), metode, data.getOngkir(), 0,data.getBiayaadmin(), 
                            data.getTotalbayar());
                }
            }
        }
    }
    public Cash cariPembayaranC(Pelanggan pel) throws ParseException{
        Cash c = null;
        for (Cash o: daftarTunai  ){
            if (o.getKeranjang().getPemesan().getId()==pel.getId()){
                    c = o;
            }
        }
        if (c == null){
            c = con.getPembayaranC(pel.getId(),pel.getNama());
        }
        return c;
    }
    public Digital cariPembayaranD(Pelanggan pel) throws ParseException{
        for (Digital o: daftarDigital){
            if (o.getKeranjang().getPemesan().getId()==pel.getId()){
                if (con.getPembayaranD(o.getKeranjang().getPemesan().getId(), o.getKeranjang().getPemesan().getNama())!=null){
                    return o;
                }
            }
        }
        return null;        
    }
    public void updatePembayaran(Pelanggan pel, String metode){
        for (Cash c: daftarTunai){
            if (metode.equals("Digital") && c.getKeranjang().getPemesan().getId()==pel.getId()){
                Digital d = new Digital(c.getKeranjang());
                daftarTunai.remove(c);
                nTunai--;
                daftarDigital.add(d);
                nDigital++;
                con.updatePembayaran(c, "Digital");
                break;
            }
        }
        for (Digital d: daftarDigital){
            if (metode.equals("Tunai") && d.getKeranjang().getPemesan().getId()==pel.getId()){
                Cash c = new Cash(d.getKeranjang());
                daftarDigital.remove(d);
                nDigital--;
                daftarTunai.add(c);
                nTunai++;
                con.updatePembayaran(d, "Tunai");
                break;
            }
        } 
    }
    public void hapusPembayaran(Pelanggan pel){
        for (Cash c: daftarTunai){
            if (c.getKeranjang().getPemesan().getId()==pel.getId()){
                daftarTunai.remove(c);
                nTunai--;
                con.hapusPembayaran(pel.getId());
                break;
            }
        }
        for (Digital d: daftarDigital){
            if (d.getKeranjang().getPemesan().getId()==pel.getId()){
                daftarDigital.remove(d);
                nDigital--;
                con.hapusPembayaran(pel.getId());
                break;
            }
        }         
    }
    public String lihatPembayaran(){
        return con.getListPembayaran();
    }
    public String setNominal(int id_pemesan, String nama_pemesan) throws SQLException{
        return con.getNominal(id_pemesan, nama_pemesan);
    }
    public void deleteAllrow() throws SQLException{
        con.deleteAllrow();
    }
}
