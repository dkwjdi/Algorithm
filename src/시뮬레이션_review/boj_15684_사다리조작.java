package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684_사다리조작 {
	static class Info {
		int left, right;

		public Info(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static int N, M, H, result;
	static Info map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new Info[H + 1][N + 1];
		for (int i = 0; i <= H; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] = new Info(0, 0);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b].right = 1;
			map[a][b + 1].left = 1;
		}

		if (endCheck()) {
			System.out.println(0);
			System.exit(0);
		}
		else {
			for (int i = 1; i < 4; i++) {
				solve(1, 1, 0, i);
			}
		}
		System.out.println(-1);
	}

	private static boolean endCheck() {
		for (int i = 1; i <= N; i++) {
			int row = i;
			for (int j = 1; j <= H; j++) {
				if (map[j][row].left == 1)
					row--;
				else if (map[j][row].right == 1)
					row++;
			}
			if (row != i)
				return false;
		}
		return true;
	}

	private static void solve(int x, int y, int cnt, int end) {
		if (cnt == end) {
			if (endCheck()) {
				System.out.println(cnt);
				System.exit(0);
			}
			return;
		}

		for (int i = x; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (x == i && j <= y)
					continue;
				if (map[i][j].left == 1 || map[i][j].right == 1)
					continue; // 중첩x
				if (map[i][j + 1].right != 1 && map[i][j+1].left!=1) { // 내 기준 오른쪽으로 사다리 가능
					map[i][j].right = 1;
					map[i][j + 1].left = 1;
					solve(i, j + 1, cnt + 1, end);
					map[i][j].right = 0;
					map[i][j + 1].left = 0;
				}

			}
		}

	}

}
