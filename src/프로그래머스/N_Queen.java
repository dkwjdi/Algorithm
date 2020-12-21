package 프로그래머스;


public class N_Queen {
	static class Solution {
		int answer;
		int dx[]= {0,0,1,-1,-1,-1,1,1};
		int dy[]= {-1,1,0,0,-1,1,-1,1};
	    public int solution(int n) {
	    	answer=0;
	    	int [][]map = new int[n][n];
	    	solve(map,n,0);
	        return answer;
	    }
		private void solve(int[][] map, int n, int cnt) {
			if(cnt==n) {
				answer++;
				return;
			}
			
			for(int i=0; i<n; i++) {
				if(!isBound(map,cnt,i,n)) continue;
				map[cnt][i]=1;
				solve(map,n,cnt+1);
				map[cnt][i]=0;
			}
			
		}
		private boolean isBound(int[][] map, int x, int y, int n ) {
			for(int i=0; i<8; i++) {
				int nx=x;
				int ny=y;
				
				while(true) {
					nx+=dx[i];
					ny+=dy[i];
					if(nx<0 || ny<0 || nx>=n || ny>=n) break;
					if(map[nx][ny]==1) return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().solution(4));
	}

}
