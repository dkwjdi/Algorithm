package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17406_배열돌리기4 {
	static class Info{
		int r,c,s;
		public Info(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	static int N,M,K, map[][], copy[][], permutationArray[], result;
	static boolean visited[];
	static List<Info> list;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		 K=Integer.parseInt(st.nextToken());
		 
		 map=new int[N+1][M+1];
		 copy=new int[N+1][M+1];
		 permutationArray=new int[K];
		 visited=new boolean[K];
		 result=Integer.MAX_VALUE;
		 list=new ArrayList<>();
		 
		 for(int i=1; i<=N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=1; j<=M; j++) {
				 map[i][j]=Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 for(int i=0; i<K; i++) {
			 st = new StringTokenizer(br.readLine());
			 list.add(new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) )); 
		 }
		 
		 permutation(0);
		 System.out.println(result);
		 
	}
	private static void permutation(int cnt) {
		if(cnt==K) {
			copyMap();
			rotate();
			return;
		}
		for(int i=0; i<K; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			permutationArray[cnt]=i;
			permutation(cnt+1);
			visited[i]=false;
		}
	}
	private static void copyMap() {
		for(int i=0; i<=N; i++) 
			System.arraycopy(map[i], 0, copy[i], 0, M+1);
	}
	private static void rotate() {
		
		for(int q=0; q<K; q++) {
			Info info=list.get(permutationArray[q]);
			int r=info.r;
			int c=info.c;
			int s=info.s;
			
			while(true) {
				go(r,c,s);
				if(--s==0) break;
			}
		}
		for(int i=1; i<=N; i++) {
			result=Math.min(result, Arrays.stream(copy[i]).sum());
		}
	}
	private static void go(int r, int c, int s) {
	
		int one=copy[r-s][c+s];
		for(int j=c+s; j>=c-s; j--)  copy[r-s][j]=copy[r-s][j-1];
		
		int two=copy[r+s][c+s];
		for(int i=r+s; i>r-s; i--) copy[i][c+s]=copy[i-1][c+s];
		copy[r-s+1][c+s]=one;
		
		int three=copy[r+s][c-s];
		for(int j=c-s; j<c+s; j++) copy[r+s][j]=copy[r+s][j+1];
		copy[r+s][c+s-1]=two;
		
		for(int i=r-s; i<r+s; i++) copy[i][c-s]=copy[i+1][c-s];
		copy[r+s-1][c-s]=three;
	}

}
