package stream;

import java.util.Random;

public class RandomString {
    private final Random rand;

    public RandomString() {
        rand = new Random();
    }

    public String random(int size){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < size; i++){
            sb.append(Character.valueOf((char) ('a'+ rand.nextInt('z' - 'a'))).toString());
        }
        return sb.toString();
    }
}
