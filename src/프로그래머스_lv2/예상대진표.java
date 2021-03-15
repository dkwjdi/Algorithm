package 프로그래머스_lv2;

public class 예상대진표 {
	static class Solution {
		public int solution(int n, int a, int b) {
			int answer = 0;
			
			while(true) {
				answer++;
				if(check(a,b)) return answer;
				a=(a+1)/2;
				b=(b+1)/2;
			}
		}

		private boolean check(int a, int b) {
			if(a%2==0) { //a가 짝수이면 b는 a-1이어야 함
				if(b==a-1) return true;
			}
			else { //a가 홀수이면 b는 a+1
				if(b==a+1) return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(8, 4, 7));
	}
}
