import java.util.concurrent.CountDownLatch;

class Foo {
    // Latch to block the second thread until the first is done
    private final CountDownLatch latch1;
    // Latch to block the third thread until the second is done
    private final CountDownLatch latch2;

    public Foo() {
        this.latch1 = new CountDownLatch(1);
        this.latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // Decrement the count of latch1, letting the second thread proceed
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first thread calls countDown() on latch1
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // Decrement the count of latch2, letting the third thread proceed
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second thread calls countDown() on latch2
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
