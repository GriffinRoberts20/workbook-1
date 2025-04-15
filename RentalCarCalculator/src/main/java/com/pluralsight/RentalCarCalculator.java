package com.pluralsight;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalCarCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String pickupDate = getPickup();//asks for pickup date
        int howLong = howLong();//asks for how long you will be renting
        String returnDate = getReturn(pickupDate, howLong);//use pickup date and rental length to calculate return date
        boolean tollTag = askTT();//asks whether you want to include toll tag
        boolean gps = askGPS();//asks whether you want to include gps
        boolean roadside = askRoadside();//asks whether you want to include roadside assistance
        boolean over25 = over25();//asks the users age, and checks if they are 25 and older
        float perDayCharge = calculatePerDayCharge(tollTag, gps, roadside, over25);//uses prior booleans to calculate the per day charge
        float totalCost = (float) howLong * perDayCharge;//uses rental length and per day charge to calculate the projected total cost
        System.out.printf("Your pickup date is %s.\nYou're renting for %d days.\nYour return date is %s.\n", pickupDate, howLong, returnDate);//tells user pickup date, rental length, return date
        //next 4 lines use the 4 booleans to acknowledge the users input on services/age
        String tollTagStr = (tollTag) ? "You said yes to include toll tag for $3.95." : "You said no to include toll tag.";
        String gpsStr = (gps) ? "You said yes to include GPS for $2.95." : "You said no to include GPS.";
        String roadsideStr = (roadside) ? "You said yes to include roadside assistance for $3.95." : "You said no to include roadside assistance.";
        String over25Str = (over25) ? "You are at least 25 years old, your base per day charge is $29.99." : "You are younger than 25 years old, your base per day charge is %29.99 plus a 30% surcharge fee.";
        System.out.printf("%s\n%s\n%s\n%s\n", tollTagStr, gpsStr, roadsideStr, over25Str);//prints services/age strings
        System.out.printf("Your per day charge is $%.2f, and your projected total cost is $%.2f.\n", perDayCharge, totalCost);//prints per day charge and total cost
    }
    //takes user input for a date, and passes to validation method that validates that the date is in the correct format
    public static String getPickup() {
        String format = "dd/MM/yyyy";
        String date = "";
        boolean gettingDate = true;
        while (gettingDate) {
            System.out.print("What date are you picking up your rental? " + format + " :");
            date = scanner.nextLine();
            if (dateFormatValidation(date, format) && date.length() == 10) {
                gettingDate = false;
            } else {
                System.out.println("Error:invalid date.");
            }
        }

        return date;
    }
    //uses a given date and number of days to calculate a new date
    public static String getReturn(String pickupDate, int howLong) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate pickup = LocalDate.parse(pickupDate, formatter);
        LocalDate returnDate = pickup.plusDays(howLong);
        return returnDate.format(formatter);
    }
    //validates the date is in the correct format
    public static boolean dateFormatValidation(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    //takes user input for number of days they will be renting
    public static int howLong() {
        boolean gettingHowLong = true;
        int howLong = -1;
        while (gettingHowLong) {
            System.out.print("How long will you be renting? ");
            if (scanner.hasNextInt()) {
                howLong = scanner.nextInt();
            }
            scanner.nextLine();
            if (howLong > 0) {
                gettingHowLong = false;
            } else {
                System.out.println("Error: invalid rental length.");
            }
        }
        return howLong;
    }
    //asks whether the user wants the toll tag service and returns response as true/false
    public static boolean askTT() {
        boolean askingTT = true;
        String answer = "";
        while (askingTT) {
            System.out.print("Would you like to have a toll tag for $3.95/day? (Y/N): ");
            answer = scanner.nextLine().toUpperCase();
            if (answer.equals("Y") || answer.equals("N")) {
                askingTT = false;
            } else {
                System.out.println("Error: invalid response.");
            }
        }
        return answer.equals("Y");
    }
    //asks whether the user wants the gps service and returns response as true/false
    public static boolean askGPS() {
        boolean askingGPS = true;
        String answer = "";
        while (askingGPS) {
            System.out.print("Would you like to have a GPS for $2.95/day? (Y/N): ");
            answer = scanner.nextLine().toUpperCase();
            if (answer.equals("Y") || answer.equals("N")) {
                askingGPS = false;
            } else {
                System.out.println("Error: invalid response.");
            }
        }
        return answer.equals("Y");
    }
    //asks whether the user wants the roadside assistance service and returns response as true/false
    public static boolean askRoadside() {
        boolean askingRoadside = true;
        String answer = "";
        while (askingRoadside) {
            System.out.print("Would you like to have roadside assistance for $3.95/day? (Y/N): ");
            answer = scanner.nextLine().toUpperCase();
            if (answer.equals("Y") || answer.equals("N")) {
                askingRoadside = false;
            } else {
                System.out.println("Error: invalid response.");
            }
        }
        return answer.equals("Y");
    }
    //asks user age and returns it as int
    public static int checkAge() {
        int age = -1;
        boolean askingAge = true;
        while (askingAge) {
            System.out.print("How old are you? ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
            }
            scanner.nextLine();
            if (age >= 0) {
                askingAge = false;
            } else {
                System.out.println("Error:please input your age");
            }
        }
        return age;
    }
    //calls checkAge to see if user is >=25 years old, returns response true/false
    public static boolean over25() {
        int age = checkAge();
        return age >= 25;
    }
    //takes true/false user input and calculates the per day charge for renting
    public static float calculatePerDayCharge(boolean tollTag, boolean gps, boolean roadside, boolean over25) {
        float perDay = 29.99f;
        if (!over25) {
            perDay *= 1.3f;
        }
        if (tollTag) {
            perDay += 3.95f;
        }
        if (gps) {
            perDay += 2.95f;
        }
        if (roadside) {
            perDay += 3.95f;
        }
        return perDay;
    }
}
