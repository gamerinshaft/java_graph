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
      int x1[] = new int[4];
      int y1[] = new int[4];
      int k;
      for(k=0;k<4;k++){
        x1[k]= (int)((100-25*k)*Math.cos(90*Math.PI/180+rad*i));
        y1[k]= (int)((100-25*k)*Math.sin(90*Math.PI/180+rad*i));
      }
      g.drawLine(215,140,215+x1[0],140-y1[0]);
      if(i+1<pa.length){
        int x2[] = new int[4];
        int y2[] = new int[4];
        int j;
        for(j=0;j<4;j++){
          x2[j]= (int)((100-25*j)*Math.cos(90*Math.PI/180+rad*(i+1)));
          y2[j]= (int)((100-25*j)*Math.sin(90*Math.PI/180+rad*(i+1)));
          g.drawLine(215+x2[j],140-y2[j],215+x1[j],140-y1[j]);
        }

      }else{
        for(k=0;k<4;k++){
          g.drawLine(215,40+25*k,215+x1[k],140-y1[k]);
        }
      }
    }

  }
}