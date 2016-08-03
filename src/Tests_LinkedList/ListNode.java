package Tests_LinkedList;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int v) {
		val = v;
	}

	public static ListNode getList() {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(6);
		ListNode n8 = new ListNode(8);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		return n0;
	}

	public static void printList(ListNode head) {
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		while (head.next != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println(head.val);
	}

}
