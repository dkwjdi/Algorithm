package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_17140_이차원배열과연산 {
	static class Info implements Comparable<Info>{
		int num,cnt;
		public Info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Info o) {
			if(this.cnt==o.cnt) return this.num-o.num;
			return this.cnt-o.cnt;
		}
	}
	static int tr,tc,row,col,k;
	static int map[][]=new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tr=Integer.parseInt(st.nextToken());
		tc=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		row=col=3;
		
		for(int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve());
		
		
		
	}
	private static int solve() {
		int time=0;
		while(time<100) {
			
			if(map[tr][tc]==k) return time;
			
			if(row>=col) R();
			else C();
			
			
			
			
			time++;
			
			
			
		}
		return -1;
	}
	private static void R() {
		int []cntArr=new int[101];
		List<Info> list =new ArrayList<>();
		Set <Integer> set=new HashSet<>();
		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				if(map[i][j]==0) break;
				cntArr[map[i][j]]+=1;
			}
			
		}
		
	}

}
