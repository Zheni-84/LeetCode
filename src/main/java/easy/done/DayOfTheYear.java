package easy.done;

/**
 * LeetCode Problem 1154 - Day of the Year
 * Topics: String, Math
 * Time complexity: O(1) - since the date string is always of fixed length.
 * Space complexity: O(1) - since we are using a constant amount of space.
 * <p>
 * Description:
 * Given a date string in the format "YYYY-MM-DD", return the day number of the year.
 * <p>
 * Link: https://leetcode.com/problems/day-of-the-year/
 **/
public class DayOfTheYear {

	public static void main(String[] args) {
		// Example usage
		String date1 = "2020-01-01"; // Expected output: 1
		String date2 = "2019-02-10"; // Expected output: 41
		String date3 = "2019-12-31"; // Expected output: 365

		System.out.println(dayOfYear1(date1)); // Output: 1
		System.out.println(dayOfYear2(date2)); // Output: 41
		System.out.println(dayOfYear2(date3)); // Output: 365
	}

	private static int dayOfYear1(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int days = Integer.parseInt(date.substring(8, 10));

		// Days in each month
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			daysInMonth[1] = 29;
		}

		// Sum days of all months before this one
		int totalDays = 0;
		for (int i = 0; i < month - 1; i++) {
			totalDays += daysInMonth[i];
		}

		return totalDays + days;
	}

	public static int dayOfYear2(String date) {
		String[] parts = date.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);

		// Days in each month
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) {
			daysInMonth[1] = 29;
		}

		// Calculate the day of the year
		int dayOfYear = day;
		for (int i = 0; i < month - 1; i++) {
			dayOfYear += daysInMonth[i];
		}

		return dayOfYear;
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}