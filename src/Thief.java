public class Thief extends Actor {
    private int direction = Direction.UP;
    private boolean carrying = false;
    private boolean consuming = false;
    private boolean active = true;
    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Thief";
    /**
     * This number indicate the object is moving back to its previous position
     */
    public static final int REVERSE = -1;
    /**
     * This number indicate the object is moving forward
     */
    public static final int POSITIVE = 1;
    /**
     * This number indicate the object rotates in clockwise direction
     */
    public static final boolean CLOCKWISE = true;
    /**
     * This number indicate the object rotates in counter-clockwise direction
     */
    public static final boolean ANTICLOCKWISE = false;
    /**
     * This number represents 90 degrees
     */
    public static final int NINTY = 90;
    /**
     * This number represents 270 degrees
     */
    public static final int TWO_HANDERD_SEVENTY = 270;

    /**
     * This is the constructor of the thief
     * @param x This is the x-coordinate of the thief
     * @param y This is the y-coordinate of the thief
     */
    public Thief(int x, int y) {
        super("res/images/thief.png", TYPE, x, y);
    }

    /**
     * This is used to get the current direction
     * @return int This returns the current direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * This is used to set the new direction
     * @param direction This is the current direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * This method is used to update the state and location of the gatherer
     */
    @Override
    public void update() {
        if(active) {
            MoveInDirection(direction, POSITIVE);
        }
        // check if any other actors in this position
        for (Actor actor : ShadowLife.getActors()) {
            if (actor.getX() == this.getX() && actor.getY() == this.getY()) {
                // move to the previous position if find a fence
                if (actor instanceof Fence) {
                    active = false;
                    MoveInDirection(direction, REVERSE);

                    // rotate direction and create new Thief if Thief meet a pool
                } else if (actor instanceof Pool) {
                    ShadowLife.addNewActor(TYPE, actor.getX(), actor.getY());
                    ((Thief) ShadowLife.getActors().get(ShadowLife.getActors().size() - 1))
                            .setDirection(Direction.rotateDirection(direction, NINTY, ANTICLOCKWISE));
                    ShadowLife.addNewActor(TYPE, actor.getX(), actor.getY());
                    ((Thief)ShadowLife.getActors().get(ShadowLife.getActors().size() - 1))
                            .setDirection(Direction.rotateDirection(direction, NINTY, CLOCKWISE));

                    MoveInDirection(direction, POSITIVE);
                    MoveInDirection(((Thief)ShadowLife.getActors()
                            .get(ShadowLife.getActors().size() - 1)).getDirection(), POSITIVE);
                    ShadowLife.getActors().remove(actor);

                    // Set direction to match the sign
                } else if (actor instanceof SignUp) {
                    setDirection(Direction.UP);
                } else if (actor instanceof SignDown) {
                    setDirection(Direction.DOWN);
                } else if (actor instanceof SignLeft) {
                    setDirection(Direction.LEFT);
                } else if (actor instanceof SignRight) {
                    setDirection(Direction.RIGHT);

                } else if (actor instanceof Pad) {
                    consuming = true;

                } else if (actor instanceof Gatherer) {
                    // rotate by 270 degree
                    direction = Direction.rotateDirection(direction, TWO_HANDERD_SEVENTY, CLOCKWISE);

                    // change the fruit number if the thief meets a tree
                } else if ((actor instanceof Tree) && (!carrying)) {
                    if (((Tree) actor).getFruitNum() >= 1) {
                        ((Tree) actor).setFruitNum(((Tree) actor).getFruitNum() - 1);
                        carrying = true;
                    }
                // change the carrying state and rotate 180 degree clockwise if meet a golden tree
                } else if ((actor instanceof GoldenTree) && (!carrying)) {
                    carrying = true;

                    // change the fruit number if the Thief meets a Stockpile/Hoard
                } else if (actor instanceof Hoard) {
                    if(consuming){
                        consuming = false;
                        if (!carrying) {
                            if(((Hoard) actor).getFruitNum()>=1) {
                                carrying = true;
                                ((Hoard) actor).setFruitNum(((Hoard) actor).getFruitNum() - 1);
                            } else {
                                direction = Direction.rotateDirection(direction, NINTY, CLOCKWISE);
                            }
                        }
                    } else if(carrying){
                        carrying = false;
                        ((Hoard) actor).setFruitNum(((Hoard) actor).getFruitNum() + 1);
                        direction = Direction.rotateDirection(direction, NINTY, CLOCKWISE);
                    }
                } else if (actor instanceof Stockpile) {
                    if (!carrying) {
                        if(((Stockpile) actor).getFruitNum()>=1) {
                            carrying = true;
                            consuming = false;
                            ((Stockpile) actor).setFruitNum(((Stockpile) actor).getFruitNum() - 1);
                            direction = Direction.rotateDirection(direction, NINTY, CLOCKWISE);
                        }
                    } else {
                        direction = Direction.rotateDirection(direction, NINTY, CLOCKWISE);
                    }
                }
            }
        }
    }

    /**
     * This method is used to move the gatherer in its current direction by one pixel
     * @param direction This is the current direction
     * @param toward This indicate whether the actor is move forward or back to its previous position
     */
    public void MoveInDirection(int direction, int toward) {
        switch (direction) {
            case Direction.UP:
                move(0, -ShadowLife.TILE_SIZE * toward);
                break;
            case Direction.DOWN:
                move(0, ShadowLife.TILE_SIZE * toward);
                break;
            case Direction.LEFT:
                move(-ShadowLife.TILE_SIZE * toward, 0);
                break;
            case Direction.RIGHT:
                move(ShadowLife.TILE_SIZE * toward, 0);
                break;
        }
    }


}
