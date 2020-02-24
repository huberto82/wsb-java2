package generics;

import java.time.LocalDate;

public class MaxApp {
    public static void main(String[] args) {
         User a = new User("ALA", LocalDate.of(2000,10,10));
         User b = new User("ADAM", LocalDate.of(2000,11,9));
         Max<User> maxUserByName = new Max<User>() {
             @Override
             public User max(User ob1, User ob2) {
                 return ob1.name.length() > ob2.name.length() ? ob1 : ob2;
             }
         };
        System.out.println(maxUserByName.max(a, b));
        System.out.println(a.info(10));
        System.out.println(a.info("ABC"));
        System.out.println(a.info(b));
    }
}
