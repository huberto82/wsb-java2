package collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("EWA");
        names.add("KAROL");
        names.add("ADAM");
        System.out.println(names);
        names.add(1,"ANNA");
        System.out.println(names);
        names.remove(2);
        System.out.println(names);
        System.out.println(names.get(1));
        System.out.println(names.indexOf("ADAM"));
        names.set(2,"BEATA");
        System.out.println(names);
        //usuwanie podczas przeglądania kolekcji tylko za pomoca iteratora!!!
        //Korzystanie z iteratora
        Iterator<String> iterator = names.iterator();
        //sprawdz czy jest następny element
        while(iterator.hasNext()){
            //przejdź do następnego elementu i zwróć bieżący element
            String name = iterator.next();
            if (name.contains("E")){
                //usuń bieżący element
                iterator.remove();
            }
        }
        System.out.println(names);
    }
}
