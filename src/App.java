import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class App extends javax.swing.JFrame {
    load g;
    String dir = "F:\\java\\Chess\\saved\\";
    FileWriter save;
    FileReader load;
    startframe a;
    middleframe b;
    String stat = "no";
    ArrayList<mohreh> shahkickers = new ArrayList();
    mohreh shah;
    int indexmohreh,indexmorba;
    mohreh mohreh;
    Color color,rang = Color.yellow , chosecolor = Color.red;
    ArrayList<Color> lastcolor = new ArrayList();
    ArrayList<rect> lastgochose = new ArrayList();
    rect rect;
    int nobat = 0;
    public App(middleframe a) {
        this.b = a;
        this.a = b.a;
        try{
            save = new FileWriter(dir+b.name+".txt");
        }catch(IOException e){}
        initComponents();
    }
    public App(load a){
        g = a;
        this.a = g.a;
        if(g.chose){
            load = g.choser;
            System.out.println(load);
        }
        try {
            save = new FileWriter(dir + g.name);
        } catch (IOException ex) {}
        initComponents();
    }
    public void load(){
        String goed;
        try{
        System.out.println(load.read());
        }catch(Exception e){}
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

        buttonGroup6 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPNL1 = new JPNL();
        jLabel1 = new javax.swing.JLabel();
        black = new javax.swing.JRadioButton();
        white = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPNL1Layout.setVerticalGroup(
            jPNL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("trun:");

        buttonGroup6.add(black);
        black.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        black.setText("black");
        black.setEnabled(false);

        buttonGroup6.add(white);
        white.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        white.setText("white");
        white.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("state:");

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        status.setText("in game");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("back to menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(black)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(white)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(status)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addComponent(jPNL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(white, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(status)))
                        .addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        if("moved".equals(stat) && ((mohreh.getrang() == Color.white && nobat == 0) ||(mohreh.getrang() == Color.black && nobat == 1))){
            for(int i = 0 ; i<this.jPNL1.morba.size() ; i++){
                if(this.jPNL1.morba.get(i).is(c)){
                    if(mohreh.can(this.jPNL1.morba.get(i), this.jPNL1.morba , this.jPNL1.mohreh) && this.jPNL1.morba.get(i).doesmohreh(this.jPNL1.mohreh) == -1){
                        mohreh.move(this.jPNL1.morba.get(i));
                        this.jPNL1.maker(true, new Point(indexmohreh,i));
                        this.jPNL1.morba.get(this.jPNL1.morba.indexOf(rect)).c = color;
                        try{
                            String type = mohreh.gettype();
                            String name = null;
                            switch(type){
                                case "shah":
                                    name = "k";
                                    break;
                                case "asb":
                                    name = "N";
                                    break;
                                case "fil":
                                    name = "B";
                                    break;
                                case "rokh":
                                    name = "R";
                                    break;
                                case "vazir":
                                    name = "Q";
                                    break;
                                case "sarbaz":
                                    name = "P";
                                    break;
                            }
                            save.write(indexmorba+name+i+"\n");
                            save.flush();
                        }catch(IOException e){}
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
                            try{
                                String type = mohreh.gettype();
                                String name = null;
                                switch(type){
                                    case "shah":
                                        name = "k";
                                        break;
                                    case "asb":
                                        name = "N";
                                        break;
                                    case "fil":
                                        name = "B";
                                        break;
                                    case "rokh":
                                        name = "R";
                                        break;
                                    case "vazir":
                                        name = "Q";
                                        break;
                                    case "sarbaz":
                                        name = "P";
                                        break;
                                }
                                save.write(indexmorba+name+"x"+i+"\n");
                                save.flush();
                            }catch(IOException e){}
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
            shahkickers.clear();
            shah = findshah(nobat , this.jPNL1.mohreh);
            for(mohreh r : this.jPNL1.mohreh){
                if(r.cankick(shah.getrect(), this.jPNL1.morba, this.jPNL1.mohreh)){
                    shahkickers.add(r);
                }
                if(shah.cancickme(this.jPNL1.mohreh, this.jPNL1.morba)){
                    this.status.setText("Kish");
                    if(shah.cango(this.jPNL1.mohreh, this.jPNL1.morba).isEmpty()){
                        for(mohreh kicker : shahkickers){
                            if(!kicker.cancickme(this.jPNL1.mohreh, this.jPNL1.morba)){
                                this.status.setText("Kish and Mot");
                            }
                        }
                    }
                }
            }
            if(shah.isemove()){
                this.status.setText("Kish and Mot");
            }
        }
    }//GEN-LAST:event_jPNL1MouseClicked
    public mohreh findshah(int nobat , ArrayList<mohreh> a){
        mohreh shah = null;
        for(mohreh b : a){
            if(nobat == 0){
                if("shah".equals(b.gettype()) && b.getrang() == Color.BLACK){
                    shah = b;
                }
            }else{
                if("shah".equals(b.gettype()) && b.getrang() == Color.white){
                    shah = b;
                }
            }
        }
        return shah;
    }
    private void jPNL1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPNL1MouseMoved
        if(stat == "select" && ((mohreh.getrang() == Color.white && nobat == 0) ||(mohreh.getrang() == Color.black && nobat == 1))){
            stat = "moved";
        }
        if(nobat == 0){
            this.white.setSelected(true);
        }else{
            this.black.setSelected(true);
        }
        load();
    }//GEN-LAST:event_jPNL1MouseMoved
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
                new App(new middleframe(new startframe())).setVisible(true);
                new App(new load(new startframe())).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton black;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private JPNL jPNL1;
    private javax.swing.JLabel status;
    private javax.swing.JRadioButton white;
    // End of variables declaration//GEN-END:variables
}