import java.awt.*;
import java.util.ArrayList;
public class sarbaz implements mohreh {
    Point xy;
    Color rang;
    private int[] x,y;
    rect e;
    public boolean change = false;
    public sarbaz(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x=makex();
        y=makey();
    }
    private int[] makex(){
        int n = e.w*3/10;
        int v = xy.x;
        int[] x = {v-n , v , v+n , v};
        return x;
    }
    private int[] makey(){
        int k = e.h/20;
        int m =e.h*25/100;
        int f =e.h*35/100;
        int v = xy.y;
        int[] y = {v-k , v-f , v-k , v+m};
        return y;
    }
    @Override
    public void move(rect e) {
        this.e = e;
        change = true;
    }
    @Override
    public void draw(Graphics g) {
        if(change){
            repaint();
        }
            g.setColor(rang);
            g.fillPolygon(x, y, x.length);
            g.fillRect(xy.x-e.w*15/100 , xy.y+e.h*3/10 , e.w*3/10, e.h/20);
    }
    @Override
    public void remove() {
        this.e = new rect(-1,-1,0,0,Color.white);
        this.repaint();
        change = true;
    }
    @Override
    public String toString(){
        return "morba andis: "+e;
    }
    private void repaint(){
        this.xy = e.vasat();
        this.x = this.makex();
        this.y = this.makey();
    }
    @Override
    public Point getxy() {
        return xy;
    }
    @Override
    public Color getrang() {
        return rang;
    }
    @Override
    public boolean can(rect d, ArrayList<rect> a , boolean isfirst) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
        if(!isfirst){
            if(rang == Color.white){
                if(j+1 == k){
                    return true;
                }
            }
            else{
                if(j-1 == k){
                    return true;
                }
            }
        }
        else{
            if(rang == Color.white){
                if(j+1 == k || j+2 == k){
                    return true;
                }
            }
            else{
                if(j-1 == k || j-2 == k){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean getchange() {
        return change;
    }
}