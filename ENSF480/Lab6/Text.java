/*
* File Name: Text.java
* Assignment: Lab 6 ExA
* Lab Section: BO2
* Completed by: Alex Yeap
* Submission Date: for 11/9/2022
*/
import java.awt.*;
public class Text implements Component {
    private int x;  
    private int y;
    private String text;

    
    public Text(String text ,int x, int y) {
        this.x = x;
        this.y = y;
        this.text = text;
    }


    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(g.getFont().getSize()));
        g2d.drawString(text, x, y);

    }

}
