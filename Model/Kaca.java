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
public class Kaca extends Barang { 
    private float ketebalan;
    
    public Kaca(String nama, int harga, int jumlah, float berat, float ketebalan) {
        super(nama, harga, jumlah, berat);
        setKetebalan(ketebalan);
    }
    public void setKetebalan(float ketebalan){
        this.ketebalan = ketebalan;
    }
    public float getKetebalan(){
        return ketebalan;
    }
    
}
