package 프로그래머스;

public class 예상대진표 {
	static class Solution {
		public int solution(int n, int a, int b) {
			int answer = 0;
			int people=n;
			int range=0; 
			int group=1; 
			
			while(true) {
				answer++;
				group=people/2; //총 몇 그룹 나오는지
				range=n/group; //1부터 몇번까지 1번그룹인지 
				
				if(((a-1)/range)==((b-1)/range)) break;
				
				people/=2; //사람수 절반 씩 줄어든다 
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(8, 4, 7));
	}

}
