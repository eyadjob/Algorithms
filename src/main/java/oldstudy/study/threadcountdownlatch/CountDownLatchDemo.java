package oldstudy.study.threadcountdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(3);

        Thread cacheService  = new Thread(new Service("cache service", 1000, latch) );
        Thread alertService  = new Thread(new Service("alert service", 2000, latch) );
        Thread validationService  = new Thread(new Service("validate service", 3000, latch) );

        cacheService.start();
        alertService.start();
        validationService.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All service is up , application is running now");
    }

}
