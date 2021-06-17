import java.awt.*;
import java.util.ArrayList;
public class rokh implements mohreh {
    Point xy;
    Color rang;
    int[] x,y;
    rect e;
    boolean change = false;
    boolean isremove = false;
    public rokh(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x=makex();
        y=makey();
    }
    private int[] makex(){
        int f = e.w/2;
        int k = f/3;
        int m = k/2;
        int v = xy.x;
        int p = 4*k;
        int[] x = {v-p/2 , v-p/2+k , v-p/2+k , v-p/2+k+m , v-p/2+k+m , v+k/2 , v+k/2 , v+k/2+m , v+k/2+m , v+p/2
        ,v+f/2 , v-f/2};
        return x;
    }
    private int[] makey(){
        int n = e.h/2;
        int d = n/6;
        int s = 2*d;
        int v = xy.y;
        int[] y = {v-n+s , v-n+s , v-n+3*s , v-n+3*s , v-n+s , v-n+s , v-n+3*s
        ,v-n+3*s, v-n+s, v-n+s , v+n/2 , v+n/2};
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
        g.fillRect(xy.x-e.w/4, xy.y+e.h/3, e.w/2, e.h/12);
            
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
    public boolean can(rect d, ArrayList<rect> a,boolean isfirst,ArrayList<mohreh> b) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
            if(((j-k)%8 == 0 || (k-j)%8==0) || (((j-k)>0 && (j-k)<8 && !e.doesmohreh(a, k, j, b))
            || ((k-j)>0 && (k-j)<8 && !e.doesmohreh(a, j, k, b)))){
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
        return "rokh";
    }
    @Override
    public boolean isemove() {
        return isremove;
    }

    @Override
    public boolean cancickme(ArrayList<mohreh> a, ArrayList<rect> c) {
        for (mohreh b : a) {
            if(b.cankick(e, c, a)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cango(ArrayList<mohreh> a, ArrayList<rect> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

