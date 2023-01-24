import java.awt.*;
public class ColouredGlassDecorator extends Decorator{ 
    public void draw(Graphics g){
        this.getCmd().draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.green);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 * 0.05f));
        g2d.fillRect(this.getX(), this.getY(), this.getWidth(), height);
    }

    public ColouredGlassDecorator(Component component,int x, int y, int width, int height){
    super(component,x,y,width,height);
    }
    
}
