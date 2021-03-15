package 프로그래머스_lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프렌즈4블록 {
	static class Solution {
	    public int solution(int m, int n, String[] board) {
	        int answer = 0;
	        int dx[]= {0,1,1}; // 오른쪽, 오른쪽아래 대각선, 아래
	        int dy[]= {1,1,0};
	        
	        char boards[][]=new char[m][n];
	        for(int i=0; i<m; i++) {
	        	boards[i]=board[i].toCharArray();
	        }
	        
	        while(true) {
	        	List<int[]> removePoint= new ArrayList<>();
	        	remove(boards,dx,dy,removePoint,m,n);
	        	if(removePoint.size()==0) break;
	        	answer+=removeExe(boards,removePoint,dx,dy);
	        	down(boards,m,n);
	        }
	        
	        
	        return answer;
	    }

		private void down(char[][] boards,int m, int n) {
			for(int j=0; j<n; j++) {
				Queue <Character> queue =new LinkedList<>();
				for(int i=m-1; i>=0; i--) {
					if(boards[i][j]=='0') continue;
					queue.add(boards[i][j]);
				}
				
				for(int ii=m-1; ii>=0; ii--) {
					if(queue.isEmpty()) boards[ii][j]='0'; //비었으면
					else boards[ii][j]=queue.poll();
					
				}
				
			}
			
		}

		private int removeExe(char[][] boards, List<int[]> removePoint, int[] dx, int[] dy) {
			int sum=0;
			for(int i=0; i<removePoint.size(); i++) {
				int point[]=removePoint.get(i); //삭제할 좌표
				if(boards[point[0]][point[1]]!='0') {
					sum++;
					boards[point[0]][point[1]]='0';
				}
				for(int d=0; d<3; d++) {
					int nx=point[0]+dx[d];
					int ny=point[1]+dy[d];
					
					if(boards[nx][ny]!='0') {
						sum++;
						boards[nx][ny]='0';
					}
				}
				
			}
			return sum;
		}

		private void remove(char[][] boards, int[] dx, int[] dy, List<int[]> removePoint, int m, int n) {
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n-1; j++) {
					int cnt=0; //몇개 같은지
					char ch=boards[i][j];
					if(ch=='0') continue;
					for(int d=0; d<3; d++) {
						int nx=i+dx[d];
						int ny=j+dy[d];
						
						if(boards[nx][ny]==ch) cnt++;
						else break;
					}
					
					if(cnt==3) removePoint.add(new int[] {i,j});
					
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		String [] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(new Solution().solution(6, 6, board));
	}

}
