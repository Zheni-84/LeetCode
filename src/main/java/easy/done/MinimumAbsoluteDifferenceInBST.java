package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem 530: Minimum Absolute Difference in BST
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the stack).
 * Topic: Binary Search Tree (BST), In-Order Traversal
 * <p>
 * This class provides a method to find the minimum absolute difference between values of any two nodes in a BST.
 * The main method demonstrates the usage of the getMinimumDifference method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: In a BST, in-order traversal gives sorted order of values.
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {
	static int min = Integer.MAX_VALUE;
	static Integer prev = null; // Use Integer to allow null value

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		int minDiff = getMinimumDifference(root);
		System.out.println("Minimum absolute difference in BST: " + minDiff); // Output: 2
		// Example: For the BST [0, 2, 4, 5, 8], the minimum absolute difference is 2 (between 2 and 4).
	}

	private static int minDiffInBST(TreeNode root) {
		inorder(root);
		return min;
	}

	private  static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		if (prev != null) {
			min = Math.min(min, Math.abs(root.val - prev));
		}

		prev = root.val;

		inorder(root.right);
	}

	private static int getMinimumDifference(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		Integer prev = null;
		int minDiff = Integer.MAX_VALUE;

		while (curr != null || !stack.isEmpty()) {
			//Go left as deep as possible
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			//Process current node
			curr = stack.pop();
			if (prev != null) {
				minDiff = Math.min(minDiff, curr.val - prev);
			}
			prev = curr.val;

			//Move to the right
			curr = curr.right;
		}

		return minDiff;
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}