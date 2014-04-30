import java.applet.Applet;
import java.awt.*;

public class PieGraph extends Applet {
  float pa[]=new float[8];
  float max = 0;
  float sum = 0;
  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=90;pa[1]=40;pa[2]=100;pa[3]=80;pa[4]=60;pa[5]=120;
     pa[6]=40;pa[7]=80;
     //値の比較
     int i;
     for(i=0;i<8;i++){
        sum += pa[i];
        if(max<=pa[i]){
          max = pa[i];
        }
     }

   }
  public void paint(Graphics g) {
    // 外の枠
    g.setColor(new Color(255,255,255));
    g.drawRect(15,15,400,250);

    g.setColor(new Color(50,50,50));
    g.fillOval(15+80-1, 15+5-1, 242, 242);
    g.setColor(new Color(35,35,35));
    g.fillOval(15+80, 15+5, 240, 240);
    g.setColor(new Color(255,0,0));
    g.fillOval(15+80, 15+5, 240, 240);

    g.setColor(new Color(35,35,35));
    g.fillOval(15+80+10,15+5+10,220,220);
    g.setColor(new Color(180,0,0));
    g.fillArc(15+80+10,15+5+10,220,220,90,Math.round(360*pa[7]/max));

    g.setColor(new Color(50,50,50));
    g.fillOval(15+100, 15+25, 200, 200);
    int k;
    for(k=6;k>=4;k--){
      g.setColor(new Color(50,50,50));
      g.fillOval(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k));
      g.setColor(new Color(255,250-50*(2-(6-k)),0));
      g.fillArc(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k), 90,Math.round(360*pa[k]/max));
    }
    g.setColor(new Color(35,35,35));
    g.fillOval(15+120, 15+45, 160, 160);
    int i;
    for(i=3;i>=0;i--){
      g.setColor(new Color(35,35,35));
      g.fillOval(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i));
      g.setColor(new Color(0,250-50*(3-i),100+50*(3-i)));
      g.fillArc(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i), 90,Math.round(360*pa[i]/max));
    }
    g.setColor(new Color(50,50,50));
    g.fillOval(15+140, 15+65, 120, 120);
    //メーター
    int j;
    int arc1 = 90;
    int length;
    for(j=0;j<8;j++){
      length = Math.round(360*pa[j]/sum);
      g.setColor(new Color(0+j*10,0+j*15,80+j*25));
      g.drawString(sum+"",15+40,30+15*j);
      g.drawString(length+"",15+15,30+15*j);
      g.fillArc(15+140, 15+65, 120, 120, arc1, length);
      arc1 += length;
    }
    g.setColor(new Color(35,35,35));
    g.fillOval(15+160, 15+85, 80, 80);
    g.setColor(new Color(50,50,50));
    g.fillOval(15+180, 15+105, 40, 40);
    //円縦線
    g.setColor(Color.RED);
    g.fillRect(15+200-1,15+5,3,120);
    g.setColor(Color.ORANGE);
    g.drawLine(15+200,15+5+5,15+200,120+20);
  }
}