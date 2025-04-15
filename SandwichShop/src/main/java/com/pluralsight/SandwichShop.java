package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int order=getOrder();
        System.out.println("------------------------------");
        String loaded=askLoaded();
        System.out.println("------------------------------");
        float discount=checkDiscount();
        System.out.println("------------------------------");
        float total=getTotal(order,discount,loaded);
        System.out.printf("Your total is $%.2f.",total);
    }
    public static int getOrder(){
        boolean f=true;
        int order=0;
        System.out.print("Hello, what would you like to order today?\n 1. Regular $5.45\n 2. Large   $8.95\n");
        while (f){
            if(scanner.hasNextInt()){
                order = scanner.nextInt();
            }
            scanner.nextLine();
            if (1<=order&&order<=2){
                f=false;
            }
            else{
                System.out.println("Error: not a menu item, please choose an item from the menu.");
                System.out.print("What would you like to order today?\n 1. Regular $5.45\n 2. Large   $8.95\n");
            }

        }
        return order;
    }
    public static String askLoaded(){
        boolean f=true;
        String answer="";
        while (f){
            System.out.print("Would you like your sandwich 'loaded'?\n 1. +$1.00\n 2. +$1.75\ny or n: " );
            answer=scanner.nextLine().toLowerCase();
            if(answer.equals("y")||answer.equals("n")){
                f=false;
            }
            else{
                System.out.println("Error:invalid response.");
            }
        }
        return answer;
    }
    public static float checkDiscount(){
        int age=-1;
        float discount=0;
        boolean f=true;
        while (f){
            System.out.print("How old are you? ");
            if(scanner.hasNextInt()){
                age = scanner.nextInt();
            }
            scanner.nextLine();
            if (age>=0){
                f=false;
            }
            else{
                System.out.println("Error:please input your age");
            }
        }
        if (age<18){
            System.out.println("You're receiving the student discount today.");
            discount=0.1f;
        }
        else if (age>64){
            System.out.println("You're receiving the senior discount today.");
            discount=0.2f;
        }
        else{
            System.out.println("No discount today.");
        }
        return discount;
    }
    public static float getTotal(int order,float discount,String loaded){
        float total=0;
        if (order==1){
            total=5.45f;
            if(loaded.equals("y")){
                total+=1;
            }
            total*=(1-discount);
        }
        else if (order==2){
            total=8.95f;
            if(loaded.equals("y")){
                total+=1.75f;
            }
            total*=(1-discount);
        }
        return total;
    }
}
