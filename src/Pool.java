public class Pool extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Pool";

    /**
     * This is the constructor of the pool
     * @param x This is the x-coordinate of the pool
     * @param y This is the y-coordinate of the pool
     */
    public Pool(int x, int y) {
        super("res/images/pool.png", TYPE, x, y);
    }

    /**
     * This method is used to update the pool
     */
    @Override
    public void update() {}
}
