import java.awt.*;
import java.util.ArrayList;
public class fil implements mohreh {
    Point xy;
    Color rang;
    int[] x1,y1,x2,y2;
    rect e;
    boolean change = false;
    public fil(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x1=makex1();
        y1=makey1();
        x2=makex2();
        y2=makey2();
    }
    private int[] makex1(){
        int b = e.w*3/10;
        int c = e.w/10;
        int p = e.w/5;
        int g = e.w/20;
        int v  = xy.x;
        int[] x = {v , v+c , v+g , v+b/2 , v+p , v+b/2 , v-b/2 , v-p};
        return x;
    }
    private int[] makex2(){
        int r = e.w/10;
        int v  = xy.x;
        int[] x = {v , v-r/2 , v , v+r/2};
        return x;
    }
    private int[] makey1(){
        int h = e.h/5;
        int f = 3*e.h/10;
        int n = e.h/20;
        int o = e.h/10;
        int v = xy.y;
        int[] y = {v-h , v-n , v+h , v+n , v+o , v+f , v+f , v+o};
        return y;
    }
    private int[] makey2(){
        int h = e.h/5;
        int v = xy.y;
        int[] y = {v-h , v-h-h/2 , v-2*h , v-h-h/2 , v-h};
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
        int b = e.w*3/10;
        int f = 3*e.h/10;
        int o = e.h/10;
        g.fillRect(xy.x - b/2, xy.y + e.h*35/100, b, o/2);
        g.fillPolygon(x1, y1, x1.length);
        g.fillPolygon(x2, y2, x2.length);
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
        this.x1 = this.makex1();
        this.y1 = this.makey1();
        this.x2 = this.makex2();
        this.y2 = this.makey2();
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
        if((j-k)%9 == 0 || (j-k)%7 == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean getchange() {
        return change;
    }
}
