package 분할정복;

import java.util.Scanner;

public class boj_1074_Z {
	static int N, r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2, sc.nextInt());
		r = sc.nextInt() + 1;
		c = sc.nextInt() + 1;

		int divide = N / 2; // 4
		int x = divide;
		int y = divide;
		int cnt = 0;
		while (true) {

			
			if (x == r && y == c) {
				
				break;
			}

			// 왼쪽 위
			if (x >= r && y >= c) {
				if (divide != 1) {
					divide /= 2;
				}
				x -=divide ;
				y -=divide;

			}

			// 오른쪽 위
			else if (x >= r && y <= c) {
				cnt += divide * divide;
				if (divide == 1) {
					cnt++;
					break;
				}
				divide /= 2;
				x -= divide;
				y += divide;

			}

			// 왼쪽아래
			else if (x <= r && y >= c) {
				cnt += 2 * (divide * divide);
				if (divide == 1) {
					cnt++;
					break;
				}
				divide /= 2;
				x += divide;
				y -= divide;
			}

			// 오른쪽아래
			else if (x <= r && y <= c) {
				cnt += 3 * (divide * divide);
				if (divide == 1) {
					cnt++;
					break;
				}
				divide /= 2;
				x += divide;
				y += divide;

			}

		}
		System.out.println(--cnt);
	}

}
