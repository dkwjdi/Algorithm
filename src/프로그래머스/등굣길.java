package 프로그래머스;

public class 등굣길 {
	static class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int answer=0;
	        int map[][]=new int[n][m];
	        
	        for(int i=0; i<puddles.length; i++) {
	        	map[puddles[i][1]-1][puddles[i][0]-1]=-1;
	        }
	        
	        for(int j=1; j<m; j++) {
	        	if(map[0][j-1]==-1) map[0][j]=-1;
	        }
	        for(int i=1; i<n; i++) {
	        	if(map[i-1][0]==-1) map[i][0]=-1;
	        }
	        
	        for(int i=0; i<n; i++) {
	        	for(int j=0; j<m; j++) {
	        		if(map[i][j]==-1) continue;
	        		else if(j==0 || i==0) map[i][j]=1;
	        		else if(map[i][j-1]==-1 || map[i-1][j]==-1)          
	        			map[i][j]=(map[i][j-1]+map[i-1][j]+1)%1000000007;
	        		else  
	        			map[i][j]=(map[i][j-1]+map[i-1][j])%1000000007;
	        	}
	        }
	        answer= map[n-1][m-1];
	        return answer==-1? 0:answer;
	    }
	}
	public static void main(String[] args) {
		int[][] puddles= {{1,2},{2,1}};
		System.out.println(new Solution().solution(4
				, 3, puddles));
	}

}
