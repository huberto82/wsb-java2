package concurrent;

//Metoda definiowania wątku jako klasy potomnej po klasie Thread
class TaskThread extends Thread{
    @Override
    public void run() {
        int count = 10;
        while(count-- > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from thread");
        }
    }
}

//Metoda definiowania przy pomocy interfejsu Runnable
class TaskRunnable implements Runnable{
    @Override
    public void run() {
        int count = 10;
        while(count-- > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from runnable");
        }
    }
}

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("START");
        Thread.sleep(1000);
        System.out.println("END");

        //uruchomienie wątku z klasy TaskThread
        TaskThread taskThread = new TaskThread();
        System.out.println("PO UTWORZENIU " + taskThread.getState());
        System.out.println("START WĄTKU");
        taskThread.start();
        Thread.sleep(500);
        System.out.println("W TRAKCIE SLEEP " + taskThread.getState());
        System.out.println("PO START " +taskThread.getState());
        System.out.println("PO STARCIE");
        taskThread.join();
        System.out.println("KONIEC PRACY WĄTKU");
        System.out.println("PO ZAKONCZENIU " +taskThread.getState());

        //Tworznie wątku klasy implementującej Runnable
        Thread runnableTask = new Thread(new TaskRunnable());
        runnableTask.start();

        //Tworzenie wątku z wykorzystanie lambdy
        new Thread(() -> {
            System.out.println("Hello from lambda");
        }).start();

    }
}
