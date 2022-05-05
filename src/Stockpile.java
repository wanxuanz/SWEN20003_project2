import bagel.Font;

public class Stockpile extends Actor {
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Stockpile";
    private int fruitNum = 0  ;
    private static Font font = new Font("res/VeraMono.ttf", 24);

    /**
     * This is used to get the number of fruits for the stockpile
     * @return int This returns the number of fruits
     */
    public int getFruitNum() {
        return fruitNum;
    }

    /**
     * This is used to set the number of fruits for the stockpile
     * @param fruitNum This is the number of fruits
     */
    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }

    /**
     * This is the constructor of the stockpile
     * @param x This is the x-coordinate of the stockpile
     * @param y This is the y-coordinate of the stockpile
     */
    public Stockpile(int x, int y) {
        super("res/images/cherries.png", TYPE, x, y);
    }

    /**
     * This method is used to draw the stockpile and its current fruit number
     */
    @Override
    public void render() {
        getImage().drawFromTopLeft(getX(), getY());
        font.drawString(Integer.toString(getFruitNum()), getX(), getY());
    }

    /**
     * This method is used to update the stockpile
     */
    @Override
    public void update() {}
}
