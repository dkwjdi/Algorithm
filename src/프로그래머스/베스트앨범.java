package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 베스트앨범 {
	static class Solution {
		class Info implements Comparable<Info>{
			int index, play;
			public Info(int index, int play) {
				this.index = index;
				this.play = play;
			}
			@Override
			public int compareTo(Info o) {
				if(o.play==this.play) return this.index-o.index;
				return o.play-this.play;
			}
		}
		class Music implements Comparable<Music>{
			String genre;
			int totalPlay;
			public Music(String genre, int totalPlay) {
				this.genre = genre;
				this.totalPlay = totalPlay;
			}
			@Override
			public int compareTo(Music o) {
				return o.totalPlay-this.totalPlay;
			}
		}
	    public int[] solution(String[] genres, int[] plays) {
	        
	        List<Integer> answerList= new ArrayList<>();
	        Map<String, Integer> bestGenre = new TreeMap<>();
	        HashMap<String, List<Info>> playOfGenre = new HashMap<>();
	        
	        for(int i=0; i<genres.length; i++) {
	        	
	        	if(bestGenre.containsKey(genres[i])) bestGenre.put(genres[i], bestGenre.get(genres[i])+plays[i]);
	        	else bestGenre.put(genres[i], plays[i]);
	        	
	        	if(!playOfGenre.containsKey(genres[i])) playOfGenre.put(genres[i], new ArrayList<>());
	        	playOfGenre.get(genres[i]).add(new Info(i,plays[i]));
	        	
	        }
	        
	        List<String> totalPlayList = new ArrayList<>(bestGenre.keySet());
	        //for(String music : bestGenre.keySet()) {
	        	
	        	//totalPlayList.add(new Music(music, bestGenre.get(music)));
	      //  }
	      //  Collections.sort(totalPlayList);
	        Collections.sort(totalPlayList, (o1, o2) -> (bestGenre.get(o2).compareTo(bestGenre.get(o1))));
	        
	        for(int i=0; i<totalPlayList.size(); i++) {
	        	String genre=totalPlayList.get(i);
	        	
	        	Collections.sort(playOfGenre.get(genre));
	        	
	        	if(playOfGenre.get(genre).size()==1) answerList.add(playOfGenre.get(genre).get(0).index);
	        	else {
	        		for(int j=0; j<2; j++) {
	        			answerList.add(playOfGenre.get(genre).get(j).index);
	        		}
	        	}
	        	
	        }
	        int[] answer= new int[answerList.size()];
	        int idx=0;
	       
	        for(int index : answerList) {
	        	answer[idx++]=index;
	        }
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] genres= {"classic", "pop", "classic", "classic", "pop"};
		int[] plays= {500,600,150,800,2500};
		new Solution().solution(genres, plays);
	}


}
