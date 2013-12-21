/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author erkoc
 */
public class AboutUs extends JFrame {

    public AboutUs() throws HeadlessException {
        this.setSize(400, 400);
        this.setTitle("About Us");


        JLabel lbl = new JLabel();
        lbl.setText("Copyright 2013 Ahmet ERKOC-Hakan AYDOGAN");
    
        this.getContentPane().add(lbl);
       this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
