//Daniel García Albert - Unit 1, exercise 1

package main;

import data.LiquorStore;
import data.Store;

public class ShoppingCart {
    public static void main(String[] args) {
        LiquorStore liquorStore = new LiquorStore(8.95);
        liquorStore.setTax(20);
        liquorStore.payDrinks(10);
        liquorStore.welcome();
        System.out.printf("%.2f", liquorStore.getCash());

        System.out.println();

        Store store = new Store(8.95) {
            @Override
            public void welcome() {
                System.out.print("Welcome to our anonymous store! Our drink price is ");
                System.out.printf("%.2f", getCash());
            }
        };
        store.payDrinks(10);
        store.welcome();
    }
}
