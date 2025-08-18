package easy.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode Problem 404: Sum of Left Leaves
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (for the stack).
 * Topic: Binary Tree, Depth-First Search (DFS)
 * This class provides a method to calculate the sum of all left leaves in a binary tree using an iterative approach.
 * The main method demonstrates the usage of the sumOfLeftLeaves method.
 * The TreeNode class is a simple representation of a binary tree node.
 * Hint: A left leaf is a node that is a left child of its parent and has no children of its own.
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		int sum = sumOfLeftLeaves(root);
		System.out.println("Sum of left leaves: " + sum); // Output: 24
	}
	private static int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		int sum = 0;

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			// Check if the left child is a leaf node
			if(node.left != null){
				// If the left child is a leaf node, add its value to the sum
				// If it has no children, it's a leaf node
				if(node.left.left == null && node.left.right == null){
					sum += node.left.val;
				} else {
					// Otherwise, push it to the stack for further processing
					stack.push(node.left);
				}
			}
			// Push right child to stack if it exists
			if(node.right != null){
				stack.push(node.right);
			}
		}

		return sum;
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