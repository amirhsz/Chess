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
    public int doesrect(ArrayList<rect> morba){
        for(int i = 0 ; i<morba.size() ; i++){
            if(this.is(morba.get(i).vasat())){
                return i;
            }
        }
        return -1;
    }
    public boolean filvazirgo(ArrayList<rect> morba , ArrayList<mohreh> moh){
        int k = morba.indexOf(this);
        try{
            for(int i = 1 ; i<8 ; i++){
                if(morba.get(k+9*i).doesmohreh(moh) != -1){
                    return false;
                }
            }
        }catch(Exception e){}
        return true;
    }
    @Override
    public String toString(){
        return "w= "+w+",h= "+h+",x= "+x+",y= "+y;
    }
}
