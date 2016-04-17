/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: To convert tablespoons to other units of measurement     *
* Date: 17/04/2016 7:30pm                                           *
********************************************************************/    
public class TablespoonsConversion
{
    public static double tablespoonsToCup(double tablespoonsValue)
    {

        double newValue = tablespoonsValue / 12.5;

        return newValue;

    }

    public static double tablespoonsToMilliliters(double tablespoonsValue)
    {

        double newValue = tablespoonsValue * 5;

        return newValue;

    }

    public static double tablespoonsToTeaspoons(double tablespoonsValue)
    {

        double newValue = tablespoonsValue * 4;

        return newValue;

    }
}
