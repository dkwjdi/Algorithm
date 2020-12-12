package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프린터 {
	static class Solution {
		public int solution(int[] priorities, int location) {
			int answer = 0;

			List<Integer> priority = new ArrayList<>();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < priorities.length; i++) {
				queue.offer(i);
				priority.add(priorities[i]);
			}
			Collections.sort(priority, Comparator.reverseOrder());
			
			while (true) {
				int index = queue.poll();
				if (priorities[index] == priority.get(0)) {
					priority.remove(0);
					answer++;
					if (index == location)
						break;
				} else
					queue.offer(index);
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		int[] priorities= {1, 1, 9, 1, 1, 1}; int location=0;
		new Solution().solution(priorities, location);
	}
}
