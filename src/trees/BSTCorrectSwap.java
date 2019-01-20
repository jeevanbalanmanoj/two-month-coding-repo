package trees;

public class BSTCorrectSwap {

	private static Node prev = null;
	private static Node first = null;
	private static Node middle = null;

	private static Node end = null;

	private static void clearNodes() {
		prev = null;
		first = null;
		middle = null;
		end = null;
	}

	private static void getViolations(Node root) {

		inorderWithPrev(root);
	}

	private static void inorderWithPrev(Node root) {
		if (root == null)
			return;
		inorderWithPrev(root.left);
		if (prev != null && root.value < prev.value) {
			System.out.println("Violation at " + prev.value + " and " + root.value);
			if (first == null) {
				first = prev;
				middle = root;
			} else
				end = root;
		}
		prev = root;
		inorderWithPrev(root.right);
	}

	private static void correctBST(BST bst) {
		getViolations(bst.root);
		if (first == null) {
			System.out.println("No violations");
			return;
		}
		if (end == null) {
			System.out.println("Only one violation");
			int temp = first.value;
			first.value = middle.value;
			middle.value = temp;
		} else {
			System.out.println("Two violations");
			int temp = first.value;
			first.value = end.value;
			end.value = temp;

		}
		clearNodes();
	}

	public static void main(String[] args) {

		BST bst = new BST();
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		bst.root = root;
		bst.inorder();
		correctBST(bst);
		// System.out.println("first : " + first.value + "\nMiddle : " + middle.value+
		// "\nEnd : "+end.value);
		bst.inorder();
		System.out.println("Correcting inorder swap");
		BST bst2 = new BST();
		root = new Node(7);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(6);
		bst2.root = root;
		bst2.inorder();
		correctBST(bst2);
		bst2.inorder();

	}

}
