package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_EX_D5_7793쌤 {
	static class Point {
		int x, y, count;

		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

	}

	static int N, M, T, max;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> squeue,dqueue ;

	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			dqueue = new LinkedList<Point>();
			squeue = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*')
						dqueue.offer(new Point(i, j, 0));
					if (map[i][j] == 'S')
						squeue.offer(new Point(i, j, 1));
				}
			}
			int result = bfs();
			if (result == -1)	System.out.println("#" + tc + " GAME OVER");
			else 	System.out.println("#" + tc + " " + result);
		}
		// 하나 입력 끝
	}

	private static int bfs() {

		while (true) {
			// 악마부터
			int dsize = dqueue.size();

			for (int i = 0; i < dsize; i++) {
				Point dp = dqueue.poll();

				for (int k = 0; k < 4; k++) {
					int nx = dp.x + dx[k];
					int ny = dp.y + dy[k];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M && (map[nx][ny] == '.'||map[nx][ny]=='S')) {
						map[nx][ny] = '*';
						dqueue.offer(new Point(nx, ny, 0));
					}

				}
			}

			// 수연이

			int ssize = squeue.size();

			for (int i = 0; i < ssize; i++) {
				Point sp = squeue.poll();

				for (int k = 0; k < 4; k++) {
					int nx = sp.x + dx[k];
					int ny = sp.y + dy[k];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M && (map[nx][ny] == '.'||map[nx][ny]=='D')) {
						if(map[nx][ny] == 'D') return sp.count;
						map[nx][ny] = 'S';
						squeue.offer(new Point(nx, ny, sp.count + 1));
					} 
				}
			}

			if (squeue.size() == 0)
				return -1;
		}

	}
}
