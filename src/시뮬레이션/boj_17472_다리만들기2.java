package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472_다리만들기2 {
	static int N, M, map[][], adj[][], minEdge[];
	static boolean bfsvisited[][], visited[];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		bfsvisited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// start 섬번호 붙이기
		int island = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0 && !bfsvisited[i][j]) {
					bfs(i, j, island++);
				}
			}
		}
		// end 섬번호 붙이기
		adj = new int[island][island];
		minEdge = new int[island];
		visited = new boolean[island];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		// 가중치행렬 만들기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0) {
					makeWeight(map[i][j], i, j);

				}
			}
		}
		// 가중치행렬 만들기
		int[][] prim = new int[island - 1][island - 1];

		for (int i = 1; i < island; i++) {
			for (int j = 1; j < island; j++) {
				prim[i - 1][j - 1] = adj[i][j];

			}
		}

		int minVertex, min = 0, result = 0;
		minEdge[0] = 0;

		for (int c = 0; c < island - 1; c++) {
			min = Integer.MAX_VALUE;
			minVertex = 0;
			for (int i = 0; i < island - 1; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;

				}
			}
			result += min;
			visited[minVertex] = true;

			for (int i = 0; i < island - 1; i++) {
				if (!visited[i] && prim[minVertex][i] != 0 && minEdge[i] > prim[minVertex][i]) {
					minEdge[i] = prim[minVertex][i];
				}
			}
		}
		int flag = 0;
		for (int i = 0; i < island - 1; i++) {
			if (!visited[i])
				flag = 1;
		}
		if (flag == 1)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static void makeWeight(int island, int i, int j) {

		for (int d = 0; d < 4; d++) {
			int cnt = 0;
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[d];
				ny += dy[d];

				if (nx < 1 || ny < 1 || nx > N || ny > M || map[nx][ny] == island)
					break;
				if (map[nx][ny] != 0 && map[nx][ny] != island) {
					if (cnt < 2)
						break;
					if (adj[island][map[nx][ny]] != 0) {

						if (adj[island][map[nx][ny]] > cnt) {
							adj[island][map[nx][ny]] = cnt;
							adj[map[nx][ny]][island] = cnt;
						}
					}
					else {
						adj[island][map[nx][ny]] = cnt;
						adj[map[nx][ny]][island] = cnt;
					}

					break;
				}
				cnt++;
			}
		}

	}

	private static void bfs(int i, int j, int island) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		map[i][j] = island;
		bfsvisited[i][j] = true;

		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];

				if (nx < 1 || ny < 1 || nx > N || ny > M || bfsvisited[nx][ny] || map[nx][ny] != 1)
					continue;

				queue.offer(new int[] { nx, ny });
				bfsvisited[nx][ny] = true;
				map[nx][ny] = island;
			}
		}
	}

}
