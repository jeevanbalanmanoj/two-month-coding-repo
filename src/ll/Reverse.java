package ll;

public class Reverse {
	public static void reverse(LinkedList ll) {
		Node prev, current, next;
		prev = null;
		current = ll.head;
		next = null;
		if (current == null) {
			return;
		}
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		ll.head = prev;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(5).add(4).add(3).add(2).add(1);
		ll.display();
		reverse(ll);
		ll.display();
		
	}

}
