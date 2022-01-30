/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuBarang;
import View.MenuPassword;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mizan Saputro
 */
public class ControllerMenuPassword implements ActionListener{
    Aplikasi model;
    MenuPassword view;
    public ControllerMenuPassword(Aplikasi model){    
        this.model = model;
        view = new MenuPassword();
        view.setVisible(true);
        view.addListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getLogin())){
            if (view.getTextusername().equals("admin") && view.getTextpassword().equals("password")){
                view.setVisible(false);
                new ControllerMenuBarang(model);
            }else{
                view.viewErrorMsg("Masukan Username dan Password dengan Benar!");
                view.setVisible(false);
                new ControllerMenuUtama(model);
            }
        }
    }
    
}
