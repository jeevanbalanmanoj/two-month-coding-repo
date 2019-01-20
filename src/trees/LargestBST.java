package trees;

class Info {
	boolean isBST;
	int size;
	int low;
	int high;

	public Info(boolean isBST, int size, int low, int high) {
		super();
		this.isBST = isBST;
		this.size = size;
		this.low = low;
		this.high = high;
	}

}

public class LargestBST {

	private static void largestBST(BinaryTree tree) {

		System.out.println(largest(tree.root).size);
	}

	private static Info largest(Node root) {
		Info info = new Info(true, 0, 0, 0);

		if (root == null)
			return info;
		info.size = 1;
		info.low = root.value;
		info.high = root.value;
		if (root.left == null && root.right == null)
			return info;

		Info left = largest(root.left);
		Info right = largest(root.right);

		info.isBST = (root.left == null || root.value >= left.high) && (root.right == null || root.value < right.low)
				&& left.isBST && right.isBST;
		if (info.isBST) {
			info.size = left.size + right.size + 1;
			if (root.left != null)
				info.low = left.low;
			if (root.right != null)
				info.high = right.high;
		} else {
			info.size = Math.max(left.size, right.size);
			info.low = 0;
			info.high = 0;
		}
		return info;
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		tree.root = root;

		largestBST(tree);

		root = new Node(60);
		root.left = new Node(65);
		root.right = new Node(70);
		root.left.left = new Node(50);

		tree.root = root;

		largestBST(tree);

	}

}
