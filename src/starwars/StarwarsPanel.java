/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static starwars.Starwars.fr;
import static starwars.Starwars.harita;
import static starwars.Starwars.iyikarakter;
import static starwars.Starwars.karakterler;
import static starwars.Starwars.iyi;
import static starwars.Starwars.kapilar;
import static starwars.Starwars.karakter;
import static starwars.Starwars.karakterSayisi;

/**
 *
 * @author ufuk
 */
public class StarwarsPanel extends JPanel {

    public StarwarsPanel() {
        Hareket hareket = new Hareket();
        addKeyListener(hareket);
    }

    public static int bitis = -1, k = -1, kontrol;
    public static int[] dizi1;

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        this.setBackground(Color.white);
        int i;
        for (i = 5; i < 80; i += 5) {
            grphcs.drawLine(5 * i, 25, 5 * i, 300);
        }
        for (i = 5; i < 65; i += 5) {
            grphcs.drawLine(25, 5 * i, 375, 5 * i);
        }

        for (int j = 0; j < 11; j++) {
            for (int k = 0; k < 14; k++) {
                if (harita[j][k] == 0) {
                    grphcs.setColor(Color.blue);
                    grphcs.fillRect(((k + 1) * 25) + 1, ((j + 1) * 25) + 1, 24, 24);
                }
            }
        }

        for (i = 0; i < karakterSayisi; i++) {
            if (karakterler[i].equalsIgnoreCase("Stormtrooper")) {
                grphcs.drawImage(new ImageIcon("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\stormtrooper.jpg").getImage(), (25 * karakter[i].getX()) + 1, (25 * (karakter[i].getY())) + 1, 24, 24, null);
            }
            if (karakterler[i].equalsIgnoreCase("Kyloren")) {
                grphcs.drawImage(new ImageIcon("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\kyloren.jpg").getImage(), (25 * karakter[i].getX()) + 1, (25 * (karakter[i].getY())) + 1, 24, 24, null);
            }
            if (karakterler[i].equalsIgnoreCase("Darthvader")) {
                grphcs.drawImage(new ImageIcon("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\darthvader.jpg").getImage(), (25 * karakter[i].getX()) + 1, (25 * (karakter[i].getY())) + 1, 24, 24, null);
                dizi1 = DarthVader.EnKisaYol(karakter[i].getX(), karakter[i].getY(), iyi.getX(), iyi.getY());
            }
        }
        if (k == 1 || k == 0) {
            for (i = 0; i < karakterSayisi; i++) {
                if (karakterler[i].equalsIgnoreCase("Darthvader")) {
                    if (dizi1[0] > 0) {

                        for (int xx = 0; xx < dizi1[0]; xx++) {

                            grphcs.setColor(Color.red);
                            grphcs.fillRect(((karakter[i].getX() - 1 - xx) * 25) + 1, ((karakter[i].getY()) * 25) + 1, 24, 24);

                        }

                        if (dizi1[1] > 0) {

                            for (int xx = 0; xx < dizi1[1]; xx++) {

                                grphcs.setColor(Color.red);
                                grphcs.fillRect(((karakter[i].getX() - dizi1[0]) * 25) + 1, ((karakter[i].getY() - 1 - xx) * 25) + 1, 24, 24);

                            }
                           
                        } else {
                            for (int xx = 0; xx < (dizi1[1] * (-1)); xx++) {

                                grphcs.setColor(Color.red);
                                grphcs.fillRect(((karakter[i].getX() - dizi1[0]) * 25) + 1, ((karakter[i].getY() + 1 + xx) * 25) + 1, 24, 24);

                            }
                        
                        }
                        
                        karakter[i].setX(karakter[i].getX() - 1);
                        
                    }

                    if (dizi1[0] <= 0) {

                        for (int xx = dizi1[0]; xx >0; xx++) {

                            grphcs.setColor(Color.red);
                            grphcs.fillRect(((karakter[i].getX() + 1 + xx) * 25) + 1, ((karakter[i].getY()) * 25) + 1, 24, 24);

                        }
                        if (dizi1[1] > 0) {

                             for (int xx = 0; xx < dizi1[1]; xx++) {

                                grphcs.setColor(Color.red);
                                grphcs.fillRect(((karakter[i].getX() - dizi1[0]) * 25) + 1, ((karakter[i].getY() - 1 - xx) * 25) + 1, 24, 24);

                            }
                            if (dizi1[0] == 0) {
                                karakter[i].setY(karakter[i].getY() - 1);
                            }
                        } else {
                            for (int xx = 0; xx < (dizi1[1] * (-1)); xx++) {

                                grphcs.setColor(Color.red);
                                grphcs.fillRect(((karakter[i].getX() - dizi1[0]) * 25) + 1, ((karakter[i].getY() + 1 + xx) * 25) + 1, 24, 24);

                            }
                            if (dizi1[0] == 0) {
                                karakter[i].setY(karakter[i].getY() + 1);
                            }
                        }
                        if (dizi1[0] < 0) {
                            karakter[i].setX(karakter[i].getX() + 1);
                        }
                    }
                }
            }
        }

        BufferedImage image = null;
        if (iyikarakter == 0) {
            try {
                image = ImageIO.read(new File("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\masteryoda.jpg"));

            } catch (IOException ex) {
                Logger.getLogger(StarwarsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            grphcs.drawImage(image.getScaledInstance(24, 24, 0), (iyi.getX() * 25) + 1, (iyi.getY() * 25) + 1, null);
            
        } else if (iyikarakter == 1) {
            try {
                image = ImageIO.read(new File("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\lukeskywalker.jpg"));

            } catch (IOException ex) {
                Logger.getLogger(StarwarsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            grphcs.drawImage(image.getScaledInstance(24, 24, 0), (iyi.getX() * 25) + 1, (iyi.getY() * 25) + 1, null);
        }

        if (bitis == 1) {
            Color yeniRenk = Color.decode("#009bff");
            grphcs.setColor(yeniRenk);
            grphcs.fillRect(0, 0, 425, 375);
            try {
                image = ImageIO.read(new File("C:\\Users\\ufuk\\Documents\\NetBeansProjects\\starwars\\kupa.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(StarwarsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            grphcs.drawImage(image.getScaledInstance(100, 100, 0), 150, 100, null);
            grphcs.setColor(Color.black);
            grphcs.drawString("KAZANDINIZ", 165, 250);
        }
        
        if(bitis == 0){
            grphcs.setColor(Color.red);
            grphcs.fillRect(0, 0, 425, 375);
            grphcs.setColor(Color.black);
            grphcs.drawString("KAYBETTİNİZ", 165, 250);
        }
        if(iyikarakter == 1){
            grphcs.setColor(Color.black);
            LukeSkywalker luke = (LukeSkywalker) iyi;
            String can = String.valueOf(luke.getCan());
            grphcs.drawString(can, 390, 20);
        } else if(iyikarakter == 0){
            grphcs.setColor(Color.black);
            MasterYoda master = (MasterYoda) iyi;
            String can = String.valueOf(master.getCan());
            grphcs.drawString(can, 390, 20);
        }
        
        
    }

    public class Hareket extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            super.keyPressed(ke);
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    k = yolHesap(iyi.getX() - 1, iyi.getY());
                    if (k == 1) {
                        iyi.setX(iyi.getX() - 1);
                    }
                    Kontrol();
                    break;
                case KeyEvent.VK_RIGHT:
                    k = yolHesap(iyi.getX() + 1, iyi.getY());
                    if (k == 1) {
                        if (iyi.getX() == 13) {
                            bitis = 1;
                        }
                        iyi.setX(iyi.getX() + 1);
                    }
                    Kontrol();
                    break;
                case KeyEvent.VK_UP:
                    k = yolHesap(iyi.getX(), iyi.getY() - 1);
                    if (k == 1) {
                        iyi.setY(iyi.getY() - 1);
                    }
                    Kontrol();
                    break;
                case KeyEvent.VK_DOWN:
                    k = yolHesap(iyi.getX(), iyi.getY() + 1);
                    if (k == 1) {
                        iyi.setY(iyi.getY() + 1);
                    }
                    Kontrol();
                    break;
            }
            repaint();
        }
    }

    public static int yolHesap(int x, int y) {
        if (x <= 14 && y <= 11 && x >= 1 && y >= 1) {
            if (harita[y - 1][x - 1] != 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    public static void Kontrol(){
        for (int i = 0; i < karakterSayisi; i++) {
            if (karakterler[i].equalsIgnoreCase("Darthvader")) {
                if(karakter[i].getX() == iyi.getX() && karakter[i].getY() == iyi.getY()){
                    if(iyikarakter == 0){
                        MasterYoda master = (MasterYoda) iyi;
                        kontrol = master.getCan();
                        master.setCan(master.getCan() - 1);
                        if(master.getCan() == 0){
                            bitis = 0;
                        } else if(kontrol > master.getCan()){
                            fr.dispose();
                            Yeniatama();
                            fr = new StarwarsFrame();
                            fr.setSize(425, 375);//400 350
                            k = -1;
                            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            fr.setTitle("Starwars");
                            fr.setLocationRelativeTo(null);
                            fr.setVisible(true);
                        }
                    }
                    if(iyikarakter == 1){
                        LukeSkywalker luke = (LukeSkywalker) iyi;
                        kontrol = luke.getCan();
                        luke.setCan(luke.getCan() - 1);
                        if(luke.getCan() == 0){
                            bitis = 0;
                        } else if(kontrol > luke.getCan()){
                            fr.dispose();
                            Yeniatama();
                            fr = new StarwarsFrame();
                            fr.setSize(425, 375);//400 350
                            k = -1;
                            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            fr.setTitle("Starwars");
                            fr.setLocationRelativeTo(null);
                            fr.setVisible(true);
                        }
                    }
                }
            }
        }
    }
    
    public static void Yeniatama(){
        iyi.setX(7);
        iyi.setY(6);
        for (int j = 0; j < karakterSayisi; j++) {
            if (kapilar[j].equalsIgnoreCase("A")) {
                karakter[j].setX(1);
                karakter[j].setY(6);
            }
            if (kapilar[j].equalsIgnoreCase("B")) {
                karakter[j].setX(5);
                karakter[j].setY(1);
            }
            if (kapilar[j].equalsIgnoreCase("C")) {
                karakter[j].setX(13);
                karakter[j].setY(1);
            }
            if (kapilar[j].equalsIgnoreCase("D")) {
                karakter[j].setX(14);
                karakter[j].setY(6);
            }
            if (kapilar[j].equalsIgnoreCase("E")) {
                karakter[j].setX(5);
                karakter[j].setY(11);
            }
        }
    }

}
