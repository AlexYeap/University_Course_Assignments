import java.awt.*;
public class ColouredFrameDecorator extends Decorator{ 
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;;
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(g.getFont().getSize()));
        g2d.drawRect(this.getX(), this.getY(), this.getWidth(), height);
        this.getCmd().draw(g2d);
    }

    public ColouredFrameDecorator(Component component,int x, int y, int width, int height, int thickness){
    super(component,x,y,width,height);
    }
    
}
