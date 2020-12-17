package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
	static class Solution {
		public int[] solution(int n, String[] words) {
			int[] answer = new int[2];

			Set<String> set = new HashSet<>();
			char pre=words[0].charAt(0);
			int no=-1;
			int cnt=1;

	  loop: for (int i = 0; i < words.length;) {
				for (int j = 0; j < n; j++) {
					String cur=words[i];
					
					if (set.contains(cur) || cur.charAt(0)!=pre) { // 틀림
						no=j+1;
						break loop;
					}
					set.add(cur);
					pre=cur.charAt(cur.length()-1);
					i++;
				}
				cnt++;
			}
			
			answer[0]= no<0? 0 : no;
			answer[1]= no<0? 0 : cnt;
			return answer;
		}
	}

	public static void main(String[] args) {
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(new Solution().solution(2, words));
	}

}
