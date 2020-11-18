package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
	

public class 여행경로 {
	static class Solution {
		static class Airport implements Comparable<Airport> {
			String start;
			String end;
			public Airport(String start, String end) {
				this.start = start;
				this.end = end;
			}
			@Override
			public int compareTo(Airport o) {
				if(this.start.equals(o.start)) {
					return (this.end.compareTo(o.end));
				}
				return (this.start.compareTo(o.start));
			}
		}

		static List<Airport> airport = new ArrayList<>();
		static String []answer;
		static boolean []visit;
		static boolean endCheck;

		public String[] solution(String[][] tickets) {
			int len=tickets.length;
			
			for (int i = 0; i < len; i++) {
				airport.add(new Airport(tickets[i][0], tickets[i][1]));
			}
			answer = new String[len+1];
			answer[0]="ICN";
			
			Collections.sort(airport); // 정렬
			visit = new boolean[len];
			
			for (int i = 0; i < len; i++) {
				if(airport.get(i).start.equals("ICN")) {
					visit[i]=true;
					dfs(1,len,airport.get(i).end, i);
					visit[i]=false;
				}
			}
			return answer;
		}

		private void dfs(int cnt, int len, String end, int idx) {
			if(endCheck) return ;
			
			if(cnt==len) {// 마지막까지 다 돌았으면 
				answer[cnt]=end;
				endCheck=true;
			}
			
			visit[idx]=true; //들어온곳 체크
			
 			for(int i=0; i<len; i++) {
                  				if(!endCheck && !visit[i] && airport.get(i).start.equals(end)) {
					answer[cnt]=airport.get(i).start;
					dfs(cnt+1,len,airport.get(i).end,i);
					visit[i]=false;
				}
			}
		}
	}

	public static void main(String[] args) {
		String[][] tickets = {
				
				{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}
//				 { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" } };
//				{ "ICN", "A" }, { "A", "B" }, { "B", "A" },
//				{ "A", "ICN" }, { "ICN", "A" }
				};

		new Solution().solution(tickets);
	}

}
