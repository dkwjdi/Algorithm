package 프로그래머스;

import java.util.PriorityQueue;

public class 가장큰수 {
	static class Solution {
	    public String solution(int[] numbers) {
	        String answer = "";
	        PriorityQueue<String > pq = new PriorityQueue<>((o1,o2) -> ((o2+o1).compareTo(o1+o2)));
	        
	        int size=numbers.length;
	        int zeroCnt=0;
	        for(int i=0; i<numbers.length; i++) {
	        	pq.add(Integer.toString(numbers[i]));
	        	if(numbers[i]==0) zeroCnt++;
	        }
	        
	        if(zeroCnt==size) return "0";
	        
	        size=pq.size();
	        for(int i=0; i<size; i++ )
	        	answer+=pq.poll();
	        
	        return answer;
	    }
	}

	
	public static void main(String[] args) {
		int[] numbers= {0,0,0};
		System.out.println(new Solution().solution(numbers));
	}

}
