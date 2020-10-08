import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static AtomicInteger counter = new AtomicInteger(0);
    private  static class Visitor extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                counter.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        Thread [] threads  = new Thread[n];
        for(int i = 0; i< n; i++){
            threads[i] = new Visitor();
            threads[i].start();
        }
        for(int i = 0; i < n; i++){
            threads[i].join();
        }
        System.out.println(counter.get());

    }
}
