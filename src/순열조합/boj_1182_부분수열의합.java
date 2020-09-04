package 순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {
	static boolean isSelected[];
	static int input[], targetSum,result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		targetSum = Integer.parseInt(st.nextToken());

		input = new int[n];
		isSelected = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, n);
		System.out.println(result);
	}

	private static void solve(int cnt, int n) {

		if (cnt == n) {
			int sum=0;
			
			int flag=0;
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
					sum+=input[i];
					flag=1;
				}
			}
			if(sum==targetSum && flag==1) result++;
			return;
		}
		isSelected[cnt] = true; // 부분집합 구성에 포함
		solve(cnt + 1, n); // 다음원소로
		isSelected[cnt] = false; // 부분집합 구성에 포함 x
		solve(cnt + 1, n); // 다음원소로 }

	}
}
