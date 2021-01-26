package 프로그래머스;

public class N진수게임 {
	static class Solution {
	    public String solution(int n, int t, int m, int p) {
	    	// n:진법 , t:미리구할 숫자의 갯수, m:게임에 참가하는 인원, p : 튜브의 순서 
	    	StringBuilder answer = new StringBuilder();
	    	String []ABCDEF= {"A","B","C","D","E","F"};
	    	int num=0;
	    	int turn=1;
	    	
	    	while(true) {
	    		String s=changeJinsu(n,num,ABCDEF);
	    		for(int i=0; i<s.length(); i++){
	    			if(turn==p) {
	    				answer.append(s.charAt(i));
	    				if(--t==0) return answer.toString();
	    			}
	    			if(++turn>m) turn=1;
	    		}
	    		num++;
	    	}
	    }

		private String changeJinsu(int jinsu, int num, String[] ABCDEF) {
			StringBuilder result = new StringBuilder();
			int quotient=num, remainder=0;
			while(quotient>=jinsu) {
				remainder=quotient%jinsu; //나머지 구하기
				if(remainder>=10) result.append(ABCDEF[remainder-10]); //숫자 10이상이면 바꿔서 넣기
				else result.append(remainder);
				quotient/=jinsu; //몫 바꿔주기 
			}
			if(quotient>=10) result.append(ABCDEF[quotient-10]); //숫자 10이상이면 바꿔서 넣기
			else result.append(quotient);
			return result.reverse().toString();
		}
	}
	public static void main(String[] args) {
		//System.out.println(new Solution().solution(2, 4, 2, 1));
		System.out.println(new Solution().solution(16, 16, 2, 1));
		System.out.println(new Solution().solution(16, 16, 2, 2));
	}

}
