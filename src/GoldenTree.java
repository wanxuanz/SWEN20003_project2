public class GoldenTree extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "GoldenTree";

    /**
     * This is the constructor of the Golden Tree
     * @param x This is the x-coordinate of the tree
     * @param y This is the y-coordinate of the tree
     */
    public GoldenTree(int x, int y) {
        super("res/images/gold-tree.png", TYPE, x, y);
    }

    /**
     * This method is used to update the golden tree
     */
    @Override
    public void update() {}
}
