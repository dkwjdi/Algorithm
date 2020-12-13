package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 문자열압축 {
	static class Solution {
		public int solution(String s) {
			String output="";
			for (int i = 1; i <= s.length(); i++) { //몇 개씩 자를건지 
				String result=makeString(i,s);
				if(output.equals("")) output=result;
				if(result.length()<output.length()) output=result;
			}
			return output.length();
		}

		private String makeString(int i, String s) {
			List<String> list = new ArrayList<>();
			
			int start=0;
			while(true) {
				if(start+i>=s.length()) {
					list.add(s.substring(start,s.length()));
					break;
				}
				list.add(s.substring(start, start+i));
				start+=i;
			}
			
			String output="";
			String eqCheck=list.get(0);
			int cnt=1;
			for(int j=1; j<list.size(); j++) {
				if(list.get(j).equals(eqCheck)) cnt++; // 같다면 그냥 넘어감 카운트만 증가
				
				else {
					if(cnt!=1) output+=Integer.toString(cnt);
					output+=eqCheck;
					cnt=1;
					eqCheck=list.get(j);
				}
			}
			if(cnt!=1) output+=Integer.toString(cnt);
			output+=eqCheck;
			return output;
		}
	}

	public static void main(String[] args) {
		new Solution().solution("xababcdcdababcdcd");
	}

}
