package 순열조합;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_EX_D4_준환이의양팔저울 {
	static int numbers[], chu[], result;
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			chu = new int[N];
			numbers = new int[N];
			isSelected = new boolean[N + 1];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++)
				chu[i] = Integer.parseInt(input[i]);
			permutation(0, N);
			System.out.println("#"+tc+" "+result);
			result=0;
		}
	}

	private static void permutation(int cnt, int N) {
		if (cnt == N) {
			cnt++;
			check(N, 0, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1, N);
			isSelected[i] = false;
		}
	}

	private static void check(int N, int left, int right, int cnt) {
		if (cnt == N) {
			result++;
			return;
		}
		check(N, left+chu[numbers[cnt]], right, cnt + 1);
		if(left>=right+chu[numbers[cnt]]) {
			check(N,left,right+chu[numbers[cnt]],cnt+1);
		}
	}
}
