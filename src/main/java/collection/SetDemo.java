package collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("ADAM");
        set.add("EWA");
        set.add("KAROL");
        System.out.println(set);
        set.add("EWA");
        System.out.println(set);
        //czy EWA należy do zbioru set
        System.out.println(set.contains("EWA"));
        set.remove("ADAM");
        System.out.println(set);
    }
}
