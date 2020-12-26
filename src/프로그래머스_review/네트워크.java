package 프로그래머스_review;

import java.util.HashSet;
import java.util.Set;

public class 네트워크 {
	static class Solution {
		public int solution(int n, int[][] computers) {

			int[] parents = new int[n];

			make_set(parents, n);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (computers[i][j] == 1) {
						if (i == j)
							continue;
						union_set(i, j, parents);
					}
				}
			}

			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < n; i++) {
				parents[i] = find_set(i, parents);
			}

			for (int i = 0; i < n; i++) {
				set.add(parents[i]);
			}

			return set.size();
		}

		private void union_set(int a, int b, int[] parents) {
			a = find_set(a, parents);
			b = find_set(b, parents);

			if (a != b)
				parents[b] = a;
		}

		private int find_set(int num, int[] parents) {
			if (parents[num] == num)
				return num;
			return find_set(parents[num], parents);
		}

		private void make_set(int[] parents, int n) {
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
		}
	}

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 }

		};
		System.out.println(new Solution().solution(3, computers));

	}

}
