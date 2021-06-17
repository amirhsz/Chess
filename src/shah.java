import java.awt.*;
import java.util.ArrayList;
public class shah implements mohreh {
    Point xy;
    Color rang;
    int[] x1,x2,y1,y2;
    rect e;
    boolean change = false;
    boolean isremove = false;
    public shah(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x1=makex1();
        x2=makex2();
        y1=makey1();
        y2=makey2();
    }
    private int[] makex1(){
        int k = e.w/10;
        int d = 3*k;
        int a = k/4;
        int v = xy.x;
        int[] x = {v-k/2 , v-a/2 , v-d/2 , v-d/2 , v-a/2 , v-k/2 , v-d/2 , v-d/2
        , v+d/2 , v+d/2, v+k/2 , v+a/2 , v+d/2 , v+d/2 , v+a/2 , v+k/2};
        return x;
    }
    private int[] makex2(){
        int m = e.w/2;
        int d = 3*e.w/10;
        int v = xy.x;
        int[] x = {v-m/2 , v-d/2 , v+d/2 , v+m/2};
        return x;
    }
    private int[] makey1(){
        int h = 2*e.h/5;
        int s = h/4;
        int d = s/2;
        int g = 25*e.h/1000;
        int v = xy.y;
        int[] y = {v-h-s , v-h+g , v-h , v-h+s , v-h+s-g, v-s , v-s
        , v-d , v-d , v-s , v-s , v-h+s-g , v-h+s , v-h , v-h+g , v-h-s};
        return y;
    }
    private int[] makey2(){
        int g = e.h/5;
        int v = xy.y;
        int[] y = {v , v+g, v+g , v};
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
        int l = e.h/5;
        int s = e.h/10;
        g.fillRect(xy.x-3*e.w/20, xy.y+l+s, 3*e.w/10, s/2);
        g.fillPolygon(x1, y1, x1.length);
        g.fillPolygon(x2, y2, x2.length);
    }
    @Override
    public void remove() {
        this.e = new rect(-1,-1,0,0,Color.white);
        this.repaint();
        change = true;
        isremove = true;
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
    public boolean can(rect d, ArrayList<rect> a,boolean isfirst ,ArrayList<mohreh> b) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
                if(j+1 == k || j-1 == k || j-8 == k || j+8 == k || j-7 == k || j+7 == k || j+9 == k || j-9 == k){
                    return true;
                }
        return false;
    }

    @Override
    public boolean getchange() {
        return change;
    }

    @Override
    public boolean cankick(rect d, ArrayList<rect> a, ArrayList<mohreh> b) {
        if(can(d , a , true , b) && d.doesmohreh(b) != -1){
            return true;
        }
        return false;
    }

    @Override
    public String gettype() {
        return "shah";
    }

    @Override
    public boolean isemove() {
        return isremove;
    }

    @Override
    public boolean cancickme(ArrayList<mohreh> a, ArrayList<rect> c) {
        int i = 0;
        for (mohreh b : a) {
            i++;
            if(b.cankick(e, c, a) && b.getrang() != rang){
                return true;
            }
        }
        return false;
    }
}
