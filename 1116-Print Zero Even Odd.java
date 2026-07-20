import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int state = 0; // 0: print zero, 1: print odd, 2: print even

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (state != 0) {
                wait();
            }
            printNumber.accept(0);
            // If the next number to print is odd, change state to 1. Otherwise, change to 2.
            if (i % 2 != 0) {
                state = 1;
            } else {
                state = 2;
            }
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                wait();
            }
            printNumber.accept(i);
            state = 0; // The next number to print must always be 0
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                wait();
            }
            printNumber.accept(i);
            state = 0; // The next number to print must always be 0
            notifyAll();
        }
    }
}
