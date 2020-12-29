package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 큰수만들기 {
//	static class Solution {
//		class Info {
//			int index, num;
//			public Info(int index, int num) {
//				this.index = index;
//				this.num = num;
//			}
//		}
//
//		public String solution(String number, int k) {
//			String answer = "";
//			List<Info> list = new ArrayList<>();
//			String[] str = number.split("");
//			int size = str.length;
//
//			for (int i = 0; i < size; i++) {
//				list.add(new Info(i, Integer.parseInt(str[i])));
//			}
//
//			Collections.sort(list, (o1, o2) -> (o2.num - o1.num));
//			int index=0;
//			int listSize=list.size();
//			int idx=0;
//
//			loop: for (int len = size - k; len > 0; len--) {
//				for (int i = idx; i < listSize; i++) {
//					if (size - list.get(i).index >= len) {
//						if(index>list.get(i).index) continue;
//						idx=i;
//						index=list.get(i).index;
//						listSize--;
//						answer += Integer.toString(list.get(i).num);
//						list.remove(i);
//						continue loop;
//					}
//				}
//
//			}
//
//			return answer;
//		}
//	}
	
	static class Solution {
	    public String solution(String number, int k) {
	        String answer = "";
	        
	        int size=number.length();
	        
	        int idx=0;
	        for(int len=size-k; len>0 ; len--) {
	        	int num=0;
	        	for(int i=idx; i<=size-len; i++) {
	        		System.out.println(number.charAt(i)-'0');
	        		if(num<number.charAt(i)-'0') {
	        			num=number.charAt(i)-'0';
	        			idx=i+1;
	        		}
	        	}
	        	answer+=num;
	        }
	        return answer;
	    }
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("4177252841", 4
				
				));
	}

}
