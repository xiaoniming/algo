package Struc;

public class QueueByLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int size;

	public QueueByLinkedList() {
		head = tail = null;
	}

	public void enqueue(T data) {
		Node<T> oldTail = tail;
		tail = new Node<T>(data, null);
		if (isEmpty())
			// initialize head
			head = tail;
		else
			oldTail.next = tail;
		size++;
	}

	public T dequeue() {
		if (isEmpty())
			return null;
		T data = head.data;
		head = head.next;
		size--;
		if (isEmpty())
			tail = null;
		return data;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;

	}

	public T getItemAt(int position) {
		if (position < 0 || position >= size || isEmpty())
			return null;
		Node<T> tmp = new Node<T>(head.data, head.next);
		for (int i = 0; i < position; i++) {
			tmp = tmp.next;
		}
		return tmp.data;

	}

	class Node<T> {
		T data;
		Node<T> next;

		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}

}
