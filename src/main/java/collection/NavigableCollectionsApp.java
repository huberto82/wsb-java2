package collection;

import java.util.*;

public class NavigableCollectionsApp {
    public static void main(String[] args) {
        NavigableMap<Integer, String> words = new TreeMap<>();

        words.put(4, "kot");
        words.put(2,"ale");
        words.put(1,"java");
        words.put(6,"laptop");
        System.out.println(words.lowerKey(2));
        System.out.println(words.tailMap(4));

        //kolekcje puste
        // emptyList nic nie zawiera, ale zajmuje dużo więcej pammięci niż list
        List<String> emptyList = new ArrayList<>();
        List<String> list = Collections.EMPTY_LIST;

        //specjalna lista na jeden element, też zajmuję dużo mniej pamieci niż zwykła lista z jednym elementem
        emptyList = Collections.singletonList("Jeden");
        System.out.println(list.size());
        System.out.println(emptyList);
        //empty list i singleton list są niemutowalne, nie wolno wykonywać add, remove itd.
        emptyList.add("następny");
        System.out.println(emptyList);
    }
}
