package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_연구소 {
	static int N,M,map[][],safeArea;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {-1,1,0,0};
	static List<int []> virusList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		safeArea=Integer.MIN_VALUE;
		
		for(int i=0; i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virusList.add(new int[] {i,j});
			}
		}
		
		dfs(0,-1,0); //벽 세우기
		System.out.println(safeArea);
	}
	private static void dfs(int x, int y, int cnt) {
		if(cnt==3) { //벽 3개 다세웠으면
			safeArea=Math.max(safeArea, bfs());
			return;
		}
		if(x==N-1 && y==M-1) return;
		
		
		if(++y==M) { //x,y좌표변경
			x++;
			y=0;
		}
		
		for(int i=x; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==x && j<y) continue; //3,4 가 들어오면  3,5부터 실행되고 3행이 끝나면 4,0부터 시작
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(i,j,cnt+1);
					map[i][j]=0; 
				}
			}
		}
		
	}
	private static int bfs() {
		int cnt=0;
		Queue <int[]> queue = new LinkedList<>();
		boolean visited[][]=new boolean[N][M];
		for(int []xy : virusList) {
			queue.offer(new int[] {xy[0],xy[1]});
			visited[xy[0]][xy[1]]=true;
		}
		
		while(!queue.isEmpty()) {
			int []xy=queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx=xy[0]+dx[d];
				int ny=xy[1]+dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==1 || visited[nx][ny]) 
					continue;//범위 넘어가면 or 벽있으면 or 이미 방문했다면
				
				queue.offer(new int[] {nx,ny});
				visited[nx][ny]=true;
			}
		}
		
		for(int i=0; i<N; i++) { //안전영역 카운트
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}

}
