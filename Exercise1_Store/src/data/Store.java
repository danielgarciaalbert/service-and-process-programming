package data;

public abstract class Store {
    private double cash;
    private double drinkPrice;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Store(double drinkPrice) {
        cash = 0.0;
        this.drinkPrice = drinkPrice;
    }

    public abstract void welcome();
    public void payDrinks(int numOfDrinks) {
        cash = numOfDrinks * drinkPrice;
    };
}
