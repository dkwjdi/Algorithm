package 프로그래머스;

import java.util.PriorityQueue;

public class 디스크컨트로러 {
	
	static class Solution {
		 class Info{
			int arrive, burst;
			public Info(int arrive, int burst) {
				this.arrive = arrive;
				this.burst = burst;
			}
		}
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        
	        PriorityQueue<Info> total = new PriorityQueue<>((o1,o2) -> (o1.arrive-o2.arrive));
	        PriorityQueue<Info> wait = new PriorityQueue<>((o1,o2) -> (o1.burst-o2.burst));
	        
	        for(int i=0; i<jobs.length; i++) {
	        	int arrive=jobs[i][0];
	        	int burst=jobs[i][1];
	        	total.add(new Info(arrive,burst));
	        }
	        int time=total.peek().arrive;
	        
	        while(true) {
	        	//현재 time 안에 들어와있는 작업들 모두 wait큐에 넣어주기
	        	while(!total.isEmpty()) {
	        		Info info=total.poll();
	        		if(info.arrive<=time) wait.add(info);
	        		else {
	        			total.add(info);
	        			break;
	        		}
	        	}
	        	
	        	if(wait.isEmpty() && total.isEmpty()) break;
	        	if(wait.isEmpty() && !total.isEmpty()) {
	        		Info curWork=total.poll();
	        		time=curWork.arrive+curWork.burst;
	        		answer+=curWork.burst;
	        		continue;
	        	}
	        	
	        	Info curWork=wait.poll();
	        	time+=curWork.burst;
	        	answer+=(time-curWork.arrive);
	        }
	        return answer/jobs.length;
	    }
	}
	public static void main(String[] args) {
		int[][] jobs= {
				{0,3},
				{15,5}
				
		};
		System.out.println(new Solution().solution(jobs));
	}

}
