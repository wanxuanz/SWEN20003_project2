public class Gatherer extends Actor {
    private int direction = Direction.LEFT;
    private boolean carrying = false;
    private boolean active = true;

    /**
     * This is the type of the actor
     */
    public static final String TYPE = "Gatherer";
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
     * This number represents 180 degrees
     */
    public static final int HANDERD_EIGTY = 180;

    /**
     * This is the constructor of the gatherer
     * @param x This is the x-coordinate of the gatherer
     * @param y This is the y-coordinate of the gatherer
     */
    public Gatherer(int x, int y) {
        super("res/images/gatherer.png", TYPE, x, y);
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
     * This is used to get the state of carrying
     * @return boolean This indicate whether the carrying state is true
     */
    public boolean isCarrying() {
        return carrying;
    }

    /**
     * This is used to get the state of active
     * @return boolean This indicate whether the actor is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * This is used to set the state of carrying
     * @param carrying This indicate whether the carrying state of the actor is true
     */
    public void setCarrying(boolean carrying) {
        this.carrying = carrying;
    }

    /**
     * This is used to set the state of active
     * @param active This indicate whether the actor is active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method is used to update the state and location of the gatherer
     */
    @Override
    public void update() {
        if(this.isActive()) {
            MoveInDirection(this.getDirection(), POSITIVE);
        }
        // check if any other actors in this position
        for (Actor actor : ShadowLife.getActors()) {
            if (actor.getX() == this.getX() && actor.getY() == this.getY()) {
                // move to the previous position if find a fence
                if (actor instanceof Fence) {
                    setActive(false);
                    MoveInDirection(this.getDirection(), REVERSE);

                // rotate direction and create new gatherer if gatherer meet a pool
                } else if (actor instanceof Pool) {
                    ShadowLife.addNewActor(TYPE, actor.getX(), actor.getY());
                    ((Gatherer) ShadowLife.getActors().get(ShadowLife.getActors().size() - 1))
                            .setDirection(Direction.rotateDirection(this.getDirection(), NINTY, ANTICLOCKWISE));
                    ShadowLife.addNewActor(TYPE, actor.getX(), actor.getY());
                    ((Gatherer)ShadowLife.getActors().get(ShadowLife.getActors().size() - 1))
                            .setDirection(Direction.rotateDirection(this.getDirection(), NINTY, CLOCKWISE));
                    // remove the original gatherer
                    ShadowLife.getActors().remove(this);

                // Set direction to match the sign
                } else if (actor instanceof SignUp) {
                    setDirection(Direction.UP);
                } else if (actor instanceof SignDown) {
                    setDirection(Direction.DOWN);
                } else if (actor instanceof SignLeft) {
                    setDirection(Direction.LEFT);
                } else if (actor instanceof SignRight) {
                    setDirection(Direction.RIGHT);

                // change the fruit number if the gatherer meets a tree
                } else if ((actor instanceof Tree) && (!this.isCarrying())) {
                    if (((Tree) actor).getFruitNum() >= 1) {
                        ((Tree)actor).setFruitNum(((Tree) actor).getFruitNum() - 1);
                        setCarrying(true);
                        // rotate by 180 degree
                        this.setDirection(Direction.rotateDirection(this.getDirection(), HANDERD_EIGTY, CLOCKWISE));
                    }

                // change the carrying state and rotate 180 degree clockwise if meet a golden tree
                } else if ((actor instanceof GoldenTree) && (!this.isCarrying())) {
                    setCarrying(true);
                    this.setDirection(Direction.rotateDirection(this.getDirection(), HANDERD_EIGTY, CLOCKWISE));

                // change the fruit number if the gatherer meets a Stockpile/Hoard
                } else if (actor instanceof Stockpile || actor instanceof Hoard) {
                    if (this.isCarrying()) {
                        setCarrying(false);
                        if (actor instanceof Stockpile) {
                            ((Stockpile)actor).setFruitNum(((Stockpile) actor).getFruitNum() + 1);
                        } else {
                            ((Hoard) actor).setFruitNum(((Hoard) actor).getFruitNum() + 1);
                        }
                    }
                    // rotate by 180 degree
                    setDirection(Direction.rotateDirection(this.getDirection(), HANDERD_EIGTY, CLOCKWISE));
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


