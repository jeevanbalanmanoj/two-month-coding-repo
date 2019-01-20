package trees;

public class Subtree {



	public static void main(String[] args) {

		Node a = new Node(1);
		Node b = new Node(2);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);

		//b.left = new Node(3);
		//b.right = new Node(2);
		b.left= new Node(4);
		b.right = new Node(5);
		//b.right.right = new Node(4);
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		tree1.root = a;
		tree2.root = b;
		System.out.println(isSubTree(tree1.root, tree2.root));

	}

	private static void inorder(Node root, StringBuilder path) {
		if (root == null) {
			path.append("*");
			return;
		}

		inorder(root.left, path);
		path.append(root.value);
		inorder(root.right, path);

	}

	private static void preorder(Node root, StringBuilder path) {
		if (root == null) {
			path.append("*");
			return;
		}

		path.append(root.value);
		preorder(root.left, path);
		preorder(root.right, path);

	}

	private static boolean isSubTree(Node a, Node b) {
		StringBuilder aPathIorder = new StringBuilder();
		StringBuilder bPathIorder = new StringBuilder();
		StringBuilder aPathPreorder = new StringBuilder();
		StringBuilder bPathPreorder = new StringBuilder();
		if (b == null)
			return true;
		if (a == null)
			return false;
		inorder(a, aPathIorder);
		inorder(b, bPathIorder);
		
		
		if (!aPathIorder.toString().contains(bPathIorder.toString()))
			return false;
		preorder(a, aPathPreorder);
		preorder(b, bPathPreorder);
		return (aPathPreorder.toString().contains(bPathPreorder.toString()));
	}

	

}
