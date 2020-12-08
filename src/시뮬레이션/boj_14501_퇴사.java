package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {
	static int time[], money[], N, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		time = new int[N + 1];
		money = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			dfs(i, 0);
		}
		System.out.println(result);

	}

	private static void dfs(int day, int totalMoney) {
		if (day > N) {
			result = Math.max(result, totalMoney);
			return;
		}
		for(int i=day; i<=N; i++) {
			
			if(day+time[i]>N+1) dfs(day+time[i], totalMoney);
			else dfs(day + time[i], totalMoney + money[i]);
			day++;
		}
	}

}
