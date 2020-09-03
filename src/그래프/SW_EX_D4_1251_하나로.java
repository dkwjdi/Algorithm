package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_EX_D4_1251_하나로 {
	static int T, N, arr[][];
	static long adj[][], dist[];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			adj = new long[N][N];
			arr = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i][0] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i][1] = Integer.parseInt(st.nextToken());
			
			double E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long c = distance(arr[i][0], arr[j][0], arr[i][1], arr[j][1]);
					adj[i][j] = c;
					adj[j][i] = c;
				}
			}
			
			visited = new boolean[N];
			dist = new long[N];
			Arrays.fill(dist, Long.MAX_VALUE);
			long result = 0, min = 0;
			dist[0] = 0;
			int index;
			
			for (int i = 0; i < N - 1; i++) {
				min = Long.MAX_VALUE;
				index = -1;
				
				for (int j = 0; j < N; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						index = j;
					}
				}
				
				for (int j = 0; j < N; j++) {
					if (!visited[j] && adj[index][j] != 0 && dist[j] > adj[index][j]) {
						dist[j] = adj[index][j];
					}
				}
				
				visited[index] = true;
			}
			
			for (int i = 0; i < N; i++)
				result += dist[i];
			System.out.println("#" + tc + " " + Math.round(result * E));
		}
	}

	static long distance(int x1, int x2, int y1, int y2) {
		long d = (long) ((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		return d;
	}
}