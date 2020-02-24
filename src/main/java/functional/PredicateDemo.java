package functional;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isNotNull = isNull.negate();
        System.out.println(isNull.test("abc"));
        System.out.println(isNotNull.test("abc"));
        Predicate<String> hasOnlyDigits = s -> {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        };
        //prawda jesli łańcuch ma 11 znaków
        Predicate<String> hasValidLength = s -> s.length() == 1;
        Predicate<String> isValidPesel = isNotNull.and(hasValidLength).and(hasOnlyDigits);
        if (isValidPesel.test("127283928918792")){
            System.out.println("Pesel poprawny");
        } else {
            System.out.println("Pesel niepoprawny");
        }
    }
}
