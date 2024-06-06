package KahveMakinesi;

public class Espresso extends Kahve{
    @Override
    public String hazirla (){
        return "Espresso hazırlanıyor";


    }
    @Override
    public String getKahveTuru(){
        return "Espresso";
    }


}
