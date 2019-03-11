package ll;

import java.util.Stack;

public class Palindrome {

	public static boolean isPalindrome(LinkedList ll) {
		Stack<Integer> stack = new Stack<>();
		Node slow, fast;
		slow = fast = ll.head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				stack.push(slow.val);
				fast = fast.next;
			}
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.val != stack.pop())
				return false;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.add(5).add(4).add(3).add(4).add(5);
		//ll.add(5).add(4).add(3).add(5);
		//ll.add(5).add(4).add(2).add(5)
		ll.display();
		System.out.println(isPalindrome(ll));

	}

}
