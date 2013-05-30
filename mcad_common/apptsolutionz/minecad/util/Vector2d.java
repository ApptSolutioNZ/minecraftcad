package apptsolutionz.minecad.util;

/**
 * Vector2d Class
 * 
 * @author Nigel Smith
 * @copyright ApptSolutioNZ May, 2013
 * @version 1.0
 */
public class Vector2d {
    int X, Y, Step_X, Step_Y;

    /**
     * Common entry for initialising class parameters
     * 
     * @param x
     * @param y
     * @param stepX
     * @param stepY
     */
    public void init(int x, int y, int stepX, int stepY) {
        X = x;
        Y = y;
        Step_X = stepX;
        Step_Y = stepY;
    }

    /**
     * Vector2d Constructor Method
     * 
     * @param x
     *            => x-origin of vector
     * @param y
     *            => y-origin of vector
     * @param stepX
     *            => x-step rate
     * @param stepY
     *            => y-step rate
     */
    public Vector2d(int x, int y, int stepX, int stepY) {
        init(x, y, stepX, stepY);
    }

    public Vector2d() {
        init(0, 0, 0, 0);
    }

    /**
     * getX gets the X-Position of the vector for a given number of steps
     * 
     * @param steps
     *            => number of steps of position required
     * @return the position of the vector
     */
    public int getX(int steps) {
        System.out.printf("pos-X: %d,", (X + (Step_X * steps)));
        return X + (Step_X * steps);
    }

    /**
     * getY gets the Y-Position of the vector for a given number of steps
     * 
     * @param steps
     *            => number of steps of position required
     * @return the position of the vector
     */
    public int getY(int steps) {
        System.out.printf("pos-Y: %d,", (Y + (Step_Y * steps)));
        return Y + (Step_Y * steps);
    }
}
