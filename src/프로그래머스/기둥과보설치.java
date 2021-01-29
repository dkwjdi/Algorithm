package 프로그래머스;

public class 기둥과보설치 {
	static class Solution {

		public int[][] solution(int n, int[][] build_frame) {
			int[][] answer = {};

			int[][] gidung = new int[n + 1][n + 1];
			int[][] bo = new int[n + 1][n + 1];

			for (int i = 0; i < build_frame.length; i++) {
				int x=build_frame[i][1];
				int y=build_frame[i][0];
				if (build_frame[i][2] == 0) { // 기둥
					if (build_frame[i][3] == 0) { // 삭제
						if(gidung[x-1][y]!=1 && bo[x+1][y]!=1 && bo[x+1][y-1]!=1) {
							gidung[x][y]=0;
						}
					} 
					else { // 설치
						if(x==0 || gidung[x-1][y]==1 || bo[x][y-1]==1 || bo[x][y]==1) {
							gidung[x][y]=1;
						}
					}
				} else { // 보
					if (build_frame[i][3] == 0) { // 삭제

					} 
					else { // 설치
						if(gidung[x-1][y]==1|| (bo[x][y-1]==1 && bo[x][y+1]==1) || gidung[x-1][y+1]==1) {
							bo[x][y]=1;
						}

					}
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		int[][] build_frame= {
				{1,0,0,1},
				{1,1,1,1},
				{2,1,0,1},
				{2,2,1,1},
				{5,0,0,1},
				{5,1,0,1},
				{4,2,1,1},
				{3,2,1,1}
				
//				{1,0,0,1},
//				{2,0,0,1},
//				{1,1,0,1}
				       
		};
		new Solution().solution(5, build_frame);
	}

}
