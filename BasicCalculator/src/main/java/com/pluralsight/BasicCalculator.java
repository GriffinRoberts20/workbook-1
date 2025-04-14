package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> options = new ArrayList<>();
        options.add("a");
        options.add("s");
        options.add("m");
        options.add("d");
        options.add("e");
        options.add("r");
        boolean f = false;
        String action = "";
        while (!f) {
            System.out.print("Possible Calculations:\n   (A) Add(x+y)\n   (S) Subtract(x-y)\n   (M) Multiply(x*y)\n   (D) Divide(x/y)\n   (E) Exponent(x^y)\n   (R) Root(x^(1/y))\nChoose calculation: ");
            action = scanner.nextLine().toLowerCase();
            String finalAction = action;
            if (options.stream().anyMatch(item -> item.equals(finalAction))) {
                f = true;
            } else {
                System.out.println("Error: entered invalid option.");
            }
        }
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        if (action.equals("a")) {
            double sum =add(x,y);
            System.out.println(x + "+" + y + "=" + sum);
        }
        else if (action.equals("s")) {
            double difference =subtract(x,y);
            System.out.println(x + "-" + y + "=" + difference);
        }
        else if (action.equals("m")) {
            double product = multiply(x,y);
            System.out.println(x + "-" + y + "=" + product);
        }
        else if (action.equals("d")) {
            while (y==0){
                System.out.print("Error: cannot divide by 0. Enter a new second number: ");
                y=scanner.nextDouble();
                scanner.nextLine();
            }
            double product = divide(x,y);
            System.out.println(x + "/" + y + "=" + product);
        }
        else if (action.equals("e")) {
            double exponential = power(x,y);
            System.out.println(x + "^" + y + "=" + exponential);
        }
        else if (action.equals("r")) {
            while (x<0&&y%2==0){
                System.out.println("Error: cannot take an even root of a negative.");
                System.out.print("Enter first number: ");
                x = scanner.nextDouble();
                System.out.print("Enter second number: ");
                y = scanner.nextDouble();
                scanner.nextLine();
            }
            while (y==0){
                System.out.print("Error: cannot divide by 0. Enter a new second number: ");
                y=scanner.nextDouble();
                scanner.nextLine();
            }
            double root = power(x,1/y);
            System.out.println(x + "^(1/" + y + ")=" + root);
        }

    }
    public static double add(double x, double y){
        return x+y;
    }
    public static double subtract(double x, double y){
        return x-y;
    }
    public static double multiply(double x, double y){
        return x*y;
    }
    public static double divide(double x, double y){
        return x/y;
    }
    public static double power(double x, double y){
        double out;
        if (x>0){
            out=Math.pow(x,y);
        }
        else{
            out=-Math.pow(-x,y);
        }
        return out;
    }
}
