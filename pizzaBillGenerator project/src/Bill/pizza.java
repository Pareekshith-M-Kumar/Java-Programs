package Bill;

import java.util.Scanner;

public class pizza {
    protected int price;
    private Boolean veg;

    protected int extraCheese = 100;
    protected int extraToppings = 150;
    protected int backPack = 20;

    protected int basePizza;

    private boolean isExtraCheeseAdded=false;
    private boolean isExtraToppingsAdded=false;
    private boolean isOptedForTakeaway=false;

    Scanner in = new Scanner(System.in);

    public pizza(Boolean veg){
        this.veg=veg;

        if(this.veg){
            this.price=300;
        }else{
            this.price=400;
        }
        basePizza=this.price;
    }
    //it is for extra cheese
    public void addExtracheese(){
        System.out.print("Extra cheese(100/-)\n(y/n)? ==> ");
        char ch=in.next().charAt(0);
        switch (ch) {
            case 'y':
                isExtraCheeseAdded=true;
                this.price += extraCheese;
                break;
            case 'n':
                isExtraCheeseAdded=false;
                break;
        }
    }
    //this is for extra toppings
    public void addExtraToppings(){
        System.out.print("Want extra toppings(150/-)\n(y/n)? ==> ");
        char ch=in.next().charAt(0);
        switch (ch) {
            case 'y':
                isExtraToppingsAdded=true;
                this.price += extraToppings;
                break;
            case 'n':
                isExtraToppingsAdded=false;
                break;
        }
    }
    //this if for takeAway
    public void takeAway(){
        System.out.print("Want TakeAway(20/-)\n(y/n)? ==> ");
        char ch=Character.toLowerCase(in.next().charAt(0));
        switch (ch) {
            case 'y':
                isOptedForTakeaway=true;
                this.price += backPack;
                break;
            case 'n':
                isOptedForTakeaway=false;
                break;
        }
    }
    //to get bill
    public void getBill(){
        String bill=" ";
        System.out.print("\npizza:"+basePizza+"\n");
        if(isExtraCheeseAdded){
            bill += "Extra Cheese: "+extraCheese+"\n";
        }
        if(isExtraToppingsAdded){
            bill += "Extra Toppings: "+extraToppings+"\n";
        }
        if(isOptedForTakeaway){
            bill += "Take Away: "+backPack+"\n";
        }
        bill += "\n Total Amount: "+this.price+"\n";
        System.out.println(bill);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("\nThank You!\nVisit Again....");
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}
