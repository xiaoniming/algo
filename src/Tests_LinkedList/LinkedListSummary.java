package Tests_LinkedList;

public class LinkedListSummary {

	public static void main(String[] args) {
		LinkedListSummary linkedListSummary = new LinkedListSummary();

		// ListNode.printList(linkedListSummary.reverseList_iteratively(ListNode.getList()));
		// ListNode.printList(linkedListSummary.reverseList_recursively(ListNode.getList()));
		ListNode.printList(linkedListSummary.deleteDuplicates_iteratively(ListNode.getList()));
		ListNode.printList(linkedListSummary.deleteDuplicates_recursive(ListNode.getList()));

	}

	public ListNode reverseList_iteratively(ListNode head) {

		ListNode cur = head, pre = null, next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public ListNode reverseList_recursively(ListNode cur) {
		if (cur == null || cur.next == null) {
			return cur;
		}
		ListNode head = reverseList_recursively(cur.next);
		cur.next.next = cur;
		cur.next = null; // make first node point to null, or 0 and 1 will
							// circle
		return head;
	}

	public ListNode deleteDuplicates_iteratively(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
				continue; // in case 1->1->1, more same together
			}
			cur = cur.next;
		}
		return head;
	}

	public ListNode deleteDuplicates_recursive(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates_recursive(head.next);
		return head.val == head.next.val ? head.next : head;

	}

}
