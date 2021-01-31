package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503_로봇청소기 {
	static int N, M, map[][];
	static int dx[] = { 0, -1, 0, 1 }; //동 북 서 남 
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		if(d==0 || d==2) d++;
		else d--;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve(r, c, d));
	}

	private static int solve(int r, int c, int d) {
		int cnt = 0;
		boolean one = true;

		loop: while (true) {
			// 현재 위치 청소
			if (one) { // 1번을 거쳐야 한다면
				cnt++;
				map[r][c] = -1;
			}
			// 왼쪽 확인
			for (int i = 0; i < 4; i++) {
				if (++d == 4)
					d = 0; // 방향 왼쪽으로
				int nr = r + dx[d];
				int nc = c + dy[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == -1 || map[nr][nc] == 1)
					continue;
				// 청소 가능 하다면
				r = nr;
				c = nc;
				one = true;
				continue loop;
			}
			//이까지 왔으면 4방향 다 확인한거임 
			one=false; //바로 2번으로 갈 수 있게 처리
			r=r-dx[d]; //방향 유지한채 한칸 후진 
			c=c-dy[d]; 
			if (r < 0 || c < 0 || r >= N || c >= M ||  map[r][c] == 1) return cnt;
		}
	}
}
