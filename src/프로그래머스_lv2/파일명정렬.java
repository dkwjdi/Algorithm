package 프로그래머스_lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
	static class Solution {
		class Info implements Comparable<Info>{
			String head;
			String number;
			String tail;
			public Info(String head, String number, String tail) {
				this.head = head;
				this.number = number;
				this.tail = tail;
			}
			@Override
			public int compareTo(Info o) {
				if(this.head.toUpperCase().compareTo(o.head.toUpperCase())==0) {
					return Integer.parseInt(this.number)-Integer.parseInt(o.number);
				}
				return this.head.toUpperCase().compareTo(o.head.toUpperCase());
			}
		}
	    public String[] solution(String[] files) {
	       
	        
	        List<Info> info=new ArrayList<>();
	        
	        for(int i=0; i<files.length; i++) {
	        	StringBuilder head= new StringBuilder();
	        	for(int j=0; j<files[i].length(); j++) {
	        		char ch=files[i].charAt(j);
	        		if(Character.isDigit(ch)) {//숫자라면
	        			String numberAndtail=makeNumberAndTail(files[i], j);
	        			String [] nAt=numberAndtail.split(",");
	        			if(nAt.length==1) info.add(new Info(head.toString(),nAt[0],""));
	        			else info.add(new Info(head.toString(),nAt[0],nAt[1]));
	        			break;
	        		}
	        		else head.append(ch); //숫자 아니라면
	        		
	        	}
	        }
	        Collections.sort(info);
	        String[] answer = new String[info.size()];
	        for(int i=0; i<info.size(); i++) {
	        	Info result=info.get(i);
	        	answer[i]=result.head+result.number+result.tail;
	        }
	        return answer;
	    }

		private String makeNumberAndTail(String str, int j) {
			StringBuilder sb= new StringBuilder();
			
			for(int i=j; i<str.length(); i++) {
				char c=str.charAt(i);
				if(Character.isDigit(c)) sb.append(c);
				else {
					if(i==str.length()-1) sb.append(","+"");
					else sb.append(","+str.substring(i));
					return sb.toString();
				}
			}
			sb.append(","+"");
			// TODO Auto-generated method stub
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		String[] files= {"img12", "im  g10.png", "img2  .png", "i  mg1.png"};
		System.out.println(new Solution().solution(files));
	}

}

