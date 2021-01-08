package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _3190_뱀 {
	static class DirChange{
		int time, dir;
		public DirChange(int time, int dir) {
			this.time = time;
			this.dir = dir;
		}
		
	}
	static int N,K,L,map[][];
	static Queue <DirChange> dirChange= new LinkedList<>();
	static int dx[]= {-1,0,1,0}; //상 우 하 좌
	static int dy[]= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		
		map=new int[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			st= new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		L=Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			st= new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			String dir=st.nextToken();
			dirChange.offer(new DirChange(time, dir.equals("L")?-1:1));
		}
		
		System.out.println(solve());
		
	}
	private static int solve() {
		int time=0;
		int x=1, y=1, dir=1; //뱀의 머리x , y  방향
		List<int []> snakeHistory = new ArrayList<>(); // 뱀머리가 지나간 자리 저장할 리스트
		Set<String> bodyCrush = new HashSet<>(); //자신의 몸이랑 부딪치는지 확인할 셋
		add(x,y,snakeHistory, bodyCrush);
		
		while(true) {
			time++;
			
			x+=dx[dir]; //이동 
			y+=dy[dir];
			
			if(x<1 || y<1 || x>N || y>N) break; //벽 만남 
			if(bodyCrush.contains(x+","+y)) break; //자신의 몸 만남
			
			if(map[x][y]==1) { //사과가 있다면 
				map[x][y]=0; //그자리 0만들어주고
			}
			else { //사과가 없다면 
				//리스트에서 맨 처음꺼 없애주고 , set에서 빼주고
				int tail[]=snakeHistory.get(0);
				snakeHistory.remove(0);
				bodyCrush.remove(tail[0]+","+tail[1]);
			}
			if(bodyCrush.contains(x+","+y)) break; //자신의 몸 만남
			
			add(x,y,snakeHistory, bodyCrush); //두곳에 넣어주기
			//System.out.println(time);
			if(!dirChange.isEmpty()&&dirChange.peek().time==time) { //지금 시간에 방향을 바꿔야 된다면 ?
				dir+=dirChange.poll().dir;
				if(dir==-1) dir=3;
				if(dir==4) dir=0;
			}
		}
		return time;
	}
	private static void add(int x, int y, List<int[]> snakeHistory, Set<String> bodyCrush) {
		snakeHistory.add(new int[] {x,y});
		bodyCrush.add(x+","+y);
	}

}
