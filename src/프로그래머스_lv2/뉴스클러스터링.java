package 프로그래머스_lv2;

import java.util.HashMap;

public class 뉴스클러스터링 {
	static class Solution {
	    public int solution(String str1, String str2) {
	        float answer = 0;
	        
	        //둘다 대문자로 변환 
	        str1=str1.toUpperCase();
	        str2=str2.toUpperCase();
	        
	        if(str1.contentEquals(str2)) return 65536;
	        
	        HashMap<String, Integer> hm1= new HashMap<>();
	        HashMap<String, Integer> hm2= new HashMap<>();
	        
	        slice(hm1, str1);
	        slice(hm2, str2);
	        
	        
	        float interSection=CalIntersection(hm1,hm2); //교집
	        float union=calUnion(hm1,hm2)-interSection; //합집
	        
	        answer=interSection/union;
	        
	        return (int)(answer*65536);
	    }


		private float calUnion(HashMap<String, Integer> hm1, HashMap<String, Integer> hm2) {
			int sum=0;
			for(String s: hm1.keySet()) {
				sum+=hm1.get(s);
			}
			for(String s: hm2.keySet()) {
				sum+=hm2.get(s);
			}
			return sum;
		}


		private int CalIntersection(HashMap<String, Integer> hm1, HashMap<String, Integer> hm2) {
			int sum=0;
			for(String str : hm1.keySet()) {
				if(hm2.containsKey(str)) { //만약 hm2에도 존재한다면 
					sum+=Math.min(hm1.get(str), hm2.get(str));
				}
			}
			return sum;
		}
		

		private void slice(HashMap<String, Integer> hm, String str) {
			for(int i=0; i<str.length()-1; i++) {
				char ch[]= {str.charAt(i), str.charAt(i+1)};
				if(isAlphabet(ch[0]) && isAlphabet(ch[1])) {
					String s=String.valueOf(ch);
					if(hm.containsKey(s)) hm.put(s, hm.get(s)+1); //이미 있으면 +1					
					else hm.put(s, 1); //없다면 1넣어서 삽입
				}
			}
			// TODO Auto-generated method stub
			
		}

		private boolean isAlphabet(char ch) {
			if(ch>=65 && ch<=90) return true;
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution("E=M*C^2", "e=m*c^2"));
	}

	
}
