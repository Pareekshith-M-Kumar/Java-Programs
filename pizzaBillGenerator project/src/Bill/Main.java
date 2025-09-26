package Bill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         System.out.println("-----------------------------------------Welcome to Pizzamania----------------------------------------");
         System.out.println("Please select your pizza: \n 1.Veg Pizza  2.Non Veg Pizza  3.Delux Veg Pizza(Extra toppings and cheese added)  4.Delux Non Veg Pizza(Extra toppings and cheese added)");
         Scanner sc=new Scanner(System.in);
         int ch=sc.nextInt();

         switch (ch) {
            case 1:
                pizza vegPizza=new pizza(true);
                vegPizza.addExtraToppings();
                vegPizza.addExtracheese();
                vegPizza.takeAway();
                vegPizza.getBill();
                break;
            case 2:
                pizza nonvegPizza = new pizza(false);
                nonvegPizza.addExtraToppings();
                nonvegPizza.addExtracheese();
                nonvegPizza.takeAway();
                nonvegPizza.getBill();
                break;
            case 3:
                DeluxPizza veg=new DeluxPizza(true);
                veg.basePizza=550;
                veg.addExtraToppings();
                veg.addExtracheese();
                veg.takeAway();
                veg.getBill();
                break;
            case 4:
                DeluxPizza nonveg=new DeluxPizza(false);
                nonveg.basePizza=650;
                nonveg.addExtraToppings();
                nonveg.addExtracheese();
                nonveg.takeAway();
                nonveg.getBill();
                break;
            default:
                System.out.println("Sorry Please enter again!");
                return;
         }
         sc.close();
    }
}
