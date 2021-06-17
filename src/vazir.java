import java.awt.*;
import java.util.ArrayList;
public class vazir implements mohreh {
    Point xy;
    Color rang;
    int[] x1,y1,x2,y2,x3,y3;
    rect e;
    boolean change = false;
    boolean isremove = true;
    public vazir(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x1=makex1();
        y1=makey1();
        x2=makex2();
        y2=makey2();
        x3=makex3();
        y3=makey3();
    }
    private int[] makex1(){
        int r = e.w*7/10;
        int a = e.w*15/100;
        int v = xy.x;
        int[] x = {v , v+a , v+r/2 , v+a , v-a , v-r/2 , v-a};
        return x;
    }
    private int[] makex2(){
        int u = e.w/2;
        int a = e.w*15/100;
        int v = xy.x;
        int[] x = {v , v+u/2 , v+a , v , v-a , v-u/2};
        return x;
    }
    private int[] makex3(){
        int i = e.w/10;
        int v = xy.x;
        int[] x = {v , v+i/2 , v , v-i/2};
        return x;
    }
    private int[] makey1(){
        int f = e.h/5;
        int s = e.h/10;
        int v = xy.y;
        int u = e.h*10/100;
        int[] y = {v+u , v+s+u , v+u , v+f+u , v+f+u , v+u , v+s+u};
        return y;
    }
    private int[] makey2(){
        int c = e.h*3/20;
        int s = e.h/10;
        int p = s/2;
        int v = xy.y;
        int u = e.h*10/100;
        int[] y = {v-c+u , v+p+u , v+s+u , v+u , v+s+u , v+p+u};
        return y;
    }
    private int[] makey3(){
        int c = e.h*3/20;
        int m = e.h/10;
        int v = xy.y;
        int u = e.h*10/100;
        int[] x = {v-c+u , v-c-m/2+u , v-c-m+u , v-c-m/2+u};
        return x;
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
            g.fillRect(xy.x - e.w*3/20, xy.y + e.h*35/100, e.w*3/10, e.h/20);
            g.fillPolygon(x1, y1, x1.length);
            g.fillPolygon(x3, y3, x3.length);
            if(rang == Color.white){
                g.setColor(new Color(250,235,215));
            }
            else{
                g.setColor(new Color(60,40,20));
            }
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
        this.x3 = this.makex3();
        this.y3 = this.makey3();
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
        if((((j-k)%8==0) || (((j-k)>0 && (j-k)<8 && !e.doesmohreh(a, k, j, b))
        || ((k-j)>0 && (k-j)<8 && !e.doesmohreh(a, j, k, b))))
        || ((j-k)%9 == 0 || ((j-k)%7 == 0 && (j-k>8 || k-j>8))) && e.filvazirgo(a, b)){
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
        return "vazir";
    }

    @Override
    public boolean isemove() {
        return isremove;
    }

    @Override
    public boolean cancickme(ArrayList<mohreh> a , ArrayList<rect> c) {
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