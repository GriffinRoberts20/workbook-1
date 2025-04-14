package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action=operationChoice(scanner);
        if (action.equals("a")) {
            add(scanner);
        }
        else if (action.equals("s")) {
            subtract(scanner);
        }
        else if (action.equals("m")) {
            multiply(scanner);
        }
        else if (action.equals("d")) {
            divide(scanner);
        }
        else if (action.equals("e")) {
            power(scanner);
        }
        else if (action.equals("r")) {
            root(scanner);
        }

    }
    public static String operationChoice(Scanner scanner){
        List<String> options = new ArrayList<>();
        options.add("a");
        options.add("s");
        options.add("m");
        options.add("d");
        options.add("e");
        options.add("r");
        String action = "";
        boolean f=false;
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
        return action;
    }

    public static void add(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        double sum=x+y;
        System.out.println(x + "+" + y + "=" + sum);
    }
    public static void subtract(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        double difference=x-y;
        System.out.println(x + "-" + y + "=" + difference);
    }
    public static void multiply(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        double product=x*y;
        System.out.println(x + "-" + y + "=" + product);
    }
    public static void divide(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        while (y==0){
            System.out.print("Error: cannot divide by 0. Enter a new second number: ");
            y=scanner.nextDouble();
            scanner.nextLine();
        }
        double product = x/y;
        System.out.println(x + "/" + y + "=" + product);
    }
    public static void power(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
        double exponential;
        if (x>0){
            exponential=Math.pow(x,y);
        }
        else{
            exponential=-Math.pow(-x,y);
        }
        System.out.println(x + "^" + y + "=" + exponential);
    }
    public static void root(Scanner scanner){
        System.out.print("Enter first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double y = scanner.nextDouble();
        scanner.nextLine();
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
        double root;
        if (x>0){
            root=Math.pow(x,1/y);
        }
        else{
            root=-Math.pow(-x,1/y);
        }
        System.out.println(x + "^(1/" + y + ")=" + root);
    }
}
