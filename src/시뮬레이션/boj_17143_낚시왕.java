package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17143_낚시왕 {
	static class Fish implements Comparable<Fish>{
		int r,c,s,d,z;
		public Fish(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public int compareTo(Fish o) {
			return this.z-o.z;
		}
		
		
	}
	static int map[][],M, R, C;
	static List <Fish> fishList;
	static int []dx= {-1,0,1,0};
	static int []dy= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		fishList= new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			map[r][c]=z;
			if(d==1) d=0;
			else if(d==4) d=1;
			fishList.add(new Fish(r,c,s,d,z));
				
			
		}
		System.out.println(solve());
	}
	private static int solve() {
		int sumOfSize=0;
		

		for(int men=1; men<=C; men++) {
			sumOfSize+=fishCatch(men); //땅에서 가장 가까운 물고기 한마리 잡기
			
			fishMove();
		}
		
		
		return sumOfSize;
		
	}
	private static void fishMove() {
		Collections.sort(fishList);
		int size=fishList.size();
		for(int i=size-1; i>=0; i--) {
			Fish fish=fishList.get(i);
			int r=fish.r;
			int c=fish.c;
			int s=fish.s;
			int d=fish.d;
			int z=fish.z;
			if(map[r][c]>z || map[r][c]==0) {
				fishList.remove(i);
				continue; //지금 들어와있는 놈이 나보다 크면 그냥  skip or 이미 잡은 물고기라면
			}
			
			if(d == 0 || d==2) s=s%((R-1)*2); //위 아래
			else s=s%((C-1)*2); //좌우
			
			
			map[r][c]=0; //원래자리 0으로 만들어주고
			
			int nr=r;
			int nc=c;
			for(int j=1; j<=s; j++) {
				if(d==0) {
					if(nr==1) d=(d+2)%4;
				}
				else if(d==1) {
					if(nc==1)  d=(d+2)%4;
				}
				else if(d==2) {
					if(nr==R)  d=(d+2)%4;
				}
				else {
					if(nc==C) d=(d+2)%4;
				}
				
				nr+=dx[d];
				nc+=dy[d];
				
				
				if(d == 0 || d==2) {  //위 아래
					if(nr<=1 || nr>=R) { 
						d=(d+2)%4;
					}
				}
				else {  //좌우
					if(nc<=1 || nc>=C) {
						d=(d+2)%4;
					}
				}
			}
			
			fish.r=nr;
			fish.c=nc;
			fish.d=d;
		}
		
		
		size=fishList.size();
		for(int i=0; i<size; i++) {
			Fish fish=fishList.get(i);
			
			map[fish.r][fish.c]=fish.z;
		}
		
	}
	private static int fishCatch(int men) {
		int size=0;
		for(int i=1; i<=R; i++) {
			if(map[i][men]>0) {
				size=map[i][men];
				map[i][men]=0;
				return size;
			}
		}
		return 0;
	}

}
