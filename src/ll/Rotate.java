package ll;

public class Rotate {

	static Node rotateRight(Node head) {

		Node ptr = head;
		while (ptr.next.next != null)
			ptr = ptr.next;
		Node nodeTobeMoved = ptr.next;
		ptr.next = null;
		nodeTobeMoved.next = head;
		head = nodeTobeMoved;
		return head;

	}

	public static Node rotate(Node head, int B) {
		if (head == null || head.next == null)
			return head;
		for (int i = 0; i < B; i++) {
			head = rotateRight(head);
		}
		return head;
	}

	private static int length(Node head) {
		Node ptr = head;
		int count = 0;
		while (ptr != null) {
			ptr = ptr.next;
			count++;
		}
		return count;
	}

	public static Node rotateOptimal(Node head, int B) {

		if (head == null || head.next == null)
			return head;
		Node slow = head, fast = head;
		Node parent = null, end = null;
		int length = length(head);
		for (int i = 0; i < B; i++) {

			fast = fast.next;
			if (fast == null)
				fast = head;
		}
		
		while (fast != null) {
			end = fast;
			fast = fast.next;
			parent = slow;
			slow = slow.next;
		}
		if( slow == null)
			return head;
		parent.next = null;
		end.next = head;
		head = slow;
		return head;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(75).add(5).add(16).add(36).add(86).add(68);
		ll.display();
		System.out.println("");
		ll.head = rotateOptimal(ll.head, 90);
		ll.display();

	}

}
