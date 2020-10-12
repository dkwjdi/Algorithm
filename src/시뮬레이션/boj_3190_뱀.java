package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3190_뱀 {
	static class Info{
		String dir;
		int time;
		public Info(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}
	static int dx[]= {0,-1,0,1}; //좌 상 우 하
	static int dy[]= {-1,0,1,0};
	static int N,K,L, map[][];
	static boolean visited[][];
	static List<Info> list;
	static List<int []> taillist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		visited=new boolean[N+1][N+1];
		for(int i=0; i<K; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=-1;
		}
		L=Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		taillist = new ArrayList<>();
		for(int i=0; i<L; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			list.add(new Info(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		System.out.println(solve());
	}
	private static int solve() {
		int headx=1, heady=1, time=0;
		visited[1][1]=true;
		taillist.add(new int[] {1,1});
		int snakeDir=2;
		
		while(true) {
			time++;
			
			headx+=dx[snakeDir];  //몸길이늘려주기
			heady+=dy[snakeDir];  //몸길이 늘려주기
			if(headx<1 || heady<1 || headx>N || heady>N) return time; //벽 부딪치면 게임끝
			if(visited[headx][heady]) return time;   //자기 몸 만나면 게임 끝
			taillist.add(new int[] {headx,heady});
			visited[headx][heady]=true; 
			if(map[headx][heady]!=-1) { //만약 사과가 그자리에 없다면
				int []remove=taillist.get(0); //머리가  지나간 자리 중 가장 옛날꺼 꺼내서 
				visited[remove[0]][remove[1]]=false; //그자리  false
				taillist.remove(0); //그리고 삭제
			}
			else map[headx][heady]=0; //사과가 있다면 그자리 0으로 
			
			if(list.size()!=0 &&list.get(0).time==time) {
				if(list.get(0).dir.equals("D")) { //오른쪽
					snakeDir=(snakeDir+1)%4;
				}
				else {
					if(--snakeDir<0) snakeDir=3;
				}
				list.remove(0);
			}
		}
	}
}
