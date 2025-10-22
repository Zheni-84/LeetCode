package easy.done;

import java.util.Optional;

/**
 * LeetCode Problem 110: Balanced Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the recursive DFS approach).
 * <p>
 * This class provides a method to check if a binary tree is balanced.
 * A balanced binary tree is defined as a tree where the depth of the two subtrees of every node never differs by more than one.
 * The main method demonstrates the usage of the isBalanced method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A balanced binary tree is one where the height of the left and right subtrees of any node differ by at most one.
 * The height of a tree is the number of edges on the longest path from the root to a leaf node.
 * If the height of the left and right subtrees of any node differ by more than one, the tree is not balanced.
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class OfficialSolutionForBalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		//root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);

		boolean isBalanced = isBalanced1(root);
		System.out.println("Is the binary tree balanced? " + isBalanced);
	}

	private static boolean isBalanced1(TreeNode root) {
		return height1(root) != -1;
	}

	private static int height1(TreeNode node) {
		if (node == null) return 0;

		int left = height1(node.left);
		if (left == -1) return -1; // left subtree not balanced

		int right = height1(node.right);
		if (right == -1) return -1; // right subtree not balanced

		if (Math.abs(left - right) > 1) return -1; // current node not balanced

		return Math.max(left, right) + 1;
	}

	private static boolean isBalanced2(TreeNode root) {
		return height2(root).isPresent();
	}

	private static Optional<Integer> height2(TreeNode node) {
		if (node == null)
			return Optional.of(0);

		var leftHeight = height2(node.left);
		if (leftHeight.isEmpty())
			return Optional.empty(); // left not balanced

		var rightHeight = height2(node.right);
		if (rightHeight.isEmpty())
			return Optional.empty(); // right not balanced

		Integer hLeft = leftHeight.get();
		Integer hRight = rightHeight.get();
		if (Math.abs(hLeft - hRight) > 1)
			return Optional.empty(); // current not balanced

		return Optional.of(Math.max(hLeft, hRight) + 1);
	}

	// Definition for a binary tree node.
	private static class TreeNode {

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