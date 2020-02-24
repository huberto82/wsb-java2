package generics;

import java.util.Optional;

public class BoxApp {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        System.out.println(stringBox.isEmpty());
        stringBox.setContent("Hello");
        System.out.println(stringBox.isEmpty());
        System.out.println(stringBox.getContent());
        Box<Integer> integerBox = new Box<>();
        int a = 4;
        integerBox.setContent(a);
        Optional<String> stringOptional = Optional.empty();
        System.out.println(stringOptional.isPresent());
        String str = "java2";
        stringOptional = Optional.of(str);
        System.out.println(stringOptional.isPresent());

        stringOptional = Optional.ofNullable(null);
        System.out.println(stringOptional.isPresent());

        System.out.println(lastWord("Ala ma kota").orElse("Nie ma ostaniego słowa!!!"));
    }

    static Optional<String> lastWord(String str){
        if (str == null || str.isEmpty()){
            return Optional.empty();
        }
        String[] words= str.split(" ");
        return Optional.of(words[words.length - 1]);
    }
}
