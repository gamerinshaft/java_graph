import java.applet.Applet;
import java.awt.*;

public class PieGraph extends Applet {
  float pa[]=new float[8];
  float max = 0;
  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=100;pa[1]=640;pa[2]=340;pa[3]=412;pa[4]=560;pa[5]=109;
     pa[6]=800;pa[7]=250;
     //値の比較
     int i;
     for(i=0;i<pa.length;i++){
        if(max<=pa[i]){
          max = pa[i];
        }
     }

   }
  public void paint(Graphics g) {
    g.fillArc(40, 30, 100, 70, 45, 135);
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
    g.setColor(new Color(50,50,50));
    g.fillOval(15+140, 15+65, 120, 120);
    g.setColor(new Color(35,35,35));
    g.fillOval(15+160, 15+85, 80, 80);
    g.setColor(new Color(50,50,50));
    g.fillOval(15+180, 15+105, 40, 40);
  }
}