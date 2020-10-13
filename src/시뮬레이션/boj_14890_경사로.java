package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14890_경사로 {
	static int N, X, result;
	static int map[][], map2[][];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		result = 0;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = map2[j][i] = num;
			}
		}
		solve(map);
		solve(map2);
		System.out.println(result);
	}

	private static void solve(int map[][]) {
		// 가로부터 확인
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			outer: for (int j = 0; j < N; j++) {
				if (j == N - 1) {
					result++;
					break;
				}
				if (j != N - 2)
					if (map[i][j] == map[i][j + 1])
						continue; // 같으면

				if (Math.abs(map[i][j] - map[i][j + 1]) > 1)
					break;
				else { // 지금이랑 그 다음이랑 1개 차이날 때
					if (map[i][j] - map[i][j + 1] > 0) {// 낮아질때
						if (widthcheck(i, j, map) == false)
							break;
						else { // 활주로 놓여져 잇는지 검사
							for (int k = j; k < j + X; k++) {
								if (visited[k + 1] == false)
									visited[k + 1] = true;
								else
									break outer;
							}
						}

					} else if (map[i][j] - map[i][j + 1] < 0) { // 높아지면
						if (widthcheck2(i, j, map) == false)
							break;
						else {
							for (int k = j; k > j - X; k--) {
								if (visited[k] == false)
									visited[k] = true;
								else
									break outer;
							}
						}
					}
				}
			}
		}
	}

	private static boolean widthcheck2(int i, int j, int[][] map) {
		if (j - X + 1 < 0)
			return false;
		for (int k = j; k > j - X + 1; k--) {
			if (map[i][k] != map[i][k - 1])
				return false;
		}
		return true;
	}

	private static boolean widthcheck(int i, int j, int[][] map) {
		if (j + X >= N)
			return false;
		for (int k = j + 1; k < j + X; k++) {
			if (map[i][k] != map[i][k + 1])
				return false;
		}
		return true;
	}
}