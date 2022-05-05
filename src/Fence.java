public class Fence extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Fence";

    /**
     * This is the constructor of the fence
     * @param x This is the x-coordinate of the fence
     * @param y This is the y-coordinate of the fence
     */
    public Fence(int x, int y) {
        super("res/images/fence.png", TYPE, x, y);
    }

    /**
     * This method is used to update the fence
     */
    @Override
    public void update() {}
}
