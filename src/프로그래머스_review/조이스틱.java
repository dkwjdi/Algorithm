package 프로그래머스_review;

import java.util.Arrays;

public class 조이스틱 {
	static class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        int cnt=0;
	        int updownJoistc[]=new int[name.length()];
	        
	        for(int i=0; i<name.length(); i++) {
	        	char ch=name.charAt(i);
	        	if(ch!='A') cnt++;
	        	updownJoistc[i]=Math.min(ch-65, 91-ch);
	        }
	        
	        answer=Arrays.stream(updownJoistc).sum();
	        
	        if(updownJoistc[0]!=0) {
	        	cnt--;
	        	updownJoistc[0]=0;
	        }
	        
	        int idx=0;
	        while(true) {
	        	if(--cnt==0) break;
	        	updownJoistc[idx]=0;
	        	
	        	int left=search(updownJoistc,idx,-1);
	        	int right=search(updownJoistc,idx,1);
	        	
	        	if(left>=right) { //왼쪽이 더 크다면  오른쪽으로 갈거임 
	        		
	        	}
	        }
	        
	        return answer;
	    }

		private int search(int[] updownJoistc, int idx, int move) {
			int copyIdx=idx+=move;
			int cnt=1;
			while(true) {
				if(updownJoistc[copyIdx]!=0) return cnt;
				copyIdx+=move;
				if(copyIdx==idx) return -1;
				if(copyIdx==-1) copyIdx=updownJoistc.length-1;
				if(copyIdx==updownJoistc.length) copyIdx=0;
				cnt++;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution("JAZ"));
	}

}
