public class Pad extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Pad";

    /**
     * This is the constructor of the pad
     * @param x This is the x-coordinate of the pad
     * @param y This is the y-coordinate of the pad
     */
    public Pad(int x, int y) {
        super("res/images/pad.png", TYPE, x, y);
    }

    /**
     * This method is used to update the pad
     */
    @Override
    public void update() {}
}
