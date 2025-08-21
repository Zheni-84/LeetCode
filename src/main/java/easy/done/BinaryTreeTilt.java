package easy.done;

/**
 * LeetCode Problem 563 - Binary Tree Tilt
 * Topics: Binary Tree, Depth-First Search (DFS)
 * Time Complexity: O(n) - where n is the number of nodes in the tree.
 * Space Complexity: O(h) - where h is the height of the tree (for the recursion stack).
 * <p>
 * Description:
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
 * and the sum of all right subtree node values. If a node does not have a left or right child, the sum is treated as 0.
 * <p>
 * Example:
 * Input: [4,2,9,3,5,null,7]
 * Output: 15
 * Explanation:
 * Tilt of node 2 = |3 - 5| = 2
 * Tilt of node 9 = |0 - 7| = 7
 * Tilt of node 4 = |(3+5+2) - (9+7)| = |10 - 16| = 6
 * Total Tilt = 2 + 7 + 6 = 15
 * <p>
 * Hint:
 * - A brute force solution repeatedly computes subtree sums → O(n^2).
 * - An optimized solution uses post-order DFS to compute subtree sums and tilt simultaneously → O(n).
 * Link: https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

	public static void main(String[] args) {
		BinaryTreeTilt btt = new BinaryTreeTilt();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);

		int tilt = btt.findTilt(root);
		System.out.println("Total Tilt: " + tilt); // Output: 15
	}

	private int totalTilt = 0;
	private int findTilt(TreeNode root) {
		dfs(root);
		return totalTilt;
	}

	private int dfs(TreeNode node){
		if(node == null) return 0;

		// Recursively calculate the sum of left and right subtrees
		// and update the total tilt
		// The sum of the current node's value is added to the total tilt
		int leftSum = dfs(node.left);
		int rightSum = dfs(node.right);
		// Calculate the tilt for the current node
		totalTilt += Math.abs(leftSum - rightSum);

		// Return the sum of the current node's value and its subtrees
		// This is used to calculate the tilt of the parent node
		// and to propagate the sum up the tree
		return leftSum + rightSum + node.val;
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
		TreeNode(int x, TreeNode left, TreeNode right) {
			val = x;
			this.left = left;
			this.right = right;
		}
	}
}