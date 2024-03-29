package za.co.kw;

import za.co.kw.exception.CardinalPointException;

import java.util.HashMap;
import java.util.Map;

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
    private int  horizontalMoveAmount;
    private int  verticalMoveAmount;

    private static Map<Character, CardinalPoint> enumOrientationMap = new HashMap<Character, CardinalPoint>();

    static
    {
        for (CardinalPoint cp : CardinalPoint.values())
        {
            enumOrientationMap.put(cp.orientation, cp);
        }
    }

    CardinalPoint(char orientation, int horizontalMoveAmount, int verticalMoveAmount)
    {
        this.orientation = orientation;
        this.horizontalMoveAmount = horizontalMoveAmount;
        this.verticalMoveAmount = verticalMoveAmount;
    }


    public char getOrientation()
    {
        return orientation;
    }


    public int getVerticalMoveAmount()
    {
        return verticalMoveAmount;
    }


    public int getHorizontalMoveAmount()
    {
        return horizontalMoveAmount;
    }


    public static CardinalPoint lookupByOrientation(char orientation) throws CardinalPointException
    {
        if (enumOrientationMap.get(orientation) != null)
        {
            return enumOrientationMap.get(orientation);
        } else
        {
            throw new CardinalPointException(orientation + " is an invalid orientation");
        }

    }
}
