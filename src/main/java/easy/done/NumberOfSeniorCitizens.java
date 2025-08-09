package easy.done;

import java.util.Arrays;

/**
 * LeetCode Problem: 2678. Number of Senior Citizens
 * Space: O(1)
 * Time: O(n)
 * Topics: String, Array
 * You are given an array of strings details, where each string contains information about a person in the following
 * format: "IDAgeSexAgeSeat"
 * - ID is a 10-digit number representing the person's ID.
 * - Age is a 2-digit number representing the person's age.
 * Hint: Use a simple loop to count the number of senior citizens (age >= 60).
 * Example:
 * Input: details = ["7868190130M7522", "5303914400F9211", "9273338290F4010"]
 * Output: 2
 * Explanation: The first person is 75 years old, the second is 92, and the third is 40.
 * The first two are senior citizens (age >= 60).
 * http://leetcode.com/problems/number-of-senior-citizens/
 */
public class NumberOfSeniorCitizens {

	public static void main(String[] args) {
		String[] details = {
				"7868190130M7522",
				"5303914400F9211",
				"9273338290F4010"
		};

		int count = countSeniors(details);
		System.out.println("Number of senior citizens: " + count); // Output: 2

		int countStream = countSeniorsStream(details);
		System.out.println("Number of senior citizens (stream): " + countStream); // Output: 2
	}

	private static int countSeniors(String[] details) {
		int count = 0;
		for (String detail : details) {
			// Extract the age from the string
			int age = Integer.parseInt(detail.substring(11, 13));
			// Check if the age is 60 or older
			if (age >= 60) {
				count++;
			}
		}
		return count;
	}

	private static int countSeniorsStream(String[] details) {
		return (int) Arrays.stream(details)
				.mapToInt(detail -> Integer.parseInt(detail.substring(11, 13)))
				.filter(age -> age > 60)
				.count();
	}
}