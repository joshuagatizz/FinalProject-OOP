/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Cash;
import Model.Digital;
import Model.Pelanggan;
import Model.Pemesanan;
import View.MenuPembayaran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mizan Saputro
 */
public class ControllerMenuPembayaran implements ActionListener{
    Aplikasi model;
    MenuPembayaran view;
    public ControllerMenuPembayaran(Aplikasi model){
        this.model = model;
        view = new MenuPembayaran();
        view.setVisible(true);
        view.addListener(this);
        view.getTFharga().setEnabled(false);
        view.getTFppn().setEnabled(false);
        view.getTFbiayaadmin().setEnabled(false);
        view.getTFongkir().setEnabled(false);
        view.getTFtotal().setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getLihatdetail())){
            try {
                Pemesanan p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                if (p!=null){
                    p.setNominal(Integer.parseInt(model.setNominal(Integer.parseInt(view.getTextid()), view.getTextnama())));
                    view.setTablepesanan(p.getPesanan());
                    view.setTextharga(Integer.toString(p.getNominal()));                    
                }else{
                    view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (source.equals(view.getTunai())){
            try {
                if (!view.getTextnama().isEmpty() && !view.getTextid().isEmpty()){
                    Pemesanan p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                    if (p!=null){
                        Cash c = new Cash(p);
                        view.setTextppn(Integer.toString(c.getPpn()));
                        view.setTextbiayaadmin("");
                        view.setTextongkir(Integer.toString(c.getOngkir()));
                        view.setTexttotal(Integer.toString(c.getTotalbayar()));
                        view.getTFnama().setEnabled(false);
                        view.getTFid().setEnabled(false);
                        view.getTFharga().setEnabled(false);
                        view.getTFppn().setEnabled(false);
                        view.getTFbiayaadmin().setEnabled(false);
                        view.getTFongkir().setEnabled(false);
                        view.getTFtotal().setEnabled(false);
                    }else{
                        view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                    }
                }else{
                    view.viewErrorMsg("Masukan ID dan Nama Pemesan!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (source.equals(view.getDigital())){
            try {
                if (!view.getTextnama().isEmpty() && !view.getTextid().isEmpty()){
                    Pemesanan p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                    if (p!=null){
                        Digital d = new Digital(p);
                        view.setTextbiayaadmin(Integer.toString(d.getBiayaadmin()));
                        view.setTextppn("");
                        view.setTextongkir(Integer.toString(d.getOngkir()));
                        view.setTexttotal(Integer.toString(d.getTotalbayar()));
                        view.getTFnama().setEnabled(false);
                        view.getTFid().setEnabled(false);
                        view.getTFharga().setEnabled(false);
                        view.getTFppn().setEnabled(false);
                        view.getTFbiayaadmin().setEnabled(false);
                        view.getTFongkir().setEnabled(false);
                        view.getTFtotal().setEnabled(false);
                    }else{
                        view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                    }
                }else{
                    view.viewErrorMsg("Masukan ID dan Nama Pemesan!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (source.equals(view.getBayar())){
            Pemesanan p = null;
            try {
                if (!view.getTextnama().isEmpty() && !view.getTextid().isEmpty()){
                    p = model.cariPemesanan(Integer.parseInt(view.getTextid()), view.getTextnama());
                    if (view.getMetode().equals("Tunai")){
                        if (p!=null){
                            Cash c = new Cash(p);
                            model.tambahPembayaran(c.getKeranjang().getPemesan(), "Tunai");
                            view.viewErrorMsg("Pembayaran Berhasil!");
                            view.setTextppn("");
                            view.setTextbiayaadmin("");
                            view.setTextharga("");
                            view.setTextongkir("");
                            view.setTexttotal("");
                            view.setTextid("");
                            view.setTextnama("");
                            view.getTFnama().setEnabled(true);
                            view.getTFid().setEnabled(true);
                            view.getTFharga().setEnabled(false);
                            view.getTFppn().setEnabled(false);
                            view.getTFbiayaadmin().setEnabled(false);
                            view.getTFongkir().setEnabled(false);
                            view.getTFtotal().setEnabled(false);
                            view.model.getDataVector().removeAllElements();
                            view.model.fireTableDataChanged();
                            view.resetMetode();
                        }else{
                            view.viewErrorMsg("Pemesanan Tidak Ditemukan!");
                        }
                    }else{
                        if (p!=null){
                            Digital d = new Digital(p);
                            model.tambahPembayaran(d.getKeranjang().getPemesan(), "Digital");
                            view.viewErrorMsg("Pembayaran Berhasil!");
                            view.setTextbiayaadmin("");
                            view.setTextppn("");
                            view.setTextongkir("");
                            view.setTexttotal("");
                            view.setTextnama("");
                            view.setTextid("");
                            view.setTextharga("");
                            view.getTFnama().setEnabled(true);
                            view.getTFid().setEnabled(true);
                            view.getTFharga().setEnabled(false);
                            view.getTFppn().setEnabled(false);
                            view.getTFbiayaadmin().setEnabled(false);
                            view.getTFongkir().setEnabled(false);
                            view.getTFtotal().setEnabled(false);
                            view.resetMetode();
                            view.model.getDataVector().removeAllElements();
                            view.model.fireTableDataChanged();
                        }
                    }
                }else{
                    view.viewErrorMsg("Masukan ID dan Nama Pemesan!");    
                }
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }else if (source.equals(view.getUbahmetode())){
            Cash Pc = null;
            Digital Pd = null;
            try {
                Pelanggan pel;
                pel = new Pelanggan(view.getTextnama(), Integer.parseInt(view.getTextid()));
                Pc = model.cariPembayaranC(pel);
                Pd = model.cariPembayaranD(pel);
                if (Pc!=null){
                    model.updatePembayaran(pel, "Digital");
                    view.viewErrorMsg("Metode Pembayaran Berhasil Diubah");
                }else if (Pd!=null){
                    model.updatePembayaran(pel, "Cash");
                    view.viewErrorMsg("Metode Pembayaran Berhasil Diubah");
                }else{
                    view.viewErrorMsg("Data Pembayaran Tidak Ada!");
                }
                view.setTextbiayaadmin("");
                view.setTextppn("");
                view.setTextongkir("");
                view.setTexttotal("");
                view.setTextnama("");
                view.setTextid("");
                view.setTextharga("");
                view.getTFnama().setEnabled(true);
                view.getTFid().setEnabled(true);
                view.getTFharga().setEnabled(false);
                view.getTFppn().setEnabled(false);
                view.getTFbiayaadmin().setEnabled(false);
                view.getTFongkir().setEnabled(false);
                view.getTFtotal().setEnabled(false);
                view.resetMetode();
                view.model.getDataVector().removeAllElements();
                view.model.fireTableDataChanged();
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (source.equals(view.getCari())){
            Cash Pc = null;
            Digital Pd = null;
            try {
                Pelanggan pel;
                pel = new Pelanggan(view.getTextnama(), Integer.parseInt(view.getTextid()));
                Pc = model.cariPembayaranC(pel);
                Pd = model.cariPembayaranD(pel);
                if (Pc!=null){
                    view.setTextid(Integer.toString(Pc.getKeranjang().getPemesan().getId()));
                    view.setTextnama(Pc.getKeranjang().getPemesan().getNama());
                    view.setTextharga(Integer.toString(Pc.getKeranjang().getNominal()));
                    view.setTextppn(Integer.toString(Pc.getPpn()));
                    view.setTextongkir(Integer.toString(Pc.getOngkir()));
                    view.setTexttotal(Integer.toString(Pc.getTotalbayar()));
                    view.setTablepesanan(Pc.getKeranjang().getPesanan());
                    view.setMetode("Tunai");
                    view.getTFnama().setEnabled(false);
                    view.getTFid().setEnabled(false);
                    view.getTFharga().setEnabled(false);
                    view.getTFppn().setEnabled(false);
                    view.getTFbiayaadmin().setEnabled(false);
                    view.getTFongkir().setEnabled(false);
                    view.getTFtotal().setEnabled(false);
                }else if (Pd!=null){
                    view.setTextid(Integer.toString(Pd.getKeranjang().getPemesan().getId()));
                    view.setTextnama(Pd.getKeranjang().getPemesan().getNama());
                    view.setTextharga(Integer.toString(Pd.getKeranjang().getNominal()));
                    view.setTextbiayaadmin(Integer.toString(Pd.getBiayaadmin()));
                    view.setTextongkir(Integer.toString(Pd.getOngkir()));
                    view.setTexttotal(Integer.toString(Pd.getTotalbayar()));
                    view.setTablepesanan(Pd.getKeranjang().getPesanan());
                    view.setMetode("Digital");
                    view.getTFnama().setEnabled(false);
                    view.getTFid().setEnabled(false);
                    view.getTFharga().setEnabled(false);
                    view.getTFppn().setEnabled(false);
                    view.getTFbiayaadmin().setEnabled(false);
                    view.getTFongkir().setEnabled(false);
                    view.getTFtotal().setEnabled(false);
                }else{
                    view.viewErrorMsg("Data Pembayaran Tidak Ada!");
                } 
            }catch (ParseException ex) {
                Logger.getLogger(ControllerMenuPembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(source.equals(view.getBatal())){
            view.setTextbiayaadmin("");
            view.setTextppn("");
            view.setTextongkir("");
            view.setTexttotal("");
            view.setTextnama("");
            view.setTextid("");
            view.setTextharga("");
            view.getTFnama().setEnabled(true);
            view.getTFid().setEnabled(true);
            view.getTFharga().setEnabled(false);
            view.getTFppn().setEnabled(false);
            view.getTFbiayaadmin().setEnabled(false);
            view.getTFongkir().setEnabled(false);
            view.getTFtotal().setEnabled(false);
            view.resetMetode();        
            view.model.getDataVector().removeAllElements();
            view.model.fireTableDataChanged();
        }else{
            view.setVisible(false);
            new ControllerMenuUtama(model);
        }
    }
}
