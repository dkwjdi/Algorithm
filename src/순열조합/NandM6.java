package 순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class NandM6 {
	private static int N, M, numbers[],input[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		input=new int[N];
		
		for(int i=0; i<N; i++) {
			input[i]=sc.nextInt();
		}
		
		Arrays.sort(input);
		combination(0,0);
	}

	private static void combination(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1,i+1);
		}
	}
}
