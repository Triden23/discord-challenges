import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/*
    This is a basic file handler. I will not comment much on this for now as I will probably change it in the future.
 */
public class FileHandler {
    private ArrayList<Image> dead,hurt,idle,jump,run,slide;
    private int x,y;
    private Toolkit toolkit;

    public FileHandler(){
        try {
            loadDead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(dead.size()>0) {
            x = dead.get(0).getHeight(null);
            y = dead.get(0).getHeight(null);
        }
        //loadHurt();
        //loadIdle();
        //loadJump();
        //loadRun();
        //loadSlide();
    }

    private void loadDead() throws IOException {

        System.out.println("Loading Sprites... dead");
        dead.add((Image) ImageIO.read(new File("Dead (1).png")));
        dead.add((Image) ImageIO.read(new File("Dead (2).png")));
        dead.add((Image) ImageIO.read(new File("Dead (3).png")));
        /*dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (4).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (5).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (6).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (7).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (8).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (9).png")));
        dead.add(ImageIO.read(this.getClass().getResource("main/resources/Dead (10).png")));*/

    }

    private void loadIdle() {
        System.out.println("Loading Sprites... idle");
    }

    private void loadHurt() {
        System.out.println("Loading Sprites... hurt");
    }

    private void loadJump() {
        System.out.println("Loading Sprites... jump");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void loadRun() {
        System.out.println("Loading Sprites... run");
    }

    private void loadSlide() {
        System.out.println("Loading Sprites... slide");
    }

    public ArrayList<Image> getDead() {
        return dead;
    }

    public ArrayList<Image> getHurt() {
        return hurt;
    }

    public ArrayList<Image> getIdle() {
        return idle;
    }

    public ArrayList<Image> getJump() {
        return jump;
    }

    public ArrayList<Image> getRun() {
        return run;
    }

    public ArrayList<Image> getSlide() {
        return slide;
    }
}
