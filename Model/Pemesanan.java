/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Mizan Saputro
 */
public class Pemesanan{
    private Pelanggan pemesan;
    private ArrayList<Barang> pesanan;
    private boolean status;
    private String date;
    private int banyak;
    private int nominal;
    private float totalBerat;
    
    public Pemesanan(Pelanggan pemesan) {
        setPemesan(pemesan);
        setDate();
        this.status = false;
        this.pesanan = new ArrayList<Barang>();
        this.banyak = 0;
        this.nominal = 0;
        this.totalBerat = 0;
    }
    public Pemesanan(Pelanggan pemesan, String date) throws ParseException {
        setPemesan(pemesan);
        setDate(date);
        this.status = false;
        this.pesanan = new ArrayList<Barang>();
        this.banyak = 0;
        this.nominal = 0;
        this.totalBerat = 0;
    }
    public void setPemesan(Pelanggan pemesan){
        this.pemesan = new Pelanggan(pemesan);
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public void setDate(String date) throws ParseException{
        //java.util.Date dt = new java.util.Date();
        Date sdf = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        this.date = formatter.format(sdf);
    }
    public void setDate(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(dt);
    }
    public void addPesanan(Barang b){
        this.pesanan.add(b);
        this.banyak++;
        this.totalBerat = this.totalBerat + b.getBerat();
        this.nominal = this.nominal+b.getHarga();
        System.out.println(b.getHarga() + " " + this.nominal);
        b.sell();
    }
    public void updatePesanan(Barang b, int harga){
        for (Barang o: this.pesanan){
            if (o.getNama().equals(b.getNama())){
                this.nominal = this.nominal-b.getHarga();
                o.setHarga(harga);
            }
        }
        this.nominal = this.nominal+harga;
    }
    public void deletePesanan(Barang b){
        this.pesanan.remove(b);
        this.banyak--;
        this.totalBerat -= b.getBerat();
        this.nominal -=b.getHarga();
        b.add();
    }
    public void setNominal(int nominal){
        this.nominal = nominal;
    }
    public Pelanggan getPemesan(){
        return pemesan;
    }
    public boolean getStatus(){
        return status;
    }
    public String getDate(){
        return date;
    }
    public ArrayList<Barang> getPesanan(){
        return pesanan;
    }
    public int getBanyak(){
        return banyak;
    }
    public int getNominal(){
        return nominal;
    }
    public float getTotalberat(){
        return totalBerat;
    }
    
    
   
    
}
