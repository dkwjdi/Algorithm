package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static int N, max, min, nums[], op[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			op = new int[4];
			nums = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i]=Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,op[0],op[1],op[2],op[3], nums[0]);
			System.out.println("#"+tc+" "+(max-min));
		}

	}

	private static void solve(int cnt, int plus, int minus, int mul, int div, int result) {
		if(cnt==N-1) {
			max=Math.max(result, max);
			min=Math.min(result, min);
			return;
		}
		if(plus>0) solve(cnt+1, plus-1, minus, mul, div, result+nums[cnt+1]);
		if(minus>0) solve(cnt+1, plus, minus-1, mul, div, result-nums[cnt+1]);
		if(mul>0) solve(cnt+1, plus, minus, mul-1, div, result*nums[cnt+1]);
		if(div>0) solve(cnt+1, plus, minus, mul, div-1, result/nums[cnt+1]);
	}
}
