package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 압축 {
	static class Solution {
		public int[] solution(String msg) {

			List<Integer> answer = new ArrayList<>();
			HashMap<String, Integer> hm = new HashMap<String, Integer>();

			int num = 27;
			int idx = 0;
			while (true) {
				String dic = msg.substring(idx);
				String s = "" + dic.charAt(0);
				int i = 1;
				for (; i < dic.length(); i++) {
					s += dic.charAt(i);
					if (!hm.containsKey(s)) {
						break;
					}
				}
				if (hm.containsKey(s))
					answer.add(hm.get(s));
				else {
					if (s.length() == 1)
						answer.add(s.charAt(0) - 64);
					else {
						if (s.length() == 2) {
							answer.add(s.charAt(0) - 64);
						} else {
							answer.add(hm.get(s.substring(0, s.length() - 1)));
						}
						hm.put(s, num++);
					}
				}
				idx += i;

				if (idx >= msg.length())
					break;

			}

			int[] result = new int[answer.size()];

			for (int i = 0; i < answer.size(); i++) {
				result[i] = answer.get(i);
			}
			System.out.println(Arrays.toString(result));

			return result;
		}
	}

	public static void main(String[] args) {
		new Solution().solution("TOBEORNOTTOBEORTOBEORNOT");
	}
}
