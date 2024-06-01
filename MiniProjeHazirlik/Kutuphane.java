// KutuphaneOduncSistemi paketi altında bir sınıf tanımlandı, bu sınıf kütüphane işlemlerini yönetiyor.
package KutuphaneOduncSistemi;

// Java'nın ArrayList ve List sınıfları import edildi.
import java.util.ArrayList;
import java.util.List;

// Kutuphane adında bir public sınıf tanımlandı.
public class Kutuphane {

    // Kütüphane adı, kitaplar listesi ve ödünç alınan kitaplar listesi tanımlandı.
    private String ad;
    private List<Kitap> kitaplar;
    private List<KitapOdunc> oduncKitaplar;

    // Kutuphane sınıfının kurucu metodunda kütüphane adı set edilir, kitaplar ve ödünç alınan kitaplar listeleri oluşturulur.
    public Kutuphane(String ad) {
        this.ad = ad;
        this.kitaplar = new ArrayList<>();
        this.oduncKitaplar = new ArrayList<>();
        // Örnek kitaplar eklenir.
        kitaplarEkle();
    }

    // Kütüphaneye örnek kitaplar ekleyen bir metot tanımlandı.
    private void kitaplarEkle() {
        // Örnek kitaplar listeye eklenir.
        kitaplar.add(new Kitap("Kitap 1", "Yazar A"));
        kitaplar.add(new Kitap("Kitap 2", "Yazar B"));
        kitaplar.add(new Kitap("Kitap 3", "Yazar C"));
        kitaplar.add(new Kitap("Kitap 4", "Yazar D"));
        kitaplar.add(new Kitap("Kitap 5", "Yazar E"));
    }

    // Kütüphane adını döndüren bir metot tanımlandı.
    public String getAd() {
        return ad;
    }

    // Kütüphanedeki kitapları döndüren bir metot tanımlandı.
    public List<Kitap> getKitaplar() {
        return kitaplar;
    }

    // Kütüphanedeki ödünç alınan kitapları döndüren bir metot tanımlandı.
    public List<KitapOdunc> getOduncKitaplar() {
        return oduncKitaplar;
    }

    // Bir kitabın ödünç durumunu true olarak işaretleyen bir metot tanımlandı.
    public void kitapRezerveEt(String kitapAdi) {
        // Kitaplar listesi üzerinde dönülerek belirtilen adı taşıyan kitabın ödünç durumu true olarak işaretlenir.
        for (Kitap kitap : kitaplar) {
            if (kitap.getAd().equals(kitapAdi)) {
                kitap.setOduncDurumu(true);
                break;
            }
        }
    }

    // Bir kitabın ödünç durumunu false olarak işaretleyen bir metot tanımlandı.
    public void kitapRezerveKaldir(String kitapAdi) {
        // Kitaplar listesi üzerinde dönülerek belirtilen adı taşıyan kitabın ödünç durumu false olarak işaretlenir.
        for (Kitap kitap : kitaplar) {
            if (kitap.getAd().equals(kitapAdi)) {
                kitap.setOduncDurumu(false);
                break;
            }
        }
    }

    // Belirtilen adı taşıyan bir kitabı kütüphaneden silen bir metot tanımlandı.
    public void kitapSil(String kitapAdi) {
        // Kitaplar listesi üzerinde dönülerek belirtilen adı taşıyan kitap listeden silinir.
        kitaplar.removeIf(kitap -> kitap.getAd().equals(kitapAdi));
    }
}
