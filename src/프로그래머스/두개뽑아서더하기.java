package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 두개뽑아서더하기 {
	static class Solution {
	    public int[] solution(int[] numbers) {
	        Set <Integer> set = new HashSet<Integer>();
	        
	        for(int i=0; i<numbers.length-1; i++) {
	        	for(int j=i+1; j<numbers.length; j++) {
	        		set.add(numbers[i]+numbers[j]);
	        	}
	        }
	        
	        List<Integer> list = new ArrayList<>(set);
	        Collections.sort(list);
	        int [] answer = new int[list.size()];
	        int idx=0;
	        for(int num : list) {
	        	answer[idx++]=num;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int [] numbers= {2,1,3,4,1};
		new Solution().solution(numbers);
	}

}
