package easy.done;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: 1496. Path Crossing
 * Space: O(n)
 * Time: O(n)
 * Topics: Hash Table, String
 * Given a string path, where path[i] = 'N', 'S', 'E', or 'W', representing moving north, south, east, or west,
 * respectively, return true if the path crosses itself at any point.
 * <p>
 * Example:
 * Input: path = "NESWW"
 * Output: true
 * Hint: Use a set to track visited positions and check for crossings.
 * http://leetcode.com/problems/path-crossing/
 */
public class PathCrossing {

	public static void main(String[] args) {
		String path = "NESWW";
		boolean result = isPathCrossing(path);
		System.out.println("Does the path cross itself? " + result); // Output: true
	}

	private static boolean isPathCrossing(String path) {
		Set<String> visited = new HashSet<>();
		int x = 0;
		int y = 0;
		visited.add("0,0"); // Starting position
		for (char c : path.toCharArray()) {
			switch (c) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
			}

			String position = x + "," + y;
			if (visited.contains(position)) {
				return true;
			}
			visited.add(position);
		}

		return false;
	}
}