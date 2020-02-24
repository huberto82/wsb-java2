package functional;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> howManyA = s -> {
          int counter = 0;
          for(int i = 0; i < s.length(); i++){
              if (s.charAt(i) == 'A'){
                  counter++;
              }
          }
          return counter;
        };

        System.out.println(howManyA.apply("ABRACADABRA"));
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        System.out.println(howManyA.andThen(square).apply("ABRACADABRA"));

        Function<String, Integer> squareOfA = howManyA.andThen(square);
        System.out.println(squareOfA.apply("ALA"));
        Function<String, Integer> squareOfACompose = square.compose(howManyA);

        System.out.println(squareOfACompose.apply("ALA"));
    }
}
