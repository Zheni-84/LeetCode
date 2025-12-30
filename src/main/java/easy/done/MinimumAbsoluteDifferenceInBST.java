package easy.done;

import java.util.*;

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
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		System.out.println("Minimum Absolute Difference in BST (Iterative In-Order): " + getMinimumDifference(root)); // Output: 1

		// Reset static variables for next method
		min = Integer.MAX_VALUE;
		prev = null;

		System.out.println("Minimum Absolute Difference in BST (Recursive In-Order): " + minDiffInBST(root)); // Output: 1

		// Reset static variables for next method
		min = Integer.MAX_VALUE;
		prev = null;

		System.out.println("Minimum Absolute Difference in BST (BFS): " + getMinimumDifferenceBFS(root)); // Output: 1
	}


	// BFS approach
	// Time Complexity: O(n log n) (due to sorting)
	// Space Complexity: O(n), for storing node values.
	private static int getMinimumDifferenceBFS(TreeNode root) {
		List<Integer> values = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			values.add(node.val);
			if (node.left != null) q.offer(node.left);
			if (node.right != null) q.offer(node.right);
		}

		Collections.sort(values);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < values.size(); i++) {
			minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
		}

		return minDiff;
	}

	private static int minDiffInBST(TreeNode root) {
		inorder(root);
		return min;
	}

	private  static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		if (prev != null) {
			min = Math.min(min, Math.abs(node.val - prev));
		}

		prev = node.val;

		inorder(node.right);
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