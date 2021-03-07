
package starwars;


public class LukeSkywalker extends Karakter{
    private int can;
    
    public LukeSkywalker(int x, int y, String Ad, String Tur, int can) {
        super(x, y, Ad, Tur);
        this.can = can;
    }
    
    public int getCan(){
        return can;
    }
    
    public void setCan(int can){
        this.can = can;
    }
    
}
