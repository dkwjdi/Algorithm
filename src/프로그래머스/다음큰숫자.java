package 프로그래머스;

public class 다음큰숫자 {
	static class Solution {
	    public int solution(int n) {
	        int num=n;
	        int oneCnt=0;
	        String binary=Integer.toBinaryString(num);
	        for(int i=0; i<binary.length(); i++) {
	        	char ch=binary.charAt(i);
	        	if(ch=='1') oneCnt++;
	        }
	        
	        while(true) {
	             binary=Integer.toBinaryString(++num);
	             int cnt=0;
	             for(int i=0; i<binary.length(); i++) {
	 	        	char ch=binary.charAt(i);
	 	        	if(ch=='1') cnt++;
	 	        }
	        	if(cnt==oneCnt) break;
	        	
	        }
	        
	        return num;
	        
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(15));
	}

}
