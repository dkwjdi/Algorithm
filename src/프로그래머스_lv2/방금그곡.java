package 프로그래머스_lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 방금그곡 {
	static class Solution {
		class Music implements Comparable<Music>{
			String title;
			int time;
			String info;
			
			public Music(String title, int time, String info) {
				this.title = title;
				this.time = time;
				this.info = info;
			}

			@Override
			public int compareTo(Music o) {
				return o.time-this.time;
			}
			
			
		}
	    public String solution(String m, String[] musicinfos) {
	        String answer = "";
	        
	        List<Music> musicList = new ArrayList<>();
	        
	        m=m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
	        
	        for(int i=0; i<musicinfos.length; i++) { //시간많은순, 인덱스가 빠른순으로정렬하기 위해 list에 정리해서 삽입
	        	musicinfos[i]=musicinfos[i].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
	        	String musicInfo[]=musicinfos[i].split(",");
	        	String startTime[]=musicInfo[0].split(":");
	        	String endTime[]=musicInfo[1].split(":");
	        	int time=(Integer.parseInt(endTime[0])*60+Integer.parseInt(endTime[1]))
	        			-(Integer.parseInt(startTime[0])*60+Integer.parseInt(startTime[1]));
	        	musicList.add(new Music(musicInfo[2],time,musicInfo[3]));
	        }
	        
	        Collections.sort(musicList); //오랜시간 재생, 인덱스 빠른순으로 정렬
	        
	        for(int i=0; i<musicList.size(); i++) { //악보를 시간만큼 늘려주는 작업해서 contain으로 확인하기
	        	Music music=musicList.get(i);
	        	int time=music.time;
	        	String info=music.info;
	        	if(time<=info.length()) { //재생시간보다 악보길이가 더 길면 잘라야됨 
	        		music.info=info.substring(0,time);
	        	}
	        	else { //재생시간이 악보길이보다 더 길면 늘려줘야함 
	        		int quotient=time/info.length();
	        		int remainder=time%info.length();
	        		for(int j=0; j<quotient; j++) {
	        			music.info+=info;
	        		}
	        		music.info+=info.substring(0,remainder);
	        	}
	        	
	        	if(music.info.contains(m)) {
	        		answer=music.title;
	        		break;
	        	}
	        	
	        }
	        if(answer.equals("")) answer="None";
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String m="CC#BCC#BCC#BCC#B";
		String[] musicinfos= {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(new Solution().solution(m, musicinfos));
		
	}

}
