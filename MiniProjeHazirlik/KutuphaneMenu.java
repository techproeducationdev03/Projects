// KutuphaneOduncSistemi paketi altında bir sınıf tanımlandı, bu sınıf menü seçeneklerini işliyor.
package KutuphaneOduncSistemi;

// Java'nın zaman kütüphanesinden LocalDate sınıfı import edildi.
import java.time.LocalDate;
// Java'nın standart kütüphanesinden Scanner sınıfı import edildi.
import java.util.Scanner;

// KutuphaneMenu adında bir public sınıf tanımlandı.
public class KutuphaneMenu {

    // Menü seçeneklerini gösteren bir metot tanımlandı.
    public static void menuGoster() {
        // Kullanıcıya menü seçenekleri gösterildi.
        System.out.println("\nKütüphane Ödünç Sistemi");
        System.out.println("1. Kitap Listesi");
        System.out.println("2. Kitap Ödünç Alma");
        System.out.println("3. Ödünç Kitap İade");
        System.out.println("4. Kullanıcı Bilgileri");
        System.out.println("0. Çıkış");
    }

    // Menü seçeneklerini işleyen bir metot tanımlandı.
    public static void menuSecenekleri(Kutuphane kutuphane, Kullanici kullanici) {
        // Kullanıcı girişi için bir Scanner nesnesi oluşturuldu.
        Scanner scanner = new Scanner(System.in);
        // Kullanıcının seçtiği seçenek.
        int secim;
        // Kullanıcı çıkış yapana kadar menü seçenekleri gösterilir ve işlenir.
        do {
            // Menü gösterilir.
            menuGoster();
            // Kullanıcıdan seçim yapması istenir.
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            // Kullanıcının seçtiği seçeneğe göre işlem yapılır.
            switch (secim) {
                case 1:
                    // Kitap listesi gösterilir.
                    kitapListesiGoster(kutuphane);
                    break;
                case 2:
                    // Kitap ödünç alma işlemi yapılır.
                    kitapOduncAl(kutuphane, kullanici);
                    break;
                case 3:
                    // Kitap iade işlemi yapılır.
                    oduncKitapIadeEt(kutuphane, kullanici);
                    break;
                case 4:
                    // Kullanıcı bilgileri gösterilir.
                    kullaniciBilgileriGoster(kullanici);
                    break;
                case 0:
                    // Çıkış yapılır.
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    // Geçersiz bir seçenek girildiğinde kullanıcı uyarılır.
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        } while (secim != 0); // Kullanıcı çıkış yapana kadar döngü devam eder.
    }

    // Kitap listesini gösteren bir metot tanımlandı.
    private static void kitapListesiGoster(Kutuphane kutuphane) {
        // Kutuphanedeki kitaplar listelenir.
        System.out.println("\nKitap Listesi:");
        for (int i = 0; i < kutuphane.getKitaplar().size(); i++) {
            Kitap kitap = kutuphane.getKitaplar().get(i);
            // Kitabın ödünç durumuna göre durumu belirlenir ve listelenir.
            String durum = kitap.isOduncDurumu() ? "Ödünçte" : "Müsait";
            System.out.println((i + 1) + ". " + kitap.getAd() + " - " + kitap.getYazar() + " (" + durum + ")");
        }
    }

    // Kitap ödünç alma işlemini gerçekleştiren bir metot tanımlandı.
    private static void kitapOduncAl(Kutuphane kutuphane, Kullanici kullanici) {
        // Kullanıcı girişi için bir Scanner nesnesi oluşturuldu.
        Scanner scanner = new Scanner(System.in);
        // Kitap listesi gösterilir.
        kitapListesiGoster(kutuphane);
        // Kullanıcıdan ödünç almak istediği kitabın numarası istenir.
        System.out.print("Ödünç almak istediğiniz kitabın numarasını girin (0: Geri): ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        // Kullanıcı geri dönmek isterse işlem durdurulur.
        if (secim == 0) {
            return;
        }

        int kitapIndex = secim - 1;

        // Seçilen kitap ve kullanıcı türüne göre ödünç alım işlemi yapılır.
        Kitap secilenKitap = kutuphane.getKitaplar().get(kitapIndex);
        int krediDususu = 0;
        switch (kullanici.getTur()) {
            case "Akademisyen":
                // Akademisyen türündeki kullanıcılar için kredi düşüşü belirlendi.
                krediDususu = 10;
                break;
            case "Öğrenci":
                // Öğrenci türündeki kullanıcılar için kredi düşüşü belirlendi.
                krediDususu = 15;
                break;
            case "Personel":
                // Personel türündeki kullanıcılar için kredi düşüşü belirlendi.
                krediDususu = 30;
                break;
        }

        // Kitap ödünç alınabilirse ve kullanıcının kredisi yeterliyse işlem gerçekleştirilir.
        if (!secilenKitap.isOduncDurumu() && kullanici.getKredi() >= krediDususu) {
            // Ödünç alınacak kitap için iade tarihi istenir.
            System.out.print("Kitabı ödünç almak için iade tarihini girin (YYYY-AA-GG): ");
            String iadeTarihiStr = scanner.nextLine();
            // Girilen iade tarihi LocalDate türüne çevrilir.
            LocalDate iadeTarihi = LocalDate.parse(iadeTarihiStr);

            // Kullanıcının kredisinden düşülecek miktar belirlenir.
            kullanici.setKredi(kullanici.getKredi() - krediDususu);
            // Kitap ödünç alındığı için rezerve edilir ve listeden silinir.
            kutuphane.kitapRezerveEt(secilenKitap.getAd());
            kutuphane.kitapSil(secilenKitap.getAd());
            // Ödünç alınan kitap için KitapOdunc sınıfından bir nesne oluşturulur.
            KitapOdunc kitapOdunc = new KitapOdunc(secilenKitap.getAd(), kullanici, kutuphane, iadeTarihi);
            // Kullanıcı bilgileri yazdırılır.
            kullanici.kullaniciBilgileriniYazdir();
            // Ödünç alınan kitabın detayları yazdırılır.
            kitapOdunc.oduncDetaylariniYazdir();
        } else {
            // Seçilen kitap ödünç alınamazsa veya kullanıcının kredisi yetersizse uyarı mesajı gösterilir.
            System.out.println("Seçilen kitap ödünç alınamaz veya krediniz yetersiz.");
        }
    }

    // Ödünç kitap iade işlemini gerçekleştiren bir metot tanımlandı.
    private static void oduncKitapIadeEt(Kutuphane kutuphane, Kullanici kullanici) {
        // Kullanıcı girişi için bir Scanner nesnesi oluşturuldu.
        Scanner scanner = new Scanner(System.in);
        // Kullanıcıdan iade etmek istediği kitabın adı istenir.
        System.out.print("İade etmek istediğiniz kitabın adını girin: ");
        String kitapAdi = scanner.nextLine();

        // Kullanıcının iade etmek istediği kitap kontrol edilir ve iade işlemi gerçekleştirilir.
        for (KitapOdunc oduncKitap : kutuphane.getOduncKitaplar()) {
            if (oduncKitap.getKitapAdi().equals(kitapAdi) && oduncKitap.getKullanici().getAd().equals(kullanici.getAd())) {
                // Kitap rezerve durumundan çıkarılır ve ödünç kitaplar listesinden kaldırılır.
                kutuphane.kitapRezerveKaldir(oduncKitap.getKitapAdi());
                kutuphane.getOduncKitaplar().remove(oduncKitap);
                // İade işlemi başarılı mesajı gösterilir.
                System.out.println("Kitap başarıyla iade edildi.");
                return;
            }
        }

        // Kitap iadesi başarısız olursa uyarı mesajı gösterilir.
        System.out.println("Kitap iadesi başarısız. Lütfen tekrar deneyin.");
    }

    // Kullanıcı bilgilerini gösteren bir metot tanımlandı.
    private static void kullaniciBilgileriGoster(Kullanici kullanici) {
        // Kullanıcı bilgileri ekrana yazdırılır.
        System.out.println("\nKullanıcı Bilgileri:");
        System.out.println("Adı: " + kullanici.getAd());
        System.out.println("Kalan Kredi: " + kullanici.getKredi());

        // Kullanıcının son kitap alma tarihi varsa ekrana yazdırılır.
        if (kullanici.getSonKitapAlmaTarihi() != null) {
            System.out.println("Son Kitap Alma Tarihi: " + kullanici.getSonKitapAlmaTarihi());
        }
    }
}
