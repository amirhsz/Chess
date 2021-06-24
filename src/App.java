import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
public class App extends javax.swing.JFrame {
    String stat = "no";
    int indexmohreh,indexmorba;
    mohreh mohreh;
    Color color,rang = Color.yellow , chosecolor = Color.red;
    ArrayList<Color> lastcolor = new ArrayList();
    ArrayList<rect> lastgochose = new ArrayList();
    rect rect;
    int nobat = 0;
    public App() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    public boolean doeschangechose(){
        int k = 0 ;
        for (rect morba : this.jPNL1.morba) {
            if(morba.c == Color.yellow){
                k++;
            }
        }
        if(k>=1){
            return true;
        }
        return false;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPNL1 = new JPNL();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPNL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPNL1MouseClicked(evt);
            }
        });
        jPNL1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPNL1MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPNL1Layout = new javax.swing.GroupLayout(jPNL1);
        jPNL1.setLayout(jPNL1Layout);
        jPNL1Layout.setHorizontalGroup(
            jPNL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
        jPNL1Layout.setVerticalGroup(
            jPNL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPNL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPNL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jPNL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPNL1MouseClicked
        Point c = evt.getPoint();
        for(int i = 0 ; i<this.jPNL1.morba.size(); i++){
            if(this.jPNL1.morba.get(i).is(c) && this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh)!=-1 &&
            ((this.jPNL1.mohreh.get(this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh)).getrang() == Color.white
            && nobat == 0) || (this.jPNL1.mohreh.get(this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh)).getrang()
            == Color.black && nobat == 1))){
                stat = "select";
                indexmohreh =this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh);
                indexmorba = i;
                mohreh = this.jPNL1.mohreh.get(indexmohreh);
                if(doeschangechose()){
                    this.jPNL1.morba.get(this.jPNL1.morba.indexOf(rect)).c = color;
                    for(int j = 0 ; j<lastcolor.size() ; j++){
                        lastgochose.get(j).c = lastcolor.get(j);
                    }
                    lastcolor.clear();
                    lastgochose.clear();
                }
                color = this.jPNL1.morba.get(this.jPNL1.morba.indexOf(mohreh.getrect())).c;
                rect = this.jPNL1.morba.get(this.jPNL1.morba.indexOf(mohreh.getrect()));
                this.jPNL1.morba.get(this.jPNL1.morba.indexOf(mohreh.getrect())).c = rang;
                lastgochose = mohreh.cango(this.jPNL1.mohreh,this.jPNL1.morba);
                for(rect b : mohreh.cango(this.jPNL1.mohreh,this.jPNL1.morba)){
                    lastcolor.add(this.jPNL1.morba.get(this.jPNL1.morba.indexOf(b)).c);
                    this.jPNL1.morba.get(this.jPNL1.morba.indexOf(b)).c = chosecolor;
                }
                this.repaint();
            }
        }
        if(stat == "moved" && ((mohreh.getrang() == Color.white && nobat == 0) ||(mohreh.getrang() == Color.black && nobat == 1))){
            for(int i = 0 ; i<this.jPNL1.morba.size() ; i++){
                if(this.jPNL1.morba.get(i).is(c)){
                    if(mohreh.can(this.jPNL1.morba.get(i), this.jPNL1.morba , this.jPNL1.mohreh) && this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh) == -1){
                        this.jPNL1.mohreh.get(indexmohreh).move(this.jPNL1.morba.get(i));
                        this.jPNL1.maker(true, new Point(indexmohreh,i));
                        this.jPNL1.morba.get(this.jPNL1.morba.indexOf(rect)).c = color;
                        for(int j = 0 ; j<lastcolor.size() ; j++){
                            lastgochose.get(j).c = lastcolor.get(j);
                        }
                        lastcolor.clear();
                        if(nobat == 0){
                            nobat = 1;
                        }
                        else{
                            nobat = 0;
                        }
                    }
                        if(mohreh.cankick(this.jPNL1.morba.get(i), this.jPNL1.morba , this.jPNL1.mohreh)){
                            this.jPNL1.mohreh.get(indexmohreh).move(this.jPNL1.morba.get(i));
                            this.jPNL1.maker(true, new Point(indexmohreh,i));
                            this.jPNL1.mohreh.get(this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh)).remove();
                            this.jPNL1.morba.get(this.jPNL1.morba.indexOf(rect)).c = color;
                            for(int j = 0 ; j<lastcolor.size() ; j++){
                                lastgochose.get(j).c = lastcolor.get(j);
                            }
                            lastcolor.clear();
                            if(nobat == 0){
                                nobat = 1;
                            }
                            else{
                                nobat = 0;
                            }
                        }
                        this.repaint();
                }
            }
        }
    }//GEN-LAST:event_jPNL1MouseClicked

    private void jPNL1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPNL1MouseMoved
        if(stat == "select" && ((mohreh.getrang() == Color.white && nobat == 0) ||(mohreh.getrang() == Color.black && nobat == 1))){
            stat = "moved";
        }
    }//GEN-LAST:event_jPNL1MouseMoved
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPNL jPNL1;
    // End of variables declaration//GEN-END:variables
}