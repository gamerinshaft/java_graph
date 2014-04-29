import java.applet.Applet;
import java.awt.*;

public class BarGraph extends Applet {
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
    int i,j;
    Graphics2D g2 = (Graphics2D)g;
    g.setColor(new Color(255,255,255));
    // 外の枠
    g.drawRect(15,15,400,250);
    //ゲージに関する記述
    for(i=0;i<8;i++){
        g.setColor(new Color(50,50,50));
        //ゲージ上部分の丸み
        g.fillOval(15+16+16*i+32*i-1,25,33,30);
        //ゲージ枠本体
        g.fillRect(15+16+16*i+32*i,25+15,32,195);
        //数値表示
        g.setColor(new Color(255,255,255));
        g.drawString((int)pa[i] + "",15+32+48*i-5-1-7,15+10+210+27);
        //丸ぽち &　色のグラデーション
        int grad;
        grad = (int)(pa[i]*600/max);
        if(grad < 100){
          g.setColor(new Color(250,50-grad*50/100,50));
        }else if(grad < 200){
          g.setColor(new Color(250,50+grad/2,50));
        }else if(grad < 300){
          g.setColor(new Color(50,150+grad/3,50));
        }else if(grad < 400){
          g.setColor(new Color(50,150,150+grad/4));
        }else if(grad < 500){
          g.setColor(new Color(50,50,150+grad/5));
        }else{
          g.setColor(new Color(50,150+grad/6,250));
        }
        g.fillOval(15+32+48*i-5-1,15+10+210+5-2,10,10);
        //ゲージ表示
        float parcent = pa[i]/max*100;
        g.fillOval(15+16+16*i+32*i-1,25+195-(int)(195*parcent/100),33,30);
        g.fillRect(15+16+16*i+32*i,25+15+195-(int)(195*parcent/100),32,(int)(195*parcent/100));
        //三角形の描画
        int[] xpoints = { 15+16/2+(16+32)*i, 15+16+32+16/2+(32+16)*i, 15+32-2+(32+16)*i};
        int[] ypoints = { 10+30+195, 10+30+195, 215};
        int npoints = xpoints.length;
        Polygon polygon = new Polygon(xpoints, ypoints, npoints);
        g2.fill(polygon);
        //ゲージ内の横線
        for(j=0;j<3;j++){
          g.setColor(new Color(25,25,25));
          g.drawLine(15+16+16*i+32*i,25+52+52*j,15+16+16*i+32*(i+1),25+52+52*j);
        }
        g.setColor(new Color(255,220,220));
        if((int)(parcent)==100){
          g.drawString((int)(parcent)+"%",15+16+16*i+32*i-1,25+195-(int)(195*parcent/100)+20);
        }else{
          g.drawString((int)(parcent)+"%",15+16+16*i+32*i-1+6,25+195-(int)(195*parcent/100)+20);
        }
     }
  }
}