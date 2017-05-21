package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public enum CardinalPoint
{
    NORTH('N', 0, 1),
    EAST('E', 1, 0),
    SOUTH('S', 0, -1),
    WEST('W', -1, 0);

    private char orientation;
    private int horizontalMoveAmount;
    private int verticalMoveAmount;

    CardinalPoint(char orientation, int horizontalMoveAmount, int verticalMoveAmount) {
        this.orientation = orientation;
        this.horizontalMoveAmount = horizontalMoveAmount;
        this.verticalMoveAmount = verticalMoveAmount;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getVerticalMoveAmount() {
        return verticalMoveAmount;
    }

    public int getHorizontalMoveAmount() {
        return horizontalMoveAmount;
    }
}
