package trees;

public class MaxWidth {
	private static int max=0;
	private static int min = 0;
	private static int maxWidth(BinaryTree tree) {
		inorder(tree.root, 0);
		return (max- min+1);
		
	}
	private static void inorder(Node root, int count) {
		if(root == null)
			return;
		
	min = Math.min(count, min);
	max =Math.max(count, max);
	inorder(root.left,count-1);
	inorder(root.right,count+1);
	
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


	/*	root = new Node(60);
		root.left = new Node(65);
		root.right = new Node(70);
		root.left.left = new Node(50);

		tree.root = root;
*/
		System.out.println(maxWidth(tree));

	}

}
