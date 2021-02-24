package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {
	static int N,L,R,result,map[][];
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result=0;
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(result);
		
	}
	private static void solve() {
		while(true) {
			int sectionNo=1;
			int [][] section = new int [N][N];
			List <int[]> totalInfo = new ArrayList<>(); // 몇번연합, 연합을 이루는 칸갯수, 연합 인구수
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(section[i][j]!=0) continue; //이미 간곳이라면 
					if(bfs(section,totalInfo,sectionNo,i,j)) sectionNo++; //연합이 만들어지면 숫자++
				}
			}
			if(sectionNo==1) break; //연합이 더이상 없으면
			divPopoulation(totalInfo,section);
			result++;
		}
		
	}
	private static void divPopoulation(List<int[]> totalInfo, int[][] section) {
		int population[]=new int[totalInfo.size()];
		for(int i=0; i<totalInfo.size(); i++) {
			int []Info=totalInfo.get(i);
			population[i]=Info[2]/Info[1];
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(section[i][j]==-1 || section[i][j]==0) continue;
				else map[i][j]=population[section[i][j]-1];
			}
		}
		
	}
	private static boolean bfs(int[][] section, List<int[]> totalInfo, int sectionNo, int x, int y) {
		section[x][y]=-1;//우선 방문처리
		int totalPopulation=map[x][y];
		int sectionCnt=1;
		Queue <int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int []point=queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx=point[0]+dx[d];
				int ny=point[1]+dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || section[nx][ny]!=0) continue;
				if(!isBound(point[0],point[1],nx,ny)) continue; //L,R확인
				section[nx][ny]=sectionNo;
				sectionCnt++;
				totalPopulation+=map[nx][ny];
				queue.offer(new int[] {nx,ny});
			}
		}
		
		if(map[x][y]==totalPopulation) return false; //연합 형성이 안됬으면 
		else {
			totalInfo.add(new int[] {sectionNo, sectionCnt, totalPopulation});
			section[x][y]=sectionNo;// 연합에 넣고
			return true; //true
		}
	}
	private static boolean isBound(int x, int y, int nx, int ny) {
		int check=Math.abs(map[x][y]-map[nx][ny]);
		if(L<=check && R>=check) return true;
		return false;
	}
}
