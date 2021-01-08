package 프로그래머스;

import java.text.ParseException;
import java.util.PriorityQueue;


public class 셔틀버스 {
	static class Solution {
		class Time implements Comparable<Time>{
			int hour,minute;
			public Time(int time) {
				this.hour = time/60;
				this.minute = time-(this.hour*60);
			}
			@Override
			public int compareTo(Time o) {
				if(this.hour==o.hour) return this.minute-o.minute;
				return this.hour-o.hour;
			}
			
		}
	    public String solution(int n, int t, int m, String[] timetable) throws ParseException {
	        Time answerTime=null;
	        
	        PriorityQueue<Time> timeList = new PriorityQueue<>();
	        
	        for(int i=0; i<timetable.length; i++) {
	        	String []time=timetable[i].split(":");
	        	if(540+(n*t)<Integer.parseInt(time[0])*60+Integer.parseInt(time[1])) continue;
	        	timeList.add(new Time(Integer.parseInt(time[0])*60+Integer.parseInt(time[1])));
	        }
	        
	        Time arriveTime=new Time(540);
	   loop:for(int i=0; i<n; i++) { //버스 몇 대 
	        	
	        	for(int j=0; j<m; j++) { // 사람 몇명 
	        		if(timeList.isEmpty()) {
	        			answerTime = new Time(arriveTime.hour*60+arriveTime.minute);
	        		}
	        		
	        		if(!timeList.isEmpty() &&i==n-1 && j==m-1) {
        				Time last=timeList.poll();
        				answerTime = new Time(last.hour*60+last.minute-1);
        				break loop;
        			}
	        		
	        		if(!timeList.isEmpty() &&isRide(timeList.peek(), arriveTime)) {
	        			
	        			timeList.poll();
	        			
	        		}
	        	}
	        	
	        	arriveTime=new Time(t+(arriveTime.hour*60)+arriveTime.minute);
	        	
	        }
	        StringBuilder sb= new StringBuilder();
	        if(answerTime.hour<10) sb.append("0"+answerTime.hour+":");
	        else sb.append(answerTime.hour+":");
	        if(answerTime.minute<10) sb.append("0"+answerTime.minute);
	        else sb.append(answerTime.minute);
	        
	        return sb.toString();
	    }
		private boolean isRide(Time peek, Time arriveTime) {
			if(peek.hour<arriveTime.hour ) return true;
			else if(peek.hour==arriveTime.hour) {
				if(peek.minute<=arriveTime.minute) return true;
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) throws ParseException {
//		String[] timetable= {"08:00", "08:01", "08:02", "08:03"};
//		String[] timetable= {"09:10", "09:09", "08:00"};
		String[] timetable= {"23:59"};
		System.out.println(new Solution().solution(1, 1, 1, timetable));
	}
}
