package Struc;

public class StackByLinkedList<T> {
	Node<T> top;
	int size;

	public StackByLinkedList() {
		top = null;
		size = 0;
	}

	public void push(T data) {
		Node<T> oldTop = top;
		top = new Node<T>(data, oldTop);
		size++;
	}

	public T pop() {
		if (isEmpty())
			return null;
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		return false;
	}

	public T getItemAt(int position) {
		if (position < 0 || isEmpty() || position >= size)
			return null;
		Node<T> temp = new Node<T>(top.data, top);
		for (int i = 0; i < size - position; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public int getSize() {
		return size;
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
