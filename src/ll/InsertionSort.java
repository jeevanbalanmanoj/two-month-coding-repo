package ll;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class InsertionSort {

	private static Node insertionSort(Node A) {
		if (A == null)
			return A;
		Node i = A.next;
		Node iPrev = A;
		while (i != null) {
			Node jPrev = null;
			Node j = A;
			while (j != i && j.val < i.val) {
				jPrev = j;
				j = j.next;
			}
			if (jPrev == null)
				A = i;
			else
				jPrev.next = i;

			iPrev.next = i.next;
			i.next = j;
			i = iPrev.next;
		}
		return A;
	}


	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.add(4).add(3).add(1).add(5).add(6);
		ll.display();
		ll.head=insertionSort(ll.head);
		ll.display();

	}

}
