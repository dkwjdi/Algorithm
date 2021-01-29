package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	static int N,t[],p[],result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N=Integer.parseInt(br.readLine());
		t=new int[N+1];
		p=new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1,0);
		System.out.println(result);
	}
	private static void dfs(int day, int money) {
		if(day>=N+1) {
			result=Math.max(result, money);
			return;
		}
		
		for(int i=day; i<=N; i++) {
			if(day+t[i]<=N+1) dfs(day+t[i], money+p[i]);
			else dfs(day+t[i], money);
			day++;
		}
		
	}
	

}
