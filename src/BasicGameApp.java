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
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

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


    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
     private butterfly butters;
     private butterfly cocoon;
     private butterfly caterpillar;

     private butterfly time;

     private butterfly water;




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
        if (caterpillar.rec.intersects(water.rec) && butters.isCrashing == false) {

            cocoon.isAlive=true;
            cocoon.isCrashing=true;
            caterpillar.isAlive=false;

            //butters.height = butters.height + 50;
            //butters.width = butters.width + 50;
          //  butters.isCrashing = true;


            System.out.println("Crash");
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
        }
        if (cocoon.rec.intersects(time.rec) && caterpillar.isCrashing == false) {

            butters.isAlive=true;
            cocoon.isCrashing=true;
            cocoon.isAlive=false;
            water.isAlive=false;
            time.isAlive=false;

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


//
//
       g.dispose();
//
      bufferStrategy.show();
    }
}