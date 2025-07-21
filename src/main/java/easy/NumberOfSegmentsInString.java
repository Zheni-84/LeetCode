package easy;

/**
 * LeetCode Problem 434 - Number of Segments in a String
 * Topics: String
 * Time Complexity: O(n) - where n is the length of the string s, as we traverse the string once.
 * Space Complexity: O(1) - no additional space used.
 * <p>
 * Description:
 * Count the number of segments in a string, where a segment is defined as a contiguous sequence of non-space characters.
 * <p>
 * Link: https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class NumberOfSegmentsInString {

	public static void main(String[] args) {
		String s = "Hello, my name is John";
		int segmentCount = countSegments(s);
		System.out.println("Number of segments: " + segmentCount);
	}

	private static int countSegments(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
				count++;
			}
		}

		return count;
	}
}