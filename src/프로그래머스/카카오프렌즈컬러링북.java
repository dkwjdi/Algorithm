package 프로그래머스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	static class Solution {
		class Point{
			int x, y;
			long num;
			public Point(int x, int y, long num) {
				this.x = x;
				this.y = y;
				this.num = num;
			}
		}
		int dx[]= {0,0,-1,1};
		int dy[]= {1,-1,0,0};
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        
	        long[][] pictures= new long[m][n];
	        
	        for(int i=0; i<m; i++) {
	        	for(int j=0; j<n; j++) {
	        		pictures[i][j]=(long)picture[i][j];
	        	}
	        }
	        
	        
	        for(int i=0; i<m; i++) {
	        	for(int j=0; j<n; j++) {
	        		if(pictures[i][j]==0) continue;
	        		//bfs
	        		numberOfArea++;
	        		int cnt=1;
	        		Queue <Point> queue = new LinkedList<>();
	        		queue.offer(new Point(i,j,pictures[i][j]));
	        		pictures[i][j]=0;
	        		
	        		while(!queue.isEmpty()) {
	        			Point point=queue.poll();
	        			
	        			for(int d=0; d<4; d++) {
	        				int nx=point.x+dx[d];
	        				int ny=point.y+dy[d];
	        				
	        				if(nx<0 || ny<0 || nx>=m || ny>=n || pictures[nx][ny]==0) continue;
	        				if(pictures[nx][ny]!=point.num) continue;
	        				queue.offer(new Point(nx,ny,point.num));
	        				pictures[nx][ny]=0;
	        				cnt++;
	        				
	        			}
	        			
	        		}
	        		maxSizeOfOneArea=Math.max(maxSizeOfOneArea, cnt);	
	        		
	        	}
	        }

	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[][] picture= {
				
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 2, 2, 1}, 
				{0, 2, 2, 1}, 
				{0, 0, 0, 3}, 
				{4, 0, 0, 3}	
				
		};
		new Solution().solution(6, 4, picture);
	}

}
