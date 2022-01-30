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
public class Cash implements Pembayaran{
    private int id;
    private int ongkir;
    private Pemesanan keranjang;
    private int ppn;
   
    public Cash(Pemesanan keranjang){
        this.ongkir = 0;
        keranjang.getPesanan().forEach((o) -> {
            if (o instanceof Furniture) {
                this.ongkir += o.getBerat()*10000;
            }else{
                this.ongkir += o.getBerat()*5000;
            }
        });
        setKeranjang(keranjang);
        setPpn();
    }

    @Override
    public void setOngkir() {
        keranjang.getPesanan().forEach((o) -> {
            if (o instanceof Furniture) {
                this.ongkir += o.getBerat()*10000;
            }else{
                this.ongkir += o.getBerat()*5000;
            }
        });
    }
    
    @Override
    public void setKeranjang(Pemesanan keranjang) {
        this.keranjang = keranjang;
    }
    
    public void setPpn(){
       this.ppn = 10*(keranjang.getNominal()+getOngkir())/100;
    }


    @Override
    public int getOngkir() {
        return ongkir;
    }
    
    public int getPpn(){
        return ppn;
    }
    @Override
    public int getTotalbayar() {
        return getPpn()+getOngkir()+keranjang.getNominal();
    }

    @Override
    public Pemesanan getKeranjang() {
        return keranjang;
    }
   
    @Override
    public void updateStatus() {
        keranjang.setStatus(true);
    }
    
}
