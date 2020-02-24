package functional;

import generics.User;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;


public class SuppllierDemo {
    public static void main(String[] args) {
        Supplier<String> alfabet = () -> "ABCDEFGHIJKLMNOPRSTU";
        Supplier<User> emptyUser = () -> new User();
        //lub Supplier<User> emptyUser = User::new;
        System.out.println(alfabet.get());
        System.out.println(emptyUser.get());

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //lub BiFunction<Integer, Integer, Integer> sum = (a, b) -> Integer::sum;
        IntFunction<Integer> kwadrat = x -> x * x;
        Function<Integer, Integer> square = x -> x * x;

        System.out.println(kwadrat.apply(6));
    }
}
