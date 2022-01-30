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
public class Perhiasan extends Barang{
    private String jenis;
    
    public Perhiasan(String nama, int harga, int jumlah, float berat, String jenis) {
        super(nama, harga, jumlah, berat);
        setJenis(jenis);
    }
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    public String getJenis(){
        return jenis;
    }
    
}
