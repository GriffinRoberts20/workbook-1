package com.pluralsight;

public class MathApp {

    public static void main(String[] args) {
        int bobSalary=80000;
        int garySalary=75000;
        int highestSalary=Math.max(bobSalary,garySalary);
        System.out.println("1. The highest salary was $"+ highestSalary);

        int carPrice=30000;
        int truckPrice=50000;
        int cheapestVehicle=Math.min(carPrice,truckPrice);
        System.out.println("\n2. The cheapest vehicle costs $"+ cheapestVehicle);

        double radius=7.25;
        double areaCircle=Math.round(Math.pow(7.25,2)*Math.PI*1000.)/1000.;
        System.out.println("\n3. The area of a circle of "+ radius +" is about "+ areaCircle);

        double x=5.0;
        double sqrtX=Math.round(Math.sqrt(x)*1000.)/1000.;
        System.out.println("\n4. The square root of "+x+" is about "+sqrtX);

        int xA=5;
        int yA=10;
        int xB=85;
        int yB=50;
        double distance=Math.round((Math.sqrt(Math.pow(xB-xA,2)+Math.pow(yB-yA,2)))*1000.)/1000.;
        System.out.println("\n5. The distance between point A("+xA+","+yA+") and point B("+xB+","+yB+") is about "+distance);

        double z=-3.8;
        double absZ=Math.abs(z);
        System.out.println("\n6. The absolute value of "+z+" is "+absZ);

        double randomNumber=Math.random();
        System.out.println("\n7. A random number between 0 and 1 is "+randomNumber);

    }

}
