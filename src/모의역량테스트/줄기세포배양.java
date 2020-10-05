package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static class Info implements Comparable<Info>{
		int x,y;
		int wait;
		int hp;
		int play;
		public Info(int x, int y, int wait, int play, int hp) {
			super();
			this.x = x;
			this.y = y;
			this.wait = wait;
			this.play = play;
			this.hp = hp;
		}
		@Override
		public int compareTo(Info o) {
			return o.hp-this.hp;
		}
		
	}
	static int N,M,K;
	static boolean [][]visited;
	static List<Info> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			visited= new boolean[N+(2*K)][M+(2*K)];
			list = new ArrayList<>();
			for(int i=K; i<K+N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=K; j<K+M; j++) {
					int tmp=Integer.parseInt(st.nextToken());
					if(tmp==0) continue;
					list.add(new Info(i,j,tmp,tmp,tmp));
					visited[i][j]=true;
				}
			}
			sb.append("#"+tc+" "+solve()+"\n");
		}
		System.out.println(sb);
	}
	private static int solve() {
		int dx[]= {0,0,-1,1};
		int dy[]= {-1,1,0,0};
		
		for(int i=0; i<=K; i++) {
			int size=list.size();
			if(i==K) return size;
			Collections.sort(list);
			
			for(int j=0; j<size; j++) {
				Info info = list.get(j);
				if(info.wait>=1) {
					info.wait-=1;
				}
				else {
					if(info.play==0) continue;
					for(int d=0; d<4; d++) {
						int nx=info.x+dx[d];
						int ny=info.y+dy[d];
						if(visited[nx][ny]) continue;
						visited[nx][ny]=true;
						int hp=info.hp;
						list.add(new Info(nx,ny,hp,hp,hp));
					}
					info.play--;
				}
			}
			int index=0;
			while(true) {
				int listsize=list.size();
				if(index==listsize) break;
				if(list.get(index).play==0) {
					list.remove(index);
					continue;
				}
				index++;
			}
		}
		return 1;
	}

}
