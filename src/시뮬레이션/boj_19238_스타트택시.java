package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_19238_스타트택시 {
	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.x==o.x) return this.y-o.y;
			// TODO Auto-generated method stub
			return this.x-o.x;
		}
	}
	static class Men{
		int sx,sy,ex,ey;
		public Men(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}
	static int N,M,gas,map[][];
	static HashMap<Integer, Men> list=new HashMap<>();
	static List<Point> block=new ArrayList<>();
	static boolean visited[][];
	static int []dx= {0,0,-1,1};
	static int []dy= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		gas=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		//맵 저장
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) block.add(new Point(i,j)); //벽 정보 저장 
			}
		}
		//택시 위치 저장 
		st = new StringTokenizer(br.readLine(), " ");
		Point taxi=new Point(Integer.parseInt(st.nextToken())
							,Integer.parseInt(st.nextToken()));
		// 승객정보 저장 + 맵에 승객번호 그리기
		int menNo=2;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Men men=new Men(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			list.put(menNo, men);
			map[men.sx][men.sy]=menNo++;
		}
		System.out.println(solve(taxi) ? gas : -1);
	}
	private static boolean  solve(Point taxi) {
		int size=list.size();
		int totalcnt=0;
		int cnt=0;
		while(true) {
			if(!selectMen(taxi)) return false;
			else cnt++;
			totalcnt++;
			if(totalcnt==size && totalcnt!=cnt) return false;
			if(cnt==size) return true;
			if(cnt!=size && gas<0) return false;
		}
	}
	private static boolean selectMen(Point taxi) {
		int dis=0;
		if(map[taxi.x][taxi.y]>1) {
			if(!ride(taxi, map[taxi.x][taxi.y])) return false;
			return true;
		}
		createVisited(); //visited만들어주고 벽자리 true만들어주기 
		Queue <Point> queue = new LinkedList<>();
		queue.offer(new Point(taxi.x, taxi.y));
		visited[taxi.x][taxi.y]=true;
		List<Point> min = new ArrayList<>();
		
		while(true) {
			int size=queue.size();
			if(size==0) return false;
			dis++;
			for(int i=0; i<size ;i++) {
				Point point=queue.poll();
				
				for(int d=0; d<4; d++) {
					int nx=point.x+dx[d];
					int ny=point.y+dy[d];
					
					if(nx<1 || ny<1 || ny>N || nx>N || visited[nx][ny]) continue;
					if(map[nx][ny]>1) min.add(new Point(nx,ny));
					else queue.offer(new Point(nx,ny));
					visited[nx][ny]=true;
				}
			}
			if(min.size()!=0) { //만약 한명 골랐다면 
				Collections.sort(min);
				gas-=dis; //내가 손님 태우러 간곳까지 소모된 연료 - 해주고 
				if(!ride(taxi, map[min.get(0).x][min.get(0).y])) return false; //손님태우러 갔는데 가스 다딸았으면 그냥 false리턴 
				else return true; //성공했다면 true
			}
		}
		
	}
	private static boolean ride(Point taxi, int menNo) {
		if(gas<=0) return false; //더못가 
		//갔으니까 연료 줄여주기 
		int dis=0;
		//택시 좌표 바꿔주기
		taxi.x=list.get(menNo).sx;
		taxi.y=list.get(menNo).sy;
		Point destination=new Point(list.get(menNo).ex, list.get(menNo).ey);
		map[taxi.x][taxi.y]=0; //map 0 으로  바꿔주기 
		//도착지점 까지  bfs 돌리기 
		createVisited(); //visited만들어주고 벽자리 true만들어주기 
		Queue <Point> queue = new LinkedList<>();
		queue.offer(new Point(taxi.x, taxi.y));
		visited[taxi.x][taxi.y]=true;
		
		while(true) {
			int size=queue.size();
			if(size==0) return false;
			dis++;
			for(int i=0; i<size ;i++) {
				Point point=queue.poll();
				
				for(int d=0; d<4; d++) {
					int nx=point.x+dx[d];
					int ny=point.y+dy[d];
					
					if(nx<1 || ny<1 || ny>N || nx>N || visited[nx][ny]) continue;
					if(nx==destination.x && ny==destination.y) {
						taxi.x=nx;
						taxi.y=ny;
						gas-=dis;
						if(gas<0)return false; //도착지까지 연료 안되면 flase
						else gas+=dis*2; //도착지까지 왔다면 소모한연료 연료*2
						list.remove(menNo); //
						return true;
					}
					queue.offer(new Point(nx,ny));
					visited[nx][ny]=true;
				}
				
			}
		}
	}
	
	private static void createVisited() {
		visited= new boolean[N+1][N+1];
		//벽 부분 true만들어주기 
		for(int i=0; i<block.size(); i++) {
			Point point=block.get(i);
			visited[point.x][point.y]=true;
		}
	}

}
