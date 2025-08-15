package easy.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode Problem 144: Binary Tree Preorder Traversal
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the stack).
 * Topic: Binary Tree, Depth-First Search (DFS), Preorder Traversal
 *
 * This class provides a method to perform a preorder traversal of a binary tree using an iterative approach with a stack.
 * The main method demonstrates the usage of the preorderTraversal method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: In preorder traversal, the nodes are visited in the order: root, left subtree, right subtree.
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		List<Integer> result = preorderTraversal(root);
		System.out.println(result); // Output: [1, 2, 4, 5, 3]
	}
	private static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);

			// Push right child first so that left child is processed first
			// in the next iteration, this is because stack is LIFO (Last In First Out)
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}

		return result;
	}

	private static List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preorder(root, result);
		return result;
	}

	private static void preorder(TreeNode node, List<Integer> result) {
		if (node == null) return;
		result.add(node.val);         // Visit root
		preorder(node.left, result);  // Visit left
		preorder(node.right, result); // Visit right
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