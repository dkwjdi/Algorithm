package 순열조합;
import java.util.Arrays;
import java.util.Scanner;

public class NandM8 {
	private static int numbers[], input[], N, M;
	private static Scanner sc = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		input = new int[N];
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		Arrays.sort(input);
		combination(0, 0);
		System.out.println(sb.toString());
	}
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)	sb.append(numbers[i] + " ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i);
		}
	}
}
