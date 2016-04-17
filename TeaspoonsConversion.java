/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: To convert teaspoons to other units of measurement       *
* Date: 17/04/2016 7:30pm                                           *
********************************************************************/    
public class TeaspoonsConversion
{
    public static double teaspoonsToCup(double teaspoonsValue)
    {

        double newValue = teaspoonsValue / 50;

        return newValue;

    }

    public static double teaspoonsToMilliliters(double teaspoonsValue)
    {

        double newValue = teaspoonsValue / 5;

        return newValue;

    }

    public static double teaspoonsToTablespoons(double teaspoonsValue)
    {

        double newValue = teaspoonsValue / 4;

        return newValue;

    }
}
