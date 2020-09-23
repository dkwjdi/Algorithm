package IM대비문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_13300_방배정 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1[] = br.readLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int K = Integer.parseInt(str1[1]);
		String str2[] = br.readLine().split(" ");
		int cur = 0;
		for (int i = 0; i < K; i++) {
			cur += Integer.parseInt(str2[i]);
		}
		int max = cur;
		for (int i = K; i < N; i++) {
			cur -= Integer.parseInt(str2[i - K]);
			cur += Integer.parseInt(str2[i]);
			max = Math.max(cur, max);
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}
