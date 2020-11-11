package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 베스트앨범 {
	static class Song implements Comparable<Song> {
		int index;
		int play;

		public Song(int index, int play) {
			this.index = index;
			this.play = play;
		}

		@Override
		public int compareTo(Song o) {
			if (this.play == o.play) {
				return this.index - o.index;
			}
			return this.play - o.play;

		}
	}

	static class Solution {
		public int[] solution(String[] genres, int[] plays) {
			HashMap<String, Integer> genreMap = new HashMap<>();
			List<Song> list = new ArrayList<>();

			for (int i = 0; i < genres.length; i++) {
				int index = i;
				int play = plays[i];
				String genre = genres[i];

				list.add(new Song(index, play));

				if (genreMap.containsKey(genre))
					genreMap.put(genre, genreMap.get(genre) + play);
				else
					genreMap.put(genre, play);
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (Integer totalPlay : genreMap.values()) {
				pq.add(totalPlay);
			}

			HashMap<Integer, String> genreMapReverse = new HashMap<Integer, String>();
			for (String key : genreMap.keySet()) {
				genreMapReverse.put(genreMap.get(key), key);
			}

			int size = pq.size();
			String gerneArray[] = new String[size];
			for (int i = 0; i < size; i++) {
				gerneArray[i] = genreMapReverse.get(pq.poll());
			}
			
			 HashMap<String, PriorityQueue<Song>> songsRank = new HashMap<String, PriorityQueue<Song>>();
		        for (int i = 0; i < plays.length; i++) {
		            if (songsRank.containsKey(genres[i])) {
		                songsRank.get(genres[i]).add(new Song(i, plays[i]));
		            } else {
		                songsRank.put(genres[i], new PriorityQueue<Song>());
		                songsRank.get(genres[i]).add(new Song(i, plays[i]));
		            }
		        }
		        
		        ArrayList<Integer> answerArrList = new ArrayList<Integer>();
		        for (int i = 0; i < gerneArray.length; i++) {
		            answerArrList.add(songsRank.get(gerneArray[i]).poll().index);
		            if (songsRank.get(gerneArray[i]).peek() != null) {
		                answerArrList.add(songsRank.get(gerneArray[i]).poll().index);
		            }
		        }

		        int[] answerArr = new int[answerArrList.size()];
		        Object[] answerArrObj = answerArrList.toArray();
		        for (int i = 0; i < answerArrObj.length; i++) {
		            answerArr[i] = (int) answerArrObj[i];
		        }
		        
		        return answerArr;
		}
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		System.out.println(new Solution().solution(genres, plays));
	}

}
