package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, R, C, L, cnt;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			solve();
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void solve() {
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		int pipe[][] = new int[8][4];
		pipe[1][0] = 1; pipe[1][1] = 1; pipe[1][2] = 1; pipe[1][3] = 1; // 1번파이프 
		pipe[2][0] = 1; pipe[2][1] = 1; // 2번파이프
		pipe[3][2] = 1; pipe[3][3] = 1; // 3번파이프
		pipe[4][0] = 1; pipe[4][3] = 1; // 4번파이프
		pipe[5][1] = 1; pipe[5][3] = 1; // 5번파이프
		pipe[6][1] = 1; pipe[6][2] = 1; // 6번파이프
		pipe[7][0] = 1; pipe[7][2] = 1; // 7번파이프

		int dir[][] = new int[4][4];
		dir[0][0] = 1; dir[0][1] = 2; dir[0][2] = 5; dir[0][3] = 6; // 내 위치 상 가능
		dir[1][0] = 1; dir[1][1] = 2; dir[1][2] = 4; dir[1][3] = 7; // 하
		dir[2][0] = 1; dir[2][1] = 3; dir[2][2] = 4; dir[2][3] = 5; // 좌
		dir[3][0] = 1; dir[3][1] = 3; dir[3][2] = 6; dir[3][3] = 7; // 우

		visit = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(R, C));
		visit[R][C] = true;

		int time = 0;
		while (true) {
			time++;

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point point = queue.poll();
				cnt++;
				int pipenum = map[point.x][point.y];

				for (int k = 0; k < 4; k++) {
					int nx = point.x;
					int ny = point.y;
					if (pipe[pipenum][k] == 1) { // 현재 위치의 파이프가 갈 수 있는 방향
						nx += dx[k];
						ny += dy[k];

						if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || visit[nx][ny] || map[nx][ny] == 0)
							continue;
						// 만약 맵밖, 파이프 없는자리, 이미 방문한 자리가 아니라면
						// 내가 지금 갈려고 하는 방향의 파이프가 내가 들어갈 수 있는 파이프 인지 화깅ㄴ한다

						int destination = map[nx][ny];

						for (int d = 0; d < 4; d++) {
							if (dir[k][d] == destination) { // 만약 있다면
								if(visit[nx][ny]==false) {
									queue.offer(new Point(nx, ny));
									visit[nx][ny]=true;
								}
								break;
							}
						}
					}
				}
			}
			if (time == L)
				break;
		}
		return;
	}

}
