package Design_Pattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer_Consumer_BlockingQueue {

	public static void main(String args[]) {
		// BlockingQueue takes the concurrent job
		// 所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
		BlockingQueue<Goods> queue = new LinkedBlockingQueue<>(6); // Capacity
																	// of 6
		Producer_B producer = new Producer_B(queue);
		Consumer_B consumer = new Consumer_B(queue);
		new Thread(producer).start();
		new Thread(consumer).start();

	}

}

class Producer_B implements Runnable {
	BlockingQueue<Goods> queue = null;

	public Producer_B(BlockingQueue<Goods> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Goods g = new Goods(i);
				queue.put(g);
				System.out.println("Put: " + g.toString());
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer_B implements Runnable {
	BlockingQueue<Goods> queue = null;

	public Consumer_B(BlockingQueue<Goods> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Goods g = queue.take();
				System.out.println("Take:  " + g.toString());
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}