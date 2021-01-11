package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
	static class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        
	        Set<Integer> set = new HashSet<>();
	        int size=nums.length;
	        
	        for(int i=0; i<size; i++) {
	        	if(!set.contains(nums[i])) {
	        		set.add(nums[i]);
	        		if(++answer==size/2) break;
	        	}
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {3,3,3,2,2,4}));
	}

}
