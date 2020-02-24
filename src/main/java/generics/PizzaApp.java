package generics;

public class PizzaApp {
    public static void main(String[] args) {
        PizzaBox<Pizza> box = new PizzaBox<>(new PepperoniPizza(1000));
        PizzaBox<HawaiiPizza> box1 = new PizzaBox<>(new HawaiiPizza(1200));
        System.out.println(box.getPizza());
        System.out.println(box1.getPizza());
        PizzaBox objBox = new PizzaBox(new PepperoniPizza(4000));
        Pizza pizza = objBox.getPizza();
        Object obj = objBox.getPizza();
   }
}
