package collection;

import generics.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MapApp {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        User user = new User("ada", LocalDate.of(2000,10,10));
        users.put("ada", user);
        users.put("karol", new User("karol",LocalDate.of(1999,4,13)));
        users.put("ewa", new User("ewa",LocalDate.of(1999,4,13)));

        System.out.println(users);
        users.put("karol", user);
        System.out.println(users);
        users.remove("karol");
        System.out.println(users);
        //wzór przetwarzania mapy w pętli foreach
        for(Map.Entry<String, User> entry: users.entrySet()){
            System.out.println("Klucz = " + entry.getKey() +", wartość= " + entry.getValue());

        }
    }
}
