package generics;

abstract public class Pizza {
    int price;

    public Pizza(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class PepperoniPizza extends Pizza{

    public PepperoniPizza(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "PepperoniPizza{" +
                "price=" + price +
                '}';
    }
}

class HawaiiPizza extends Pizza{
    public HawaiiPizza(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "HawaiiPizza{" +
                "price=" + price +
                '}';
    }
}

