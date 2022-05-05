import bagel.Font;

public class Tree extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Tree";
    private int fruitNum = 3;
    private static Font font = new Font("res/VeraMono.ttf", 24);

    /**
     * This is used to get the number of fruits for the tree
     * @return int This returns the number of fruits
     */
    public int getFruitNum() {
        return this.fruitNum;
    }

    /**
     * This is used to set the number of fruits for the tree
     * @param fruitNum This is the number of fruits
     */
    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }

    /**
     * This is the constructor of the tree
     * @param x This is the x-coordinate of the tree
     * @param y This is the y-coordinate of the tree
     */
    public Tree(int x, int y) {
        super("res/images/tree.png", TYPE, x, y);
    }

    /**
     * This method is used to draw the tree and its current fruit number
     */
    @Override
    public void render() {
        getImage().drawFromTopLeft(getX(), getY());
        font.drawString(Integer.toString(getFruitNum()), getX(), getY());
    }

    /**
     * This method is used to update the tree
     */
    @Override
    public void update() {}
}
