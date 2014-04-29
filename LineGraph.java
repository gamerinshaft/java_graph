import java.applet.Applet;
import java.awt.*;

public class LineGraph extends Applet {
  float pa[]=new float[12];
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
    g.drawString(max+"",15,15);
    int i,j;
    Graphics2D g2 = (Graphics2D)g;
    g.setColor(new Color(255,255,255));
    // 外の枠
    g.drawRect(15,15,400,250);

  }
}