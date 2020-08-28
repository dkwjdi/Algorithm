package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_EX_D4_7699 {
	static int T, R, C, max;
	static char[][] map;
	static boolean[] visited;
	//상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String []input= br.readLine().split(" ");
		T = Integer.parseInt(input[0]);

		for (int t = 1; t <= T; t++) {
			input= br.readLine().split(" ");
			R =Integer.parseInt(input[0]);
			C =Integer.parseInt(input[1]);

			map = new char[R][C];
			visited = new boolean[30];

			for (int i = 0; i < R; i++) {
				String data = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = data.charAt(j);
				}
			}

			dfs(0, 0, 1);
			System.out.println("#"+t+" "+max);
			max = 0;

		}

	}

	private static void dfs(int x, int y, int cnt) {

		if (max <= cnt)
			max = cnt;
		visited[map[x][y] - 'A'] = true;
		if (max == 26)
			return; // 모든 명물을 다 봤다면 탈출
		

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R  || ny >=C || visited[map[nx][ny] - 'A'])
				continue;

			dfs(nx, ny, cnt + 1);
			
			visited[map[nx][ny] - 'A']=false;

		}

	}

}
