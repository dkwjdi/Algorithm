package 프로그래머스;


public class 이진변환반복하기 {
	static class Solution {
	    public int[] solution(String s) {
	        int len=0, cnt=0, remove=0;
	        
	        while(true) {
	        	if(s.length()==1) break;
	        	cnt++;
	        	len=s.length();
	        	s=s.replace("0", ""); // 0다지우기
	        	remove+=len-s.length(); // x의 모든 0을 제거할때 0제거한 갯수
	        	s=Integer.toBinaryString(s.length());
	        }
	        
	        int[] answer = {cnt, remove};
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("01110"));
	}

}
