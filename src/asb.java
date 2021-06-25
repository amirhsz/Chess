import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
public class asb implements mohreh {
    Point xy;
    Color rang;
    int[] x1,y1,x2,y2,x3,y3;
    rect e;
    boolean isremove = false;
    boolean change = false;
    public asb(rect e,Color rang){
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
        int b = e.w/4;
        int p = e.w*325/1000;
        int f = e.w*3/10;
        int o = e.w/20;
        int v = xy.x;
        int[] x = {v , v-b , v-f/2 , v+o , v-f/2 , v+f/2 , v+p};
        return x;
    }
    private int[] makex2(){
        int p = e.w/20;
        int u = 2*p;
        int o = e.w*125/1000;
        int v = xy.x;
        int[] x = {v-p , v-u , v-o};
        return x;
    }
    private int[] makex3(){
        int p = e.w*65/1000;
        int u = e.w*290/1000;
        int i = e.w*175/1000;
        int q = e.w*40/1000;
        int c = e.w*265/1000;
        int o = e.w*150/1000;
        int v = xy.x;
        int[] x = {v+p , v+u , v+i , v+o ,v+c , v+q};
        return x;
    }
    private int[] makey1(){
        int q = e.h*4/10;
        int a = e.h*3/10;
        int k = e.h/10;
        int o = e.h/20;
        int v = xy.y;
        int[] y = {v-q , v-o , v+k , v-k , v+a , v+a , v};
        return y;
    }
    private int[] makey2(){
        int n = e.h/10;
        int m = e.h*15/100;
        int v = xy.y;
        int[] y = {v-m , v-m , v-n};
        return y;
    }
    private int[] makey3(){
        int p = e.h/5;
        int u = e.h*3/10;
        int v = xy.y;
        int[] y = {v-u , v , v+p , v+p , v , v-u};
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
            g.fillRect(xy.x - e.w*3/20, xy.y + e.h*35/100, e.w*3/10, e.h/20);
            g.fillPolygon(x1, y1, x1.length);
            g.setColor(e.c);
            g.fillPolygon(x2, y2, x2.length);
            g.fillPolygon(x3, y3, x3.length);
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
    public boolean can(rect d, ArrayList<rect> a , ArrayList<mohreh> b) {
        int jx = (e.x + e.w/2)/e.w;
        int jy = (e.y + e.h/2)/e.h;
        int kx = (d.x + d.w/2)/d.w;
        int ky = (d.y + d.h/2)/d.h;
        if(d.doesmohreh(b) == -1 || (d.doesmohreh(b) != -1 && b.get(d.doesmohreh(b)).getrang() != rang)){
            if(jx>kx){
                if(jx -1 == kx){
                    if(jy+2 == ky || jy-2 == ky){
                        return true;
                    }
                }
                if(jx -2 == kx){
                    if(jy+1 == ky || jy-1 == ky){
                        return true;
                    }
                }
            }else{
                if(jx +1 == kx){
                    if(jy+2 == ky || jy-2 == ky){
                        return true;
                    }
                }
                if(jx +2 == kx){
                    if(jy+1 == ky || jy-1 == ky){
                        return true;
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
        if(can(d , a , b) && d.doesmohreh(b) != -1 && b.get(d.doesmohreh(b)).getrang() != rang){
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
    public ArrayList<rect> cango(ArrayList<mohreh> a, ArrayList<rect> c) {
        ArrayList<rect> chose = new ArrayList();
        for (rect c1 : c) {
            if(this.can(c1, c,a)){
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
