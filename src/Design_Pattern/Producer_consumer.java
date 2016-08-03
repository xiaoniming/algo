package Design_Pattern;

import java.util.LinkedList;
import java.util.Queue;

public class Producer_consumer {

	public static void main(String[] args) {
		Storage s = new Storage();
		Producer producer = new Producer(s);
		Consumer consumer1 = new Consumer(s);
		Consumer consumer2 = new Consumer(s);
		Consumer consumer3 = new Consumer(s);
		new Thread(producer, "producer").start();
		new Thread(consumer1, "consumer 1 ").start();
		new Thread(consumer2, "consumer 2 ").start();
		new Thread(consumer3, "consumer 3 ").start();

	}

}

class Goods {
	private int id;

	public Goods(int pid) {
		id = pid;
	}

	@Override
	public String toString() {
		return "" + id;
	}
}

// Repository to store goods that have been produced, waiting to be taken
class Storage {
	private int MAX_SIZE = 6;
	private Queue<Goods> list = new LinkedList<Goods>();
	public Object signal = new Object();
	public Object signal_take = new Object();

	public void take() {
		synchronized (signal_take) {
			try {
				while (list.size() <= 0) {
					System.out.println("**Storage empty, cannot get!!!**");
					signal_take.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("                 Get: " + list.poll());
			signal_take.notify();

		}

	}

	public void put(Goods g) {
		synchronized (signal) {
			try {
				while (list.size() >= MAX_SIZE) {
					System.out.println("**Storage full, cannot put!!!**");
					signal.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.offer(g);
			System.out.println("Put: " + g.toString());
			signal.notify();
		}
	}
}

class Consumer implements Runnable {
	Storage storage;

	public Consumer(Storage s) {
		storage = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			storage.take();
			System.out.println(Thread.currentThread().getName() + " have: " + i + " Goods.");
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Producer implements Runnable {
	Storage storage;

	public Producer(Storage s) {
		storage = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Goods goods = new Goods(i);
			storage.put(goods);
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
