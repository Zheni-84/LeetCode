package easy.done;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 257: Binary Tree Paths
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the recursion stack).
 * Topic: Binary Tree, Depth-First Search (DFS), Path Finding
 *
 * This class provides a method to find all root-to-leaf paths in a binary tree.
 * The main method demonstrates the usage of the binaryTreePaths method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A root-to-leaf path is defined as a path from the root node down to any leaf node.
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;

		dfs(root, new StringBuilder(), result);
		return result;
	}

	private void dfs(TreeNode node, StringBuilder path, List<String> result) {
		if (node == null)
			return;

		// We keep track of the length before appending to handle the "->" correctly
		// This way, we can backtrack easily by restoring the path to its previous state
		// This is important to ensure that the path is correct for the next recursive call
		int lenBefore = path.length();
		// If this is not the first node, append "->" to the path
		if (lenBefore != 0) {
			path.append("->");
		}
		// Append the current node's value to the path
		path.append(node.val);

		// If a leaf, add path to result
		if (node.left == null && node.right == null) {
			result.add(path.toString());
		} else {
			// Continue to traverse left and right children
			dfs(node.left, path, result);
			dfs(node.right, path, result);
		}

		// Backtrack to explore other paths
		// Restore the path to its previous state
		// by removing the last appended node value
		// This is important to ensure that the path is correct for the next recursive call
		// We use the length before appending to avoid removing the "->" if it was not added
		// This way, we maintain the correct path for each recursive call
		path.setLength(lenBefore);
	}

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
