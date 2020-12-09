package 프로그래머스;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 방금그곡 {
	static class Solution {
		class Info implements Comparable<Info>{
			int index, time;
			String  title, melody;
			
			public Info(int index, int time, String title, String melody) {
				this.index = index;
				this.time = time;
				this.title = title;
				this.melody = melody;
			}
			@Override
			public int compareTo(Info o) {
				if(o.time==this.time) return this.index-o.index;
				return o.time-this.time;
			}
		}
	    public String solution(String m, String[] musicinfos) throws ParseException {
	        String answer = "(None)";
	        m=m.replace("C#", "c").replace("D#", "d").replace("F#","f").replace("G#","g").replace("A#", "a");
	        
	        List<Info> list= new ArrayList<>();
	        
	        
	        for(int i=0; i<musicinfos.length; i++) {
	        	String []info=musicinfos[i].split(",");
	        	info[3]=info[3].replace("C#", "c").replace("D#", "d").replace("F#","f").replace("G#","g").replace("A#", "a");
	        	SimpleDateFormat date = new SimpleDateFormat("HH:mm");
	        	int time= (int) (date.parse(info[1]).getTime()-date.parse(info[0]).getTime())/60000;
	        	String melody=getMelody(info[3],time);
	        	list.add(new Info(i,time , info[2],melody));
	        }
	        
	        Collections.sort(list);
	        for(int i=0; i<list.size(); i++) {
	        	Info music=list.get(i);
	        	String melody=music.melody;
	        	
	        	if(melody.contains(m)) {
	        		System.out.println(music.title);
	        		return music.title;
	        	}
	        }
	        return answer;
	    }
		private String getMelody(String melody, int time) {
			String data="";
			for(int i=0; i<time; i++) {
				data+=melody.charAt(i%melody.length());
			}
			return data;
		}
	}
	public static void main(String[] args) throws ParseException {
		String[] musicinfos= {
				"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"
		};
		new Solution().solution("ABC", musicinfos);
		
	}
}
