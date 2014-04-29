import java.applet.Applet;
import java.awt.*;

public class BarGraph extends Applet {
  float pa[]=new float[12];
  float max = 0;
  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=180;pa[1]=120;pa[2]=283;pa[3]=112;pa[4]=190;pa[5]=109;
     pa[6]=200;pa[7]=400;
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
    //ゲージに関する記述
    for(i=0;i<8;i++){
        g.setColor(new Color(50,50,50));
        //三角形の描画
        int[] xpoints = { 15+16/2+(16+32)*i, 15+16+32+16/2+(32+16)*i, 15+32-2+(32+16)*i};
        int[] ypoints = { 10+30+195, 10+30+195, 215};
        int npoints = xpoints.length;
        Polygon polygon = new Polygon(xpoints, ypoints, npoints);
        g2.fill(polygon);
        g.setColor(new Color(50,50,50));
        //ゲージ上部分の丸み
        g.fillOval(15+16+16*i+32*i-1,25,33,30);
        //ゲージ本体
        g.fillRect(15+16+16*i+32*i,25+15,32,195);
        //数値表示
        g.setColor(new Color(255,255,255));
        g.drawString((int)pa[i] + "",15+32+48*i-5-1-7,15+10+210+27);
        //丸ぽち
        int grad;
        grad = (int)(pa[i]*600/max);
        if(grad < 200){
          g.setColor(new Color(50+grad,50,50));
        }else if(grad < 400){
          g.setColor(new Color(50,50+grad/2,50));
        }else{
          g.setColor(new Color(50,50,50+grad/3));
        }
        g.fillOval(15+32+48*i-5-1,15+10+210+5-2,10,10);
        //ゲージ内の横線
        for(j=0;j<3;j++){
          g.setColor(new Color(25,25,25));
          g.drawLine(15+16+16*i+32*i,25+52+52*j,15+16+16*i+32*(i+1),25+52+52*j);
        }
     }
  }
}