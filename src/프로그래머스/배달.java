package 프로그래머스;

public class 배달 {
	static class Solution {
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        
	        int [][]map=new int[N+1][N+1];
	        
	        for(int i=0; i<road.length; i++) {
	        	int start=road[i][0];
	        	int end=road[i][1];
	        	int cost=road[i][2];
	        	
	        	if(map[start][end]==0) map[start][end]=cost;
	        	else map[start][end]=Math.min(map[start][end], cost);
	        	
	        	if(map[end][start]==0) map[end][start]=cost;
	        	else map[end][start]=Math.min(map[end][start], cost);
	        }
	        
	        for(int k=1; k<=N; k++) {
	        	for(int i=1; i<=N; i++) {
	        		for(int j=1; j<=N; j++) {
	        			if(map[i][k]==0 || map[k][j]==0 || i==j) continue;
	        			if(map[i][k]+map[k][j]<map[i][j]) map[i][j]=map[i][k]+map[k][j];
	        			if(map[i][j]==0) map[i][j]=map[i][k]+map[k][j];
	        		}
	        	}
	        }
	        
	        for(int i=1; i<=N; i++) {
	        	if(map[1][i]<=K) answer++;
	        }

	        return answer;
	    }
	    
	}
	public static void main(String[] args) {
		int[][] road = {
				
				{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
				
		};
		System.out.println(new Solution().solution(5, road, 3));
	}

}
