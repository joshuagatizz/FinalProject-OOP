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
public interface Pembayaran  {
    
    public void setKeranjang(Pemesanan keranjang);
    public void setOngkir();
    public int getOngkir();
    public Pemesanan getKeranjang();
    public int getTotalbayar();
    public void updateStatus();
}
