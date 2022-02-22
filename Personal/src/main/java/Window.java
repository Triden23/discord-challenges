import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    //JFrame to hold the JPanel
    protected JFrame frameDisplay;

    //JPanel to paint the png's on as the animation goes.
    protected JPanel panelDisplay;

    //File handler so we can load specific sections of images
    protected FileHandler fileHandler;

    //Maybe changing to this depending on quality of the image.
    protected Graphics2D graphics2D;

    //The current selection of images that are loaded
    ArrayList<Image> currentAnimation;

    //the amount of time between each image change in MS
    protected int animationTimer = 80;

    //the default animation at start
    protected int animationIndex = 1;

    //order of load
    public Window(){
        //We want to load the art first so we can set the size of the Java.Swing components
        loadArt(animationIndex);

        //Setting up the Java.Swing components
        swingInit();

    }
    protected void start(){
        //Making the animation visible
        frameDisplay.setVisible(true);
        panelDisplay.setVisible(true);

        //Running the animation with Java.Swing paint and a wait as a timer to space out the paint to make it an animation
        runAnimation();
    }

    private void swingInit() {
        //initiating the variables.
        frameDisplay = new JFrame();
        panelDisplay = new JPanel();

        //setting the size of the panel and frame to the size of the image.
        frameDisplay.setSize(fileHandler.getX(),fileHandler.getY());
        panelDisplay.setSize(fileHandler.getX(),fileHandler.getY());

        //Setting the close operation and location of the JFrame.
        //Null centers the JFrame.
        frameDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDisplay.setLocationRelativeTo(null);

        //Painting and initial graphic
        panelDisplay.paint(currentAnimation.get(1).getGraphics());
        frameDisplay.add(panelDisplay);



    }


    //Retrieves the animation for the art.
    private void loadArt(int index){
        System.out.println("Loading....");

        //initiating the file handler
        fileHandler = new FileHandler();

        //Using an index system to load specific files
        loadIndex(index);
    }

    //This is in its own method because it will need to be called again later. this helps prevent us from initiating variable again.
    private void loadIndex(int index) {
        if(index == 1){
            currentAnimation.addAll(fileHandler.getDead());
        }
    }


    //Running a foreach to display each picture at the set delayed time
    private void runAnimation() {
        System.out.println("Animation starting");
        currentAnimation.forEach((e) -> {
            paint(e);
            timer(animationTimer);
        });
    }

    //basic timer that delays the picture change
    private void timer(int animationTimer) {
        try {
            wait(animationTimer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //paints the image.
    private void paint(Image e) {
        panelDisplay.paint(e.getGraphics());
    }
}
