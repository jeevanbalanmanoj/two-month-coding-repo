package trees;

import java.util.Arrays;

public class LCA {
	private static boolean found1, found2;

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		lca(tree, 4, 5);

		BST bst = new BST();
		Arrays.stream(new int[] { 4, 2, 1, 67, 32, 12, 100, 43 }).forEach(bst::add);

		lca(bst, 100, 11);

	}

	private static void lca(BinaryTree tree, int a, int b) {
		Node lca = lca(tree.root, a, b);
		if (lca != null && found1 && found2)
			System.out.println("LCA : " + lca.value);
		else
			System.out.println("None");
	}

	private static Node lca(Node root, int a, int b) {
		if (root == null)
			return null;
		if (root.value == a) {
			found1 = true;
			return root;
		}
		if (root.value == b) {
			found2 = true;
			return root;
		}

		Node left = lca(root.left, a, b);
		if (found1 && found2)
			return left;
		Node right = lca(root.right, a, b);
		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;

	}

	private static void lca(BST tree, int a, int b) {

		Node ptr = tree.root;
		while (ptr != null) {
			if (ptr.value == a || ptr.value == b) {
				System.out.println("LCA : " + ptr.value);
				return;
			}
			if (a < ptr.value && b < ptr.value)
				ptr = ptr.left;
			else if (a > ptr.value && b > ptr.value)
				ptr = ptr.right;
			else {
				System.out.println("LCA : " + ptr.value);
				return;
			}
		}
		System.out.println("No common parent");

	}

}
