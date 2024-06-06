package KahveMakinesi;

import java.util.Scanner;

public class KahveMakinesiApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Hangi kahveyi istersiniz? Çıkmak için çıkış yazınız.");
            System.out.println("1. Türk Kahvesi");
            System.out.println("2. Filtre Kahve");
            System.out.println("3. Espresso");

            String hangiKahve = sc.nextLine().toLowerCase();
            if (hangiKahve.equals("çıkış")) {
                System.out.println("çıkış yapılıyor.. ");
                break;
            }
            Kahve kahve;

            switch (hangiKahve) {
                case "türk kahvesi":
                    kahve = new TurkKahvesi();
                    break;
                case "filtre kahve":
                    kahve = new FiltreKahve();
                    break;
                case "espresso":
                    kahve = new Espresso();
                    break;
                default:
                    System.out.println("Hatalı tuşlama yaptınız.");
                    continue;

            }
            System.out.println(kahve.hazirla());

            SiparisOzellikleri siparisOzellikleri = new SiparisOzellikleri();

            String sut;
            while (true) {
                System.out.println("Süt eklemek ister misiniz? Evet ya da hayır yazabilirsiniz.");
                sut = sc.nextLine().toLowerCase();

                if (sut.equals("evet") || sut.equals("hayır")) {
                    siparisOzellikleri.setSut(sut);
                    break;
                } else {
                    System.out.println("Hatalı girdiniz, lütfen 'evet' ya da 'hayır' yazınız.");
                }
            }

            String seker;
            while (true) {
                System.out.println("Şeker ister misiniz? Evet ya da hayır yazabilirsiniz.");
                seker = sc.nextLine().toLowerCase();

                if (seker.equals("evet")) {
                    int kacSeker;
                    while (true) {
                        System.out.println("Kaç şeker olsun?");
                        String kacSekerStr = sc.nextLine();
                        try {
                            kacSeker = Integer.parseInt(kacSekerStr);
                            if (kacSeker >= 0) {
                                siparisOzellikleri.setSeker(seker, kacSeker);
                                break;
                            } else {
                                System.out.println("Hatalı girdiniz, lütfen pozitif bir sayı giriniz.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Hatalı girdiniz, lütfen tekrar deneyiniz.");
                        }
                    }
                    break;
                } else if (seker.equals("hayır")) {
                    siparisOzellikleri.setSeker(seker, 0);
                    break;
                } else {
                    System.out.println("Hatalı girdiniz, lütfen 'evet' ya da 'hayır' yazınız.");
                }
            }

            String boyut;

            while (true) {
                System.out.println("Hangi boyutta olsun? Büyük boy-Orta boy-Küçük boy");
                boyut = sc.nextLine().toLowerCase();

                if (boyut.equals("büyük boy") || boyut.equals("orta boy") || boyut.equals("küçük boy")) {
                    break;
                } else {
                    System.out.println("Hatalı girdiniz, lütfen tekrar deneyiniz.");
                }

            }
            siparisOzellikleri.setBoyut(boyut);
            System.out.println(kahve.getKahveTuru() + " " + siparisOzellikleri.boyutYazdır() + " hazırdır afiyet olsun.");
            break;

        }
            sc.close();
    }
}
