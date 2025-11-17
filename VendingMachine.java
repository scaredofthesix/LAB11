import java.util.Scanner;
enum Drinks{
    COKE_COLA("coca_cola",100),
    SPRITE("Sprite",110),
    FANTA("fanta",50);

    private String name; 
    private double price;

    Drinks(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}

enum Money{
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100);

    private int n;

    Money(int n){
        this.n = n;
    }
    public int getNominalo(){
        return  n;
    }
}


public class LAB {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        double balance = 0;
        while (true) {
            System.out.println("MENU");
            for (Drinks drink : Drinks.values()) {
                System.out.println(drink.getName() + " - " + drink.getPrice() + " rub.");
            }
            System.out.println("Balance " + " - " + balance + " rub.");
            System.out.println("1 - Put some money");
            System.out.println("2 - buy drink");
            System.out.println("3 - return change");
            System.out.println("4 - end");

            int choice = s.nextInt();
            if (choice == 1) {
                System.out.println("NOMINALO:");
                for (Money money : Money.values()) {
                    System.out.println(money.getNominalo() + " rub.");
                }
                System.out.println("How many do you want to contribute?");
                double money = s.nextDouble();
               s.nextLine();
                balance += money;
            } else if (choice == 2) {
                System.out.println("Choose drink: 0 - 2");
                int drinkchoice = s.nextInt();
                s.nextLine();
                Drinks selectedDrink = Drinks.values()[drinkchoice];
                double price = selectedDrink.getPrice();
                if (balance >= price) {
                    balance -= price;
                    System.out.println("your drink is" + selectedDrink.getName());
                    System.out.println("Balance: " + balance + " rub.");
                } else {
                    System.out.println("NO MONEY - NO DRINK");
                }
            } else if (choice == 3) {
                Money best = null;
                for (Money money : Money.values()) {
                    if (money.getNominalo() <= balance) {
                        if (best == null || money.getNominalo() > best.getNominalo()) {
                            best = money;
                        }
                    }
                }
                if (best != null) {
                    System.out.println("return " + best.getNominalo() + " руб.");
                    double change = balance - best.getNominalo();
                    if (change > 0) {
                        System.out.println("No change" + change + " руб.");
                    }
                }
                else{
                    System.out.println("Nothing to return");
                }
                balance = 0;
            } else if (choice == 4){
                break;
            }
        }
        s.close();
    }
}
