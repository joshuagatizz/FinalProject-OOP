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
public class Furniture extends Barang {
    private float panjang;
    private float lebar;
    private float tinggi;
    
    public Furniture(String nama, int harga, int jumlah, float berat, float
            panjang, float lebar, float tinggi) {
        super(nama, harga, jumlah, berat);
        setPanjang(panjang);
        setTinggi(tinggi);
        setLebar(lebar);
    }
    public void setPanjang(float panjang){
        this.panjang = panjang;
    }
    public void setLebar(float lebar){
        this.lebar = lebar;
    }
    public void setTinggi(float tinggi){
        this.tinggi = tinggi;
    }
    public float getPanjang(){
        return panjang;
    }
    public float getLebar(){
        return lebar;
    }
    public float getTinggi(){
        return tinggi;
    }

    
}
