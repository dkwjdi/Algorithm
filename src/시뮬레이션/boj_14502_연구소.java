package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_연구소 {
	static int N,M, map[][] ,copy[][], result;
	static List<Point> list ;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st= new StringTokenizer(br.readLine());
		 
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		 map=new int [N][M];
		 copy= new int [N][M];
		 list=new ArrayList<>();
		 result=Integer.MIN_VALUE;
		 
		 for(int i=0; i<N; i++) {
			 st= new StringTokenizer(br.readLine());
			 for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) list.add(new Point(i,j));
			 }
		 }
		 
		 solve(0,0,0);
		 System.out.println(result);
	}
	private static void copyMap() {
		for(int i=0; i<N; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, M);
		}
	}
	private static void solve(int i, int j, int cnt) {
		if(cnt==3 ) {
			copyMap();
			result=Math.max(result, bfs());
			return;
		}
		if((i==N-1 && j==M-1)) {
			return;
		}
		
		for(int x=i; x<N; x++) {
			for(int y=0 ; y<M; y++) {
				if(x==i && y<j) continue;
				if(map[x][y]==0) {
					map[x][y]=1;
					solve(x,y+1,cnt+1);
					map[x][y]=0;
				}
			}
		}
	}
	private static int bfs() {
		Queue <Point> queue = new LinkedList<>();
		for(int i=0; i<list.size(); i++) {
			queue.offer(new Point(list.get(i).x, list.get(i).y));
		}
		
		while(!queue.isEmpty()) {
			Point virus=queue.poll();
			for(int i=0; i<4; i++) {
				int nx=virus.x+dx[i];
				int ny=virus.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || copy[nx][ny]==2 || copy[nx][ny]==1) continue;
				
				copy[nx][ny]=2;
				queue.offer(new Point(nx,ny));
			}
		}
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
}
