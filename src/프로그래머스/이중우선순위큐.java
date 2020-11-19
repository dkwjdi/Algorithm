package 프로그래머스;

import java.util.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	static PriorityQueue<Integer> max = new PriorityQueue<Integer>(); //최솟값 먼저 
	static PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder()); //최댓값먼저
	static int offerCnt;
	static int pollCnt;

	static class Solution {
		public int[] solution(String[] operations) {
			max = new PriorityQueue<Integer>();
			min = new PriorityQueue<Integer>(Collections.reverseOrder());
			offerCnt=0;
			pollCnt=0;
			
			int len = operations.length;
			for (int i = 0; i < len; i++) {
				String input = operations[i];
				int num = Integer.parseInt(input.substring(2));
				switch (input.charAt(0)) {
				case 'I':
					inputNum(num);
					break;
				case 'D':
					deleteNum(num);
					break;
				}
			}
			
			if(offerCnt<2) {
				int[] answer= {0,0};
				return answer;
			}
			else {
				 int[] answer = {min.poll(), max.poll()};
				return answer;
			}
		}

		private void deleteNum(int num) {
			if(offerCnt>0) {
				if(--offerCnt==0) {
					max.clear();
					min.clear();
					return;
				}
			}
			if (num > 0)
				min.poll();
			else
				max.poll();
		}

		private void inputNum(int num) {
			offerCnt++;
			max.add(num);
			min.add(num);
		}
	}

	public static void main(String[] args) {
		
		String[] op = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6" };
		new Solution().solution(op);

//		String st="D 1";
//		System.out.println(st.length());
//		StringBuilder sb= new StringBuilder("");
//		sb= new StringBuilder(st);
//		
//		int a = Integer.parseInt(st.substring(2));
//		System.out.println(a);
//		
//		Deque <Integer> deque = new ArrayDeque<>();
	}

}
