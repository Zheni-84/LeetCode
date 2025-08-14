package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 111: Minimum Depth of Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the BFS approach).
 * Topic: Binary Tree, Breadth-First Search (BFS), Depth Calculation
 *
 * This class provides a method to calculate the minimum depth of a binary tree using a breadth-first search (BFS) approach.
 * The main method demonstrates the usage of the minDepth method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: The minimum depth of a binary tree is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int depth = minDepth(root);
		System.out.println("Minimum Depth of Binary Tree: " + depth); // Output: 2
	}
	private static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				//found the first leaf
				if (node.left == null && node.right == null)
					return depth;

				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
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