package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
	static class Solution {
		class Info implements Comparable<Info>{
			int index;
			String realhead,  head, number ,tail;
			public Info(int index, String realhead, String head, String number, String tail) {
				this.index = index;
				this.realhead = realhead;
				this.head = head;
				this.number = number;
				this.tail = tail;
			}
			@Override
			public int compareTo(Info o) {
				if(this.head.equals(o.head)) {
					return Integer.parseInt(this.number)-Integer.parseInt(o.number);
				}
				return this.head.compareTo(o.head);
				//return 0;
			}
			
		}
		List<Info> list = new ArrayList<>();
	    public String[] solution(String[] files) {
	      
	        
	         for(int i=0; i<files.length; i++) {
	        	String head="";
	        	String number="";
	        	String tail="";
	        	String file=files[i];
	        	
	        	int j=0;
	        	for(; j<file.length(); j++) {
	        		char ch=file.charAt(j);
	        		if(Character.isDigit(ch)) break;
	        		head=head.concat(Character.toString(ch));
	        	}
	        	
	        	int cnt=0;
	        	for(; j<file.length(); j++) {
	        		char ch=file.charAt(j);
	        		if(!Character.isDigit(ch)) break;
	        		if(cnt>5) {
	        			j--;
	        			break;
	        		}
	        		number=number.concat(Character.toString(ch));
	        		cnt++;
	        	}
	        	
	        	for(; j<file.length(); j++) {
	        		char ch=file.charAt(j);
	        		tail=tail.concat(Character.toString(ch));
	        	}
	        	
	        	list.add(new Info(i,head,head.toLowerCase(),number,tail));
	        }
	         
	        Collections.sort(list);
	        String[] answer = new String[list.size()];
	        
	        for(int i=0; i<list.size(); i++) {
	        	Info info=list.get(i);
	        	String input=info.realhead+info.number+info.tail;
	        	answer[i]=input;
	        	
	        }
	        
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		
		System.out.println("Ddd");
		String[] files= {
				"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
				
		};
		new Solution().solution(files);
	}

}
