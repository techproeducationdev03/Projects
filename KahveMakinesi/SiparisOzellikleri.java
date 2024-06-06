package KahveMakinesi;

public class SiparisOzellikleri {
    private String sut;
    private String seker;
    private int kacSeker;
    private String boyut;

    public void setSut(String sut){
        if (sut.equals("evet")){
            System.out.println("Süt ekleniyor...");
        } else if (sut.equals("hayır")){
            System.out.println("Süt eklenmiyor.");
        }
        this.sut = sut;
    }

    public void setSeker(String seker,int kacSeker){
        if (seker.equals("evet")){
            System.out.println(kacSeker + " şeker ekleniyor...");
        } else if (seker.equals("hayır")) {
            System.out.println("Şeker eklenmiyor.");
        }
        this.seker = seker;
        this.kacSeker = kacSeker;

    }

    public void setBoyut(String boyut){
        switch (boyut){
            case "büyük boy" :
                System.out.println("Kahveniz " + boyut + " hazırlanıyor..");
                break;
            case "orta boy" :
                System.out.println("Kahveniz " + boyut + " hazırlanıyor..");
                break;
            case "küçük boy" :
                System.out.println("Kahveniz " + boyut + " hazırlanıyor..");
                break;

        }
        this.boyut = boyut;

    }
    public String boyutYazdır(){
        return boyut;
    }
}


