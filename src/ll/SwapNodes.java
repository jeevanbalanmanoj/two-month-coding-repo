package ll;

public class SwapNodes {
	public static void swap(LinkedList ll) {
		Node prev, current, next;
		prev = null;
		current = ll.head;

		if (current == null) {
			return;
		}
		next = current.next;
		if (next == null)
			return;
		ll.head = next;

		while (current != null && next != null) {
			current.next = next.next;
			next.next = current;
			if (prev != null) {
				prev.next = next;
			}
			prev = current;
			current = current.next;
			if (current == null)
				return;
			next = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(1).add(2).add(3).add(4);
		ll.display();
		swap(ll);
		ll.display();

	}

}
