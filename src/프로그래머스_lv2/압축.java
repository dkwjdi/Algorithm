package 프로그래머스_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 압축 {
	static class Solution {
	    public int[] solution(String msg) {
	        char alphabet='A';
	        List<Integer> result=new ArrayList<>();
	        HashMap<String, Integer> dic = new HashMap<>();
	        for( int i=0; i<26; i++) {
	        	dic.put(String.valueOf(alphabet), i+1);
	        	alphabet++;
	        }
	        int num=27;
	        StringBuilder sb= new StringBuilder();
	        for(int i=0; i<msg.length(); i++) {
	        	sb.append(msg.charAt(i));
	        	if(!dic.containsKey(sb.toString())) { //없다면 ?
	        		dic.put(sb.toString(), num++);//사전에 삽입
	        		result.add(dic.get(sb.toString().substring(0, sb.length()-1)));
	        		sb=new StringBuilder();
	        		i--;
	        	}
	        	
	        }
	        result.add(dic.get(sb.toString()));
	        int[] answer = new int[result.size()];
	        for(int i=0; i<result.size(); i++) {
	        	answer[i]=result.get(i);
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution("KAKAO")));
		System.out.println(Arrays.toString(new Solution().solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(new Solution().solution("ABABABABABABABAB")));
	}
}
