package Struc;

public class CustomLinkedList<T> {
	Node<T> head = null;

	public CustomLinkedList() {

	}

	public void add(T data) {
		Node<T> n = new Node<>(data, null);

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
