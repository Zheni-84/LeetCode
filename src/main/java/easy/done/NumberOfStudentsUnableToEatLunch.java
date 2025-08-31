package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/* Leetcode Problem 1700: Number of Students Unable to Eat Lunch
 * Time Complexity: O(n^2) in the worst case, where n is the number of students.
 * Space Complexity: O(n) for the queue used to simulate the students.
 * Topic: Queue, Simulation
 *
 * There are two types of sandwiches: circular (0) and square (1). Each student prefers one
 * type of sandwich. The sandwiches are placed in a stack, and students form a queue.
 * The student at the front of the queue tries to take the top sandwich from the stack.
 * If the student prefers that type of sandwich, they take it and leave the queue.
 * If not, they move to the back of the queue. This continues until no students can
 * take the top sandwich. The task is to determine how many students are unable to eat.
 *
 * Hint: Use a queue to simulate the students and an index to track the top sandwich.
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class NumberOfStudentsUnableToEatLunch {

	public static void main(String[] args) {
		int[] students = { 1, 1, 0, 0 };
		int[] sandwiches = { 0, 1, 0, 1 };
		System.out.println(countStudentsBrute(students, sandwiches));
		System.out.println(countStudentsCounters(students, sandwiches));

		int[] students2 = { 1, 1, 1, 0, 0, 1 };
		int[] sandwiches2 = { 1, 0, 0, 0, 1, 1 };
		System.out.println(countStudentsBrute(students2, sandwiches2));
		System.out.println(countStudentsCounters(students2, sandwiches2));
	}

	// brute force solution using queue and stack simulation
	// Time Complexity: O(n^2) in the worst case, where n is the number of students.
	// Space Complexity: O(n) for the queue used to simulate the students
	private static int countStudentsBrute(int[] students, int[] sandwiches) {
		Queue<Integer> queue = new LinkedList<>();
		for (int s : students)
			queue.offer(s);

		int index = 0;

		while (!queue.isEmpty() && index < sandwiches.length) {
			int rotations = 0;
			int size = queue.size();

			while (rotations < size) {
				int student = queue.poll();
				if (student == sandwiches[index]) {
					index++;
					break;
				} else {
					queue.offer(student);
					rotations++;
				}
			}

			if (rotations == size)
				break;
		}

		return queue.size();
	}

	private static int countStudentsCounters(int[] students, int[] sandwiches) {
		int count0 = 0, count1 = 0;
		for (int s : students) {
			if (s == 0)
				count0++;
			else
				count1++;
		}

		for (int sandwich : sandwiches) {
			if (sandwich == 0) {
				if (count0 == 0)
					break;
				count0--;
			} else {
				if (count1 == 0)
					break;
				count1--;
			}
		}

		return count0 + count1;
	}
}