package 백트래킹;

import java.util.Scanner;

public class boj_9663 {
	static int []visited;
	static int totalcnt,N;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		visited= new int[N+1];
		dfs(1);
		System.out.println(totalcnt);
	}

	private static void dfs(int row) {
		if(row>N) {
			totalcnt++;
			return;
		}
		for(int j=1; j<=N; j++) {
			if(check(row,j)) {
			visited[row]=j;
			dfs(row+1);
			}
		}
	}

	private static boolean check(int row, int col) {
		for(int i=1; i<row; i++) {
			if(visited[i]==col || (Math.abs(row-i)==Math.abs(visited[i]-col))) return false;
		}
		return true;
	}

}
