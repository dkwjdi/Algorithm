package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236_아기상어 {
	static class Point{
		int x,y,count;

		public Point(int x, int y,int count) {
			this.x = x;
			this.y = y;
			this.count=count;
		}
	}
	static int [] dx= {0,0,-1,1};
	static int [] dy= {-1,1,0,0};
	static int N, Time,map[][], shark[];
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		visited = new boolean[N][N];
		shark=new int[2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark[0]=i;
					shark[1]=j;
					map[i][j]=0;
				}
			}
		}
		bfs();
		System.out.println(Time);
	}
	private static void bfs() {
		int size=2;
		int cnt=0;
		Queue <Point> queue = new LinkedList<>();
		Queue <Point> qshark = new LinkedList<>();
		queue.offer(new Point(shark[0],shark[1],0));
		visited[shark[0]][shark[1]]=true;
		
		while(true) {
			int qsize=queue.size();
			
			if(qsize==0) break;
			
			for(int i=0; i<qsize; i++) {
				Point s=queue.poll();
				
				if(map[s.x][s.y]!=0 && map[s.x][s.y]<size) {
					qshark.offer(new Point(s.x , s.y , s.count));
				}
				for(int d=0; d<4; d++) {
					int nx=s.x+dx[d];
					int ny=s.y+dy[d];
					
					if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
					
					if(map[nx][ny]>size) continue; 
					
					queue.offer(new Point(nx,ny,s.count+1));
					visited[nx][ny]=true;
				}
			}
			int ssize=qshark.size();
			
			Point tmp = null;
			if(ssize!=0) {
				int tmpx=Integer.MAX_VALUE, tmpy=Integer.MAX_VALUE,tmptime=0;
				for(int i=0; i<ssize; i++) {
					tmp=qshark.poll();
					if(tmp.x<tmpx) {
						tmpx=tmp.x;
						tmpy=tmp.y;
						tmptime=tmp.count;
					}
					if(tmp.x==tmpx) {
						if(tmp.y<tmpy) {
							tmpx=tmp.x;
							tmpy=tmp.y;
							tmptime=tmp.count;
						}
					}
				}
				Time+=tmp.count;
				map[tmpx][tmpy]=0;
				
				if(++cnt==size) {
					size++;
					cnt=0;
				}
				queue.clear();
				queue.offer(new Point(tmpx,tmpy,0));
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						visited[i][j]=false;
					}
				}
				visited[tmpx][tmpy]=true;
			}
		}
	}

}
