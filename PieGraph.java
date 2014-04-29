import java.applet.Applet;
import java.awt.*;

public class PieGraph extends Applet {
  float pa[]=new float[8];
  float max = 0;
  float sum = 0;
  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=20;pa[1]=40;pa[2]=20;pa[3]=80;pa[4]=60;pa[5]=100;
     pa[6]=40;pa[7]=50;
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
    g.setColor(new Color(50,50,50));
    g.fillOval(15+100, 15+25, 200, 200);
    g.setColor(new Color(35,35,35));
    g.fillOval(15+120, 15+45, 160, 160);
    int i;
    for(i=3;i>=0;i--){
      g.setColor(new Color(35,35,35));
      g.fillOval(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i));
      g.setColor(new Color(35+40*i,235,235));
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
      g.setColor(new Color(0+j*10,0+j*15,0+j*35));
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
    g.setColor(new Color(200,200,200));
    g.fillRect(15+200-1,15+5,3,120);
  }
}