package Bill;

public class DeluxPizza extends pizza {

    public DeluxPizza(Boolean veg) {
        super(veg);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void addExtracheese(){
        this.price += extraCheese;
    }

    @Override
    public void addExtraToppings(){
        this.price += extraToppings;
    }
    
}
