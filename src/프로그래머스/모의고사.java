package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
	static class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = new int[4];
	        
	        int [] one = {1,2,3,4,5};
	        int [] two = {1,3,4,5};
	        int [] three= {3,1,2,4,5};
	        
	        int oneIdx=0;
	        int twoIdx=0;
	        int threeIdx=0;
	        
	        for(int i=1; i<=answers.length; i++) {
	        	int num=answers[i-1];
	        	//1번
	        	if(one[oneIdx++]==num) answer[1]++;
	        	
	        	if(i%2==0) { //i가 짝수일 때 2 3번
	        		if(two[twoIdx++]==num) answer[2]++;
	        		if(three[threeIdx++]==num) answer[3]++;
	        	}
	        	else { //i가 홀수일 때 2 3번
	        		if(num==2) answer[2]++;
	        		if(three[threeIdx]==num) answer[3]++;
	        	}
	        	
	        	
	        	if(oneIdx==5) oneIdx=0;
	        	if(twoIdx==4) twoIdx=0;
	        	if(threeIdx==5) threeIdx=0;
	        	
	        }
	        
	        List<Integer> list = new ArrayList<>();
	        int max=Arrays.stream(answer).max().getAsInt();
	        
	        for(int i=1; i<=3; i++) {
	        	if(answer[i]==max) list.add(i);
	        }
	        
	        int result[]=new int[list.size()];
	        int idx=0;
	        
	        for(int num : list) result[idx++]=num;
	        return result;
	    }
	}
	
	
	public static void main(String[] args) {
		int[] answers= {1,3,2,4,2};
		System.out.println(Arrays.toString(new Solution().solution(answers)));
	}

}
