package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {
	static class Solution {
		public int solution(int cacheSize, String[] cities) {
			
			if(cacheSize==0 ||  (cacheSize>=cities.length)) return 5*cities.length;

			List<String> list = new ArrayList<>();
			int answer =0;

			for (int i = 0; i < cities.length; i++) {
				answer += solve(list, cities[i].toUpperCase(),cacheSize);
			}
			System.out.println(answer);
			return answer;
		}

		private int solve(List<String> list, String city, int cacheSize) {
			if(list.size()==0) {
				list.add(city);
				return 5;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(city)) {
					list.remove(i);
					list.add(city);
					return 1;
				}
			}
			
			if(list.size()==cacheSize) 
				list.remove(0);
			
			list.add(city);
			return 5;
		}
	}

	public static void main(String[] args) {
		int cacheSize = 3
				;
		// Jeju, Pangyo, Seoul, NewYork, LA
		String[] cities = { "1", "2", "1", "3", "4" };
		new Solution().solution(cacheSize, cities);
	}

}
