package easy.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* * LeetCode Problem: 94. Binary Tree Inorder Traversal
 * Space: O(h) recursion stack, worst case O(n) for skewed tree
 * Time: O(n)
 * Topics: Tree, Depth-First Search, Binary Tree
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Hint: Use recursion to traverse the left subtree, visit the node, and then traverse the right subtree.
 * http://leetcode.com/problems/binary-tree-inorder-traversal/
 */

// This code implements the inorder traversal of a binary tree using recursion.
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		List<Integer> result = inorderTraversal(root);
		System.out.println(result); // Output: [1, 3, 2]

		List<Integer> iterativeResult = inOrderIterative(root);
		System.out.println(iterativeResult); // Output: [1, 3, 2]
	}

	private static List<Integer> inOrderIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			//Traverse to the leftmost node
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			// Visit the node
			current = stack.pop();
			result.add(current.val);

			//Traverse the right subtree
			current = current.right;
		}

		return result;
	}

	private static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inOrderRecursion(root, result);
		return result;
	}

	private static void inOrderRecursion(TreeNode node, List<Integer> result) {
		// Base case: if the node is null, return
		// This is the termination condition for the recursion.
		// It prevents further traversal down a non-existent branch.
		if (node == null)
			return;
		// Recursive case: traverse the left subtree, visit the node, and then traverse the right subtree.
		// This follows the inorder traversal pattern: left, root, right.
		inOrderRecursion(node.left, result);
		result.add(node.val);
		inOrderRecursion(node.right, result);
	}

	static class TreeNode {

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