// KutuphaneOduncSistemi paketi altında bir sınıf tanımlandı, bu sınıf kitapları temsil ediyor.
package KutuphaneOduncSistemi;

// Kitap adında bir public sınıf tanımlandı.
public class Kitap {

    // Kitabın adı, yazarı ve ödünç durumu özellikleri tanımlandı.
    private String ad;
    private String yazar;
    private boolean oduncDurumu;

    // Kitap sınıfının kurucu metodunda kitabın adı, yazarı ve ödünç durumu set edilir.
    public Kitap(String ad, String yazar) {
        this.ad = ad;
        this.yazar = yazar;
        this.oduncDurumu = false;
    }

    // Kitabın adını döndüren bir metot tanımlandı.
    public String getAd() {
        return ad;
    }

    // Kitabın adını ayarlayan bir metot tanımlandı.
    public void setAd(String ad) {
        this.ad = ad;
    }

    // Kitabın yazarını döndüren bir metot tanımlandı.
    public String getYazar() {
        return yazar;
    }

    // Kitabın yazarını ayarlayan bir metot tanımlandı.
    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    // Kitabın ödünç durumunu döndüren bir metot tanımlandı.
    public boolean isOduncDurumu() {
        return oduncDurumu;
    }

    // Kitabın ödünç durumunu ayarlayan bir metot tanımlandı.
    public void setOduncDurumu(boolean oduncDurumu) {
        this.oduncDurumu = oduncDurumu;
    }
}
