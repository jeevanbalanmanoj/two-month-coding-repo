package trees;

public class BoundaryNodes {

	private static void boundary(BinaryTree tree) {
		printLeftBoundary(tree.root);
		System.out.println("*");
		printLeaf(tree.root);
		System.out.println("*");
		printRightBoundary(tree.root.right);

	}

	private static void printLeaf(Node root) {

		if (root == null)
			return;
		printLeaf(root.left);
		if (root.left == null && root.right == null)
			System.out.println(root.value);
		printLeaf(root.right);

	}

	private static void printLeftBoundary(Node root) {

		if (root == null)
			return;
		if (root.left != null || root.right != null)
			System.out.println(root.value);
		printLeftBoundary(root.left);
		if (root.left == null && root.right != null)
			printLeftBoundary(root.right);

	}

	private static void printRightBoundary(Node root) {

		if (root == null)
			return;
		if (root.left != null || root.right != null)
			System.out.println(root.value);
		printRightBoundary(root.right);
		if (root.right == null && root.left != null)
			printLeftBoundary(root.left);

	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);

		boundary(tree);
	}

}
