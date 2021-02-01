package 프로그래머스_review;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
	static class Solution{
		public int[] solution(int []progresses, int[] speeds) {
			int []days=new int[progresses.length];
			int a=0;
			
			for(int i=0; i<progresses.length; i++) {
				int day=1;
				while(true) { //몇 일 걸리는지
					if(progresses[i]+day*speeds[i]>=100) break;
					day++;
				}
				days[i]=day;
			}
			
			List<Integer> answerList = new ArrayList<>();
			int release=0;
			for(int i=0; i<days.length; i++) {
				release++;
				if(i==days.length-1) { //마지막
					if(days[i-1]>=days[i]) answerList.add(release);
					else answerList.add(1);
					break;
				}
				if(days[i]<days[i+1]) {
					answerList.add(release);
					release=0;
				}
			}
			
			
			int [] answer=new int[answerList.size()];
			for(int i=0; i<answerList.size(); i++) answer[i]=answerList.get(i);
			return answer;
		}
	}
	
	public static void main(String[] args) {
		int []progresses= {93, 30, 55};
		 int[] speeds= {1, 30, 5};
		System.out.println(new Solution().solution(progresses, speeds));
	}

}
