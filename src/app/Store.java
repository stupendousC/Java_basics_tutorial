package app;

public class Store {
  // instance fields
  String productType;
  int inventoryCount;
  double inventoryPrice;
  
  // constructor method
  public Store(String productArg, int countArg, double priceArg) {
    productType = productArg;
    inventoryCount = countArg;
    inventoryPrice = priceArg;
  }
  
  // main method
  public static void main(String[] args) {
    Store lemonadeStand = new Store("lemonade", 42, .99);
    Store cookieShop = new Store("cookies", 12, 3.75);
    
    System.out.println("\nOur first shop sells " + lemonadeStand.productType + " at " + lemonadeStand.inventoryPrice + " per unit.");
    System.out.println("Our second shop has " + cookieShop.inventoryCount + " units remaining.");

    System.out.println("\n\nNow I'm going to say the same thing but with %s/%d/%f string interpolation!");
    System.out.println(String.format("We have %d %ss selling at $%.2f each", lemonadeStand.inventoryCount, lemonadeStand.productType, lemonadeStand.inventoryPrice));
  }
}