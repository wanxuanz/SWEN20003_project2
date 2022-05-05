import bagel.Font;

public class Hoard extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Hoard";
    private int fruitNum = 0;
    private static Font font = new Font("res/VeraMono.ttf", 24);

    /**
     * This is used to get the number of fruits for the hoard
     * @return int This returns the number of fruits
     */
    public int getFruitNum() {
        return fruitNum;
    }

    /**
     * This is used to set the number of fruits for the hoard
     * @param fruitNum This is the number of fruits
     */
    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }

    /**
     * This is the constructor of the hoard
     * @param x This is the x-coordinate of the hoard
     * @param y This is the y-coordinate of the hoard
     */
    public Hoard(int x, int y) {
        super("res/images/hoard.png", TYPE, x, y);
    }

    /**
     * This method is used to draw the hoard and its current fruit number
     */
    @Override
    public void render() {
        getImage().drawFromTopLeft(getX(), getY());
        font.drawString(Integer.toString(getFruitNum()), getX(), getY());
    }

    /**
     * This method is used to update the hoard
     */
    @Override
    public void update() {}
}
