package ll;


public class RemoveDupsFromSortedList {

	private static Node deleteDuplicates(Node A) {
		if (A == null)
			return A;
		Node ptr = A;
		while (ptr.next != null) {
			Node i = ptr;
			while (ptr.val == ptr.next.val) {
				ptr = ptr.next;
			}
			if (i != ptr)
				i.next = ptr.next;
			ptr = ptr.next;

		}
		return A;
	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.add(5).add(4).add(3).add(3).add(1).add(1);
		ll.display();
		ll.head = deleteDuplicates(ll.head);
		ll.display();

	}

}
