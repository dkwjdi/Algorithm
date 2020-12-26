package 프로그래머스_review;

public class 순위 {
	static class Solution {
		public int solution(int n, int[][] results) {
			int answer = 0;

			int[][] graph = new int[n + 1][n + 1];

			for (int i = 0; i < results.length; i++) {
				graph[results[i][0]][results[i][1]] = 1;
				graph[results[i][1]][results[i][0]] = -1;
			}

			for (int k = 1; k <= n; k++) { // 들렀다 가는곳
				for (int i = 1; i <= n; i++) { // 시작
					for (int j = 1; j <= n; j++) { // 도착
						if (i == j || graph[i][j] != 0) continue;
						if (graph[i][k] == graph[k][j]) graph[i][j] = graph[i][k];
					}
				}
			}

	 loop: for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) continue;
					if (graph[i][j] == 0) continue loop;
				}
				answer++;
			}
			return answer;
		}

	}

	public static void main(String[] args) {
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 }

		};
		System.out.println(new Solution().solution(5, results));
	}

}
