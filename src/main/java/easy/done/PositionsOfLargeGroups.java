package easy.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {

	public static void main(String[] args) {
		String s = "abbxxxxzzy";
		List<List<Integer>> result = largeGroupPositionsFor(s);
		System.out.println(result); // Output: [[3, 6]]

		s = "abc";
		result = largeGroupPositionsWhile(s);
		System.out.println(result); // Output: []

		s = "abcdddeeeeaabbbcd";
		result = largeGroupPositionsWhile(s);
		System.out.println(result); // Output: [[3, 5], [6, 9], [12, 14]]
	}

	// Using a while loop to find large group positions
	private static List<List<Integer>> largeGroupPositionsWhile(String s) {
		List<List<Integer>> result = new ArrayList<>();
		int n = s.length();
		int i = 0;

		while (i < n) {
			int start = i;
			//Move i forward while the same character
			while (i < n && s.charAt(i) == s.charAt(start)) {
				i++;
			}
			//check if the group length is at least 3
			if (i - start >= 3) {
				result.add(Arrays.asList(start, i - 1));
			}
		}

		return result;
	}

	// Using a for loop to find large group positions
	public static List<List<Integer>> largeGroupPositionsFor(String s) {
		List<List<Integer>> result = new ArrayList<>();
		int n = s.length();
		int start = 0;

		for (int i = 1; i <= n; i++) {
			if (i == n || s.charAt(i) != s.charAt(start)) {
				if (i - start >= 3) {
					result.add(Arrays.asList(start, i - 1));
				}
				start = i;
			}
		}

		return result;
	}
}