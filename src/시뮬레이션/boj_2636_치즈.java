package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2636_치즈 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int flag, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][]map = new int[N][M];
		int time=0, last=0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (flag != 1) {
			flag = 1;
			last=bfs(map);
			time++;
		}
		System.out.println(time+"\n"+last);
	}

	private static int bfs(int [][]map) {
		int[][] visited = new int[N][M];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		visited[0][0] = 1;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			visited[x][y] = 1;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] == 1 || visited[nx][ny] == 2)
					continue;

				if (map[nx][ny] == 1) { // 만약 치즈라면
					visited[nx][ny] = 2;
				} else { // 그냥 빈공간이라면
					visited[nx][ny] = 1;
					queue.offer(new Point(nx, ny));
				}
			}
		}
		int meltnum = 0;
		int cheese = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					cheese++;
				if (visited[i][j] == 2) {
					meltnum++;
					map[i][j]=0;
				}
			}
		}
		if(meltnum==cheese)  return cheese; 
		
		flag=0;
		return 0;
	}
}
