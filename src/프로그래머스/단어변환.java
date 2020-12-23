package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	static class Solution {
	    public int solution(String begin, String target, String[] words) {
	        int answer = 0;
	        
	        
	        return  bfs(begin, target, words);
	        
	    }

		private int bfs(String begin, String target, String[] words) {
			boolean visited[] = new boolean[words.length];
			int cnt=-1;
			Queue<String> queue= new LinkedList<>();
			queue.offer(begin);
			
			while(true) {
				int size=queue.size();
				if(size==0) return 0;
				cnt++;
				for(int i=0; i<size; i++) {
					String str=queue.poll();
					if(str.equals(target)) return cnt; //target 과 같아진다면 끝 
					
					for(int j=0; j<words.length; j++) {
						if(visited[j]) continue;
						if(check(words[j],str)) {
							queue.offer(words[j]);
							visited[j]=true;
						}
					}
					
				}
			}
		}

		private boolean check(String word, String str) {
			int len=str.length();
			int cnt=0;
			
			for(int i=0; i<len; i++) {
				if(word.charAt(i)==str.charAt(i)) cnt++;
			}
			
			if(cnt==len-1) return true;
			return false;
		}
	}
	
	public static void main(String[] args) {
//		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words= {"hhh", "hhy"};
		System.out.println(new Solution().solution("hit", "hhh", words));
		
	}

}
