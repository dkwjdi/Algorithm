package 순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class NandM5 {
	private static int N, M, numbers[],input[];
	private static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		input=new int[N];
		isSelected = new boolean[N + 1];
		
		for(int i=0; i<N; i++) {
			input[i]=sc.nextInt();
		}
		
		Arrays.sort(input);
		permutation(0);
	}

	private static void permutation(int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i] == true)
				continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
