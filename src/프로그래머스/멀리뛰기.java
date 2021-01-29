package 프로그래머스;

public class 멀리뛰기 {
	static class Solution {
		public long solution(int n) {
			long answer = 1;
			
			int a=1, b=1;
			
			for(int i=1; i<n; i++) {
				answer=(a+b)%1234567;
				
				a=b;
				b=(int) answer;
			}

			return answer % 1234567;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(1));
	}
}
