package data;

public class LiquorStore extends Store {
    private double tax;

    public void setTax(double tax) {
        this.tax = tax;
    }

    public LiquorStore(double drinkPrice) {
        super(drinkPrice);
    }

    @Override
    public void welcome() {
        System.out.println("Welcome to our liquor store. "
                + "If you are younger than 18, go back home!");
    }

    @Override
    public void payDrinks(int numOfDrinks) {
        super.payDrinks(numOfDrinks);
        double total = (super.getCash() * (tax / 100)) + super.getCash();
        super.setCash(total);
    }
}
