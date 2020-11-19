package 프로그래머스;

public class 네트워크 {
	static class Solution {
		static int[] parents;
		static int N;

		public int solution(int n, int[][] computers) {
			int answer = 0;
			
			boolean visited[] = new boolean[n];
			parents = new int[n];
			N = n;

			make_set();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if(computers[i][j]==1) union_set(i, j);
				}
			}
			
			for(int i=0; i<n; i++) {
				find_set(i);
			}
			
			for(int i=0; i<n; i++) {
				if(visited[parents[i]]) continue;
				visited[parents[i]]=true;
				answer++;
			}
			
			return answer;
		}

		private void union_set(int x, int y) {
			x = find_set(x);
			y = find_set(y);
			if (x != y)
				parents[y] = x;

		}

		private void make_set() {
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}

		}

		private int find_set(int x) {
			if (x == parents[x])
				return x;
			else
				return parents[x] = find_set(parents[x]);

		}

	}

}
