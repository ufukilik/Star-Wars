
package starwars;


public class KyloRen extends Karakter{
    
    public KyloRen(int x, int y, String Ad, String Tur) {
        super(x, y, Ad, Tur);
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
