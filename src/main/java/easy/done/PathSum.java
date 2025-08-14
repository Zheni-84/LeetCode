package easy.done;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode Problem 112: Path Sum
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the BFS approach).
 * Topic: Binary Tree, Depth-First Search (DFS), Breadth-First Search (BFS), Path Sum Calculation
 * This class provides methods to determine if a binary tree has a root-to-leaf path such that the sum of the node values equals a given target sum.
 * The main method demonstrates the usage of both the DFS and BFS approaches.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A root-to-leaf path is a path that starts at the root and ends at any leaf node, where a leaf node is a node with no children.
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

	public static void main(String[] args) {
		// Example usage
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		int targetSum = 22;

		System.out.println(hasPathSumDFS(root, targetSum)); // Output: true
		System.out.println(hasPathSumBFS(root, targetSum)); // Output: true
	}

	private static boolean hasPathSumDFS(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		// Subtract the current node's value from targetSum
		// to check if the remaining sum can be achieved in the subtree
		targetSum -= root.val;
		if (root.left == null && root.right == null) {
			// If we reach a leaf node, check if the remaining targetSum is zero
			// This means we have found a path that sums up to the original targetSum
			// because we subtracted the values along the path
			return targetSum == 0;
		}

		// Recursively check the left and right subtrees
		// If either subtree returns true, we have found a valid path
		return hasPathSumDFS(root.left, targetSum) || hasPathSumDFS(root.right, targetSum);
	}

	private static boolean hasPathSumBFS(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		Queue<TreeNode> nodeQueue = new ArrayDeque<>();
		Queue<Integer> sumQueue = new ArrayDeque<>();

		nodeQueue.offer(root);
		sumQueue.offer(root.val);

		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int sum = sumQueue.poll();

			if (node.left == null && node.right == null && sum == targetSum) {
				return true;
			}
			if (node.left != null) {
				nodeQueue.offer(node.left);
				sumQueue.offer(sum + node.left.val);
			}
			if (node.right != null) {
				nodeQueue.offer(node.right);
				sumQueue.offer(sum + node.right.val);
			}
		}
		return false;
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}