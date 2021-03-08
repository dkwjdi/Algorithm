package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	static class Solution {
	    public int solution(int[][] maps) {
	        int answer = 0;
	        
	        boolean flag=false;
	        int cnt=0;
	        int n=maps.length;
	        int m=maps[0].length;
	        int []dx= {-1,1,0,0};
	        int []dy= {0,0,-1,1};
	        
	        boolean visited[][]=new boolean[n][m];
	        Queue <int[]> queue= new LinkedList<>();
	        queue.offer(new int[] {0,0});
	        visited[0][0]=true;
	        
	    out:  while(!queue.isEmpty()) {
	        	answer++;
	        	int size=queue.size();
	        	
	        	for(int i=0; i<size; i++) {
	        		int []point = queue.poll();
	        		
	        		for(int d=0; d<4; d++) {
	        			int nx=point[0]+dx[d];
	        			int ny=point[1]+dy[d];
	        			
	        			if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || maps[nx][ny]==0) continue;
	        			if(nx==n-1 && ny==m-1) {
	        				flag=true;
	        				break out;
	        			}
	        			cnt++;
	        			visited[nx][ny]=true;
	        			queue.offer(new int[] {nx, ny});
	        		}
	        		
	        	}
	        }
	        
	        if(!flag) return -1;
	        return answer+1;
	    }
	}
	
	public static void main(String[] args) {
		int [][]maps= {
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
				
				
//				{1,0,1,1,1},
//				{1,0,1,0,1},
//				{1,0,1,1,1},
//				{1,1,1,0,0},
//				{0,0,0,0,1}
		};
		System.out.println(new Solution().solution(maps));
	}

}
