/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mizan Saputro
 */
public class ControllerMenuUtama implements ActionListener {
    Aplikasi model;
    MenuUtama view;
    public ControllerMenuUtama(Aplikasi model){
        this.model = model;
        view = new MenuUtama();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBarang())) {
            view.setVisible(false);
            new ControllerMenuPassword(model);
        }else if(source.equals(view.getPemesanan())){
            view.setVisible(false);
            new ControllerMenuPemesanan(model);
        }else if(source.equals(view.getPembayaran())){
            view.setVisible(false);
            new ControllerMenuPembayaran(model);
        }else if(source.equals(view.getExit())){
            try {
                model.deleteAllrow();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuUtama.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }
}
    

