package com.pluralsight;

public class ShoppingList2 {
    public static void main(String[] args) {
        String[] shoppingList={"bacon",
                "eggs",
                "frozen pizzas",
                "ground beef",
                "rice",
                "soda",
                "coffee",
                "pasta",
                "pasta sauce",
                "cheese",
                "more cheese"};
        System.out.println("Shopping List\n-------------------");
        for (String s : shoppingList) {
            System.out.print(s+"\n");
        }
    }
}
