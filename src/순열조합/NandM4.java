package 순열조합;

import java.util.Scanner;

public class NandM4 {
	private static int N, M, numbers[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		
		combination2(0,1);
	}

	private static void combination2(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			
			numbers[cnt] = i;
			combination2(cnt + 1,i);
			
		}
	}
}
