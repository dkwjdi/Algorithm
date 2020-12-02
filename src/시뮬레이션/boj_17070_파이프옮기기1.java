package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070_파이프옮기기1 {
	static int N, map[][], result;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(1, 2, 0);
		System.out.println(result);
	}

	private static void solve(int x, int y, int dir) { // 0 가로 1:대각선 2:아래
		if(x==N && y==N) {
			result++;
			return;
		}
		
		if(dir==0) { //가로 대각선 가능
			for(int i=0; i<2; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(!isbound(nx,ny,i)) continue;
				solve(nx,ny,i);
			}
		}
		else if(dir==1) {
			for(int i=0; i<3; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(!isbound(nx,ny,i)) continue;
				solve(nx,ny,i);
			}
		}
		else {
			for(int i=1; i<3; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(!isbound(nx,ny,i)) continue;
				solve(nx,ny,i);
			}
		}

	}


	private static boolean isbound(int nx, int ny, int dir) {
		if(nx<1 || ny<1 || nx>N || ny>N || map[nx][ny]==1) return false;
		if(dir==1) {  //대각선일 때 체크 
			if(map[nx][ny-1]==1 || map[nx-1][ny]==1) return false;
		}
		return true;
	}

}
