package easy.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode Problem 653: Two Sum IV - Input is a BST
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(n), where n is the number of nodes in the tree (for storing values).
 * Topic: Binary Search Tree (BST), Two-Pointer Technique
 * <p>
 * This class provides a method to determine if there exist two elements in a BST such that their sum is equal to a given target.
 * The main method demonstrates the usage of the findTarget method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: We can perform an in-order traversal to get the sorted values of the BST and then use the two-pointer technique to find if there are two numbers that sum to the target.
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		int k = 9;

		TwoSumIV solution = new TwoSumIV();
		boolean result = solution.findTarget(root, k);
		System.out.println("Exist two elements in the BST such that their sum is equal to " + k + "? " + result); // Output: true

		// Using optimized approach with two controlled BST iterators
		boolean resultIterators = solution.findTargetIterators(root, k);
		System.out.println("Exist two elements in the BST such that their sum is equal to " + k + "? " + resultIterators); // Output: true
	}

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> values = new ArrayList<>();
		// Perform in-order traversal to get sorted values
		inorder(root, values);

		int left = 0;
		int right = values.size() - 1;
		// Use two-pointer technique to find if there are two numbers that sum to k
		while (left < right) {
			int sum = values.get(left) + values.get(right);
			if (sum == k)
				return true;
			// Move the left pointer to the right if the sum is less than k
			if (sum < k) {
				left++;
			}
			// Move the right pointer to the left if the sum is greater than k
			else {
				right--;
			}
		}

		// If no such pair is found, return false
		return false;
	}

	private void inorder(TreeNode node, List<Integer> values) {
		if (node == null)
			return;

		inorder(node.left, values);
		values.add(node.val);
		inorder(node.right, values);
	}

	// Optimized approach using two controlled BST iterators
	// Time Complexity: O(n)
	// Space Complexity: O(h), where h is the height of the tree (for the stacks)
	public boolean findTargetIterators(TreeNode root, int k) {
		if (root == null)
			return false;

		BSTIterator leftIt = new BSTIterator(root, true);   // Ascending
		BSTIterator rightIt = new BSTIterator(root, false); // Descending

		int leftVal = leftIt.next();
		int rightVal = rightIt.next();

		while (leftVal < rightVal) { // Stop when iterators cross
			int sum = leftVal + rightVal;
			if (sum == k)
				return true;
			if (sum < k)
				leftVal = leftIt.next();
			else
				rightVal = rightIt.next();
		}
		return false;
	}

	// Helper class for controlled BST traversal
	static class BSTIterator {

		private final Deque<TreeNode> stack = new ArrayDeque<>();
		private final boolean forward; // true = ascending, false = descending

		BSTIterator(TreeNode root, boolean forward) {
			this.forward = forward;
			pushAll(root);
		}

		int next() {
			TreeNode node = stack.pop();
			if (forward)
				pushAll(node.right);
			else
				pushAll(node.left);
			return node.val;
		}

		private void pushAll(TreeNode node) {
			while (node != null) {
				stack.push(node);
				node = forward ? node.left : node.right;
			}
		}
	}

	static class TreeNode {

		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}