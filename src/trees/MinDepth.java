package trees;

public class MinDepth {
	private static int minDepth(Node A) {
		if (A == null)
			return 0;
		if (A.left == null && A.right == null)
			return 1;
		if(A.right==null)
		return minDepth(A.left) +1;
		if(A.left==null)
			return minDepth(A.right) +1;
		
		return Math.min(minDepth(A.left), minDepth(A.right)) + 1;

	}

	public static void main(String[] args) {
		Node a = new Node(1);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);
		BinaryTree tree = new BinaryTree();
		tree.root = a;
		System.out.println(minDepth(tree.root));

	}

}
