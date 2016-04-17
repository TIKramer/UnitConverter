/*******************************************************************
 * Author: Thomas Kramer                                           *
 * Purpose: Converting between units                               *
 *    of measurement (cup, millilitres, tablespoons, teaspoons)    *
 * Date: 17/04/2016 7:00pm                                         *
********************************************************************/

import java.util.Scanner;
import java.util.StringTokenizer;

public class UnitConverter
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Units firstUnit = unitSelection();
        double firstUnitNum = validateInput(firstUnit);
        Units secoundUnit = unitSelection();
        selectConvertor(firstUnit, firstUnitNum, secoundUnit);
    }

/*********************************************************************
 * Author: Thomas Kramer                                             *
 * Purpose: Allow the user to select the unit that want to convert   *
 *          (The first unit)                                         *
 * Date: 17/04/2016 7:00pm                                           *
 ********************************************************************/ 
    public static Units unitSelection()
    {
        Scanner sc = new Scanner(System.in);
        boolean valid = true;
        String selection = "";

        Units unitSelection = null;
        do
        {
            System.out.println("Please select a unit of measurment:" + "\nCup, Milliliters, Tablespoons, Teaspoons");

            selection = sc.next();
            try
            {
                unitSelection = Units.valueOf(selection.toLowerCase());
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid");
                valid = false;
            }
        } while (valid == false);

        System.out.println(unitSelection);

        return unitSelection;

    }

/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: Will validate the user input for unit amount and will    *
*    Handle the input differently if it is a fraction converting it *
*    to a double.                                                   *
* Date: 17/04/2016 7:23pm                                           *
********************************************************************/    
    public static double validateInput(Units firstUnit)
    {
        boolean validSelection = false;
        double firstUnitNum = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Please enter the number of " + firstUnit + "s");
            String firstUnitNumIp = sc.nextLine();
            try
            {
                // If user had inputed a fraction convert it to a double
                      //Checking if the input contains a / meaning it would be a fraction
                if (firstUnitNumIp.contains("/"))
                {

                //Split the number by left side of '/' symbol and right side(Top/bottom of fraction)
                    //Then divide the numerator by the denominator 
                    StringTokenizer stok = new StringTokenizer(firstUnitNumIp, "/");
                    int numerator  = Integer.parseInt(stok.nextToken());
                    int denominator = Integer.parseInt(stok.nextToken());
                    firstUnitNum = (double) numerator / (double) denominator;
                    validSelection = true;
                }
                //If input is not a fraction (does not have '/' symbol and is not null)
                else if (!firstUnitNumIp.contains("/") && (!(firstUnitNumIp == null)))
                {
                    firstUnitNum = Double.parseDouble(firstUnitNumIp);
                    validSelection = true;
                }
                else
                {
                    System.out.println("Error");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error");
            }
        } while (validSelection == false);

        return firstUnitNum;

    }

/********************************************************************
* Author: Thomas Kramer                                             *
* Purpose: Will run the appropriate method and class depending on   *
*           the passed parameters                                   *
* Date: 17/04/2016 7:23pm                                           *
********************************************************************/       
    
    public static void selectConvertor(Units firstUnit, double firstUnitNum, Units secoundUnit)
    {
        String selection = (firstUnit.toString() + "|" + secoundUnit.toString());
        double secoundUnitNum = 0;
        if (selection.equals("cup|milliliters"))
            secoundUnitNum = CupConversion.cupsToMilliliters(firstUnitNum);
        else if (selection.equals("cup|tablespoons"))
            secoundUnitNum = CupConversion.cupsToTablespoons(firstUnitNum);
        else if (selection.equals("cup|teaspoons"))
            secoundUnitNum = CupConversion.cupsToTeaspoons(firstUnitNum);

        // Milliliters if statements
        else if (selection.equals("milliliters|cup"))
            secoundUnitNum = MillilitersConversion.millilitersToCup(firstUnitNum);
        else if (selection.equals("milliliters|tablespoons"))
            secoundUnitNum = MillilitersConversion.millilitersToTablespoons(firstUnitNum);
        else if (selection.equals("milliliters|teaspoons"))
            secoundUnitNum = MillilitersConversion.millilitersToTeaspoons(firstUnitNum);

        // Tablespoon if statements
        else if (selection.equals("tablespoons|cup"))
            secoundUnitNum = TablespoonsConversion.tablespoonsToCup(firstUnitNum);
        else if (selection.equals("tablespoons|milliliters"))
            secoundUnitNum = TablespoonsConversion.tablespoonsToMilliliters(firstUnitNum);
        else if (selection.equals("tablespoons|teaspoons"))
            secoundUnitNum = TablespoonsConversion.tablespoonsToTeaspoons(firstUnitNum);

        // Teaspoons if statements
        else if (selection.equals("teaspoons|cup"))
            secoundUnitNum = TeaspoonsConversion.teaspoonsToCup(firstUnitNum);
        else if (selection.equals("teaspoons|milliliters"))
            secoundUnitNum = TeaspoonsConversion.teaspoonsToMilliliters(firstUnitNum);
        else if (selection.equals("teaspoons|teaspoons"))
            secoundUnitNum = TeaspoonsConversion.teaspoonsToTablespoons(firstUnitNum);
        // When both numbers are the same
        else
            secoundUnitNum = firstUnitNum;

        System.out.print(firstUnitNum + " " + firstUnit + " is equal to = " + secoundUnitNum + " " + secoundUnit);
    }

    public enum Units
    {
        cup, milliliters, tablespoons, teaspoons
    };

}
