import java.applet.Applet;
import java.awt.*;

public class BarGraph extends Applet {
  int pa[]=new int[12];

  public void init() {
     setBackground(new Color(25,25,25));
     pa[0]=180;pa[1]=120;pa[2]=83;pa[3]=112;pa[4]=90;pa[5]=109;
     pa[6]=120;pa[7]=130;pa[8]=200;pa[9]=155;pa[10]=180;pa[11]=170;
   }

  public void paint(Graphics g) {
     int i,j;
     g.setColor(new Color(255,255,255));
     // 外の四角
     g.drawRect(15,15,400,250);
     for(i=0;i<8;i++){
        g.setColor(new Color(50,50,50));
        g.fillOval(15+16+16*i+32*i-1,25,33,33);
        g.fillRect(15+16+16*i+32*i,25+20,32,210);
        for(j=0;j<3;j++){
          g.setColor(new Color(25,25,25));
          g.drawLine(15+16+16*i+32*i,25+54+52*j,15+16+16*i+32*(i+1),25+54+52*j);
        }
     }

  }
}