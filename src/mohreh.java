import java.awt.*;
import java.util.ArrayList;
public interface mohreh{
    void move(rect e);
    void draw(Graphics g);
    void remove();
    boolean can(rect d , ArrayList<rect> a, boolean isfirst);
    boolean cankick(rect d , ArrayList<rect> a);
    Point getxy();
    Color getrang();
    boolean getchange();
}