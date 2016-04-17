/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: To convert milliliters to other units of measurement     *
* Date: 17/04/2016 7:30pm                                           *
********************************************************************/    
public class MillilitersConversion
{
    public static double millilitersToCup(double millilitersValue)
    {

        double newValue = millilitersValue / 250;

        return newValue;

    }

    public static double millilitersToTablespoons(double millilitersValue)
    {

        double newValue = millilitersValue / 20;

        return newValue;

    }

    public static double millilitersToTeaspoons(double millilitersValue)
    {

        double newValue = millilitersValue / 5;

        return newValue;

    }
}
