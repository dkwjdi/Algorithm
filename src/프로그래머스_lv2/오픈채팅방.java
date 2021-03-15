package 프로그래머스_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
	static class Solution {
	    public String[] solution(String[] record) {
	        List<String> accessUseridList = new ArrayList<>(); //userid
	        List<String> accessList = new ArrayList<>(); // 들어왔습니다, 나갔습니다,
	        HashMap<String, String> nickName =new HashMap<>(); //userid 와 닉네임 매칭
	        
	        for(int i=0; i<record.length; i++) {
	        	String []access=record[i].split(" ");
	        	
	        	if(access[0].equals("Enter")) { //들어왔음
	        		accessUseridList.add(access[1]);
	        		accessList.add("님이 들어왔습니다.");
	        		nickName.put(access[1], access[2]); //userid와 nickname 매칭
	        	}
	        	else if(access[0].equals("Leave")) {
	        		accessUseridList.add(access[1]);
	        		accessList.add("님이 나갔습니다.");
	        	}
	        	else { //Change
	        		nickName.put(access[1], access[2]); //userid와 nickname 매칭
	        	}
	        }
	        int size=accessList.size();
	        String[] answer = new String[size]; 
	        for(int i=0; i<size; i++) {
	        	String result=nickName.get(accessUseridList.get(i))+accessList.get(i);
	        	answer[i]=result;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String [] record={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(new Solution().solution(record));
	}

}
