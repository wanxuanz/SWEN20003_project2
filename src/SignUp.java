public class SignUp extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "SignUp";

    /**
     * This is the constructor of the SignUp
     * @param x This is the x-coordinate of the SignUp
     * @param y This is the y-coordinate of the SignUp
     */
    public SignUp(int x, int y) {
        super("res/images/up.png", TYPE, x, y);
    }

    /**
     * This method is used to update the SignUp
     */
    @Override
    public void update() {}
}
