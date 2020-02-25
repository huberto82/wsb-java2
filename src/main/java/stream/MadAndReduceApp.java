package stream;

import generics.User;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class X{
    double x;

    public X(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
public class MadAndReduceApp {
    public static void main(String[] args) {
        //wykorzystanie reduce do sumowania
        int suma = IntStream.generate(() -> new Random().nextInt(100))
                .limit(100000)
                .reduce(0,(accu, i) -> accu + i);
        System.out.println(suma);
        //result = a * x + b * x + c * x;
        //a, b, c są w strumieniu
        double result = DoubleStream.of(4.0, 2.5, 1.0)
                .reduce(0.0, (accu, factor) -> accu + factor * 5.0);
        System.out.println(result);

        //z listy wierszy opisujących użytkownika chcemy otrzymać listę obiektów klasy User
        List<String> usersAsStr = Arrays.asList("ola 2000-10-10","adam 2004-12-09", "karol 1999-05-13", "ewa");
        //Lista optionali z userami
        List<Optional<User>> OptionalUsers = usersAsStr.stream()
                .map(line -> {
                    String[] tokens = line.split(" ");
                    if (tokens.length == 2){
                        String name = tokens[0];
                        LocalDate date = LocalDate.parse(tokens[1]);
                        User user = new User(name, date);
                        return Optional.of(user);
                    }
                    return Optional.empty();
                })
                .map(o -> (Optional<User>) o)
                .collect(Collectors.toList());
        System.out.println(OptionalUsers);
        //Lista z userami, która może zawierać wartość null
        List<User> users = usersAsStr.stream()
                .map(line -> {
                    String[] tokens = line.split(" ");
                    if (tokens.length == 2){
                        String name = tokens[0];
                        LocalDate date = LocalDate.parse(tokens[1]);
                        User user = new User(name, date);
                        return user;
                    }
                    return null;
                })
                .filter(Objects::nonNull) // usuwanie nulli
                .collect(Collectors.toList());
        //filtracja listy z userami
        users.stream().filter(u -> u.getName().startsWith("a")).forEach(System.out::println);
        //filtracja listy z Optional<User>
        OptionalUsers.stream().filter(o -> o.filter(u -> u.getName().startsWith("a")).isPresent()).forEach(System.out::println);
        //czy istnieje jakikolwiek element w strumieniu - findAny
        Optional<User> findAny = users.stream().findAny();
        System.out.println(findAny);
        //Czy wszystkie znaki są cyframi - metoda allMatch
        System.out.println("123556a".chars().allMatch(Character::isDigit));
        List<User> team = Arrays.asList(new User("dyrektor", LocalDate.parse("1987-11-11")), new User("edek", LocalDate.parse("2001-05-16")));
        Stream.of(users,team).flatMap(u -> u.stream().filter(user -> user.getName().length() < 5)).forEach(System.out::println);
    }
}
