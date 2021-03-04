package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static int N,map[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int []shark=new int[2];
		map=new int[N][N];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark[0]=i;
					shark[1]=j;
				}
			}
		}
		//입력 끝 
		System.out.println(solve(shark));
	}
	private static int solve(int[] shark) {
		int time=0;
		int size=2;
		int sizeup=0;
		
		while(true) {
			map[shark[0]][shark[1]]=0;
			int tmptime=bfs(shark[0],shark[1], size, shark);
			if(shark[0]==Integer.MAX_VALUE) break;
			map[shark[0]][shark[1]]=9;
			if(++sizeup==size) { //사이즈 키워주기
				sizeup=0;
				size++;
			}
			//이까지 왔다는건  물고기 자리로 갔다는 뜻
			time+=tmptime;
		}
		return time;
		
	}
	private static int bfs(int sharkx, int sharky, int size, int[] shark) {
		int time=-1;
		int eatFish[]= {Integer.MAX_VALUE, Integer.MAX_VALUE};
		boolean flag=false;
		
		boolean visited[][]=new boolean[N][N];
		visited[sharkx][sharky]=true;
		
		Queue <int[]> queue= new LinkedList<>();
		queue.offer(new int[] {sharkx,sharky});
		
		while(!queue.isEmpty()) {
			time++;
			int queueSize=queue.size();
			for(int i=0; i<queueSize; i++) {
				int sharkxy[]=queue.poll();
				if(map[sharkxy[0]][sharkxy[1]]!=9 && size>map[sharkxy[0]][sharkxy[1]]) {
					if(map[sharkxy[0]][sharkxy[1]]!=0) { //물고기 들어왔다면 ??
						flag=true; //bfs끝내는 플래그 true
						if(eatFish[0]>sharkxy[0]) { // 더 위에 있다면 
							eatFish[0]=sharkxy[0];
							eatFish[1]=sharkxy[1];
						}
						else if(eatFish[0]==sharkxy[0]) { //x의 위치가 같다면 y로 판단
							if(eatFish[1]>sharkxy[1]) {
								eatFish[0]=sharkxy[0];
								eatFish[1]=sharkxy[1];
							}
						}
					}
					
				}
				if(flag) continue;
				for(int d=0; d<4; d++) {
					int nx=sharkxy[0]+dx[d];
					int ny=sharkxy[1]+dy[d];
					if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]>size || visited[nx][ny]) continue;
					visited[nx][ny]=true;
					queue.offer(new int[] {nx,ny});
				}
			}
			if(flag) break;
		}
		shark[0]=eatFish[0];
		shark[1]=eatFish[1];
		return time;
	}

}
