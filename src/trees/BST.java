package trees;

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		super();
		this.value = value;
		this.left = this.right = null;
	}

}

public class BST {
	Node root;

	public BST() {
		super();
		this.root = null;
	}

	public BST(Node root) {
		super();
		this.root = root;
	}

	public void delete(int del) {

		if (root == null) {
			System.out.println("Empty tree");
			return;
		}

		Node save = null, ptr = root;
		while (ptr != null) {
			if (ptr.value == del) {
				break;
			}
			save = ptr;
			if (del < ptr.value)
				ptr = ptr.left;
			else
				ptr = ptr.right;
		}

		// ptr found

		if (ptr == null) {
			System.out.println("Not found");
			return;
		}

		if (ptr.left != null & ptr.right != null) {

			Node parent = ptr;
			Node child = ptr;
			if (child.right == null)
				return;
			
			// Get the inorder successor 
			
			parent = child;
			child = child.right;
			while (child.left != null) {
				parent = child;
				child = child.left;
			}
			
			// Delete that node from the tree 
			delete_single(parent, child);

			
			// Plug in that successor to node to be deleted's place
			
			child.left = ptr.left;
			child.right = ptr.right;

			if (ptr == root) {
				root = child;
				return;
			}

			if (save.left == ptr)
				save.left = child;
			else
				save.right = child;

		} else
			delete_single(save, ptr);

	}

	private void delete_single(Node parent, Node node) {

		Node child = null;
		if (node.left != null)
			child = node.left;
		else
			child = node.right;

		if (root == node) {
			root = child;
			return;
		}

		if (node == parent.left)
			parent.left = child;
		else
			parent.right = child;

	}

	public void add(int newVal) {

		Node n = new Node(newVal);
		if (root == null) {
			root = n;
			return;
		}
		Node save = null, ptr = root;
		while (ptr != null) {
			save = ptr;
			if (n.value <= ptr.value)
				ptr = ptr.left;
			else
				ptr = ptr.right;
		}
		if (n.value < save.value)
			save.left = n;
		else
			save.right = n;
	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);

	}

}
