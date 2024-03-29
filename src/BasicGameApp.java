//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image buttersPic;
    public Image cocoonPic;
    public Image caterpillarPic;
    public Image skyBack;
    public Image timePic;
    public Image waterPic;

    public Image pblue;

    public Image pgold;

    public Image pvividPink;

    public Image plightPink;

    public Image ppurple;

    public Image pgreen;

    public Image ppinkflower;

    public Image ppurpleflower;

    public Image pbluebird;

    public Image pdove;

    public butterfly[] fliers = new butterfly[100];



    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
     private butterfly butters;
     private butterfly cocoon;
     private butterfly caterpillar;

     private butterfly time;

     private butterfly water;

     private butterfly blue;

     private butterfly gold;

     private butterfly vividPink;

     private butterfly lightPink;

     private butterfly purple;

     private butterfly green;

     private butterfly pinkFlower;

     private butterfly purpleFlower;

     private butterfly blueBird;

     public butterfly dove;





    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        buttersPic = Toolkit.getDefaultToolkit().getImage("butterfly.png"); //load the picture
        butters= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        butters.isAlive=false;

        cocoonPic= Toolkit.getDefaultToolkit().getImage("cocoon.png");
        cocoon= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        cocoon.isAlive=false;

        caterpillarPic= Toolkit.getDefaultToolkit().getImage("caterpillar.png");
       caterpillar= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
       caterpillar.isAlive=true;

        timePic= Toolkit.getDefaultToolkit().getImage("time.png");
        time= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        time.isAlive=true;

        waterPic= Toolkit.getDefaultToolkit().getImage("water.png");
        water= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        water.isAlive=true;

        skyBack = Toolkit.getDefaultToolkit().getImage("sky back.jpg"); //load the picture

        pblue= Toolkit.getDefaultToolkit().getImage("blue");
        blue= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        blue.isAlive=true;

        pbluebird= Toolkit.getDefaultToolkit().getImage("blue bird");
        blueBird= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        blueBird.isAlive=true;

        pdove= Toolkit.getDefaultToolkit().getImage("dove");
        dove= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        dove.isAlive=true;

        pgold= Toolkit.getDefaultToolkit().getImage("gold");
        gold= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        gold.isAlive=true;

        pgreen= Toolkit.getDefaultToolkit().getImage("green");
        green= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        green.isAlive=true;

        plightPink= Toolkit.getDefaultToolkit().getImage("light pink");
        lightPink= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        lightPink.isAlive=true;

        ppinkflower= Toolkit.getDefaultToolkit().getImage("pink flower");
        pinkFlower= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        pinkFlower.isAlive=true;

        ppurple= Toolkit.getDefaultToolkit().getImage("purple");
        purple= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        purple.isAlive=true;

        ppurpleflower= Toolkit.getDefaultToolkit().getImage("purpleFlower");
        purpleFlower= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        purpleFlower.isAlive=true;

        pvividPink= Toolkit.getDefaultToolkit().getImage("vivid pink");
        vividPink= new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        vividPink.isAlive=true;


        for(int z=0; z<fliers.length; z++){
            fliers[z]=new butterfly((int)(Math.random()*940),(int)(Math.random()*640));
        }





    }



//
////*******************************************************************************
////User Method Section
////
//// put your code to do things here.
//
//    // main thread
//    // this is the code that plays the game after you set things up
    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    }
//
//
    public void moveThings() {
        //calls the move( ) code in the objects
        caterpillar.wrap();
        water.bounce();
        time.bounce();
        cocoon.bounce();
        butters.wrap();
        blue.bounce();
        dove.bounce();
        blueBird.bounce();
        green.bounce();
        gold.bounce();
        lightPink.bounce();
        pinkFlower.bounce();
        purple.bounce();
        purpleFlower.bounce();


        vividPink.bounce();

        for(int x=0; x<fliers.length; x++){
           fliers[x].wrap();
        }

        for(int x=0; x<fliers.length;x++) {
            if (fliers[x].rec.intersects(caterpillar.rec) && fliers[x].isCrashing == false) {
                caterpillar.height=10+caterpillar.height;
                caterpillar.width=10+caterpillar.width;



                if (caterpillar.rec.intersects(water.rec) && water.isCrashing == false) {

                    cocoon.isAlive = true;
                    water.isCrashing = true;
                    caterpillar.isAlive = false;

                    //butters.height = butters.height + 50;
                    //butters.width = butters.width + 50;
                    //  butters.isCrashing = true;


                    System.out.println("Crash");
                }
            }
        }

        for(int z=0;z<fliers.length;z++){
            for(int y=z+1;y<fliers.length; y++){
                if(fliers[z].rec.intersects(fliers[y].rec)&&fliers[z].isCrashing==false){
                    System.out.println("fliers crashing!");
                }
            }
        }
//
                    //}
                    //...
//
//       // if(astro.rec.intersects(astro2.rec)==false){
//
//         //   astro.isCrashing=false;
//       // }
//     //   if(astro.rec.intersects(astro3.rec) && astro.isCrashing==false){
//
//
//
//          //  astro3.height=astro3.height-5;
//        //    astro3.width=astro3.width-5;
//         //   astro3.isCrashing=true;
//
//
////            System.out.println("Crash");
////
////        }
////
////        if(astro.rec.intersects(astro3.rec)==false){
////
////            astro.isCrashing=false;
////        }
//
////        if(astro2.rec.intersects(astro3.rec) && astro.isCrashing==false){
////
////
////
////            astro2.intersect();
////            astro3.intersect();
////            astro3.isCrashing=true;
//
//
//            System.out.println("Crash");
//
////        }
////
////        if(astro2.rec.intersects(astro3.rec)==false){
////
////            astro2.isCrashing=false;
////        }
//
//
//
//
//    }
//
//
//
                //}

                if (caterpillar.rec.intersects(water.rec) == false) {
                    water.isCrashing = false;

                }
                if (cocoon.rec.intersects(time.rec) && cocoon.isCrashing == false) {

                    butters.isAlive = true;
                    cocoon.isCrashing = true;
                    cocoon.isAlive = false;
                    water.isAlive = false;
                    time.isAlive = false;

                    //butters.height = butters.height + 50;
                    //butters.width = butters.width + 50;
                    //  butters.isCrashing = true;


                    System.out.println("Crash");
//.
                    //}
                    //...
//
//       // if(astro.rec.intersects(astro2.rec)==false){
//
//         //   astro.isCrashing=false;
//       // }
//     //   if(astro.rec.intersects(astro3.rec) && astro.isCrashing==false){
//
//
//
//          //  astro3.height=astro3.height-5;
//        //    astro3.width=astro3.width-5;
//         //   astro3.isCrashing=true;
//
//
////            System.out.println("Crash");
////
////        }
////
////        if(astro.rec.intersects(astro3.rec)==false){
////
////            astro.isCrashing=false;
////        }
//
////        if(astro2.rec.intersects(astro3.rec) && astro.isCrashing==false){
////
////
////
////            astro2.intersect();
////            astro3.intersect();
////            astro3.isCrashing=true;
//
//
//            System.out.println("Crash");
//
////        }
////
////        if(astro2.rec.intersects(astro3.rec)==false){
////
////            astro2.isCrashing=false;
////        }
//
//
//
//
//    }
//
//
//
                }

                if (cocoon.rec.intersects(time.rec)) {
                    cocoon.isCrashing = false;
                }


            }

//    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
//
            // Graphics setup method


   private void setUpGraphics() {
       frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
       panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
       panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel

       panel.setLayout(null);   //set the layout

       // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
       // and trap input events (Mouse and Keyboard events)
       canvas = new Canvas();
       canvas.setBounds(0, 0, WIDTH, HEIGHT);
       canvas.setIgnoreRepaint(true);
       canvas.addKeyListener(this);

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
//
//    }
//
//
//    //paints things on the screen using bufferStrategy
   }
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(skyBack, 0, 0, WIDTH, HEIGHT,  null);
//
//        //draw the image of the astronaut
        if(butters.isAlive==true){
            g.drawImage(buttersPic, butters.xpos, butters.ypos, butters.width, butters.height, null);
        }
       if(cocoon.isAlive==true){
           g.drawImage(cocoonPic, cocoon.xpos, cocoon.ypos, cocoon.width, cocoon.height, null);
       }
      if(caterpillar.isAlive==true){
          g.drawImage(caterpillarPic, caterpillar.xpos, caterpillar.ypos, caterpillar.width, caterpillar.height, null);
      }
       if(water.isAlive==true){
           g.drawImage(waterPic, water.xpos, water.ypos, water.width, water.height, null);
       }
       if(time.isAlive==true){
           g.drawImage(timePic, time.xpos,time.ypos, time.width, time.height, null);
       }

       for(int x=0;x<fliers.length;x++){
           g.drawImage(buttersPic, fliers[x].xpos, fliers[x].ypos, fliers[x].width, fliers[x].height, null);
       }


//
//
       g.dispose();
//
      bufferStrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==38){
            System.out.println("going up");
            time.isNorth=true;

        }

        if(e.getKeyCode()==40){
            System.out.println("going down");
            time.isSouth =true;
        }

        if(e.getKeyCode()==37){
            System.out.println("going right");
            time.isEast = true;
        }

        if(e.getKeyCode()==39){
            System.out.println("going left");
           time.isWest = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==38) {
            System.out.println("going up");
            time.isNorth = false;

        }

        if(e.getKeyCode()==37) {
            System.out.println("going left");
            time.isWest = false;

        }

        if(e.getKeyCode()==39) {
            System.out.println("going right");
            time.isEast = false;

        }

        if(e.getKeyCode()==48) {
            System.out.println("going down");
            time.isSouth = false;

        }

    }
}