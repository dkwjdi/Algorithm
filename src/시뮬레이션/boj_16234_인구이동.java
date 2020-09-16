package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {
	static int N, L, R, map[][], populationMove;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int flag=0;
		outer: while (true) {
			visited = new boolean[N][N];
			flag=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					if(bfs(i,j,visited)) flag=1;
				}
			}
			if(flag==0) break outer;
			populationMove++;
		}
		System.out.println(populationMove);
	}

	private static boolean bfs(int x, int y, boolean visited[][]) {
		Queue<int[]> queue = new LinkedList<>();
		List <int []> list = new ArrayList<>();
		queue.offer(new int[] { x, y });
		visited[x][y]=true;
		list.add(new int[] {x,y});

		while (!queue.isEmpty()) {
			int[] point=queue.poll();
			int tmpx=point[0];
			int tmpy=point[1];
			
			for (int d = 0; d < 4; d++) {
				int nx=dx[d]+tmpx;
				int ny=dy[d]+tmpy;
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				if(check(map[tmpx][tmpy],map[nx][ny])) { //만약 L이상 R이하라면 
					visited[nx][ny]=true;
					queue.offer(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
				}
			}
		}
		int size=list.size();
		int sum=0;
		if(size!=1) {
			for(int i=0 ; i<size; i++) {
				int [] team=list.get(i);
				sum+=map[team[0]][team[1]];
			}
			int avg=sum/size;
			for(int i=0 ; i<size; i++) {
				int [] team=list.get(i);
				map[team[0]][team[1]]=avg;
			}
			return true;
		}
		return false;
	}

	private static boolean check(int a,int b) {
		int result=Math.abs(a-b);
		if(result>=L && result<=R) return true;
		return false;
	}
}
