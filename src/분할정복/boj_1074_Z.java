package 분할정복;

import java.util.Scanner;

public class boj_1074_Z {
	static int N, r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) Math.pow(2, sc.nextInt());//8
		r = sc.nextInt() + 1;
		c = sc.nextInt() + 1;

		int divide = N/2;//4
		int x = divide;//4
		int y = divide;//4
		int cnt = 0;
		
		while (true) {
			if(divide<=0) {
				System.out.println(cnt);
				break;
			}
			int skip=divide*divide;
			divide/=2;

			// 왼쪽 위
			if (x >= r && y >= c) {
				x-=divide;
				y-=divide;

			}

			// 오른쪽 위
			else if (x >= r && y <= c) {
				cnt+=skip;
				x-=divide;
				y+=divide;
			}

			// 왼쪽아래
			else if (x <= r && y >= c) {
				cnt+=skip*2;
				x+=divide;
				y-=divide;
			}

			// 오른쪽아래
			else if (x <= r && y <= c) {
				cnt+=skip*3;
				x+=divide;
				y+=divide;

			}
		}

	}
}
