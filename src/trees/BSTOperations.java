package trees;

import java.util.Arrays;

public class BSTOperations {

	public static void main(String[] args) {

		BST bst = new BST();
		Arrays.stream(new int[] { 4, 2, 1, 67, 32, 12, 100, 43 }).forEach(bst::add);
		bst.delete(67);
		bst.inorder();
	}

}
/*
            4 
    2                  67 
1              32                    100
             12         43      */