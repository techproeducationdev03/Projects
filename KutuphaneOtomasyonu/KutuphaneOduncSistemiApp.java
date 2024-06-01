// Bu sınıf main metodu içeriyor program buradan yürütülüyor, projenin runner class'ıdır.
package KutuphaneOduncSistemi;

// Java kütüphanesinden Scanner sınıfı import edildi.
import java.util.Scanner;

// KutuphaneOduncSistemiApp adında bir public sınıf tanımlanıyor.
public class KutuphaneOduncSistemiApp {

    // Ana metot (main method) tanımlanıyor.
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için bir Scanner nesnesi oluşturuldu.
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıya hoş geldiniz mesajı yazıldı.
        System.out.println("Kütüphane Ödünç Sistemi'ne Hoş Geldiniz!");

        // Kullanıcıdan kullanıcı adı alındı.
        System.out.print("Kullanıcı Adınızı Girin: ");
        String kullaniciAdi = scanner.nextLine();

        // Kullanıcıya kullanıcı türünü seçmesi istendi (1: Akademisyen, 2: Öğrenci, 3: Personel).
        System.out.print("Kullanıcı Türünüzü Seçin (1: Akademisyen, 2: Öğrenci, 3: Misafir): ");
        int kullaniciTur = scanner.nextInt();
        scanner.nextLine();

        // Kullanıcının seçtiği türe göre uygun metni belirlemek için switch-case yapısı kullanıldı.
        String tur = "";
        switch (kullaniciTur) {
            case 1:
                tur = "Akademisyen";
                break;
            case 2:
                tur = "Öğrenci";
                break;
            case 3:
                tur = "Personel";
                break;
            default:
                // Geçersiz kullanıcı türü durumunda kullanıcı bilgilendirildi ve varsayılan olarak Öğrenci atanır.
                System.out.println("Geçersiz kullanıcı türü. Varsayılan olarak Misafir olarak devam edilecek.");
                tur = "Öğrenci";
        }

        // Kullanıcı nesnesi oluşturuldu ve bilgileri kullanıcı adı, limiti (100) ve türü ile atandı.
        Kullanici kullanici = new Kullanici(kullaniciAdi, 100, tur);

        // Kutuphane nesnesi oluşturuldu ve adı "Örnek Kutuphane" olarak atandı.
        Kutuphane kutuphane = new Kutuphane("Örnek Kutuphane");

        // KutuphaneMenu sınıfından menuSecenekleri metodu çağrıldı ve kullanıcıya menü seçenekleri sunuldu.
        KutuphaneMenu.menuSecenekleri(kutuphane, kullanici);
    }
}
