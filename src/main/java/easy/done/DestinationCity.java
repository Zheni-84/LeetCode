package easy.done;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode Problem: 1436. Destination City
 * Space: O(n)
 * Time: O(n)
 * Topics: Hash Table, String
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
 * Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * Example:
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 *
 * Hint: Use a set to track all starting cities and then find the one that is not in the set.
 * http://leetcode.com/problems/destination-city/
 */
public class DestinationCity {

	public static void main(String[] args) {
		List<List<String>> paths = List.of(
				List.of("London", "New York"),
				List.of("New York", "Lima"),
				List.of("Lima", "Sao Paulo")
		);

		String destination = destCitySet(paths);
		System.out.println("Destination City: " + destination); // Output: "Sao Paulo"
		// Another approach
		String destination2 = destCity(paths);
		System.out.println("Destination City: " + destination2); // Output: "Sao Paulo"
	}

	// Using Sets to find the destination city
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static String destCitySet(List<List<String>> paths) {
		Set<String> from = new HashSet<>();
		Set<String> to = new HashSet<>();

		for(List<String> dest : paths){
			from.add(dest.get(0));
			to.add(dest.get(1));
		}

		Set<String> diff = new HashSet<>(to);
		diff.removeAll(from);

		return diff.iterator().next();
	}

	private static String destCity(List<List<String>> paths) {
		Set<String> starts = new HashSet<>();
		for (List<String> path : paths) {
			starts.add(path.get(0));
		}

		for (List<String> path : paths) {
			String dest = path.get(1);
			if (!starts.contains(dest)) {
				return dest;
			}
		}

		return "";
	}
}