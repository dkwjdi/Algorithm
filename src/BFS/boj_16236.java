package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16236 {

	static class Point {
		int x, y, distance;

		Point(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	static int N, sx, sy, MinDistance = 99999999;
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) {
		input();
		solve();

	}

	private static void solve() {
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		int size=2; 
		int cnt=0;
		int time=0;
		Queue <Point> queue = new LinkedList<>();
		queue.offer(new Point(sx,sy,0));
		visit[sx][sy]=true;
		
		while(queue.isEmpty()) {
			Point p=queue.poll();
			
			if(map[p.x][p.y] > size ) continue;
			if(map[p.x][p.y] !=0 && map[p.x][p.y]<size ) {
				if(p.distance<MinDistance) {
					MinDistance=p.distance;
					cnt++;
					if(cnt==size) {
						size++;
						cnt=0;
					}
				}
				else if(p.distance==MinDistance) {
					if(p.)
				}
			}
			
			for(int i=0; i<4; i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				
				if(nx<0 || ny<0 || nx>N-1 || ny>N-1 || visit[nx][ny]==true) continue;
				
				visit[nx][ny]=true;
				queue.offer(new Point(nx,ny,p.distance+1));
				
				
				
				
				
			}
			
		}
		

	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
	}

}
