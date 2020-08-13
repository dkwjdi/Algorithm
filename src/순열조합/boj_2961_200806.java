package 순열조합;
import java.util.Scanner;

public class boj_2961_200806 {

	static Food[] food;
	static int N, min, result = 999999;

	static class Food {
		int s, b;
		Food(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		food = new Food[N];
		
		for (int i = 0; i < N; i++)	food[i] = new Food(sc.nextInt(), sc.nextInt());
		
		combination(0, 0, 1, 0);

		System.out.println(result);

	}

	private static void combination(int cnt, int start, int mul, int plus) {

		if (cnt >= 1) {
			int flavor = Math.abs(mul - plus);
			
			if (flavor < result)result = flavor;
			
			if (cnt == N) return;
		}

		for (int i = start; i < N; i++) {
			combination(cnt + 1, i + 1, mul * food[i].s, plus + food[i].b);
		}

	}

}
