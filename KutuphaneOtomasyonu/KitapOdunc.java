// KutuphaneOduncSistemi paketi altında bir sınıf tanımlandı, bu sınıf ödünç alınan kitapların detaylarını temsil ediyor.
package KutuphaneOduncSistemi;

// Java'nın zaman kütüphanesinden LocalDate sınıfı import edildi.
import java.time.LocalDate;

// KitapOdunc adında bir public sınıf tanımlandı.
public class KitapOdunc {

    // Kitap adı, kullanıcı, kütüphane ve iade tarihi özellikleri tanımlandı.
    private String kitapAdi;
    private Kullanici kullanici;
    private Kutuphane kutuphane;
    private LocalDate iadeTarihi;

    // KitapOdunc sınıfının kurucu metodunda kitap adı, kullanıcı, kütüphane ve iade tarihi bilgileri alınır.
    public KitapOdunc(String kitapAdi, Kullanici kullanici, Kutuphane kutuphane, LocalDate iadeTarihi) {
        this.kitapAdi = kitapAdi;
        this.kullanici = kullanici;
        this.kutuphane = kutuphane;
        this.iadeTarihi = iadeTarihi;
        // Ödünç alınan kitap, kütüphanenin ödünç kitaplar listesine eklenir.
        kutuphane.getOduncKitaplar().add(this);
    }

    // Kitabın adını döndüren bir metot tanımlandı.
    public String getKitapAdi() {
        return kitapAdi;
    }

    // Kitabın adını ayarlayan bir metot tanımlandı.
    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    // Kitabı ödünç alan kullanıcıyı döndüren bir metot tanımlandı.
    public Kullanici getKullanici() {
        return kullanici;
    }

    // Kitabı ödünç alan kullanıcıyı ayarlayan bir metot tanımlandı.
    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    // Kitabın ödünç alındığı kütüphaneyi döndüren bir metot tanımlandı.
    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    // Kitabın ödünç alındığı kütüphaneyi ayarlayan bir metot tanımlandı.
    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    // Kitabın iade tarihini döndüren bir metot tanımlandı.
    public LocalDate getIadeTarihi() {
        return iadeTarihi;
    }

    // Kitabın iade tarihini ayarlayan bir metot tanımlandı.
    public void setIadeTarihi(LocalDate iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

    // Ödünç alınan kitabın detaylarını yazdıran bir metot tanımlandı.
    public void oduncDetaylariniYazdir() {
        // Ödünç detayları ekrana yazdırılır.
        System.out.println("*".repeat(42));
        System.out.println("------- Ödünç Detayı -------");
        System.out.println("Kitap Adı: " + this.kitapAdi);
        System.out.println("Kütüphane: " + this.kutuphane.getAd());
        System.out.println("Kullanıcı: " + this.kullanici.getAd());
        System.out.println("İade Tarihi: " + this.iadeTarihi);
        System.out.println("*".repeat(42));
    }
}
