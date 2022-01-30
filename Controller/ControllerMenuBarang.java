/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.MenuBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mizan Saputro
 */
public class ControllerMenuBarang implements ActionListener {
    Aplikasi model;
    MenuBarang view;
    public ControllerMenuBarang(Aplikasi model){
        this.model = model;
        view = new MenuBarang();
        view.setValueTable(model.daftarBarang);
        view.setVisible(true);
        view.addListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getTambahbarang())) {
            Barang b = null;
            if (view.getKategori().equals("Perabotan")){
                b = new Furniture(view.getTextNama(),Integer.parseInt(view.getTextHarga()), 
                        Integer.parseInt(view.getTextJumlah()), Float.parseFloat(view.getTextBerat()), 
                        Float.parseFloat(view.getTextPanjang()), Float.parseFloat(view.getTextLebar()), 
                        Float.parseFloat(view.getTextTinggi()));
                
                model.addBarang(b.getNama(), b.getHarga(), 
                        b.getJumlah(), b.getBerat(),((Furniture) b).getPanjang(), ((Furniture) b).getLebar(),
                        ((Furniture) b).getTinggi());
            }else if(view.getKategori().equals("Kaca")){
                b = new Kaca(view.getTextNama(),Integer.parseInt(view.getTextHarga()), 
                        Integer.parseInt(view.getTextJumlah()), Float.parseFloat(view.getTextBerat()),
                        Float.parseFloat(view.getTextKetebalan()));
                
                model.addBarang(b.getNama(), b.getHarga(), b.getJumlah(), 
                        b.getBerat(),((Kaca) b).getKetebalan());
            }else{
                b = new Perhiasan(view.getTextNama(),Integer.parseInt(view.getTextHarga()), 
                        Integer.parseInt(view.getTextJumlah()), Float.parseFloat(view.getTextBerat()),
                        view.getTextJenis());
                model.addBarang(b.getNama(), b.getHarga(), b.getJumlah(), 
                        b.getBerat(), ((Perhiasan) b).getJenis());
            }
            view.addValueTable(b);
            view.viewErrorMsg("Berhasil !");
            view.setTextNama("");
            view.setTextHarga("");
            view.setTextJumlah("");
            view.setTextBerat("");
            view.setTextPanjang("");
            view.setTextLebar("");
            view.setTextTinggi("");
            view.setTextKetebalan("");
            view.setTextJenis("");
            view.setTextCari("");
            view.resetKategori();
        }else if (source.equals(view.getCaribarang())){
            Barang b = model.cariBarang(view.getTextCari());
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
            view.setTextCari("");
        }else if(source.equals(view.getPerbaharuibarang())){
            try {
                if (model.cariBarang(view.getTextNama())!=null){
                    if (!view.getTextJumlah().isEmpty()&&!view.getTextHarga().isEmpty()){
                        model.updateBarang(view.getTextNama(),Integer.parseInt(view.getTextJumlah()),
                                Integer.parseInt(view.getTextHarga()));
                        view.viewErrorMsg("SISTEM: Barang Sudah Diperbaharui!");
                    }else if (view.getTextJumlah().isEmpty()&&!view.getTextHarga().isEmpty()){
                        model.updateBarang(view.getTextNama(),model.cariBarang(view.getTextNama()).getJumlah(),
                                Integer.parseInt(view.getTextHarga()));
                        view.viewErrorMsg("SISTEM: Barang Sudah Diperbaharui!");
                    }else if (!view.getTextJumlah().isEmpty()&&view.getTextHarga().isEmpty()){
                        model.updateBarang(view.getTextNama(),Integer.parseInt(view.getTextJumlah()),
                                model.cariBarang(view.getTextNama()).getHarga());
                        view.viewErrorMsg("SISTEM: Barang Sudah Diperbaharui!");
                    }else{
                        view.viewErrorMsg("SISTEM: Tidak Ada Pembaharuan!");
                    }
                    view.setValueTable(model.daftarBarang);
                }else{
                    view.viewErrorMsg("SISTEM: Gagal Diperbaharui \n Barang Tidak Ditemukan!");
                }
                view.setTextNama("");
                view.setTextHarga("");
                view.setTextJumlah("");
                view.setTextBerat("");
                view.setTextPanjang("");
                view.setTextLebar("");
                view.setTextTinggi("");
                view.setTextKetebalan("");
                view.setTextJenis("");
                view.resetKategori();
                
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(source.equals(view.getHapusbarang())){
            if (model.cariBarang(view.getTextNama())!=null){
                model.hapusBarang(view.getTextNama());
                view.viewErrorMsg("SISTEM: BERHASIL! \n Barang Berhasil Dihapus!");
            }else{
                view.viewErrorMsg("SISTEM: GAGAL! \n Barang Gagal Dihapus!");
            }
            view.setValueTable(model.daftarBarang);
            view.setTextNama("");
            view.setTextHarga("");
            view.setTextJumlah("");
            view.setTextBerat("");
            view.setTextPanjang("");
            view.setTextLebar("");
            view.setTextTinggi("");
            view.setTextKetebalan("");
            view.setTextJenis("");
            view.resetKategori();
        }else if (source.equals(view.getBatal())){
            view.setTextNama("");
            view.setTextHarga("");
            view.setTextJumlah("");
            view.setTextBerat("");
            view.setTextPanjang("");
            view.setTextLebar("");
            view.setTextTinggi("");
            view.setTextKetebalan("");
            view.setTextJenis("");
            view.resetKategori();
        } else if (source.equals(view.getMainmenu())){
            view.setVisible(false);
            new ControllerMenuUtama(model);
        }
        
    }
    
}
