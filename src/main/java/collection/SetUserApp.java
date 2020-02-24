package collection;

import generics.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUserApp {
    public static void main(String[] args) {
        /**
         * Włąsne klasy muszą mieć zdefiniowane:
         * metodę equals i hashCode jeśli używamy kolekcji typu set, hash
         * interfejs Comparable jeśli używamy kolekcji TreeSet, TreeMap
         * dla zbioru TreeSet o unikalności decyduje compareTo!!!
         */
        Set<User> users = new TreeSet<>();
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        users.add(new User("ada", LocalDate.of(2000, 10, 10)));
        System.out.println(users);
        System.out.println("**************************");
        users.add(new User("alicja", LocalDate.of(1999,12,12)));
        System.out.println(users);
    }
}
