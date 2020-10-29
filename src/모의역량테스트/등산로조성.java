package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 등산로조성 {
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int map[][], copy[][];
	static int N, K, result;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { -1, 1, 0, 0 };
	static List<Point> top;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			copy = new int[N][N];
			top = new ArrayList<>();
			int topM = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j]=map[i][j];
					if (topM < map[i][j]) topM = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) { // 가장큰 높이 찾아서 리스트에 넣어주기
				for (int j = 0; j < N; j++) {
					if (map[i][j] == topM) top.add(new Point(i, j));
				}
			}

			for (Point p : top) { // 맨 윗 봉우리 하나씩 뺴서..
				for (int k = 0; k <= K; k++) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							copy[i][j]=map[i][j]-k;
							solve(p.x, p.y, 1);
							copy[i][j]+=k;
						}
					}
				}
			}
			sb.append("#" + tc + " " + (result) + "\n");
			result = 0;
		}
		System.out.println(sb);
	}

	private static void solve(int x, int y, int height) {
		result = Math.max(result, height);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue; // 범위 벗어나면 안되고
			if (copy[x][y] > copy[nx][ny]) solve(nx, ny, height + 1); // 나보다 작은 산이면 길이 추가하고 간다
		}
	}
}

