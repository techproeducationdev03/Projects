import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class YilanOyunu {
    public static final int terminalGenislik = 20;
    public static final int terminalYukseklik = 10;
    public static LinkedList<Point> yilan = new LinkedList<>();
    public static int fareX, fareY;
    public static int oyuncuPuani = 0;
    public static boolean oyunDevamEdiyor = true;
    public static int kalanCanlar = 3;

    public static void main(String[] args) {
        baslangicAyarları();
        Scanner input = new Scanner(System.in);

        while (oyunDevamEdiyor && kalanCanlar > 0) {
            ekranıTemizleVeYazdır();
            if (input.hasNext()) {
                char yon = input.next().charAt(0);
                yilaniHareketEttir(yon);
                yemiKontrolEt();
                carpismaKontrolu();
            }
        }
        System.out.println("Oyun Bitti! Skorunuz: " + oyuncuPuani);
        input.close();
    }

    private static void baslangicAyarları() {
        Random rand = new Random();
        int baslangicX = rand.nextInt(terminalGenislik - 2) + 1;
        int baslangicY = rand.nextInt(terminalYukseklik - 2) + 1;
        yilan.clear();
        yilan.add(new Point(baslangicX, baslangicY)); // Yılan başlangıçta rastgele bir yerde başlar
        yerlestirYeniYem();
    }

    private static void ekranıTemizleVeYazdır() {
        System.out.print("\033[H\033[2J"); // Terminali temizler
        System.out.flush();

        for (int y = 0; y < terminalYukseklik; y++) {
            for (int x = 0; x < terminalGenislik; x++) {
                if (x == 0 || x == terminalGenislik - 1 || y == 0 || y == terminalYukseklik - 1) {
                    System.out.print("#");
                } else if (yilan.contains(new Point(x, y))) {
                    System.out.print("*");
                } else if (x == fareX && y == fareY) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("Puan: " + oyuncuPuani + " | Kalan Canlar: " + kalanCanlar);
    }

    private static void yilaniHareketEttir(char yon) {
        Point yeniBas = new Point(yilan.getFirst());
        switch (yon) {
            case 'w': yeniBas.translate(0, -1); break;
            case 's': yeniBas.translate(0, 1); break;
            case 'a': yeniBas.translate(-1, 0); break;
            case 'd': yeniBas.translate(1, 0); break;
        }

        if (yeniBas.x < 1 || yeniBas.x >= terminalGenislik - 1 || yeniBas.y < 1 || yeniBas.y >= terminalYukseklik - 1) {
            kalanCanlar -= 1;
            if (kalanCanlar > 0) {
                System.out.println("Sınırlara çarptınız! Kalan can: " + kalanCanlar);
                baslangicAyarları(); // Yılanı başlangıç konumuna sıfırla
            } else {
                oyunDevamEdiyor = false;
                System.out.println("Canınız kalmadı! Oyun bitti.");
            }
        } else {
            yilan.addFirst(yeniBas);
            if (yilan.size() > 1) {
                yilan.removeLast();
            }
        }
        carpismaKontrolu(); // Kendi üzerine çarpma kontrolü
    }

    private static void yemiKontrolEt() {
        Point kafa = yilan.getFirst();
        if (kafa.x == fareX && kafa.y == fareY) {
            oyuncuPuani += 10;
            Point sonSegment = yilan.getLast();
            Point yeniSegment = new Point(sonSegment);

            if (yilan.size() > 1) {
                Point ondanOncekiSegment = yilan.get(yilan.size() - 2);
                if (sonSegment.x == ondanOncekiSegment.x) {
                    yeniSegment.y = sonSegment.y + (sonSegment.y > ondanOncekiSegment.y ? 1 : -1);
                } else {
                    yeniSegment.x = sonSegment.x + (sonSegment.x > ondanOncekiSegment.x ? 1 : -1);
                }
            } else {
                // Eğer yılan sadece bir segmentten oluşuyorsa, varsayılan bir yönde uzat
                yeniSegment.y += 1;
            }

            yilan.addLast(yeniSegment);
            yerlestirYeniYem();
        }
    }

    private static void carpismaKontrolu() {
        Point kafa = yilan.getFirst();
        for (int i = 1; i < yilan.size(); i++) {
            if (kafa.equals(yilan.get(i))) {
                kalanCanlar -= 1;
                if (kalanCanlar > 0) {
                    System.out.println("Kendi üzerinize geldiniz! Kalan can: " + kalanCanlar);
                    baslangicAyarları(); // Yılanı başlangıç konumuna sıfırla
                } else {
                    oyunDevamEdiyor = false;
                    System.out.println("Canınız kalmadı! Oyun bitti.");
                }
                break;
            }
        }
    }



    private static void yerlestirYeniYem() {
        Random rand = new Random();
        fareX = rand.nextInt(terminalGenislik - 2) + 1; // Yemin X koordinatı
        fareY = rand.nextInt(terminalYukseklik - 2) + 1; // Yemin Y koordinatı
    }
}