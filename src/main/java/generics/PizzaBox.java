package generics;

public class PizzaBox<T extends Pizza> {
    T pizza;

    public PizzaBox(T pizza) {
        this.pizza = pizza;
    }

    public T getPizza() {
        return pizza;
    }

    public boolean isPresent(){
        return pizza != null;
    }
}
