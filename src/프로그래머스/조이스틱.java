package 프로그래머스;

import java.util.Arrays;

public class 조이스틱 {
	static class Solution {
		int min;
	    public int solution(String name) {
	        int answer = 0;
	        min=Integer.MAX_VALUE;
	        int notZeroCnt=0;
	        int updown[] = new int[name.length()];
	        for(int i=0; i<name.length(); i++) {
	        	char ch = name.charAt(i);
	        	updown[i]=Math.min(ch-65, 90-ch+1); //조이스틱 위 아래 최소값 저장 
	        	if(updown[i]!=0) notZeroCnt++;
	        }
	        
	        answer=Arrays.stream(updown).sum();
	        
	        int idx=0;
	        while(notZeroCnt!=0) {
	        	int left=Serach(idx,updown,-1);
	        	int right=Serach(idx,updown,1);
	        	
	        	if(left>=right) {// 오른쪽 선택
	        		idx=(idx+right)%updown.length;
	        		updown[idx]=0;
	        		answer+=right;
	        	}
	        	else { // 왼쪽 선택
	        		idx=idx-left;
	        		if(idx<0) idx=idx+updown.length;
	        		updown[idx]=0;
	        		answer+=left;
	        	}
	        	
	        	--notZeroCnt;
	        }
	        System.out.println(answer);
	        return answer;
	    }
		private int Serach(int idx, int[] updown, int move) {
			int cnt=0;
			
			while(true) {
				if(updown[idx]!=0) return cnt;
				else {
					cnt++;
					idx+=move;
					if(idx==updown.length) idx=0;
					if(idx==-1) idx=updown.length-1;
				}
			}
		}

	}
	public static void main(String[] args) {
		new Solution().solution("BAAAAABBB");
		
	}

}
