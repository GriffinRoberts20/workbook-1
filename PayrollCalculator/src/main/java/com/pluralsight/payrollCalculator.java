package com.pluralsight;
import java.util.Scanner;
public class payrollCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name=scanner.nextLine();
        System.out.print("Enter your hours worked: ");
        float hours=scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter your pay rate: ");
        float payRate=scanner.nextFloat();
        scanner.nextLine();
        float grossPay=payRate*hours;
        System.out.printf("%s's total pay for %.2f hours work at $%.2f/hr is $%.2f%n",name,hours,payRate,grossPay);
    }
}
