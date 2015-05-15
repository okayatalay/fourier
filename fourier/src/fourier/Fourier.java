/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sin;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import java.util.concurrent.*;

public class Fourier extends JLabel {

    Integer N = 7;
    Double PI = Math.PI;
    Double f = 0.3;  // frekans
    Integer V = 80; // genlik
    Double Cizgi = 1.0;
    Double w = 0.0;
    Long basla, bitis;
    Double kalite1 = 0.02, kalite2 = 0.002; //çizgi kalitesi

    @Override
    protected void paintComponent(Graphics g) {
        basla = System.currentTimeMillis();
        w = (2 * PI * f);
        koordinat(g);
        g.setColor(Color.black);
        //sinc(t) fonksiyonu
        /*for (double i = 0; i < 560; i = i + 0.0002) {
            g.drawLine(
                    (int) i + 30,
                    (int) (300 - (200 * sin(Radyan(i) * PI) / (PI * Radyan(i)))),
                    (int) (i + 30 + Cizgi),
                    (int) (300 - (200 * sin(Radyan(i) * PI) / (PI * Radyan(i))))
            );
        }*/
        for (int j = 1; j < N + 1; j += 2) {
            for (double i = 0; i < 560; i = i + kalite1) {
                g.drawLine(
                        (int) i + 30,
                        (int) (300 - (4 * V / (j * PI)) * sin(j * w * Radyan(i)) ),
                        (int) (i + 30 + Cizgi),
                        (int) (300 - (4 * V / (j * PI)) * sin(j * w * Radyan(i)) )
                );
            }
        }
        g.setColor(Color.blue);
        for (double i = 0; i < 560; i = i + kalite2) {
            g.drawLine(
                    (int) i + 30,
                    (int) (300 - ana_grafik(Radyan(i))),
                    (int) (i + 30 + Cizgi),
                    (int) (300 - ana_grafik(Radyan(i)))
            );
        }
        bitis = System.currentTimeMillis();
        g.drawString("Gecen Süre: " + String.valueOf((double) (bitis - basla) / 1000) + " Saniye", 200, 15);
    }

    double ana_grafik(double i) {
        double toplam = 0;
        for (int j = 1; j < N + 1; j += 2) {
            toplam += (sin(j * w * i)) / j;
        }
        toplam = (4 * V) / (PI) * toplam;
        return toplam; //double toplam=0;for(int j=1;j<N+1;j+=2) toplam+=((4*V)/(PI*j)) * (sin(j*w*i));return toplam;     
    }

    void koordinat(Graphics g) {
        //x-y düzlemi
        g.drawLine(30, 0, 30, 600); //y ekseni
        g.drawLine(30, 300, 600, 300);//x ekseni
        g.drawLine(30, 301, 600, 301);//x ekseni
        g.drawLine(30, 299, 600, 299);//x ekseni
        //y-eksenindeki bilgiler
        g.drawString("40", 0, 260);
        g.drawString("80", 0, 220);
        g.drawString("120", 0, 180);
        g.drawString("160", 0, 140);
        g.drawString("200", 0, 100);
        g.drawString("240", 0, 60);
        g.drawString("0", 10, 305);
        g.drawString("-40", 0, 340);
        g.drawString("-80", 0, 380);
        g.drawString("-120", 0, 420);
        g.drawString("-160", 0, 460);
        g.drawString("-200", 0, 500);
        g.drawString("-240", 0, 540);
        kesik_cizgiler(g);
    }

    void kesik_cizgiler(Graphics g) {
        for (int j = 60; j < 541; j = j + 40) {
            for (int i = 0; i < 560; i += 10) {
                g.drawLine(30 + i, j, 31 + i, j);
            }
        }
    }

    double Radyan(double i) {
        return i * PI / 180;
    }

}
