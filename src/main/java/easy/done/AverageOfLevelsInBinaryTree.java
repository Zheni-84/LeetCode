package easy.done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem 637: Average of Levels in Binary Tree
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(w), where w is the maximum width of the tree (for the queue).
 * Topic: Binary Tree, Breadth-First Search (BFS)
 * <p>
 * This class provides a method to calculate the average value of nodes at each level of a binary tree.
 * The main method demonstrates the usage of the averageOfLevels method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: The average of levels is calculated by summing the values of nodes at each level and dividing by the number of nodes at that level.
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */

public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
		List<Double> averages = solution.averageOfLevels(root);
		System.out.println(averages); // Output: [3.0, 14.5, 11.0]
	}

	// BFS approach
	// Time Complexity: O(n), where n is the number of nodes in the tree.
	// Space Complexity: O(w), where w is the maximum width of the tree (for the queue).
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (root == null)
			return null;

		// Using a queue for level order traversal (BFS)
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// While there are nodes to process
		while (!queue.isEmpty()) {
			// Get the number of nodes at this level
			int size = queue.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;

				// Add the left and right children to the queue for the next level
				// If they exist, we will process them in the next iteration
				// This ensures we traverse the tree level by level
				// and calculate the average for each level
				// This is the essence of level order traversal
				// We use a queue to keep track of nodes at the current level
				// and process them before moving to the next level
				// This way, we can calculate the average for each level
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}

			// Calculate the average for this level and add it to the result list
			result.add(sum / size);
		}

		return result;
	}

	static class TreeNode {

		int val;
		TreeNode left, right;

		TreeNode(int x) {
			val = x;
		}
	}
}