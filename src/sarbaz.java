import java.awt.*;
import java.util.ArrayList;
public class sarbaz implements mohreh {
    Point xy;
    Color rang;
    private int[] x,y;
    rect e;
    boolean change = false;
    boolean isremove = false;
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
    public boolean can(rect d, ArrayList<rect> a , boolean isfirst ,ArrayList<mohreh> b) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
        if(d.doesmohreh(b) == -1 || (d.doesmohreh(b) != -1 && b.get(d.doesmohreh(b)).getrang() != rang)){
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
                    if(j-2 == k && e.doesmohreh(a, k, j, b)){
                        return false;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public boolean getchange() {
        return change;
    }

    @Override
    public boolean cankick(rect d, ArrayList<rect> a, ArrayList<mohreh> b) {
        int j = a.indexOf(e);
        int k = a.indexOf(d);
        if(d.doesmohreh(b) != -1){
            if(rang == Color.black){
                if((j-9 == k) || (j+7 == k)){
                    return true;
                }
            }
            else{
                if(j+9 == k || j-7 == k){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String gettype() {
        return "sarbaz";
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
    public ArrayList<rect> cango(ArrayList<mohreh> a, ArrayList<rect> c) {
        ArrayList<rect> chose = new ArrayList();
        for (rect c1 : c) {
            if(this.can(c1, c, true, a) || cankick(c1 , c , a)){
                chose.add(c1);
            }
        }
        return chose;
    }

    @Override
    public rect getrect() {
        return e;
    }
}