package Tests_LinkedList;

public class L328_OddEvenLinkedList {

	public static void main(String[] args) {

		L328_OddEvenLinkedList a = new L328_OddEvenLinkedList();

		ListNode.printList(a.oddEvenList1(ListNode.getList()));
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next, cur = head, curNext;
		int count = 1;
		while (cur.next.next != null) {
			curNext = cur.next;
			cur.next = curNext.next;
			cur = curNext;
			count++;
		}
		if (count % 2 == 1) {
			cur.next = second;
		} else {
			cur.next.next = second;
			cur.next = null;
		}
		return head;
	}

	// faster method
	public ListNode oddEvenList1(ListNode head) {
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;

	}

}
