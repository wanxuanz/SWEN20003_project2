public class SignDown extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "SignDown";

    /**
     * This is the constructor of the SignDown
     * @param x This is the x-coordinate of the SignDown
     * @param y This is the y-coordinate of the SignDown
     */
    public SignDown(int x, int y) {
        super("res/images/down.png", TYPE, x, y);
    }

    /**
     * This method is used to update the SignDown
     */
    @Override
    public void update() {}
}
