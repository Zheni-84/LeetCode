package easy.done;

/**
 * LeetCode Problem 2331: Evaluate Boolean Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
 * Topic: Tree, Depth-First Search (DFS)
 *
 * This class provides a method to evaluate a boolean binary tree, where each leaf node represents
 * a boolean value (0 for false, 1 for true) and each internal node represents a logical operation
 * (2 for OR, 3 for AND). The main method demonstrates the usage of the evaluateTree method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: Use DFS to evaluate the tree from the leaves up to the root.
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 */
public class EvaluateBooleanBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		boolean result = evaluateTree(root);
		System.out.println(result); // Output: true
	}
	private static boolean evaluateTree(TreeNode root) {
		int val = root.val;

		// leaf case
		if(root.left==null && root.right==null){
			return val == 1;
		}

		//inner node
		boolean leftVal = evaluateTree(root.left);
		boolean rightVal = evaluateTree(root.right);

		return val == 2 ? leftVal || rightVal : leftVal && rightVal;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}