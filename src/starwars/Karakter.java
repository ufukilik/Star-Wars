package starwars;


public class Karakter extends Lokasyon{
    protected String Ad;
    protected String Tur;

    public Karakter(int x, int y, String Ad, String Tur) {
        super(x, y);
        this.Ad = Ad;
        this.Tur = Tur;
    }
    
    public String getAd(){
        return Ad;
    }
    
    public void setAd(String Ad){
        this.Ad = Ad;
    }
    
    public String getTur(){
        return Tur;
    }
    
    public void setTur(String Tur){
        this.Tur = Tur;
    }
    
    
    public static int[] EnKisaYol(int q1,int q2 ,int q3,int q4){
      
        int xmesafe=q1-q3;
        int ymesafe=q2-q4;
        int[] dizi=new int[2];
        dizi[0]=xmesafe;
        dizi[1]=ymesafe;
        return dizi;
    }
    
}
