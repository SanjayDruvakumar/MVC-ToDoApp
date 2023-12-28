package syncronized;

public class SynchronizationDemo {
	static int x = 0;

	synchronized void increase() {
		x++;
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizationDemo demo = new SynchronizationDemo();
		Thread thread1 = new Thread(() -> {
			for (int i = 1; i <= 10000; i++) {
				demo.increase();
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 1; i <= 20000; i++) {
				demo.increase();
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(x);
	}
}
