package easy.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* LeetCode Problem 1971: Find if Path Exists in Graph
   Time Complexity: O(E + V), where E is the number of edges and V is the number of vertices.
   Space Complexity: O(V)
   Topic: Graph, Union-Find (Disjoint Set Union)
   This class provides a method to determine if there is a valid path between two nodes in an undirected graph.
   The validPath method uses the Union-Find data structure to efficiently connect nodes and check connectivity.
   Hint: Use Union-Find to group connected components and check if source and destination are in the same component.
   https://leetcode.com/problems/find-if-path-exists-in-graph/
*/
public class FindIfPathExistsInGraph {

	public static void main(String[] args) {
		int n1 = 3;
		int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		int source1 = 0;
		int destination1 = 2;
		System.out.println("Valid Path (Test Case 1): " + validPath(n1, edges1, source1, destination1)); // Output: true

		int n2 = 6;
		int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
		int source2 = 0;
		int destination2 = 5;
		System.out.println("Valid Path (Test Case 2): " + validPath(n2, edges2, source2, destination2)); // Output: false
	}

	public boolean validPathDFSIterative(int n, int[][] edges, int source, int destination) {
		if(source == destination) return true;

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) graph.add(new ArrayList<>());

		boolean[] visited = new boolean[n];
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(source);
		visited[source] = true;
		while(!stack.isEmpty()){
			int node = stack.pop();
			if(node == destination) return true;
			List<Integer> nodeNeighbors = graph.get(node);
			for(int ne : nodeNeighbors){
				if(!visited[ne]){
					visited[ne] = true;
					stack.push(ne);
				}
			}
		}

		return false;
	}

	private static boolean validPath(int n, int[][] edges, int source, int destination) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;

		for (int[] e : edges) union(parent, e[0], e[1]);
		return find(parent, source) == find(parent, destination);
	}

	private static int find(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find(parent, parent[x]); // path compression
		return parent[x];
	}

	private static void union(int[] parent, int a, int b) {
		int pa = find(parent, a);
		int pb = find(parent, b);
		if (pa != pb)
			parent[pa] = pb;
	}
}