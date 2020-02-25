package concurrent;

import java.util.Scanner;

public class InterruptDemo {
    public static void main(String[] args) {
        Thread task = new Thread(()->{
           int counter = 0;
           while(!Thread.currentThread().isInterrupted()){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
               //sekcja jednej iteracji
               counter++;
           }
           if (counter >= 10) {
               System.out.println("Sukces: " + counter);
           } else {
               System.out.println("Porażka " + counter);
           }
        });
        task.start();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("quit")){
            //przerywamy wątek task;
            task.interrupt();
        }
    }
}
