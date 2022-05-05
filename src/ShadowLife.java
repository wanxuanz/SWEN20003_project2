import bagel.AbstractGame;
import bagel.Image;
import bagel.Input;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This is the main class for Project 2b
 * I have use the code taken from the project1 solution
 * @author Wanxuan Zhang
 */
public class ShadowLife extends AbstractGame {
    /**
     * This is the tile size for a single movement
     */
    public static final int TILE_SIZE = 64;
    private long lastTick = 0;
    private static int tickRate;
    private static int maxTick;
    private int tickNum = 0;
    private static String worldFile;
    protected static CopyOnWriteArrayList<Actor> actors = new CopyOnWriteArrayList<>();
    private final Image background = new Image("res/images/background.png");

    /**
     * This is the constructor of ShadowLife
     */
    public ShadowLife() {
        loadActors();
    }

    /**
     * This is used to get the arraylist of actors
     * @return CopyOnWriteArrayList This returns a arraylist of actors
     */
    public static CopyOnWriteArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * This is the main method which checks the validity of the input arguments and run the ShadowLife
     * @param args This is the input arguments
     */
    public static void main(String[] args) {
        if((args.length != 3)){
            PrintErrorMsg();
        }
        try{
            tickRate = Integer.parseInt(args[0]);
            maxTick = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            PrintErrorMsg();
        }
        if((tickRate < 0)||(maxTick < 0)){
            PrintErrorMsg();
        }
        worldFile = args[2];
        new ShadowLife().run();

    }

    /**
     * This method is used to print the error msg and exit when receive invalid input
     */
    public static void PrintErrorMsg() {
        System.out.println("usage: ShadowLife <tick rate> <max ticks> <world file>");
        System.exit(-1);
    }

    /**
     * This method is used to read in the actors from csv file.
     */
    private void loadActors() {
        try (BufferedReader reader = new BufferedReader(new FileReader(worldFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                switch (type) {
                    case Tree.TYPE:
                        actors.add(new Tree(x, y));
                        break;
                    case Gatherer.TYPE:
                        actors.add(new Gatherer(x, y));
                        break;
                    case Fence.TYPE:
                        actors.add(new Fence(x, y));
                        break;
                    case GoldenTree.TYPE:
                        actors.add(new GoldenTree(x, y));
                        break;
                    case Hoard.TYPE:
                        actors.add(new Hoard(x, y));
                        break;
                    case Pad.TYPE:
                        actors.add(new Pad(x, y));
                        break;
                    case Pool.TYPE:
                        actors.add(new Pool(x, y));
                        break;
                    case Stockpile.TYPE:
                        actors.add(new Stockpile(x, y));
                        break;
                    case Thief.TYPE:
                        actors.add(new Thief(x, y));
                        break;
                    case SignUp.TYPE:
                        actors.add(new SignUp(x, y));
                        break;
                    case SignDown.TYPE:
                        actors.add(new SignDown(x, y));
                        break;
                    case SignLeft.TYPE:
                        actors.add(new SignLeft(x, y));
                        break;
                    case SignRight.TYPE:
                        actors.add(new SignRight(x, y));
                        break;
                }
            }
        // exit the program and print error msg if catch IOException
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * This method is used to create new actor and add to the arraylist
     * @param type This the the type of the actor
     * @param x This is the x-coordinate of the actor
     * @param y This is the y-coordinate of the actor
     */
    public static void addNewActor(String type, int x, int y) {
        switch (type) {
            case Thief.TYPE:
                actors.add(new Thief(x, y));
                break;
            case Gatherer.TYPE:
                actors.add(new Gatherer(x, y));
                break;
        }
    }

    /**
     * This method is used to update the image within specified ticks
     * @param input This is the input
     */
    @Override
    protected void update(Input input) {
        // check whether there are more than the maximum number of ticks pass during a simulation
        if(tickNum > maxTick) {
            System.out.println("Timed out");
            System.exit(-1);
        }

        // check whether there is actors running
        boolean running = false;
        for (Actor actor: actors) {
            if ((actor instanceof Gatherer)||(actor instanceof Thief)) {
                if(((Gatherer)actor).isActive()) {
                    running = true;
                    break;
                }
            }
        }

        // exit if the actors are not active, print the tick num and number of fruits
        if(!running) {
            System.out.println(tickNum + " ticks");
            for (Actor actor: actors) {
                if (actor instanceof Stockpile) {
                    System.out.println(((Stockpile) actor).getFruitNum());
                } else if (actor instanceof Hoard) {
                    System.out.println(((Hoard) actor).getFruitNum());
                }
            }
            System.exit(0);
        }

        // If enough time has passed, run the next tick
        if (System.currentTimeMillis() - lastTick > tickRate) {
            lastTick = System.currentTimeMillis();
            for (Actor actor : actors) {
                if (actor != null) {
                    actor.tick();
                }
            }
            tickNum++;
        }

        // Draw all elements
        background.drawFromTopLeft(0, 0);
        for (Actor actor : actors) {
            if (actor != null) {
                actor.render();
            }
        }
    }
}
