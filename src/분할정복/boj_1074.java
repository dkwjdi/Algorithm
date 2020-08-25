package 분할정복;

import java.util.Scanner;

class boj_1074 {

	static int N;
	static int r;
	static int c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int n = (int)Math.pow(2, N);
		int x = 0, y=0, check=0;
		
		while (true) {
			n /= 2;

			// 왼쪽 위
			if (r < x + n && c < y + n) {
			}
			// 오른쪽 위
			
			else if (r < x + n) {
				check += n * n * 1;
				y += n;
			}
			// 왼쪽 아래 
			else if (c < y + n) {
				check += n * n * 2;
				x += n;
			}
			// 오른쪽아래 
			else {
				check += n * n * 3;
				x += n;
				y += n;
			}

			if (n == 1 || n<=0) {
				System.out.println(check);
				break;
			}
		}
	}


}
