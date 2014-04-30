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
    //　中の両サイドの枠
    g.setColor(new Color(50,50,50));
    g.fillRect(15+1,15+1,75-1,250-2);
    g.fillRect(325+15+1,15+1,75-1,250-2);

    g.setColor(new Color(50,50,50));
    g.fillOval(15+80-1, 15+5-1, 242, 242);
    g.setColor(new Color(35,35,35));
    g.fillOval(15+80, 15+5, 240, 240);

    //一番外枠パーセンテージの表示
    g.setColor(new Color(255,0,0));
    g.fillArc(15+80,15+5,240,240,90,360);
    g.setColor(new Color(255,128,0));
    g.fillArc(15+80,15+5,240,240,90,315);
    g.setColor(new Color(255,255,0));
    g.fillArc(15+80,15+5,240,240,90,270);
    g.setColor(new Color(0,255,0));
    g.fillArc(15+80,15+5,240,240,90,225);
    g.setColor(new Color(0,255,255));
    g.fillArc(15+80,15+5,240,240,90,180);
    g.setColor(new Color(00,128,255));
    g.fillArc(15+80,15+5,240,240,90,135);
    g.setColor(new Color(0,0,255));
    g.fillArc(15+80,15+5,240,240,90,90);
    g.setColor(new Color(0,0,128));
    g.fillArc(15+80,15+5,240,240,90,45);

    g.setColor(new Color(35,35,35));
    g.fillOval(15+80+10,15+5+10,220,220);
    g.setColor(new Color(190,0,0));
    g.fillArc(15+80+10,15+5+10,220,220,90,Math.round(360*pa[7]/max));
    g.drawString(7+"",15+15+325,45+20+15*7);
    g.drawString((int)(100*pa[7]/max)+"%",15+35+325,45+20+15*7);

    g.setColor(new Color(50,50,50));
    g.fillOval(15+100, 15+25, 200, 200);
    int k;
    for(k=6;k>=4;k--){
      g.setColor(new Color(50,50,50));
      g.fillOval(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k));
      g.setColor(new Color(255,250-50*(2-(6-k)),0));
      g.fillArc(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k), 90,Math.round(360*pa[k]/max));
      g.drawString(k+"",15+15+325,45+20+15*k);
      g.drawString((int)(100*pa[k]/max)+"%",15+35+325,45+20+15*k);
    }
    g.setColor(new Color(35,35,35));
    g.fillOval(15+120, 15+45, 160, 160);
    int i;
    for(i=3;i>=0;i--){
      g.setColor(new Color(35,35,35));
      g.fillOval(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i));
      g.setColor(new Color(0,250-50*(3-i),100+50*(3-i)));
      g.fillArc(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i), 90,Math.round(360*pa[i]/max));
      g.drawString(i+"",15+15+325,45+20+15*i);
      g.drawString((int)(100*pa[i]/max)+"%",15+35+325,45+20+15*i);
    }
    g.setColor(new Color(50,50,50));
    g.fillOval(15+140, 15+65, 120, 120);
    //メーター
    int j;
    int arc1 = 90;
    int length;
    //文面の記述
    g.setColor(new Color(255,255,255));
    g.drawString("各要素の",15+12,30);
    g.drawString("数値一覧表",15+5,30+15);
    g.drawString("最大値に",15+12+325,30);
    g.drawString("対する比率",15+5+325,30+15);

    for(j=0;j<8;j++){
      length = Math.round(360*pa[j]/sum);
      if(j<=1){
        g.setColor(new Color(255,127*j,0));
      }else if(j<=3){
        g.setColor(new Color(255-127*(j-2),255,0));
      }else if(j<=5){
        g.setColor(new Color(0,255-127*(j-4),127*(j-4)));
      }else{
        g.setColor(new Color(0,255-127*(j-5),255));
      }
      g.drawString(j+"",15+15,45+20+15*j);
      g.drawString((int)(pa[j])+"",15+35,45+20+15*j);
      g.fillArc(15+140, 15+65, 120, 120, arc1, length);
      arc1 += length;
    }
    g.setColor(new Color(35,35,35));
    g.fillOval(15+160, 15+85, 80, 80);
    g.setColor(new Color(50,50,50));
    g.fillOval(15+180, 15+105, 40, 40);
    //円縦線
    g.setColor(Color.WHITE);
    g.fillRect(15+200-1,15+5,3,120);
    g.setColor(Color.ORANGE);
    g.drawLine(15+200,15+5+5,15+200,120+20);
  }
}