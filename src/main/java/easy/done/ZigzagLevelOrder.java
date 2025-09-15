package easy.done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem 103: Binary Tree Zigzag Level Order Traversal
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(m), where m is the maximum number of nodes at any level in the tree (for the queue).
 * Topic: Tree, Breadth-First Search (BFS)
 *
 * This class provides a method to perform a zigzag level order traversal of a binary tree.
 * The main method demonstrates the usage of the zigzagLevelOrder method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: Use a queue to perform BFS and a boolean flag to alternate the order of insertion.
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		ZigzagLevelOrder solution = new ZigzagLevelOrder();
		var result = solution.zigzagLevelOrder(root);
		System.out.println(result); // Output: [[3], [20, 9], [15, 7]]
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (leftToRight) {
					level.add(node.val);
				} else {
					level.add(0, node.val); // add to the front for reverse order
				}

				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}

			result.add(level);
			leftToRight = !leftToRight; // toggle the direction
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}