package easy.done;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 2073: Time Needed to Buy Tickets
 * Time: O(n)
 * Space: O(1)
 * Topics: Array, Simulation, Queue
 * <p>
 * There are n people in a line queuing to buy tickets. The ith person has tickets[i] tickets to buy.
 * Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and
 * must go to the end of the line (which happens instantaneously) after buying a ticket if they still
 * have tickets to buy. If a person has no tickets left to buy, they leave the line.
 * <p>
 * Return the time it takes for the kth person (0-indexed) to finish buying all their tickets.
 * <p>
 * Example:
 * Input: tickets = [2,3,2], k = 2
 * Output: 6
 * Hint: Simulate the process using a queue or use a mathematical approach to calculate the time directly.
 * http://leetcode.com/problems/time-needed-to-buy-tickets/
 */
public class TimeNeededToBuyTickets {

	public static void main(String[] args) {
		int[] tickets1 = {2, 3, 2};
		int k1 = 2;
		System.out.println(timeRequiredToBuyBrute(tickets1.clone(), k1)); // Output: 6
		System.out.println(timeRequiredToBuyMath(tickets1.clone(), k1));  // Output: 6
		System.out.println(timeRequiredToBuyQueue(tickets1.clone(), k1)); // Output: 6

		int[] tickets2 = {5, 1, 10, 1};
		int k2 = 0;
		System.out.println(timeRequiredToBuyBrute(tickets2.clone(), k2)); // Output: 12
		System.out.println(timeRequiredToBuyMath(tickets2.clone(), k2));  // Output: 12
		System.out.println(timeRequiredToBuyQueue(tickets2.clone(), k2)); // Output: 12
	}

	private static int timeRequiredToBuyBrute(int[] tickets, int k) {
		int time = 0;
		int n = tickets.length;

		while (tickets[k] > 0) {
			for (int i = 0; i < n; i++) {
				if (tickets[i] > 0) {
					tickets[i]--;
					time++;
				}
				if (tickets[k] == 0) {
					break;
				}
			}
		}

		return time;
	}

	private static int timeRequiredToBuyMath(int[] tickets, int k) {
		int time = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (i <= k) {
				time += Math.min(tickets[i], tickets[k]);
			} else {
				time += Math.min(tickets[i], tickets[k] - 1);
			}
		}
		return time;
	}

	private static int timeRequiredToBuyQueue(int[] tickets, int k) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++) {
			queue.offer(i);  // put all people indexes in the queue
		}

		int time = 0;

		while (!queue.isEmpty()) {
			int person = queue.poll();
			tickets[person]--;   // they buy 1 ticket
			time++;              // 1 second passes

			if (tickets[person] > 0) {
				queue.offer(person);  // still need more tickets
			}

			if (tickets[k] == 0) {   // our target person is done
				break;
			}
		}

		return time;
	}
}
