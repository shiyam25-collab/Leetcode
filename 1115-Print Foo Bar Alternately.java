import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    // Semaphore for foo: initialized with 1 permit so foo() can start first
    private final Semaphore fooSemaphore = new Semaphore(1);
    // Semaphore for bar: initialized with 0 permits so bar() must wait
    private final Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Acquire a permit to print "foo"
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            // Release a permit to let bar() execute
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Acquire a permit to print "bar" (blocks until foo releases it)
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            // Release a permit to let foo() execute again
            fooSemaphore.release();
        }
    }
}
