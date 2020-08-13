package 순열조합;

import java.util.Arrays;
import java.util.Scanner;

public class NandM3 {
	private static int N, M, numbers[];
	private static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		permutation2(0);
		System.out.println(sb.toString());
	}

	private static void permutation2(int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
				
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
		
			numbers[cnt] = i;
			permutation2(cnt + 1);
		}
	}
}
