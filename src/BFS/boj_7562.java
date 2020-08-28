package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7562 {
	static class Point {
		int x, y, count;

		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

	}

	static int T, N, cnt;
	static int[] dx = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] dy = { -1, 1, -2, 2, -1, 1, -2, 2 };
	
	
	static boolean[][] visited;
	static Point start, end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			visited = new boolean[N][N];
			start = new Point(sc.nextInt(), sc.nextInt(), 0);
			end = new Point(sc.nextInt(), sc.nextInt(), 0);

			if (start.x == end.x && start.y == end.y)
				System.out.println(0);
			else {
				
				System.out.println(bfs()+1);
			}
			cnt = 0;
		}
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start.x, start.y, 0));
		visited[start.x][start.y] = true;

		while (true) {
			int size = queue.size();
			if (size == 0) {
				return -1;
			}
			
			for (int i = 0; i < size; i++) {
				Point p = queue.poll();

				for (int k = 0; k < 8; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];
					// 팔방탐색
					if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] == true)
						continue;
					if (nx == end.x && ny == end.y) {
						return p.count;
					}
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, (p.count + 1)));
				}

			}

		}

	}

}
