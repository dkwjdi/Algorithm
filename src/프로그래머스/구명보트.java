package 프로그래머스;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class 구명보트 {
	static class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			Arrays.sort(people);
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < people.length; i++) list.add(people[i]);
			
			int weight=0;
			int size=list.size()-1;
			while (true) {
				if(size==-1) break;
				weight = list.remove(size--);
				if(size==-1) {
					answer++;
					break;
				}
				if(weight+list.get(0)<=limit) {
					list.remove(0);
					size--;
				}
				answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] people = { 7, 5, 8
				};
		System.out.println(new Solution().solution(people, 10));
	}

}
