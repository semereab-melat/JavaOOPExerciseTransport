

import java.text.DecimalFormat;
import java.util.Scanner;

/***************************************************************
 Filename: Transport
 Created by: Melat Semereab
 Created on: 08/11/2021
 Comment: Program to read in the weights of containers until -1 is entered and calculate the cost of
 haulage depending on the number of containers and the total weight
 ***************************************************************/



class Main {
public static final int TERMINATOR = -1;


    //getting the weight of the package from package number
    public static int getWeight(int number)
    {
        Scanner keyboard = new Scanner(System.in);
        int weight;
        System.out.println("Please enter the weight of the container " + number + " (in kg) or -1 to finish: ");
        weight = keyboard.nextInt();
        return weight;
    }
    //calculating the cost of the haulage
    public static double calculateCost(int number, int totalWeight)
    {
        final int HIGHWEIGHT = 1000; final int HIGHCOST = 1200; final int LOWWEIGHT = 500; final int MIDDLECOST = 750;
        final int LOWCOST = 400; final int DISCOUNTNUMBER = 5;
        double cost; final double DISCOUNTRATE = 0.25;


        if (totalWeight > HIGHWEIGHT)
        {
            cost = HIGHCOST;
        }
        else
            if (totalWeight > LOWWEIGHT)
            {
                cost = MIDDLECOST;
            }
            else
                cost = LOWCOST;

        if (number <= DISCOUNTNUMBER)
        {
            cost = cost - (cost * DISCOUNTRATE);
        }
        return cost;
    }

    public static void main (String[] args)
    {
        DecimalFormat df = new DecimalFormat("00.00");
        int numberOfContainers = 1; int totalWeight = 0; int weight;
        double cost = 0;

        weight = getWeight(numberOfContainers);
        while (weight!= TERMINATOR)
        {
            numberOfContainers = numberOfContainers + 1;

            weight = getWeight(numberOfContainers);

            totalWeight = totalWeight + weight;
            
            cost = calculateCost(numberOfContainers, totalWeight);
        }
            System.out.println("The total number of containers is " + (numberOfContainers - 1));
            System.out.println("The total weight of the container is " + totalWeight);
            System.out.println("The total cost of transport is £ " + df.format(cost));

    }//main
}//class

