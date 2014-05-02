import java.applet.Applet;
import java.awt.*;

public class RaderChart extends Applet {
  float pa[]=new float[180];
  float max = 0;
  float sum = 0;
  public void init() {
    setBackground(new Color(25,25,25));
    pa[0]=90;pa[1]=40;pa[2]=100;pa[3]=80;pa[4]=60;pa[5]=120;
    //値の比較
    int i;
    for(i=0;i<6;i++){
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
    // レーダー枠
    double rad = (360/pa.length)*(Math.PI/180);
    int i;
    for(i=0;i<pa.length;i++){
      int x1= (int)(100*Math.cos(90*Math.PI/180+rad*i));
      int y1= (int)(100*Math.sin(90*Math.PI/180+rad*i));
      g.drawLine(215,140,215+x1,140-y1);
    }

  }
}