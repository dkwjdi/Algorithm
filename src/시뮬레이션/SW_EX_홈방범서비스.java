package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_EX_홈방범서비스 {
	static int T, N, homeCost, map[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			homeCost = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
				}
			}

			int kCost = 1, homeCnt=0, totalSum=0, max=1;
			for (int k = 2; k <= N+1; k++) {
				kCost += 4 * (k - 1);

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						homeCnt = bfs(i, j, k);
						totalSum = homeCnt * homeCost - kCost;
						if (totalSum >= 0) max = Math.max(max, homeCnt);
					}
				}
			}
			sb.append("#" + tc + " " + max+"\n");
			max = 0;
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y, int k) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		boolean visited[][] = new boolean[N][N];
		if (map[x][y] == 1)cnt++;
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int tmpx = tmp[0];
			int tmpy = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nx = tmpx + dx[i];
				int ny = tmpy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;

				if (distance(nx, ny, x, y, k)) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					if (map[nx][ny] == 1)cnt++;
				}
			}

		}
		return cnt;
	}

	private static boolean distance(int nx, int ny, int x, int y, int k) {
		if (Math.abs(nx - x) + Math.abs(ny - y) < k) return true;
		return false;
	}
}
