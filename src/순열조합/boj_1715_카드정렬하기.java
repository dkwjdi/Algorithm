package 순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj_1715_카드정렬하기 {
	static int N, card[], min, numbers[];
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++)
			queue.offer(Integer.parseInt(br.readLine()));

		if (N == 1) {
			System.out.println(0);
			return;
		}
		if (N == 2) {
			System.out.println(queue.poll()+queue.poll());
			return;
		}
		
		
		int ans=0;
		while(queue.size()!=1) {
			int a=queue.poll();
			int b=queue.poll();
			ans+=a+b;
			queue.offer(a+b);
		}
		System.out.println(ans);

	}

}
