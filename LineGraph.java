import java.applet.Applet;
import java.awt.*;

public class LineGraph extends Applet {
  float pa[]=new float[12];
  float max = 0;
  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=700;pa[1]=640;pa[2]=340;pa[3]=412;pa[4]=560;pa[5]=109;
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
    int i,j;
    Graphics2D g2 = (Graphics2D)g;
    g.setColor(new Color(255,255,255));
     //0の表示
    g.drawString("0",15+10+15,250-15);
    // 外の枠
    g.drawRect(15,15,400,250);
    g.setColor(new Color(50,50,50));
    //縦線
    g.drawLine(15+45,15+15,15+45,250-15);
    //横線
    g.drawLine(15+45,250-15,390,250-15);
    //縦線データー線記入
    Color color1 = Color.BLACK;
    Color color2 = Color.BLACK;
    if(250-20-(int)(205*pa[0]/max) >= 15+10+51*4){
      GradientPaint gp = new GradientPaint(15+45,15+10+51*3,Color.RED,15+45,250-15,Color.YELLOW);
      color1 = Color.RED;
      g2.setPaint(gp);
    }else if(250-20-(int)(205*pa[0]/max) >= 15+10+51*3){
      GradientPaint gp = new GradientPaint(15+45,15+10+51*3,Color.ORANGE,15+45,250-15,Color.RED);
      color1 = Color.ORANGE;
      g2.setPaint(gp);
    }else if(250-20-(int)(205*pa[0]/max) >= 15+10+51*2){
      GradientPaint gp = new GradientPaint(15+45,15+10+51*2,Color.GREEN,15+45,250-15,Color.ORANGE);
      color1 = Color.GREEN;
      g2.setPaint(gp);
    }else if(250-20-(int)(205*pa[0]/max) >= 15+10+51*1){
      GradientPaint gp = new GradientPaint(15+45,15+10+51*1,Color.BLUE,15+45,250-15,Color.GREEN);
      color1 = Color.BLUE;
      g2.setPaint(gp);
    }else if(250-20-(int)(205*pa[0]/max) >= 15+10+51*0){
      GradientPaint gp = new GradientPaint(15+45,15+10+51*0,Color.CYAN,15+45,250-15,Color.BLUE);
      color1 = Color.CYAN;
      g2.setPaint(gp);
    }
    g2.drawLine(15+45,250-20-(int)(205*pa[0]/max),15+45,250-15);
    //縦線数値の記入
    //縦丸ぽちの追加
   for(i=0;i<4;i++){
      g.setColor(new Color(255,255,255));
      g.drawString((int)(max*(4-i)/4)+"",15+10,15+15+5+51*i);
      if(250-20-(int)(205*pa[0]/max) < 15+10+51*i){
        g2.fillOval(15+40,15+10+51*i,10,10);
      }else{
        g.setColor(new Color(50,50,50));
        g.fillOval(15+40,15+10+51*i,10,10);
      }
    }
    //横線数値記入
    //横丸ぽちの追加
    for(i=0;i<8;i++){
      g.setColor(new Color(255,255,255));
      g.drawString(i+"",(int)(15+40+335*i/7)+1,250+7);
      g.setColor(new Color(50,50,50));
      g.fillOval((int)(15+40+335*i/7),250-20,10,10);
    }
    //折れ線グラフのデータ記入
    for(i=0;i<8;i++){
      if(i==7){
        g2.fillOval((int)(15+40+335*i/7),250-20-(int)(205*pa[i]/max),10,10);
        break;
      }else{
        if(250-20-(int)(205*pa[i+1]/max) >= 15+10+51*4){
        }else if(250-20-(int)(205*pa[i+1]/max) >= 15+10+51*3){
          color2 = Color.RED;
        }else if(250-20-(int)(205*pa[i+1]/max) >= 15+10+51*2){
          color2 = Color.ORANGE;
        }else if(250-20-(int)(205*pa[i+1]/max) >= 15+10+51*1){
          color2 = Color.GREEN;
        }else if(250-20-(int)(205*pa[i+1]/max) >= 15+10+51*0){
          color2 = Color.BLUE;
        }
        GradientPaint gp = new GradientPaint((int)(15+40+335*i/7)+5,5+250-20-(int)(205*pa[i]/max),color1,5+(int)(15+40+335*(i+1)/7),5+250-20-(int)(205*pa[i+1]/max),color2);
        g2.setPaint(gp);
        g2.drawLine((int)(15+40+335*i/7)+5,5+250-20-(int)(205*pa[i]/max),5+(int)(15+40+335*(i+1)/7),5+250-20-(int)(205*pa[i+1]/max));
        color1 = color2;
        g2.fillOval((int)(15+40+335*i/7),250-20-(int)(205*pa[i]/max),10,10);
      }

    }
  }
}