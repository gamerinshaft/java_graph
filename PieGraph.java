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
    // 外の枠
    g.setColor(new Color(255,255,255));
    g.drawRect(15,15,400,250);
    g.setColor(Color.red);
    g.fillArc(40, 30, 100, 70, 45, 135);
    g.fillOval(15+100, 15+25, 200, 200);
  }
}