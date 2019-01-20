package trees;

public class BinaryTreeMirror {

	public static boolean isMirror(Node a, Node b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;

		return (a.value == b.value && isMirror(a.left, b.right) && isMirror(a.right, b.left));

	}

	public static void main(String[] args) {

		Node a = new Node(1);
		Node b = new Node(1);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);

		b.left = new Node(3);
		b.right = new Node(2);
		b.right.left = new Node(5);
		b.right.right = new Node(4);
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		tree1.root = a;
		tree2.root = b;
		System.out.println(isMirror(tree1.root, tree2.root));

	}

}
