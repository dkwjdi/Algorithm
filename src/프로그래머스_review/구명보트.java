package 프로그래머스_review;

import java.util.Arrays;

public class 구명보트 {
	static class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        int left=0;
	        int right=people.length-1;
	        Arrays.sort(people);
	        
	        while(left<=right) {
	        	
	        	if(people[right]+people[left]<=limit) { //가벼운사람 + 무거운사람 가능 
	        		right--;
	        		left++;
	        		answer++;
	        	}
	        	else { // 둘이 같이 못타면 무거운 사람만 태움
	        		right--;
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {70,50,80,50}, 100));
		System.out.println(new Solution().solution(new int[] {70,50,80,50}, 80));
		System.out.println(new Solution().solution(new int[] {70,80,50}, 100));
		
	}

}
