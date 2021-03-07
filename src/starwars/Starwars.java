package starwars;

import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Starwars {

    public static String[] karakterler, kapilar;
    public static int karakterSayisi = 0;
    public static int[][] harita;
    public static Karakter[] karakter;
    public static Karakter iyi;
    public static int iyikarakter;
    public static StarwarsFrame fr;

    public static void main(String[] args) throws IOException {
        fr = new StarwarsFrame();
        fr.setSize(425, 375);//400 350
        fr.setTitle("Starwars");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(false);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("------ İyi karakteri seciniz ------");
        System.out.print("Master Yoda icin 0, Luke Skywalker icin 1 giriniz : ");
        do {
            iyikarakter = sc.nextInt();
        } while (iyikarakter != 1 && iyikarakter != 0);
        if (iyikarakter == 0) {
            iyi = new MasterYoda(7, 6, "Master Yoda", "iyi", 6);// 176 151
        }
        if (iyikarakter == 1) {
            iyi = new LukeSkywalker(7, 6, "Luke Skywalker", "iyi", 3);
        }

        File file = new File("Harita.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        int ikinokta1, ikinokta2, virgul;
        karakterler = new String[6];
        kapilar = new String[6];
        harita = new int[11][14];
        int sayac = 0;
        String yedek;
        while ((line = br.readLine()) != null) {
            ikinokta1 = line.indexOf(":");
            if (ikinokta1 != -1) {
                virgul = line.indexOf(",");
                karakterler[karakterSayisi] = line.substring(ikinokta1 + 1, virgul);
                ikinokta2 = line.lastIndexOf(":");
                kapilar[karakterSayisi] = line.substring(ikinokta2 + 1);
                karakterSayisi++;
            } else {
                yedek = line.replaceAll("\\s", "");
                for (int j = 0; j < 14; j++) {
                    harita[sayac][j] = yedek.charAt(j) - '0';
                }
                sayac++;
            }
        }
        br.close();

        karakter = new Karakter[karakterSayisi];

        for (int i = 0; i < karakterSayisi; i++) {
            if (karakterler[i].equalsIgnoreCase("Stormtrooper")) {
                karakter[i] = new Stormtrooper(0, 0, "Stormtrooper", "kotu");
            } else if (karakterler[i].equalsIgnoreCase("Darthvader")) {
                karakter[i] = new DarthVader(0, 0, "Darth Vader", "kotu");
            } else if (karakterler[i].equalsIgnoreCase("Kyloren")) {
                karakter[i] = new KyloRen(0, 0, "Kylo Ren", "kotu");
            }
        }

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

        
        
        fr.setVisible(true);//ilk başta false olacak.
        
    }

}
