package kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 실패율 {
	static class Point implements Comparable<Point> {
		double fail;
		int num;

		public Point(double fail, int num) {
			this.fail = fail;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			int r = new Double(this.fail).compareTo(o.fail) * -1;
			if (r == 0)
				r = this.num - o.num;
			return r;
		}

	}

	public static void main(String[] args) {
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] aa = solve(stages, 5);

		for (int a : aa) {
			System.out.println(a);
		}

	}

	private static int[] solve(int[] stages, int N) {

		int len = stages.length;

		double[] cnt = new double[N + 1];

		for (int i = 0; i < len; i++) {
			if (stages[i] > N)
				continue;
			cnt[stages[i]] += 1;
		}

		Point[] failcheck = new Point[N ];
		int tmplen = len;
		for (int i = 0; i < N; i++) {

			double tmp = cnt[i+1] / tmplen;
			failcheck[i] = new Point(tmp, i+1);
			tmplen -= cnt[i+1];
		}

		
		Arrays.sort(failcheck);
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = failcheck[i].num;
		}

		return answer;

	}

}
