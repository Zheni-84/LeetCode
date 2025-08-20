package easy.done;

/**
 * LeetCode Problem 543: Diameter of Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the recursion stack).
 * Topic: Binary Tree, Depth-First Search (DFS)
 *
 * This class provides two methods to calculate the diameter of a binary tree.
 * The main method demonstrates the usage of both methods.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: The diameter is defined as the length of the longest path between any two nodes in the tree.
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

	private int diameter = 0; // Class variable to store the diameter, used in the second method

	public static void main(String[] args) {
		// Example usage
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int diameter = diameterOfBinaryTree1(root);
		System.out.println("Diameter of the binary tree: " + diameter); // Output: 3
	}

	// First method to calculate the diameter of a binary tree using recursion with diameter as an value parameter
	private static int diameterOfBinaryTree1(TreeNode root) {
		int[] diameter = new int[1];
		depth(root, diameter);
		return diameter[0];
	}

	private static int depth(TreeNode node, int[] diameter) {
		if (node == null)
			return 0;

		int leftDepth = depth(node.left, diameter);
		int rightDepth = depth(node.right, diameter);

		// Update the diameter if the path through this node is larger
		diameter[0] = Math.max(diameter[0], leftDepth + rightDepth);

		// Return the depth of the current node
		return Math.max(leftDepth, rightDepth) + 1;
	}

	/*******************************************************************************************/

	// Second alternative method using a class variable for diameter
	public int diameterOfBinaryTree2(TreeNode root) {
		height(root);
		return diameter;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;

		int left = height(node.left);
		int right = height(node.right);

		// Update diameter if path through this node is longer
		diameter = Math.max(diameter, left + right);

		// Height = 1 + max(left, right)
		return 1 + Math.max(left, right);
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}