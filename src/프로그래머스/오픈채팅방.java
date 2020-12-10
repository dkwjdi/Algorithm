package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
	static class Solution {
		class Info{
			String userid,act;
			public Info(String userid, String act) {
				this.userid = userid;
				this.act = act;
			}
		}
	    public String[] solution(String[] record) {
	        HashMap <String, String> hm= new HashMap<>();
	        List<Info> list = new ArrayList<>();
	        
	        
	        for(int i=0; i<record.length; i++) {
	        	String data[]=record[i].split(" ");
	        	if(data[0].equals("Enter")) {
	        		hm.put(data[1], data[2]);
	        		list.add(new Info(data[1],data[0]));
	        	}
	        	else if(data[0].equals("Leave")) list.add(new Info(data[1],data[0]));
	        	else hm.put(data[1], data[2]);
	        }
	        
	        String[] answer = new String[list.size()];
	        
	        int idx=0;
	        for(Info info:list) {
	        	if(info.act.equals("Enter")) answer[idx++]=hm.get(info.userid)+"님이 들어왔습니다.";
	        	else answer[idx++]=hm.get(info.userid)+"님이 나갔습니다.";
	        }
	        System.out.println(Arrays.toString(answer));
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] record= {
				"Enter uid0606 Gimoi", "Enter uid4567 Prodo", "Leave uid0606", "Enter uid1234 Prodo", "Change uid1234 OhYeah"
				
		};
		new Solution().solution(record);
	}

}
