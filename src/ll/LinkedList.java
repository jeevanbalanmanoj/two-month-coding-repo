package ll;

class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
		this.next = null;
	}

	public Node() {
	}

}

public class LinkedList {
	Node head;

	public LinkedList add(int n) {
		Node node = new Node(n);
		if (head == null) {
			head = node;
			return this;
		}
		node.next = head;
		head = node;
		return this;

	}

	public void delete(int n) {
		if (head == null) {
			System.out.println("Empty LL");
			return;
		}
		Node ptr = head, save = null;
		if (ptr.val == n) {
			head = head.next;
			return;
		}

		while (ptr != null && ptr.val != n) {
			save = ptr;
			ptr = ptr.next;
		}
		if (ptr == null)
			return;
		save.next = ptr.next;

	}

	public void display() {
		if (head == null) {
			System.out.println("Empty LL");
			return;
		}
		Node ptr = head;
		while (ptr != null) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}

}
