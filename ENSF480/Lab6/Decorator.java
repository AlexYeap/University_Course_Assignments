import java.awt.*;
public class Decorator implements Component {
    private Component cmd;
    private int x;
    private int y;
    private int width;
    public int height;
    public void draw(Graphics g){
    }
    public Decorator(Component Cmd, int x, int y, int width, int height) {
        this.cmd = Cmd;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Component getCmd() {
        return cmd;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    
    
}
