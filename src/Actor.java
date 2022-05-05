import bagel.Image;

/**
 * This is the abstract class of actor
 * I have use the code taken from the project1 solution for this class
 */

public abstract class Actor {
    private int x;
    private int y;
    private final Image image;
    /**
     * This is the string that indicating the type of the actor
     */
    public final String type;

    /**
     * This is the constructor of Actor
     * @param filename This is the filename of the image for the actor
     * @param type This is the type of the actor
     * @param x This is the x-coordinate of the actor
     * @param y This is the y-coordinate of the actor
     */
    public Actor(String filename, String type, int x, int y) {
        image = new Image(filename);
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /** This is used to get the x-coordinate of the actor
     * @return int This returns the x-coordinate of the actor
     */
    public int getX() {
        return x;
    }

    /** This is used to get the y-coordinate of the actor
     * @return int This returns the y-coordinate of the actor
     */
    public int getY() {
        return y;
    }

    /** This is used to get the image of the actor
     * @return int This returns the image of the actor
     */
    public Image getImage() {
        return image;
    }

    /**
     * This is the method that run the update the method in each tick
     */
    public final void tick() {
        update();
    }

    /**
     * This is the method that draws the actor
     */
    public void render() {
        image.drawFromTopLeft(x, y);
    }

    /**
     * This is the method that change the position of the actor
     * @param deltaX This is the change in x direction
     * @param deltaY This is the change in y direction
     */
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    /**
     * This is the method that update the position and state of the actor
     */
    public abstract void update();
}
