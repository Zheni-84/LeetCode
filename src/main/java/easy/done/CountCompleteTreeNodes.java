package easy.done;

/**
 * LeetCode Problem 222: Count Complete Tree Nodes
 * Time Complexity: O(log(n) * log(n)), where n is the number of nodes in the tree.
 * Space Complexity: O(1), since we are using a constant amount of space.
 * Topic: Binary Tree, Height Calculation
 * <p>
 * This class provides a method to count the number of nodes in a complete binary tree.
 * The main method demonstrates the usage of the countNodes method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		int count = countNodes(root);
		System.out.println("Count of complete tree nodes: " + count); // Output: 6
	}

	private static int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int leftH = getHeight(root.left);
		int rightH = getHeight(root.right);

		if (leftH == rightH) {
			// Left subtree is perfect
			return (1 << leftH) + countNodes(root.right);
		}
		// Right subtree is perfect
		return (1 << rightH) + countNodes(root.left);
	}

	// This method calculates the height of the leftmost path in the tree
	// which is used to determine if the tree is complete.
	// The height is defined as the number of nodes in the longest path from the root to the leftmost leaf node.
	private static int getHeight(TreeNode node) {
		int h = 0;
		while (node != null) {
			h++;
			node = node.left;
		}

		return h;
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

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