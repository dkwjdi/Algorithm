package 프로그래머스;

public class 가장큰정사각형찾기 {
	static class Solution {
		public int solution(int[][] board) {
			int answer = 0;
			int W=board[0].length;
			int H=board.length;
			int oneCnt=0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(i<1 || j<1) {
						if(board[i][j]==1) oneCnt++;
						continue;
					}
					
					if(board[i][j]==1) board[i][j]=Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
					answer=Math.max(answer, board[i][j]);
				}
			}
			if(oneCnt>=1 && answer==0) answer=1;
			return answer*answer;
		}
	}

	public static void main(String[] args) {
		int[][] board = { 
//				{ 0, 1, 1, 1 }, 
//				{ 1, 1, 1, 1 }, 
//				{ 1, 1, 1, 1 }, 
//				{ 0, 0, 1, 0 }
				
				{ 1, 0 }, 
				{ 0,  0 } 
				

		};

		System.out.println(new Solution().solution(board));
	}
}
