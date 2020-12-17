package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 짝지어제거하기 {
	static class Solution {
		public int solution(String s) {
			int answer = 0;

			List<Character> list = new ArrayList<>();
			int size = -1;

			for (int i = 0; i < s.length(); i++) {
				if (size == -1) {
					list.add(s.charAt(i));
					size++;
					continue;
				}
				if (s.charAt(i) == list.get(size)) {
					list.remove(size);
					size--;
					continue;
				} else {
					list.add(s.charAt(i));
					size++;
				}
			}
			answer = list.size() < 1 ? 1 : 0;
			return answer;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("cdcd"));

	}

}
