package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            int iteration = 10;
            while(iteration-- > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello");
            }
        });
        service.execute(()->{
            System.out.println("start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        });

        Runnable task = () -> {
            System.out.println("TASK");
        };
        service.execute(task);
        final AtomicInteger teamCounter = new AtomicInteger(0);
        Runnable playerTask = () -> {
          int counter = 1000;
          while(counter-- > 0){
              try {
                  Thread.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              teamCounter.incrementAndGet();
          }
        };

        service.execute(playerTask);
        service.execute(playerTask);
        service.execute(playerTask);
        service.execute(playerTask);
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
        System.out.println(teamCounter.get());
    }
}
