package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_EX_D4_보급로 {
	static int N, map[][], visited[][];

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			solve();
			sb.append("#" + tc + " " + visited[N - 1][N - 1] + "\n");
		}

		System.out.println(sb);
	}

	private static void solve() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = point.x + dx[d];
				int ny = point.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue; // 범위 벗어나면 내보내고

				int next = point.cnt + map[nx][ny];
				if (next >= visited[nx][ny])
					continue;
				visited[nx][ny] = next;
				queue.offer(new Point(nx, ny, next));

			}
		}

	}

}
