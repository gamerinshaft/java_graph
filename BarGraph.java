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
     int i;
     g.setColor(new Color(0,0,0));
     g.drawLine(50,250,350,250);
     g.drawLine(50,250,50,50);
     for(i=0;i<13;i++){
       g.drawLine(50+i*25,250,50+i*25,252);
     }
     for(i=0;i<5;i++){
       g.drawLine(48,50+i*50,50,50+i*50);
       g.drawString(i*50+"",5,250-i*50);
     }
     for(i=0;i<12;i++){
       g.setColor(new Color(0,0,0));
       g.drawString(i+1+"",57+i*25,263);
       g.setColor(new Color(0,0,255));
       g.fillRect(53+i*25+5,250-pa[i],10,pa[i]);
     }

  }
}