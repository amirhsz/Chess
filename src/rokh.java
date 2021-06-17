import java.awt.*;
import java.util.ArrayList;
public class rokh implements mohreh {
    Point xy;
    Color rang;
    int[] x,y;
    rect e;
    boolean change = false;
    public rokh(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x=makex();
        y=makey();
    }
    private int[] makex(){
        int f = e.w/5;
        int k = e.w/10;
        int m = k/2;
        int p = e.w*15/100;
        int v = xy.x;
        int[] x = {v-f , v-k , v-k , v-m , v-m , v+m , v+m , v+k , v+k , v+f
        ,v+p , v-p};
        return x;
    }
    private int[] makey(){
        int n = e.h*35/100;
        int d = e.h*5/100;
        int s = e.h*15/100;
        int u = e.h*15/100;
        int v = xy.y;
        int[] y = {v-n+u , v-n+u , v-d+u , v-d+u , v-n+u , v-n+u , v-d+u
        ,v-d+u , v-n+u , v-n+u , v+s+u , v+s+u};
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
        g.fillRect(xy.x-e.w*15/100, xy.y + e.h * 35 / 100, e.w*3/10, e.h/20);
            
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
    public boolean can(rect d, ArrayList<rect> a,boolean isfirst) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
            if(((j-k)%8 == 0 || (k-j)%8==0) || (((j-k)>0 && (j-k)<8) || ((k-j)>0 && (k-j)<8))){
                return true;
            }
        return false;
    }

    @Override
    public boolean getchange() {
        return change;
    }
}

