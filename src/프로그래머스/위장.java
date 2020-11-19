package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 위장 {
	static class Solution {
		static HashMap<String, List<String>> hm;
		static List<String> list[];
		static int answer=1, array[];
	    public int solution(String[][] clothes) {
	    	 hm = new HashMap<>();
	    	
	    	for(int i=0; i<clothes.length; i++) {
	    		String name=clothes[i][0];
	    		String type=clothes[i][1];
	    		
	    		if(hm.containsKey(type)) { //만약에 이미 들어있는 종류라면
	    			hm.get(type).add(name);
	    		}
	    		else {
	    			hm.put(type, new ArrayList<>());
	    			hm.get(type).add(name);
	    		}
	    	}
	    	
	    	int typeSize=hm.size();
	    	
	    	list = new ArrayList[typeSize];
	    	array=new int[typeSize];
	    	
	    	for(int i=0; i<typeSize; i++) {
	    		list[i]=new ArrayList<>();
	    	}
	    	
	    	int idx=0;
	    	for(String type : hm.keySet()) {
	    		int len=hm.get(type).size();
	    		
	    		for(int i=0; i<len; i++) {
	    			list[idx].add(hm.get(type).get(i));
	    		}
	    		idx++;
	    	}
	    	
	    	for(int i=0; i<typeSize; i++) {
	    		answer*=list[i].size()+1;
	    	}
	    	
	    	answer-=1;
	        
	        System.out.println(answer);
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String[][] clothes= {
				{ "1","a" },
				{ "2","a" },
				{ "3","a" },
				{ "4","b" },
				{ "5","b" },
				{ "6","c" },
			//	{ "","" },
				//{ "","" },
				
				
		};
		new Solution().solution(clothes);
		
	}

}
