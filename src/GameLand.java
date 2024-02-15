//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class GameLand implements Runnable {

    //Variable Declaration Section
    //Declare the variables used in the program
    //You can set their initial values here if you want

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    //Declare the objects used in the program below


    /** Step 0 - declare object **/
//    public Hero skier;

    public Hero potter;
    public Hero voldemort;
    public Hero minion;
    public Hero minion1;
    public Hero student;
    public Hero student1;
    public Hero redBolt;
    public Hero redBolt1;
    public Hero greenBolt;
    public Hero greenBolt1;
//    public Hero explosion;
//    public Hero slime;
//    public Boolean isAlive;

//    public Hero monster;
//
//    public Hero star;
//
//    public Hero snowman;

    /** Step 1 declare image for object**/

    public Image potterPic;
    public Image voldemortPic;
    public Image minionPic;
    public Image minion1Pic;
    public Image studentPic;
    public Image student1Pic;
    public Image redBoltPic;
    public Image redBolt1Pic;
    public Image greenBoltPic;
    public Image greenBolt1Pic;
    public Image explosionPic;
    public Image slimePic;
    public Image trophyPic;

//    Declare background image
    public Image hallwayPic;

//    intersection booleans
    public boolean redBoltIsIntersectingStudent;
    public boolean redBoltIsIntersectingStudent1;
    public boolean redBolt1IsIntersectingStudent;
    public boolean redBolt1IsIntersectingStudent1;

    public boolean greenBoltIsIntersectingMinion;
    public boolean greenBolt1IsIntersectingMinion;
    public boolean greenBoltIsIntersectingMinion1;
    public boolean greenBolt1IsIntersectingMinion1;

    public boolean redBoltIsIntersectinggreenBolt;
    public boolean redBoltIsIntersectinggreenBolt1;
    public boolean redBolt1IsIntersectinggreenBolt;
    public boolean redBolt1IsIntersectinggreenBolt1;

//    public Image skierPic;
//    public Image monsterPic;
//
//    public Image starPic;
//
//    public Image alpsPic;
//
//    public Image snowmanPic;


    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
       GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
        /** Step 2 - construct object**/
//        skier = new Hero(200,300, -15,10,100,50);
//        monster = new Hero(500, 400,10,-20,50,40);
//        star = new Hero(400,100,20,40,50,30);
//        snowman = new Hero(600,10,10,5,150,150);

        potter = new Hero(25,300,0,0,75,75);
        voldemort = new Hero(950,300,0,0,95,95);
        student = new Hero(125,300,0,15,65,65);
        student1 = new Hero(125,400,0,15,65,65);
        minion = new Hero(825,300,0,15,65,65);
        minion1 = new Hero(825,500,0,15,65,65);
        redBolt = new Hero(minion.xpos,minion.ypos,-10,0,65,65);
        redBolt1 = new Hero(minion1.xpos,minion1.ypos,-10,0,65,65);
        greenBolt = new Hero(student.xpos,student.xpos,10,0,65,65);
        greenBolt1 = new Hero(student1.xpos,student.ypos,10,0,65,65);



        /** Step 3 - add image to object**/
//        skierPic= Toolkit.getDefaultToolkit().getImage("skier.png");
//        skier.printInfo();
//
//        monsterPic= Toolkit.getDefaultToolkit().getImage("monster.png");
//        monster.printInfo();
//
//        alpsPic = Toolkit.getDefaultToolkit().getImage("alps.jpg");
//
//        starPic = Toolkit.getDefaultToolkit().getImage("star.png");
//        star.printInfo();
//
//        snowmanPic = Toolkit.getDefaultToolkit().getImage("snowman.png");
//        snowman.printInfo();
        hallwayPic = Toolkit.getDefaultToolkit().getImage("hallway.jpg");
        potterPic= Toolkit.getDefaultToolkit().getImage("potter.png");
        voldemortPic= Toolkit.getDefaultToolkit().getImage("voldemort.png");
        studentPic= Toolkit.getDefaultToolkit().getImage("student.png");
        student1Pic= Toolkit.getDefaultToolkit().getImage("student.png");
        minionPic= Toolkit.getDefaultToolkit().getImage("minion.png");
        minion1Pic= Toolkit.getDefaultToolkit().getImage("minion.png");
        redBoltPic= Toolkit.getDefaultToolkit().getImage("redBolt.png");
        redBolt1Pic= Toolkit.getDefaultToolkit().getImage("redBolt.png");
        greenBoltPic= Toolkit.getDefaultToolkit().getImage("greenBolt.png");
        greenBolt1Pic= Toolkit.getDefaultToolkit().getImage("greenBolt.png");
        slimePic = Toolkit.getDefaultToolkit().getImage("slime.png");
        explosionPic = Toolkit.getDefaultToolkit().getImage("explosion.png");
        trophyPic = Toolkit.getDefaultToolkit().getImage("trophy.png");



        //for each object that has a picture, load in images as well


    }// GameLand()

//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 20 ms
            collisions();
        }

    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of your objects below:
        /** Step 4 - draw object images**/
//        g.drawImage(alpsPic,0,0,WIDTH,HEIGHT,null );
//        g.drawImage(starPic, star.xpos,star.ypos,star.width,star.height,null);
//        g.drawImage(skierPic,skier.xpos,skier.ypos,skier.width,skier.height,null);
//        g.drawImage(monsterPic,monster.xpos,monster.ypos,monster.width,monster.height,null);
//        g.drawImage(snowmanPic,snowman.xpos,snowman.ypos,snowman.width,snowman.height,null);
        g.drawImage(hallwayPic,0,0,WIDTH,HEIGHT,null );

        g.drawImage(potterPic,potter.xpos,potter.ypos,potter.width,potter.height,null);

        g.drawImage(voldemortPic,voldemort.xpos,voldemort.ypos,voldemort.width,voldemort.height,null);

        if (student.isAlive==true){
            g.drawImage(studentPic,student.xpos,student.ypos,student.width,student.height,null);
            g.drawImage(greenBoltPic,greenBolt.xpos,greenBolt.ypos,greenBolt.width,greenBolt.height,null);} else {

            g.drawImage(trophyPic,student.xpos,student.ypos,student.width,student.height,null);
        }
        if (student1.isAlive==true){
            g.drawImage(student1Pic,student1.xpos,student1.ypos,student1.width,student1.height,null);
            g.drawImage(greenBolt1Pic,greenBolt1.xpos,greenBolt1.ypos,greenBolt1.width,greenBolt1.height,null);} else {

            g.drawImage(trophyPic,student1.xpos,student1.ypos,student1.width,student1.height,null);
        }

        if (minion.isAlive==true){
            g.drawImage(minionPic,minion.xpos,minion.ypos,minion.width,minion.height,null);
            g.drawImage(redBoltPic,redBolt.xpos,redBolt.ypos,redBolt.width,redBolt.height,null);} else {

            g.drawImage(explosionPic,minion.xpos,minion.ypos,minion.width,minion.height,null);
        }

//        Minion1 and redBolt1
        if (minion1.isAlive==true){
            g.drawImage(minion1Pic,minion1.xpos,minion1.ypos,minion1.width,minion1.height,null);
            g.drawImage(redBolt1Pic,redBolt1.xpos,redBolt1.ypos,redBolt1.width,redBolt1.height,null);
        } else {

            g.drawImage(explosionPic,minion1.xpos,minion1.ypos,minion1.width,minion1.height,null);
        }





        //dispose the images each time(this allows for the illusion of movement).
        g.dispose();

        bufferStrategy.show();
    }

    public void moveThings() {
        //call the move() method code from your object class
        student.bouncingMove();
        student1.bouncingMove();
        minion.bouncingMove();
        minion1.bouncingMove();
        redBolt.boltMove();
        redBolt1.boltMove();
        greenBolt.boltMove();
        greenBolt1.boltMove();

    }
    public void collisions(){

//        Student work
//        redBolt with student
        if (redBolt.rec.intersects(student.rec) && redBoltIsIntersectingStudent==false){
            redBoltIsIntersectingStudent=true;
            student.isAlive=false;
            student.dy=0;
            student.dx=0;
            redBolt.xpos=825;
        }
        if (redBolt.rec.intersects(student.rec)==false){
            redBoltIsIntersectingStudent=false;
        }

//        redBolt1 with student
        if (redBolt1.rec.intersects(student.rec) && redBolt1IsIntersectingStudent==false){
            redBolt1IsIntersectingStudent=true;
            student.dy=0;
            student.isAlive=false;
            student.dx=0;
            redBolt1.xpos=825;
        }
        if (redBolt1.rec.intersects(student.rec)==false){
            redBolt1IsIntersectingStudent=false;
        }
//        redBolt with student1
        if (redBolt.rec.intersects(student1.rec) && redBoltIsIntersectingStudent1==false){
            redBoltIsIntersectingStudent1=true;
            student1.dy=0;
            student1.isAlive=false;
            student1.dx=0;
            redBolt.xpos=825;
        }
        if (redBolt.rec.intersects(student1.rec)==false){
            redBoltIsIntersectingStudent1=false;
        }
//        redBolt1 with student1
        if (redBolt1.rec.intersects(student1.rec) && redBolt1IsIntersectingStudent1==false){
            System.out.println("ouch");
            redBolt1IsIntersectingStudent1=true;
            student.dy=0;
            student1.isAlive=false;
            student.dx=0;
            redBolt1.xpos=825;
        }
        if (redBolt1.rec.intersects(student1.rec)==false){
            redBolt1IsIntersectingStudent1=false;
        }


//        Minion work
//        greenBolt with minion
        if (greenBolt.rec.intersects(minion.rec) && greenBoltIsIntersectingMinion==false){
            greenBoltIsIntersectingMinion=true;
            minion.dy=0;
            minion.isAlive=false;
            minion.dx=0;
            greenBolt.xpos=125;

        }
        if (greenBolt.rec.intersects(minion.rec)==false){
            greenBoltIsIntersectingMinion=false;
        }

//        greenBolt with minion1
        if (greenBolt.rec.intersects(minion1.rec) && greenBoltIsIntersectingMinion1==false){
            greenBoltIsIntersectingMinion1=true;
            minion1.dy=0;
            minion1.isAlive=false;
            minion1.dx=0;
            greenBolt.xpos=125;

        }
        if (greenBolt.rec.intersects(minion1.rec)==false){
            greenBoltIsIntersectingMinion1=false;
        }

//        greenBolt1 with minion

        if (greenBolt1.rec.intersects(minion.rec) && greenBolt1IsIntersectingMinion==false){
            greenBolt1IsIntersectingMinion=true;
            minion1.dy=0;
            minion1.isAlive=false;
            minion1.dx=0;
            greenBolt1.xpos=125;

        }
        if (greenBolt1.rec.intersects(minion.rec)==false) {
            greenBolt1IsIntersectingMinion = false;
        }
//            greenBolt1 with minion1
        if (greenBolt1.rec.intersects(minion1.rec) && greenBolt1IsIntersectingMinion1==false){
            greenBolt1IsIntersectingMinion1=true;
            minion1.dy=0;
            minion1.isAlive=false;
            minion1.dx=0;
            greenBolt1.xpos=125;

        }
        if (greenBolt1.rec.intersects(minion1.rec)==false) {
            greenBolt1IsIntersectingMinion1 = false;
        }

//        Bolts w/ each other
//        redBolt with greenBolt
        if (redBolt.rec.intersects(greenBolt.rec) && redBoltIsIntersectinggreenBolt==false){
            System.out.println("ouch");
            redBoltIsIntersectinggreenBolt=true;
            redBolt.xpos=825;
            redBolt.ypos=minion.ypos;
            greenBolt.xpos=125;
            greenBolt.ypos=student.ypos;
        }
        if (redBolt.rec.intersects(greenBolt.rec)==false){
            redBoltIsIntersectinggreenBolt=false;
        }
//        redBolt1 with greenBolt
        if (redBolt1.rec.intersects(greenBolt.rec) && redBolt1IsIntersectinggreenBolt==false){
            System.out.println("ouch");
            redBolt1IsIntersectinggreenBolt=true;
            redBolt1.xpos=825;
            redBolt1.ypos=minion.ypos;
            greenBolt.xpos=125;
            greenBolt.ypos=student.ypos;
        }
        if (redBolt1.rec.intersects(greenBolt.rec)==false){
            redBolt1IsIntersectinggreenBolt=false;
        }
//        redBolt with greenBolt1
        if (redBolt.rec.intersects(greenBolt1.rec) && redBoltIsIntersectinggreenBolt1==false){
            System.out.println("ouch");
            redBoltIsIntersectinggreenBolt1=true;
            redBolt.xpos=825;
            redBolt.ypos=minion.ypos;
            greenBolt1.xpos=125;
            greenBolt1.ypos=student.ypos;
        }
        if (redBolt.rec.intersects(greenBolt1.rec)==false){
            redBoltIsIntersectinggreenBolt1=false;
        }
//        redBolt1 with greenBolt1
        if (redBolt1.rec.intersects(greenBolt1.rec) && redBolt1IsIntersectinggreenBolt1==false){
            System.out.println("ouch");
            redBolt1IsIntersectinggreenBolt1=true;
            redBolt1.xpos=825;
            redBolt1.ypos=minion.ypos;
            greenBolt1.xpos=125;
            greenBolt1.ypos=student.ypos;
        }
        if (redBolt1.rec.intersects(greenBolt1.rec)==false){
            redBolt1IsIntersectinggreenBolt1=false;
        }

//
//        if (greenBolt.rec.intersects(minion.rec)){
//            skier.height=skier.height+2;
//        }
//        if (greenBolt.rec.intersects(redBolt.rec)){
//            skier.dx=skier.dx+2;
//            skier.dy=skier.dy+5;
//        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}