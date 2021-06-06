import java.awt.*;
import java.util.ArrayList;
public class JPNL extends javax.swing.JPanel {
    ArrayList<rect> morba = new ArrayList();
    ArrayList<mohreh> mohreh = new ArrayList();
    ArrayList<Point> randb = new ArrayList();
    int h,w;
    boolean d = true,resized = true;
    public JPNL() {
        initComponents();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        w = this.getWidth();
        h = this.getHeight();
        for(int i = 1 ; i<=8 ; i++){
            for(int j = 1 ; j<=8 ; j++){
                if(morba.size()<64){
                    //jافقی
                    //i عمودی
                    rect e = new rect((i-1)*w/8, (j-1)*h/8, w/8, h/8, new Color(50,50,50));
                    if((i+j)%2==0){
                        e.c = new Color(255, 230, 173);
                    }
                    morba.add(e);
                    if(j==1){
                        if(i==1 || i==8){
                            mohreh.add(new rokh(e,Color.white));
                        }
                        if(i==2 || i==7){
                            mohreh.add(new asb(e,Color.white));
                        }
                        if(i==3 || i==6){
                            mohreh.add(new fil(e,Color.white));
                        }
                        if(i==4){
                            mohreh.add(new vazir(e,Color.white));
                        }
                        if(i==5){
                            mohreh.add(new shah(e,Color.white));
                        }
                    }
                    if(j==2){
                        mohreh.add(new sarbaz(e,Color.white));
                    }
                    if(j==7){
                        mohreh.add(new sarbaz(e,Color.black));
                    }
                    if(j==8){
                        if(i==1 || i==8){
                            mohreh.add(new rokh(e,Color.black));
                        }
                        if(i==2 || i==7){
                            mohreh.add(new asb(e,Color.black));
                        }
                        if(i==3 || i==6){
                            mohreh.add(new fil(e,Color.black));
                        }
                        if(i==4){
                            mohreh.add(new shah(e,Color.black));
                        }
                        if(i==5){
                            mohreh.add(new vazir(e,Color.black));
                        }
                    }
                }
                else{
                    if(this.w/8!=morba.get(0).w || this.h/8!=morba.get(0).h){
                        mohreh.clear();
                        morba.clear();
                        resized = true;
                        d = true;
                        this.repaint();
                    }
                }
            }
        }
        for(int i = 0 ; i<morba.size() ; i++){
            morba.get(i).draw(g);
        }
        if(!d){
            for(int i = 0 ; i<mohreh.size() ; i++){
                mohreh.get(i).draw(g);
            }
        }
        if(d){
            /*if((resized && morba.size()!=0)){
                for(int k = 0; k<randb.size(); k++){
                    move(k);
                }
                System.out.println("yes");
                d=false;
                resized = false;
                this.repaint();
            }*/
            move(randb.size()-1);
            d = false;
            this.repaint();
        }
    }
    public void maker(boolean d, Point p){
        this.d = d;
        this.randb.add(p);
        this.repaint();
    }
    private void move(int i){
        try{
            mohreh.get(randb.get(i).x).move(morba.get(randb.get(i).y));
        }catch(Exception e){}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}