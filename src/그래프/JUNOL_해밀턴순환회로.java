package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNOL_해밀턴순환회로 {
	static int N = 5, map[][], minEdge[], result, min = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N];
		visited[0] = true;
		dfs(1, 0, 0);
		System.out.println(min);

	}

	private static void dfs(int cnt, int cost, int vertex) {
		if (cnt == N) {
			if (map[vertex][0] == 0)
				return;
			cost += map[vertex][0];
			if (min > cost) {
				min = cost;
			}
			return;
		}
		for (int i = 1; i < N; i++) {
			if (!visited[i] && map[vertex][i] != 0) {
				visited[i] = true;
				dfs(cnt + 1, cost + map[vertex][i], i);
				visited[i] = false;
			}
		}

	}

}
