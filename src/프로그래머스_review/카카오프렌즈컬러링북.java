package 프로그래머스_review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	static class Solution {
	    public int[] solution(int m, int n, int[][] picture) {
	    	int dx[]= {0,0,-1,1};
	    	int dy[]= {-1,1,0,0};
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        
	        int pictures[][] = new int[picture.length][picture[0].length];
	        
	        for(int i=0; i<picture.length; i++) {
	        	for(int j=0; j<picture[0].length; j++) {
	        		pictures[i][j]=picture[i][j];
	        	}
	        }
	        
	        for(int i=0; i<picture.length; i++) {
	        	for(int j=0; j<picture[0].length; j++) {
	        		if(pictures[i][j]!=0) {
	        			numberOfArea++;
	        			maxSizeOfOneArea=Math.max(maxSizeOfOneArea, bfs(i,j,m,n,pictures,dx,dy));
	        		}
	        		
	        	}
	        }

	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }

		private int bfs(int i, int j, int m, int n, int[][] picture, int[] dx, int[] dy) {
			int num=picture[i][j]; // 숫자 받고 
			int cnt=1; //카운트 
			
			Queue <int []> queue = new LinkedList<>();
			queue.offer(new int[] {i,j}); //큐에 삽입
			picture[i][j]=0; //방문체크
			
			while(!queue.isEmpty()) {
				int point[]=queue.poll();
				
				for(int d=0; d<4; d++) {
					int nx=point[0]+dx[d];
					int ny=point[1]+dy[d];
					
					if(nx<0 || ny<0 || nx>=m || ny>=n || picture[nx][ny]==0 || picture[nx][ny]!=num) continue; 
					cnt++;
					queue.offer(new int[] {nx,ny});
					picture[nx][ny]=0;
				}
				
			}
			return cnt;
		}
	}
	public static void main(String[] args) {
		int [][]picture= {
//				{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
				{1,1},{1,4}
		};
		System.out.println(Arrays.toString(new Solution().solution(2, 2, picture)));
		
	}

}
