import java.applet.Applet;
import java.awt.*;

public class RaderChart extends Applet {
  float pa[]=new float[12];
  float max = 0;
  float sum = 0;
  float percent[] = new float[pa.length];
  public void init() {
    setBackground(new Color(25,25,25));
    pa[0]=90;pa[1]=40;pa[2]=100;pa[3]=80;pa[4]=60;
    pa[5]=120;pa[6]=190;pa[7]=120;pa[8]=130;pa[9]=80;
    pa[10]=120;pa[11]=150;
    int i;
    //値の比較
    for(i=0;i<pa.length;i++){
        sum += pa[i];
        if(max<=pa[i]){
          max = pa[i];
        }
    }
    for(i=0;i<pa.length;i++){
      percent[i] = pa[i]*100/max;
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

      //円の周りの値
      int z_x = (int)(-(110*Math.cos(90*Math.PI/180+rad*i)));
      int z_y = (int)(110*Math.sin(90*Math.PI/180+rad*i));
      g.drawString(i+1+"",208+z_x,145-z_y);


      //各値の座標
      int point_x1 = (int)(-(percent[i]*Math.cos(90*Math.PI/180+rad*i)));
      int point_y1 = (int)(percent[i]*Math.sin(90*Math.PI/180+rad*i));


      //丸ぽち
      g.fillOval(211+point_x1,136-point_y1,8,8);


      int k;
      for(k=0;k<4;k++){
        x1[k]= (int)(-((100-25*k)*Math.cos(90*Math.PI/180+rad*i)));
        y1[k]= (int)((100-25*k)*Math.sin(90*Math.PI/180+rad*i));
      }
      //棒線
      g.drawLine(215,140,215+x1[0],140-y1[0]);

      //レーダーの点と点とをつなぐ線
      if(i+1<pa.length){
        int x2[] = new int[4];
        int y2[] = new int[4];
        int point_x2 = (int)(-(percent[i+1]*Math.cos(90*Math.PI/180+rad*(i+1))));
        int point_y2 = (int)(percent[i+1]*Math.sin(90*Math.PI/180+rad*(i+1)));
        int j;
        //値同士の線
        g.drawLine(215+point_x1,140-point_y1,215+point_x2,140-point_y2);
        for(j=0;j<4;j++){
          x2[j]= (int)(-((100-25*j)*Math.cos(90*Math.PI/180+rad*(i+1))));
          y2[j]= (int)((100-25*j)*Math.sin(90*Math.PI/180+rad*(i+1)));
          g.drawLine(215+x2[j],140-y2[j],215+x1[j],140-y1[j]);
        }

      }else{
        for(k=0;k<4;k++){
          g.drawLine(215+point_x1,140-point_y1,215+(int)(-(percent[0]*Math.cos(90*Math.PI/180+rad*0))),140-(int)(percent[0]*Math.sin(90*Math.PI/180+rad*0)));
          g.drawLine(215,40+25*k,215+x1[k],140-y1[k]);
        }
      }
    }

  }
}