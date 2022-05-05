public class SignRight extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "SignRight";

    /**
     * This is the constructor of the SignRight
     * @param x This is the x-coordinate of the SignRight
     * @param y This is the y-coordinate of the SignRight
     */
    public SignRight(int x, int y) {
        super("res/images/right.png", TYPE, x, y);
    }

    /**
     * This method is used to update the SignRight
     */
    @Override
    public void update() {}
}
