package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        final double rentalBasic = 29.99;
        final double underageCharge = 0.3;
        final double tagCharge = 3.95;
        final double gpsCharge = 2.95;
        final double assistanceCharge = 3.95;
        double subtotalBasic;
        double subtotalTag = 0;
        double subtotalGps = 0;
        double subtotalAssistance = 0;
        double totalCost;
        int rentalDays;

        // a. pickup date (store as a string)
        System.out.print("When do you want to pickup a car? Enter a date:");
        String pickupDate = myScanner.nextLine();

        //b. number of days for the rental
        System.out.print("How many days you want to rent for? Enter a number:");
        rentalDays = myScanner.nextInt();
        myScanner.nextLine();

        subtotalBasic = rentalBasic * rentalDays;
        System.out.println("Your basic car rental cost is $" + String.format("%.2f", subtotalBasic));

        //c. whether they want an electronic toll tag at $3.95/day (yes/no);
        System.out.print("Do you want an electronic toll tag at $3.95/day? Enter 'yes' or 'no':");
        String electronicTag = myScanner.nextLine();

        switch (electronicTag) {
            case "no":
                break;
            case "yes":
                subtotalTag = tagCharge * rentalDays;
                System.out.println("Electronic toll tag cost for " + rentalDays + " days is $" + String.format("%.2f", subtotalTag));
                break;
            default:
                System.out.println("Please enter a valid answer.");
        }

        //d. whether they want a GPS at $2.95/day (yes/no)
        System.out.print("Do you want a GPS at $2.95/day? Enter 'yes' or 'no':");
        String gps = myScanner.nextLine();

        switch (gps) {
            case "no":
                break;
            case "yes":
                subtotalGps = gpsCharge * rentalDays;
                System.out.println("GPS cost for " + rentalDays + " days is $" + String.format("%.2f", subtotalGps));
            break;
            default:
                System.out.println("Please enter a valid answer.");
        }

        //e. whether they want roadside assistance at $3.95/day (yes/no)
        System.out.print("Do you want roadside assistance at $3.95/day? Enter 'yes' or 'no':");
        String assistance = myScanner.nextLine();

        switch (assistance) {
            case "no":
                break;
            case "yes":
                subtotalAssistance = assistanceCharge * rentalDays;
                System.out.println("Roadside assistance for " + rentalDays + " days is $" + String.format("%.2f", subtotalAssistance));
        }

        //f. their current age
        System.out.print("How old are you? Enter a number:");
        int clientAge = myScanner.nextInt();

        if (clientAge < 16) {

            System.out.println("Cars cannot be rented for people under 16 years old.");

        } else if (clientAge < 25) {

            subtotalBasic = subtotalBasic + subtotalBasic * underageCharge;
            System.out.println("There is a 30% surcharge on the basic car rental rate for drivers under 25 years old.");

            // calculating total cost
            totalCost = subtotalBasic + subtotalAssistance + subtotalGps + subtotalTag;
            System.out.println("Your total is $" + String.format("%.2f", totalCost));

        } else {

            // calculating total cost
            totalCost = subtotalBasic + subtotalAssistance + subtotalGps + subtotalTag;
            System.out.println("Your total is $" + String.format("%.2f", totalCost));
        }


        //Calculate and display:
        //a. basic car rental
        //b. options cost
        //c. underage driver surcharge
        //d. total cost
        //The basic car rental is $29.99 per day. There is a 30% surcharge on the basic car rental
        //for drivers under 25. All taxes have already been incorporated into the fees shown.
    }
}