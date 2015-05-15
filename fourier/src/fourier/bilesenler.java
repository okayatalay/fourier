/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author 1
 */
public class bilesenler extends JPanel {

    private static JButton butonciz = new JButton("ÇİZ");
    private static JTextArea textfrekans = new JTextArea("0.3");
    private static JTextArea textgenlik = new JTextArea("80");
    private static JTextArea textharmonik = new JTextArea("7");
    private static Fourier grafik = new Fourier();
    private static JPanel panel2 = new JPanel();
    private static JPanel panelCombolar = new JPanel();
    private static JPanel panelCombolarVEpanel2 = new JPanel();
    private static JLabel hata_etiket = new JLabel("");
    private static JComboBox combobox = new JComboBox();
    private static JComboBox kalemcombox = new JComboBox();

    public bilesenler() {
        butonciz.setPreferredSize(new Dimension(100, 20));
        textfrekans.setPreferredSize(new Dimension(50, 20));
        textgenlik.setPreferredSize(new Dimension(50, 20));
        textharmonik.setPreferredSize(new Dimension(50, 20));
        setLayout(new BorderLayout());
        setBackground(Color.white);

        combobox.addItem("Düşük");
        combobox.addItem("Orta");
        combobox.addItem("Normal");
        combobox.addItem("Yüksek");
        combobox.addItem("Çok Yüksek");

        kalemcombox.addItem("Kalin Çizgi");
        kalemcombox.addItem("Normal Çizgi");
        kalemcombox.addItem("İnce Çizgi");

        panel2.add(new JLabel("Frekans"));
        panel2.add(textfrekans);
        panel2.add(new JLabel("Genlik"));
        panel2.add(textgenlik);
        panel2.add(new JLabel("Harmonik"));
        panel2.add(textharmonik);
        panel2.add(new JLabel(""));
        panel2.add(butonciz);

        panelCombolar.add(new JLabel("Grafik kalitesi:"));
        panelCombolar.add(combobox);
        panelCombolar.add(new JLabel(" Kalem Boyutu:"));
        panelCombolar.add(kalemcombox);
        panelCombolar.add(hata_etiket);
        hata_etiket.setForeground(Color.red);

        panelCombolarVEpanel2.setLayout(new BorderLayout());
        panelCombolarVEpanel2.add(panel2, BorderLayout.NORTH);
        panelCombolarVEpanel2.add(panelCombolar, BorderLayout.CENTER);

        add(panelCombolarVEpanel2, BorderLayout.NORTH);
        add(grafik, BorderLayout.CENTER);

        butonciz.addActionListener(new olay_dinleyici());

    }

    public class olay_dinleyici implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (kalemcombox.getSelectedItem().toString()) {
                case "Kalin Çizgi":
                    grafik.Cizgi = 1.0;
                    break;
                case "Normal Çizgi":
                    grafik.Cizgi = 0.5;
                    break;
                case "İnce Çizgi":
                    grafik.Cizgi = 0.001;
                    break;
            }
            switch (combobox.getSelectedItem().toString()) {
                case "Düşük":
                    grafik.kalite1 = 0.1;
                    grafik.kalite2 = 0.05;
                    break;
                case "Orta":
                    grafik.kalite1 = 0.05;
                    grafik.kalite2 = 0.03;
                    break;
                case "Normal":
                    grafik.kalite1 = 0.02;
                    grafik.kalite2 = 0.008;
                    break;
                case "Yüksek":
                    grafik.kalite1 = 0.01;
                    grafik.kalite2 = 0.003;
                    break;
                case "Çok Yüksek":
                    grafik.kalite1 = 0.005;
                    grafik.kalite2 = 0.0003;
                    break;
            }
            try {
                grafik.N = Integer.valueOf(textharmonik.getText());
                grafik.V = Integer.valueOf(textgenlik.getText());
                grafik.f = Double.valueOf(textfrekans.getText());
                grafik.repaint();
                hata_etiket.setText("");

            } catch (NumberFormatException n) {
                hata_etiket.setText("Hatalı Değer");
            }
        }

    }

}
