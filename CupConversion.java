/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: To convert cups to other units of measurement            *
* Date: 17/04/2016 7:30pm                                           *
********************************************************************/    

public class CupConversion
{


public static double cupsToMilliliters(double cupValue)
{

    double newValue = cupValue * 250;

    return newValue;

}

public static double cupsToTablespoons(double cupValue)
{

    double newValue = cupValue * 12.5;

    return newValue;

}

public static double cupsToTeaspoons(double cupValue)
{

    double newValue = cupValue * 50;

    return newValue;
}
}