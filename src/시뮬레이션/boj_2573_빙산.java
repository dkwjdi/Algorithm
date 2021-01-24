package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573_빙산 {
	static class Info{
		int x,y,size;
		public Info(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	static int N,M,map[][],copy[][];
	static int []dx= {0,0,-1,1};
	static int []dy= {-1,1,0,0};
	static List<Info> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) list.add(new Info(i,j,map[i][j]));
			}
		}
		System.out.println(solve());
	}
	private static int solve() {
		int time=0;
		
		while(true) {
			time++;
			meltIce(list.size()); //얼음 녹이기
			copyToArr();
			if(list.size()==0) return 0;
			if(isDivide()) break; //1덩어리가 나눠졌으면
			
			
		}
		return time;
	}
	private static void copyToArr() {
		map=new int[N][M];
		
		for(int i=0; i<list.size(); i++) {
			Info info=list.get(i);
			map[info.x][info.y]=info.size;
		}
		
		
	}
	private static boolean isDivide() {
		boolean visited[][]=new boolean[N][M];  //bfs돌릴 visited
		Info info=list.get(0);
		bfs(visited,info.x,info.y);
		
		for(int i=0; i<list.size(); i++) {
			Info ice=list.get(i);
			if(!visited[ice.x][ice.y]) return true;
		}
		return false;
	}
	private static void bfs(boolean[][] visited, int i, int j) {
		Queue<int []> queue = new LinkedList<>();
		visited[i][j]=true;
		queue.offer(new int [] {i,j});
		
		while(!queue.isEmpty()) {
			int []point=queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx=point[0]+dx[d];
				int ny=point[1]+dy[d];
				
				//범위 넘어가거나 copy맵에 0이라면 스킵
				if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==0 || visited[nx][ny]) continue;
				visited[nx][ny]=true;
				queue.offer(new int[] {nx,ny});
			}
			
		}
		
		
	}
	private static void meltIce(int listSize) {
		List<Info> tmpList=new ArrayList<>();
		
		for(int i=0; i<listSize; i++) {
			Info ice=list.get(i);
			int x=ice.x;
			int y=ice.y;
			int size=ice.size;
			
			for(int d=0; d<4; d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]!=0) continue;  //범위 넘어가면 skip
				size--; //옆에 0이면 size줄여줌
			}
			//size다 줄이고 나서 
			if(size>0) tmpList.add(new Info(x,y,size));
		}
		
		list = new ArrayList<>(); //리스트 없애고 다시 만듬 
		for(int i=0; i<tmpList.size();i++) {
			Info info=tmpList.get(i);
			list.add(new Info(info.x, info.y, info.size));
		}
		
	}
}
