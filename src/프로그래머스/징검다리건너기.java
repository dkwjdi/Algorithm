package 프로그래머스;

public class 징검다리건너기 {
	static class Solution {
		public int solution(int[] stones, int k) {
			int answer = Integer.MAX_VALUE;
			int max=0;
			loop: for (int i = 0; i <= stones.length - k; i++) {
				max = 0;
				for (int j = 0; j < k; j++) {
					if(max<stones[i+j]) max=stones[i+j];
					if (max >= answer)
						continue loop;
				}
				if(max<answer) answer=max;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		System.out.println(new Solution().solution(stones, 3));

	}

}
