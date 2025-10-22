package easy.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode Problem 145: Binary Tree Postorder Traversal
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the stack).
 * Topic: Binary Tree, Depth-First Search (DFS), Postorder Traversal
 * This class provides methods to perform postorder traversal of a binary tree using an iterative approach.
 * The main method demonstrates the usage of the postorderTraversal method.
 * The TreeNode class is a simple representation of a binary tree node.
 *
 * Hint: In postorder traversal, we visit the left subtree, then the right subtree, and finally the root node.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(5);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);

		List<Integer> result = postorderTraversal(root);
		System.out.println(result); // Output: [2, 5, 11, 6, 7, 5, 9, 9, 1]
		// Using recursion
		// Uncomment the following lines to see the recursive approach
		// List<Integer> resultRecursion = postorderTraversalRecursion(root);
		// System.out.println(resultRecursion); // Output: [2, 5, 11, 6, 7, 5, 9, 9, 1]
	}

	private static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		TreeNode lastVisited = null;

		while (curr != null || !stack.isEmpty()) {
			// Traverse to the leftmost node and push all nodes onto the stack until we reach a null node
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				// Peek the top node of the stack
				// If the right child is not null and has not been visited, move to the right child
				TreeNode peekNode = stack.peek();
				if (peekNode.right != null && lastVisited != peekNode.right) {
					curr = peekNode.right;
				} else {
					// Otherwise, pop the node from the stack and add it to the result
					result.add(peekNode.val);
					lastVisited = stack.pop();
				}
			}
		}

		return result;
	}

	// Recursive approach for postorder traversal
	// Time Complexity: O(n)
	// Space Complexity: O(h) - height of the tree
	private static List<Integer> postorderTraversalRecursion(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		postorder(root, result);
		return result;
	}

	private static void postorder(TreeNode node, List<Integer> result) {
		if (node == null) return;
		postorder(node.left, result);
		postorder(node.right, result);
		result.add(node.val);
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