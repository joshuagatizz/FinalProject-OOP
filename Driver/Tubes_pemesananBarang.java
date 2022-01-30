/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import Controller.*;
import Database.Database;
import Model.*;
import View.MenuUtama;
import java.text.ParseException;
/**
 *
 * @author Mizan Saputro
 */
public class Tubes_pemesananBarang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Aplikasi model = new Aplikasi();
        new ControllerMenuUtama(model);
    }
    
}
