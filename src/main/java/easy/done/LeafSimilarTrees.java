package easy.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* LeetCode Problem 872 - Leaf Similar Trees
 * Time complexity: O(n + m), where n and m are the number of nodes in the two trees.
 * Space complexity: O(h1 + h2), where h1 and h2 are the heights of the two trees (due to recursion stack or explicit stack).
 * Topics: Tree, Depth-First Search, Stack, Recursion
 *
 * Description:
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * Note:
 * Both of the given trees will have between 1 and 100 nodes.
 *
 * Hint: Use Depth-First Search (DFS) to traverse both trees and collect their leaf values.
 * Link: https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(1);
		root1.left.left = new TreeNode(6);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(4);
		root1.right.left = new TreeNode(9);
		root1.right.right = new TreeNode(8);

		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(1);
		root2.left.left = new TreeNode(6);
		root2.left.right = new TreeNode(7);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(2);
		root2.right.right.left = new TreeNode(9);
		root2.right.right.right = new TreeNode(8);

		System.out.println(leafSimilar1(root1, root2)); // Output: true
	}

	private static boolean leafSimilar1(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		stack1.push(root1);
		stack2.push(root2);

		while(!stack1.isEmpty() && !stack2 .isEmpty()){
			int leaf1 = getNextLeaf(stack1);
			int leaf2 = getNextLeaf(stack2);
			// If the leaf values are not the same, exit early
			if(leaf1 != leaf2) return false;
		}

		// If one stack is empty and the other is not, the trees are not leaf-similar
		// If both stacks are empty, the trees are leaf-similar
		return stack1.isEmpty() && stack2.isEmpty();
	}

	private static int getNextLeaf(Stack<TreeNode> stack){
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			// Push right first so that left is processed first (LIFO)
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
			// If it's a leaf node, return its value
			if(node.left == null & node.right==null){
				return node.val;
			}
		}

		return -1;// we should never reach here
	}

	private static boolean leafSimilar2(TreeNode root1, TreeNode root2) {

		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();

		// Collect leaves of both trees
		collectLeaves(root1, leaves1);
		collectLeaves(root2, leaves2);

		return leaves1.equals(leaves2);
	}

	private static void collectLeaves(TreeNode node, List<Integer> leaves) {
		if (node == null)
			return;

		// If it's a leaf node, add its value to the list
		if (node.left == null && node.right == null) {
			leaves.add(node.val);
			return;
		}

		// Recursion for left and right subtrees
		collectLeaves(node.left, leaves);
		collectLeaves(node.right, leaves);
	}

	// Definition for a binary tree node.
	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

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