package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
	static class Solution {
		int answer;
	    public int solution(int n, int[][] edge) {
	    	answer=0;
	        List<Integer> list[]=new List[n+1];
	        for(int i=0; i<=n; i++) list[i]=new ArrayList<>();
	        
	        for(int i=0; i<edge.length; i++) {
	        		list[edge[i][0]].add(edge[i][1]);
	        		list[edge[i][1]].add(edge[i][0]);
	        }
	        
	        boolean [] visited= new boolean[n+1];
	        bfs(list,visited);
	        return answer;
	    }

		private void bfs(List<Integer>[] list, boolean[] visited) {
			Queue<Integer> queue=new LinkedList<Integer>();
			visited[1]=true;
			queue.offer(1);
			
			while(true) {
				int size=queue.size();
				if(size==0) return;
				answer=0;
				for(int i=0; i<size; i++) {
					int vertex=queue.poll();
					answer++;
					
					for(int j=0; j<list[vertex].size(); j++) {
						int end=list[vertex].get(j);
						if(!visited[end]) {
							queue.offer(end);
							visited[end]=true;
						}
					}
				}
				
			}
			
		}
	}
	public static void main(String[] args) {
		int[][] edge = { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(new Solution().solution(6, edge));
	}

}
