package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683_감시 {
	static class Cctv {
		int x, y, no;
		public Cctv(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}
	static List<Cctv> cctvList = new ArrayList<>();
	static int N, M, result;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int dir[][] = { 
			{}, 
			{ 0 }, 
			{ 0, 2 }, 
			{ 0, 1 }, 
			{ 0, 1, 2 }, 
			{ 0, 1, 2, 3 }, 
			};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		result=Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					cctvList.add(new Cctv(i, j, map[i][j]));
			}
		}
		solve(0, cctvList.size(), map);
		System.out.println(result);
	}

	private static void solve(int cnt, int size, int[][] map) {
		if (cnt == size) {
			int zeroCnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) zeroCnt++; 
				}
			}
			result = Math.min(result, zeroCnt);
			return;
		}
		for (int d = 0; d < 4; d++) {

			int[][] copy = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, M);
			}

			Cctv cctv = cctvList.get(cnt);

			for (int i = 0; i < dir[cctv.no].length; i++) {
				int nx=cctv.x;
				int ny=cctv.y;
				while(true) {
					nx += dx[(dir[cctv.no][i]+d)%4];
				    ny += dy[(dir[cctv.no][i]+d)%4];
				    
				    if(nx<0 || ny<0 || nx>=N || ny>=M || copy[nx][ny]==6) break;
				    if(copy[nx][ny]!=0) continue;
				    copy[nx][ny]=7;
				}
			}
			solve(cnt + 1, size,copy);
		}
	}

}
