package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStringApp {
    public static void main(String[] args) {
        RandomString gen = new RandomString();
        System.out.println(gen.random(6));
        //strumien liczb całkowitych
        IntStream.range(0,100)
                .mapToObj(i -> gen.random(3 +new Random().nextInt(17)))
                .forEach(System.out::println);
        //metoda tworzenia strumieni z interfejsu Stream
        randomStringStream(gen)
                .forEach(System.out::println);
        //tworzenie strumienia z tablicy
        String[] arr = {"AA","BB","VV","CCC"};
        Arrays.stream(arr).filter(s -> s.contains("B")).forEach(System.out::println);

        //FizzBuzz
        IntStream.range(0, 100)
                .mapToObj(i -> {
                    String result = i+" ";
                    if (i % 3 == 0){
                        result += "Fizz ";
                    }
                    if (i % 5 == 0) {
                        result += "Buzz";
                    }
                    return result;
                })
                .forEach(System.out::println);
        IntPredicate fizz = x -> x % 3 == 0;
        IntPredicate buzz = x -> x % 5 == 0;
        //FizzBuzz 2
        IntStream.range(0, 100)
                .mapToObj(i -> {
                    String result = i+" ";
                    result += fizz.test(i) ? "Fizz " : "";
                    result += buzz.test(i) ? "Buzz" : "";
                    return result;
                })
                .forEach(System.out::println);
        //Grupowanie łancuchów wg ich długości
        Map<Integer, List<String>> wordMap = randomStringStream(gen).collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(wordMap);
        System.out.print(wordMap.keySet());

        //Grupowanie łańcuchów wg ich długości i obliczenie liczby słów o tej długości
        Map<Integer, Long> wordCount = randomStringStream(gen).collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
        System.out.println(wordCount);
        //Lista łańcuchów zaczynających się od a i f
        List<String> wordsDF = randomStringStream(gen).filter(s -> s.startsWith("d") || s.startsWith("f")).collect(Collectors.toList());
        System.out.println(wordsDF);
    }

    private static Stream<String> randomStringStream(RandomString gen) {
        return Stream.generate(() -> gen.random(3 + new Random().nextInt(17)))
                .limit(100);
    }
}
