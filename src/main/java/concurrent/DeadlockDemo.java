package concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        //bezpieczna wielowątkowo lista
        final List<String> list = Collections.synchronizedList(new ArrayList<>());
        //lista niemodyfikowalna
        final List<String> listOnlyRead = Collections.unmodifiableList(new ArrayList<>());
        Runnable task1 = ()-> {
            int count = 10;
            while(count-- > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                lockB.lock();

                counterA.inc(2);
                counterB.inc(1);

                lockA.unlock();
                lockB.unlock();
                System.out.println("TASK1 " + count);
                //zostanie rzucony wyjątek UnsupportedOperationException
                listOnlyRead.add("ALA");
                //do tej listy mozemy bezpiecznie dodawać elementy
                list.add("aaa");
            }
        };
        Runnable task2 = ()-> {
            int count = 10;
            while(count-- > 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                lockB.lock();

                counterA.inc(1);
                counterB.inc(2);

                lockA.unlock();
                lockB.unlock();

                System.out.println("TASK2 " + count);
            }
        };

        service.execute(task1);
        service.execute(task2);

        service.shutdown();
    }
}
