package trees;

import java.util.Arrays;

public class IsBST {

	private static boolean isBst(BinaryTree tree) {

		return isBst(tree.root, null, null);

	}

	private static boolean isBst(Node root, Node low, Node high) {

		if (root == null)
			return true;
		System.out.println("Visiting " + root.value);
		if( low != null && root.value< low.value)
			return false;
		if( high != null && root.value>= high.value)
			return false;
		
		return (isBst(root.left, low, root) && isBst(root.right, root, high));

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		
		/*Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		tree.root=root;*/
		System.out.println(isBst(tree));
		// lca(tree, 4, 5);

	}

}
