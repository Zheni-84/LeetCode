package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 104: Maximum Depth of Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the recursive DFS approach) or O(n) for the BFS approach in the worst case (if the tree is skewed).
 *
 * This class provides two methods to calculate the maximum depth of a binary tree:
 * 1. maxDepthDFSBrute - a brute force recursive approach using Depth First Search (DFS).
 * 2. maxDepthBFS - an iterative approach using Breadth First Search (BFS).
 * The main method demonstrates the usage of the maxDepthDFSBrute method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int depth = maxDepthDFSBrute(root);
		System.out.println("Maximum Depth of Binary Tree: " + depth); // Output: 3
	}

	private static int maxDepthDFSBrute(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepthDFSBrute(root.left), maxDepthDFSBrute(root.right));
	}

	private static int maxDepthBFS(TreeNode root) {
		if (root == null)
			return 0;

		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		// Start with the root node in the queue
		// This is the first level of the tree
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				// Process all nodes at the current level
				// Dequeue(remove from start) the current node and enqueue (add to end) its children
				// If the current node has children, they will be added to the queue end for the next level
				TreeNode current = queue.poll();//remove from start
				// If the current node has children, they will be added to the queue end for the next level
				// This is the key part of BFS, where we explore all nodes at the current level before moving to the next level
				// We add the left child first, then the right child
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			depth++;
		}

		return depth;
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