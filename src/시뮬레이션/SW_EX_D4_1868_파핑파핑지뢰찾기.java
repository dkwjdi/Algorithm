package 시뮬레이션;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_EX_D4_1868_파핑파핑지뢰찾기 {
	static int N, map[][];
	static char cmap[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cmap = new char[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				char input[] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) { //
					cmap[i][j] = input[j];
					if (input[j] == '*') {
						map[i][j] = -1; // 지뢰자리 -1로
						visited[i][j] = true;
					}

				}
			}

			System.out.println("#" + tc + " " + solve());
		}
	}

	private static int solve() {
		int cnt = 0;

		fills(); // 숫자 미리 다 채워주기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (true) {
			int size = queue.size();
			if(size==0) break;
			for (int k = 0; k < size; k++) {
				int tmp[] = queue.poll();

				for (int i = 0; i < 8; i++) {
					int nx = tmp[0] + dx[i];
					int ny = tmp[1] + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (visited[nx][ny])
						continue;
					if (map[nx][ny] == -1)
						continue;
					if (map[nx][ny] != 0)
						visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}

				}

			}

		}

	}

	private static void fills() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { // 지뢰 -2(*), 지뢰x -1(.)
				if (map[i][j] != -1) {
					map[i][j] = check(i, j);
				}
			}
		}
	}

	private static int check(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (map[nx][ny] == -1)
				cnt++;

		}
		return cnt;
	}

}
