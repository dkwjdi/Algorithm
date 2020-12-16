package 프로그래머스;

import java.util.Stack;

public class 괄호변환 {
	static class Solution {
		
		public String solution(String p) {
			if (p.equals("")) return ""; // 빈 문자열이라면 빈 문자열 반환
			if (isCollect(p)) return p; //올바른 문자열이라면 바로 반환 

			return solve(p);
		}

		private boolean isCollect(String p) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < p.length(); i++) {
				char ch = p.charAt(i);
				if (ch == '(')stack.push(ch);
				else {
					if (stack.isEmpty()) return false;
					stack.pop();
				}
			}
			return true;
		}

		private String solve(String p) {
			if(p.equals("")) return "";
			int index=divided(p);
			String u = p.substring(0, index);
			String v=p.substring(index, p.length());
			
			if(isCollect(u)) return u+solve(v);
			else return "("+solve(v)+")"+removeAndReverse(u);
		}

		private String removeAndReverse(String u) {
			String tmp="";
			u=u.substring(1, u.length()-1);
			for(int i=0; i<u.length(); i++) {
				if(u.charAt(i)=='(') tmp+=")";
				else tmp+="(";
			}
			return tmp;
		}

		private int divided(String p) {
			int flag=0;
			int i=0;
			for (; i < p.length(); i++) {
				if(p.charAt(i)=='(') flag++;
				else flag--;
				if(flag==0) break;
			}
			return ++i;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution("()))((()"));
	}

}
