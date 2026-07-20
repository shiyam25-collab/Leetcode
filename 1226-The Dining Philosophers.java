import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore waiter = new Semaphore(4); // limit concurrent diners to avoid deadlock

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        waiter.acquire(); // ensures at most 4 philosophers try to pick up forks at once

        forks[left].acquire();
        forks[right].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[left].release();
        forks[right].release();

        waiter.release();
    }
}
