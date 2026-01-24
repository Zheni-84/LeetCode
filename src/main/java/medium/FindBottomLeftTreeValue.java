package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 513. Find Bottom Left Tree Value
 * Time Complexity: O(N) where N is the number of nodes in the tree
 * Space Complexity: O(H) where H is the height of the tree (due to recursion stack)
 * Topics: Tree, Depth-First Search, Breadth-First Search
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Examples:
 * Input: root = [2,1,3]
 * Output: 1
 * <p>
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * <p>
 * Solutions:
 * 1. Depth-First Search (O(N) time, O(H) space)
 * <p>
 * Hint:
 * 1. Perform a DFS traversal while keeping track of the depth and update the leftmost value when a new maximum depth is reached.
 * <p>
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);

		FindBottomLeftTreeValue finder = new FindBottomLeftTreeValue();
		int bottomLeftValueDFS = finder.findBottomLeftValueDFS(root);
		System.out.println("Bottom Left Value (DFS): " + bottomLeftValueDFS); // Output: 7

		int bottomLeftValueBFS = findBottomLeftValueBFS(root);
		System.out.println("Bottom Left Value (BFS): " + bottomLeftValueBFS); // Output: 7
	}

	//Time Complexity: O(N) where N is the number of nodes in the tree
	//Space Complexity: O(H) where H is the height of the tree (due to recursion stack)
	//Breadth-First Search
	private static int findBottomLeftValueBFS(TreeNode root) {
		if (root == null) {
			return -1; // or throw an exception based on requirements
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int leftmostValue = root.val;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			// The first node in the current level is the leftmost node
			leftmostValue = queue.peek().val;

			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}

		return leftmostValue;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	private int maxDepth = -1;
	private int leftmostValue;

	//Time Complexity: O(N) where N is the number of nodes in the tree
	//Space Complexity: O(H) where H is the height of the tree (due to recursion stack)
	//Depth-First Search
	public int findBottomLeftValueDFS(TreeNode root) {
		dfs(root, 0);
		return leftmostValue;
	}

	private void dfs(TreeNode node, int depth) {
		if (node == null) {
			return;
		}

		// If this is the first time we reach this depth, update leftmostValue
		if (depth > maxDepth) {
			maxDepth = depth;
			leftmostValue = node.val;
		}

		// Traverse left subtree first to ensure the leftmost node is found first
		dfs(node.left, depth + 1);
		dfs(node.right, depth + 1);
	}

	// Definition for a binary tree node.
	public static class TreeNode {

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