package Struc;

public class QueueByArray {
	int data[];
	int head;
	int tail;

	public QueueByArray(int data[]) {
		this.data = data;
		head = 0;
		tail = data.length;
	}

	public boolean isEmpty() {
		return (head == tail);
	}

	public void enqueue(int num) {
		if (tail - head >= data.length) {
			resizeArray(data.length * 2);
		}
		data[tail++] = num;
	}

	public int dequeue() {
		if (head == tail)
			return -1;
		int tmp = data[head++];
		if ((tail - head) <= data.length / 4) {
			resizeArray(data.length / 2);
		}
		return tmp;
	}

	public int[] getQueue() {
		int d[] = new int[tail - head];
		for (int i = head; i < tail; i++) {
			d[i - head] = data[i];
		}
		return d;
	}

	private void resizeArray(int newlength) {
		int[] newArray = new int[newlength];
		for (int i = head; i < tail; i++) {
			newArray[i - head] = data[i];
		}
		data = newArray;
		tail = tail - head;
		head = 0;
	}

}
