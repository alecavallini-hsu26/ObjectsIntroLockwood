import java.awt.*;

public class Hero {
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public Hero(int pxpos, int pypos, int pdx, int pdy, int pwidth,int pheight){
        xpos=pxpos;
        ypos=pypos;
        dx=pdx;
        dy=pdy;
        width=pwidth;
        height=pheight;
        isAlive=true;
        rec=new Rectangle(xpos,ypos,width,height);

    }
    public void printInfo(){
        System.out.println("X position: " + xpos);
        System.out.println("Y position: " + ypos);
        System.out.println("x speed: "+dx);
        System.out.println("y speed: "+dy);
        System.out.println("height: "+width);
        System.out.println("height: "+height);
        System.out.println("isAlive: "+isAlive);
    }
    public void move(){
        xpos = xpos+dx;
        ypos = ypos+dy;

        rec = new Rectangle(xpos, ypos, width,height);
    }
    public void wrappingMove() {
        //this method should have your hero show up back on the opposite side of the screen if it goes oof the top, bottom,
        // left or right.
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos > 1000) {
            xpos = 0;
            xpos = xpos + dx;
        }
        if (ypos > 700) {
            ypos = 0;
            ypos = ypos + dy;
        }
        if (ypos < 0) {
            ypos = 0;
            ypos = ypos - dy;
        }
        if (xpos < 0) {
            xpos = 0;
            xpos = xpos + dx;
        }
        rec = new Rectangle(xpos, ypos, width,height);
    }

    public void bouncingMove(){
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos > 1000) {

            dx=-dx;
        }
        if (ypos > 660) {

            dy=-dy;
        }
        if (ypos < 0) {

            dy=-dy;
        }
        if (xpos < 0) {

            dx=-dx;
        }
        rec = new Rectangle(xpos, ypos, width,height);


// this method should have your hero bounce (aka reverse direction) when it hits the ceiling, floor, or walls of the screen.

    }
    public void boltMove(){
        xpos = xpos + dx;
        ypos = ypos;
        if (xpos > 950) {
            xpos=300;
        }

        if (xpos < 100) {
            xpos=825;
        }
        rec = new Rectangle(xpos, ypos, width,height);

    }
}
