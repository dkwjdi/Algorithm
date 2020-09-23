package dp;

import java.util.Scanner;

public class junol_2283_RGB마을 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] cost = new int[1001][3];
		int[][] dp = new int[1001][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		for(int j=0; j<3; j++) dp[0][j]=cost[0][j];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}
		System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
	}
}