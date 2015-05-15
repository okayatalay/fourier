/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author 1
 */
public class main extends JFrame {
    bilesenler bil=new bilesenler();
    main(){
        setTitle("OKAY ATALAY");
        setVisible(true);
        setSize(600,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(bil);
        setResizable(false);
    }
    public static void main(String[] args) {
        new main();
    }
 
}

