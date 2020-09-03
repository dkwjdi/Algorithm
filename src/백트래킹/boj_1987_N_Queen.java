package 백트래킹;

import java.util.Scanner;

public class boj_1987_N_Queen {
	static int cnt, N, row[];
	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		N=sc.nextInt();
		row = new int[N+1];
		dfs(1);
		System.out.println(cnt);
		
	}
	private static void dfs(int rowNo) {
		if(rowNo==N+1) {
			cnt++;
			return ;
		}
		
		for(int i=1; i<=N; i++) {
			row[rowNo]=i;
			if(check(rowNo,i)){
				dfs(rowNo+1);
			}
		}
	}
	private static boolean check(int rowNo, int i) {
		for(int k=1; k<rowNo; k++) {
			if(row[k]==i || (Math.abs(rowNo-k)==Math.abs(i-row[k]))) 
				return false;
		}
		return true;
	}
}
