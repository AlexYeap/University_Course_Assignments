import java.awt.*;
public class BorderDecorator extends Decorator{
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,
        0, new float[]{9}, 0);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(dashed);
        g2d.drawRect(this.getX(), this.getY(), this.getWidth(), height);
        this.getCmd().draw(g);
    }

    public BorderDecorator(Component component,int x, int y, int width, int height){
        super(component, x, y, width, height);
        
    }
    
}
