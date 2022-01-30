/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Mizan Saputro
 */
public abstract class Barang  {
    private String nama;
    private int harga;
    private float berat;
    private int jumlah;
    
    public Barang(String nama, int harga, int jumlah, float berat){
        setNama(nama);
        setHarga(harga);
        setJumlah(jumlah);
        setBerat(berat);
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public void setBerat(float berat){
        this.berat = berat;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public int getJumlah(){
        return jumlah;
    }
    public float getBerat(){
        return berat;
    }
    public void sell(){
        this.jumlah--;
    }
    public void add(){
        this.jumlah++;
    }
    
    
}
