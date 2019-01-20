package trees;

class Height {
	int h;

	public Height(int h) {
		super();
		this.h = h;
	}

}

class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
	}

	public int diameter() {

		Height h = new Height(0);
		return diameter(root, h);
	}

	public int diameter(Node root, Height h) {
		Height lh = new Height(0);
		Height rh = new Height(0);
		if (root == null) {
			h.h = 0;
			return 0;
		}
		int ld = diameter(root.left, lh);
		int rd = diameter(root.right, rh);
		h.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(Math.max(ld, rd), lh.h + rh.h + 1);

	}
}

public class LargestDiameter {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The diameter of given binary tree is : " + tree.diameter());
	}

}
