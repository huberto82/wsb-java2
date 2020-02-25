package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Flux{
    List<String> flux;

    public Flux(List<String> flux) {
        this.flux = flux;
    }

    public Flux filter(Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for(String item:flux){
            System.out.println("FILTER");
            if (predicate.test(item)){
                result.add(item);
            }
        }
        return new Flux(result);
    }

    public void forEach(Consumer<String> consumer){
        for(String item: flux){
            System.out.println("FOREACH");
            consumer.accept(item);
        }
    }
}

public class StreamsApp {
    public static void main(String[] args) {
        /**
         * Cechy strumieni:
         * leniwe przetwarzanie - operacje zapisane w strumieniu są wykonywane tylko gdy zostanie strumiewń zakończony opercją terminalną (która nie zwraca strumienia)
         * iteracja po elementach strumienia jest wykonywana tylko raz
         */
        List<String> list = Arrays.asList("ABB","CFG","DRFT","ERTYUA");
        new Flux(list).filter(s -> s.length() == 3);
        Stream<String> words = list.stream().filter(s -> {
            System.out.println("STREAM FILTER");
            return s.length() == 3;
        });
        long count = words.count();
    }
}
