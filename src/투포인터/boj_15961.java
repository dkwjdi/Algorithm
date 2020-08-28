package 투포인터;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj_15961 {
	static int N, d, k, c, maxvalue;
	static int[] food;
	static int[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		c = sc.nextInt();
		isSelected = new int[d + 1];
		food = new int[N];
		int cnt = 0;

		isSelected[c] = 1;
		for (int i = 0; i < N; i++)
			food[i] = sc.nextInt();

		for (int i = 0; i < k; i++) {
			isSelected[food[i]]++;
		}
		isSelected[c]++;

		for (int i = 0; i <= d; i++) {
			if (isSelected[i] != 0)
				cnt++;
		}

		maxvalue = Math.max(maxvalue, cnt);

		for (int i = 1; i < N; i++) {

			if (--isSelected[food[i - 1]] != 0) { // 앞에꺼 뺏을 때 또 잇다면 skip
			} else { // 0이라면 cnt--해줘야 함
				cnt--;
			}
			if (++isSelected[food[(i + k - 1) % N]] == 1) { // 그다음 넣을 거 ++해줌
				cnt++;
			}
			maxvalue = Math.max(maxvalue, cnt);
		}
		System.out.println(maxvalue);

	}
}
