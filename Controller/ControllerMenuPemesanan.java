/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Barang;
import Model.Furniture;
import Model.Kaca;
import Model.Pemesanan;
import Model.Perhiasan;
import View.MenuPemesanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mizan Saputro
 */
public class ControllerMenuPemesanan implements ActionListener {
    Aplikasi model;
    MenuPemesanan view;
    public ControllerMenuPemesanan(Aplikasi model){
        this.model = model;
        view = new MenuPemesanan();
        view.setTablebarang(model.daftarBarang);
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getCaribarang())){
            Barang b = model.cariBarang(view.getTextcaribarang());
            if (b!=null){
                if (b instanceof Furniture){
                    view.viewErrorMsg(
                            "Nama: "+b.getNama()+"\n"
                            +"Harga: "+b.getHarga()+"\n"
                            + "Jumlah: "+b.getJumlah()+"\n"
                            + "Berat: "+b.getBerat()+"\n"
                            + "Panjang: "+((Furniture) b).getPanjang()+"\n"
                            + "Lebar: "+((Furniture) b).getLebar()+"\n"
                            + "Tinggi: "+((Furniture) b).getTinggi()+"\n"
                    );    
                }else if (b instanceof Kaca){
                    view.viewErrorMsg(
                            "Nama: "+b.getNama()+"\n"
                            +"Harga: "+b.getHarga()+"\n"
                            + "Jumlah: "+b.getJumlah()+"\n"
                            + "Berat: "+b.getBerat()+"\n"
                            + "Ketebalan: "+((Kaca) b).getKetebalan()+"\n"
                    );
                }else {
                    view.viewErrorMsg(
                            "Nama: "+b.getNama()+"\n"
                            +"Harga: "+b.getHarga()+"\n"
                            + "Jumlah: "+b.getJumlah()+"\n"
                            + "Berat: "+b.getBerat()+"\n"
                            + "Jenis: "+((Perhiasan) b).getJenis()+"\n"
                    );
                }
            }else{
                view.viewErrorMsg("Barang Tidak Ditemukan!");
            }
            view.setTextcaribarang("");
        }else if (source.equals(view.getCaripemesanan())){
            try {
                Pemesanan p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                if (p!=null){
                    view.setTablepemesnan(p);
                    view.viewErrorMsg("Pemesanan Ditemukan!");
                }else{
                    view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (source.equals(view.getTambah())){
            Pemesanan p;
            try {
                Barang b = model.cariBarang(view.getTextbarang());
                if (b!=null && b.getJumlah()>0){
                    model.tambahPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama(), b);
                    p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                    view.setTablebarang(model.daftarBarang);
                    view.addPemesanan(p, b);
                }else{
                    view.viewErrorMsg("Barang Tidak Ditemukan/Habis!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(source.equals(view.getHapus())){
            Pemesanan p;
            try {
                p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                Barang b = model.cariBarang(view.getTextbarang());
                boolean cek = false;
                if (p!=null && b!=null){
                    for (int i=0;i<p.getPesanan().size();i++){
                        if (p.getPesanan().get(i).getNama().equals(b.getNama())){
                            model.hapusPemesanan(p.getPemesan().getId(), p.getPemesan().getNama(), b.getNama());
                            cek = true;
                        }
                    }
                    if (cek==false){
                        view.viewErrorMsg("SISTEM: Barang Tidak Ada Di Keranjang!");
                    }else{
                        view.viewErrorMsg("SISTEM: Barang Berhasil Dihapus Dari Keranjang!");
                    }
                    view.setTablebarang(model.daftarBarang);
                    view.setTablepemesnan(p);
                    
                }else{
                    view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }else if (source.equals(view.getBatal())){
            view.setTextbarang("");
            view.setTextcaribarang("");
            view.setTextid("");
            view.setTextnama("");
            view.modelP.getDataVector().removeAllElements();
            view.modelP.fireTableDataChanged();
            
        }else{
            view.setVisible(false);
            new ControllerMenuUtama(model);
        }
        view.setTextbarang("");
        view.setTextcaribarang("");
    }
    
}
