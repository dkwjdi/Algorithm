package 프로그래머스;

public class 가장긴팰린드롬 {
	static class Solution {
		public int solution(String s) {
			int answer = 1;
			int len=s.length();
			int leftIndex=0, rightIndex=0;
			
			for(int i=1; i<len-1; i++) {
				leftIndex=rightIndex=i;
				while(true) {
					if(--leftIndex<0 || ++rightIndex>=len) break; //더 못가면 브레이크
					
					if(s.charAt(leftIndex)==s.charAt(rightIndex)) answer=Math.max(answer, (i-leftIndex)*2+1);
					else break;
				 }
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("aaaa"));

	}

	
}
