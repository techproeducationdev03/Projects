// KutuphaneOduncSistemi paketi altında bir sınıf tanımlandı, bu sınıf kullanıcı bilgilerini temsil ediyor.
package KutuphaneOduncSistemi;

// Java'nın zaman kütüphanesinden LocalDate sınıfı import edildi.
import java.time.LocalDate;

// Kullanici adında bir public sınıf tanımlandı.
public class Kullanici {

    // Kullanıcının adı, kredisi, türü ve son kitap alma tarihi özellikleri tanımlandı.
    private String ad;
    private int kredi;
    private String tur;
    private LocalDate sonKitapAlmaTarihi;

    // Kullanıcı sınıfının kurucu metodunda ad, kredi ve tür bilgileri alınır.
    public Kullanici(String ad, int kredi, String tur) {
        this.ad = ad;
        this.kredi = kredi;
        this.tur = tur;
    }

    // Kullanıcının adını döndüren bir metot tanımlandı.
    public String getAd() {
        return ad;
    }

    // Kullanıcının kredisini döndüren bir metot tanımlandı.
    public int getKredi() {
        return kredi;
    }

    // Kullanıcının kredisini ayarlayan bir metot tanımlandı.
    public void setKredi(int kredi) {
        this.kredi = kredi;
    }

    // Kullanıcının türünü döndüren bir metot tanımlandı.
    public String getTur() {
        return tur;
    }

    // Kullanıcının son kitap alma tarihini döndüren bir metot tanımlandı.
    public LocalDate getSonKitapAlmaTarihi() {
        return sonKitapAlmaTarihi;
    }

    // Kullanıcının son kitap alma tarihini ayarlayan bir metot tanımlandı.
    public void setSonKitapAlmaTarihi(LocalDate sonKitapAlmaTarihi) {
        this.sonKitapAlmaTarihi = sonKitapAlmaTarihi;
    }

    // Kullanıcının bilgilerini yazdıran bir metot tanımlandı.
    public void kullaniciBilgileriniYazdir() {
        // Kullanıcı bilgileri ekrana yazdırılır.
        System.out.println("\nKullanıcı Bilgileri:");
        System.out.println("Adı: " + ad);
        System.out.println("Kalan Kredi: " + kredi);

        // Kullanıcının son kitap alma tarihi varsa ekrana yazdırılır.
        if (sonKitapAlmaTarihi != null) {
            System.out.println("Son Kitap Alma Tarihi: " + sonKitapAlmaTarihi);
        }
    }
}
