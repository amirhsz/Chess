import java.awt.*;
import java.util.ArrayList;
public class asb implements mohreh {
    Point xy;
    Color rang;
    int[] x,y;
    rect e;
    boolean isremove = false;
    boolean change = false;
    public asb(rect e,Color rang){
        this.xy = e.vasat();
        this.rang = rang;
        this.e = e;
        x=makex();
        y=makey();
    }
    private int[] makex(){
        int n = 2*e.w/5;
        int m = n/2;
        int g = 3*n/2;
        int[] x = {xy.x-m/2,xy.x+m/2,xy.x+m/2,xy.x+g/2,xy.x-g/2,xy.x-m/2};
        return x;
    }
    private int[] makey(){
        int k = e.h/5;
        int f=2*k;
        int[] y = {xy.y-e.h/2+k,xy.y-e.h/2+k,xy.y-e.h/2+f,xy.y-e.h/2+2*f,xy.y-e.h/2+2*f,xy.y-e.h/2+f};
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
    public boolean can(rect d, ArrayList<rect> a,boolean isfirst , ArrayList<mohreh> b) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
        if(j-6 == k || j+6 == k || j+10 == k || j-10 == k || j+17 == k || j+15 == k || j-15 == k || j-17 == k){
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
        return "asb";
    }

    @Override
    public boolean isemove() {
        return isremove;}

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
