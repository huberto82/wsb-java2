package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> print = System.out::print;
        Consumer<String> println = System.out::println;
        Consumer<Integer> squareToPrint = x -> System.out.println(x * x);

        print.accept("ALA ");
        println.accept(" BEATA");
        squareToPrint.accept(5);

        List<String> names = Arrays.asList("ALA", "OLA", "ADA", "KAROL");
        names.forEach(name -> System.out.print(" |" + name +"| "));
        names.forEach(name -> System.out.print(name.length() + " "));
    }
}
