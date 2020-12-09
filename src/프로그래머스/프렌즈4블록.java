package 프로그래머스;

import java.util.Stack;

public class 프렌즈4블록 {
	static class Solution {
		int cnt;
	    public int solution(int m, int n, String[] board) {
	    	
	    	boolean flag=true;
	    	char [][]map=new char[m][n];
	    	boolean [][]visited=new boolean[m][n];
	    	cnt=0;
	        
	        for(int i=0; i<m; i++) {
	        	map[i]=board[i].toCharArray();
	        }
	        while(flag) {
	        	flag=false;
	        	for(int i=0; i<m; i++) {
	        		for(int j=0; j<n; j++) {
	        			if(map[i][j]=='x' || map[i][j]=='\0') continue;
	        			if(mark(i,j,map,visited,m,n)) flag=true;
	        		}
	        	}
	        	down(map,visited,m,n);
	        	visited= new boolean[m][n];
	        }
	        return cnt;
	    }

		private void down(char[][] map, boolean[][] visited, int m, int n) {
			char [][]tmpmap=new char[m][n];
			
			Stack<Character> stack = new Stack<>();
			for(int j=0 ; j<n; j++) {
				for(int i=0; i<m; i++) {
					if(visited[i][j]) {
						cnt++;
						continue;
					}
					stack.push(map[i][j]);
				}
				int size=stack.size();
				for(int i=m-1; i>=m-size; i--) {
					tmpmap[i][j]=stack.pop();
				}
			}
			
			for(int i=0; i<m; i++) {
				System.arraycopy(tmpmap[i], 0, map[i], 0, n);
			}
		}

		private boolean mark(int x, int y, char[][] map, boolean[][] visited,int m, int n) {
			int []dx= {0,1,1};
			int []dy= {1,1,0};
			
			for(int i=0; i<3; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0 || ny<0 || nx>=m || ny>=n) return false;
				if(map[x][y]!=map[nx][ny]) return false;
				
			}
			visited[x][y]=true;
			
			for(int i=0; i<3; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				visited[nx][ny]=true;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		String[] board= {
				"CCBDE", "AAADE", "AAABF", "CCBBF"
				
		};
		new Solution().solution(4, 5, board);
	}
	
}
