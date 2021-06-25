import java.awt.*;
import java.util.ArrayList;
public class rect {
    int x,y,w,h;
    Color c;
    public rect(int x, int y, int w, int h, Color c){
        this.x = x;
        this.y = y;
        this.w= w;
        this.h = h;
        this.c = c;
    }
    public Point vasat(){
        return new Point(this.x + this.w/2 , this.y + this.h/2);
    }
    public void setc(Color k){
        this.c = k;
    }
    public void move(Graphics g,int x, int y){
        this.x = x;
        this.y = y;
        this.draw(g);
    }
    public void remove(Graphics g){
        g.clearRect(x, y, w, h);
    }
    public void draw(Graphics g){
        g.drawRect(x, y, w, h);
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }
    public boolean is(Point a){
        if((x<=a.x && x+w>=a.x)&&(y<=a.y && y+h>=a.y)){
            return true;
        }
        return false;
    }
    public int doesmohreh(ArrayList<mohreh> a){
        for(int i = 0 ; i<a.size() ; i++){
            if(this.is(a.get(i).getxy())){
                return i;
            }
        }
        return -1;
    }
    public boolean doesmohreh(ArrayList<rect> a , int n , int m ,ArrayList<mohreh> b){
        for(int i = n+1 ; i< m ; i++){
            if(a.get(i).doesmohreh(b) != -1){
                return true;
            }
        }
        return false;
    }
    public boolean doesmohrehrokh(ArrayList<rect> a , int[] n , int[] m ,ArrayList<mohreh> b , boolean isofogh){
        int first = n[1]+(8*n[0]);
        int last = m[1]+(8*m[0]);
        int fasleh;
        int i = 0;
        if(isofogh){
            if(first>last){
                fasleh = (first - last)/8;
            }else{
                fasleh = (last - first)/8;
            }
            while(fasleh > 0){
                i++;
                if(first>last){
                    if(a.get(first-(i*8)).doesmohreh(b) != -1){
                        if(b.get(a.get(first-(i*8)).doesmohreh(b)).getrect() != a.get(last)){
                            return true;
                        }
                    }
                }else{
                    if(a.get(first+(i*8)).doesmohreh(b) != -1){
                        if(b.get(a.get(first+(i*8)).doesmohreh(b)).getrect() != a.get(last)){
                            return true;
                        }
                    }
                }
                fasleh --;   
            }
            return false;
        }else{
            if(first>last){
                return doesmohreh(a,last,first,b);
            }else{
                return doesmohreh(a,first,last,b);
            }
        }
    }
    public boolean doesmohrehfil(ArrayList<rect> a , int[] n , int[] m ,ArrayList<mohreh> b){
        ArrayList<Integer> go = new ArrayList();
        int jx = n[0];
        int jy = n[1];
        int kx = m[0];
        int ky = m[1];
        int i = 0;
        while(i<9){
            i++;
            if(jx>kx){
                go.add(makefandl(jy-i , jx-i));
                go.add(makefandl(jy+i , jx-i));
            }else{
                go.add(makefandl(jy-i , jx+i));
                go.add(makefandl(jy+i , jx+i));
            }
        }
        for (Integer g : go) {
            //System.out.println(g);
            if(a.get(g).doesmohreh(b) != -1 && a.get(g).doesmohreh(b) != makefandl(ky,kx)){
                return true;
            }
        }
        return false;
    }
    private int makefandl(int jy , int jx){
        return jy + (8*jx);
    }
    public int doesrect(ArrayList<rect> morba){
        for(int i = 0 ; i<morba.size() ; i++){
            if(this.is(morba.get(i).vasat())){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        return "w= "+w+",h= "+h+",x= "+x+",y= "+y;
    }
}
