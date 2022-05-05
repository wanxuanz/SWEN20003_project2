public class SignLeft extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "SignLeft";

    /**
     * This is the constructor of the SignLeft
     * @param x This is the x-coordinate of the SignLeft
     * @param y This is the y-coordinate of the SignLeft
     */
    public SignLeft(int x, int y) {
        super("res/images/left.png", TYPE, x, y);
    }

    /**
     * This method is used to update the SignLeft
     */
    @Override
    public void update() {}
}
