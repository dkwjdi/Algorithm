package 시뮬레이션;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17837_새로운게임2 {
	static class Info{
		int x,y,dir;
		public Info(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static int N,K, map[][];
	static StringBuilder sb[][];
	static List<Info> list = new ArrayList<>();
	static int dx[]= {0,-1,0,1};
	static int dy[]= {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map=new int[N][N];
        sb=new StringBuilder[N][N];
        
        for(int i=0; i<N;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		sb[i][j]=new StringBuilder();
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	int dir=Integer.parseInt(st.nextToken())-1;
        	if(dir==1) dir=2;
        	else if(dir==2) dir=1;
        	list.add(new Info(x,y,dir));
        }
        System.out.println(solve());
    }

	private static int solve() {
		int size=list.size();
		for(int i=0; i<size; i++) {
			Info info = list.get(i);
			sb[info.x][info.y].append(i);
		}
		
		for(int k=0 ; k<1001; k++) {
			for(int i=0; i<size; i++) {
				Info info=list.get(i);
				
				int nx=info.x+dx[info.dir];
				int ny=info.y+dy[info.dir];
				//이동방향 반대로 바꾸고 한칸이동 근데 거기가 파란색이면 가만히 있어야 함(파랑, 벽 )
				if(nx<0 || ny<0|| nx>=N || ny>=N || map[nx][ny]==2) {
					info.dir=(info.dir+2)%4;
					nx=info.x+dx[info.dir];
					ny=info.y+dy[info.dir];
				}
				if(!colorCheck(i,info,nx,ny,k)) return k+1;
			}
		}
		return -1;
	}

	private static boolean colorCheck(int i, Info info, int nx, int ny,int k) {
		if(nx<0 || ny<0|| nx>=N || ny>=N || map[nx][ny]==2) return true; //파란색이면 끝냄
			
		int idx=sb[info.x][info.y].indexOf(Integer.toString(i));
		StringBuilder moveHorse=new StringBuilder(sb[info.x][info.y].substring(idx));
		sb[info.x][info.y].delete(idx, sb[info.x][info.y].length());
		
		if(map[nx][ny]==0) sb[nx][ny].append(moveHorse.toString()); //흰색
		
		else if(map[nx][ny]==1) sb[nx][ny].append(moveHorse.reverse().toString());
		
		for(int j=0; j<moveHorse.length(); j++) {
			char horseIdx= moveHorse.charAt(j);
			Info move=list.get(horseIdx-'0');
			move.x=nx;
			move.y=ny;
		}
		if(sb[nx][ny].length()>=4) return false;
		return true;
	}
}