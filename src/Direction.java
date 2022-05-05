public class Direction {
    /**
     * This is the integer indicating up direction
     */
    public static final int UP = 1;
    /**
     * This is the integer indicating right direction
     */
    public static final int RIGHT = 2;
    /**
     * This is the integer indicating down direction
     */
    public static final int DOWN = 3;
    /**
     * This is the integer indicating left direction
     */
    public static final int LEFT = 4;
    /**
     * This is the number indicating 90 degrees
     */
    public static final int PI = 90;
    /**
     * This is the max value out of all the numbers that indicate direction
     */
    public static final int MAX_DIRECTION_NUM = 4;
    /**
     * This is the min value out of all the numbers that indicate direction
     */
    public static final int MIN_DIRECTION_NUM = 1;

    /**
     * This method is used to get the new direction after rotation
     * @param direction This is the current direction
     * @param degree This is the degree that the actor will be rotated
     * @param clockwise This indicates whether the actor is rotating clockwise or anti-clockwise
     * @return int This returns the updated direction
     */
    public static int rotateDirection(int direction, int degree, boolean clockwise) {
        int newDirection;
        int multiple = degree/PI;
        if(clockwise) {
            newDirection = direction + multiple;
            if(newDirection > MAX_DIRECTION_NUM) {
                newDirection = newDirection - MAX_DIRECTION_NUM;
            }
        } else {
            newDirection = direction - multiple;
            if(newDirection < MIN_DIRECTION_NUM) {
                newDirection = newDirection + MAX_DIRECTION_NUM;
            }
        }
        return newDirection;
    }
}
