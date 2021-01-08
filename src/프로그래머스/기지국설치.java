package 프로그래머스;

public class 기지국설치 {
	static class Solution {
		public int solution(int n, int[] stations, int w) {
			int answer = 0;

			int start = 1, right = 0, left = 0, empty;
			for (int i = 0; i < stations.length; i++) {
				left = stations[i] - w; //전파범위 왼쪽 끝
				right = stations[i] + w; //전파범위 오른쪽 끝

				empty = left - start; //왼쪽에 빈공간 구해주기
				if (empty > 0) { // 왼쪽 비었으면
					answer+=build(empty,w); //몇개 설치 ?
				}
				start = right + 1;
			}

			if (start == n) answer += 1; //끝이 16인데 start가 16이면 1개 설치
			else if (start < n) { // 맨 마지막 오른쪽 범위 남았으면
				empty = n - start + 1;
				answer+=build(empty,w);
			}
			return answer;
		}

		private int build(int empty, int w) {
			int result=empty / (2 * w + 1); //나누어 떨어지면 딱 그 개수만큼
			if (empty % (2 * w + 1) == 0)  return result; //안나누어 떨어지면 +1
			else return result+1;
		}
	}

	public static void main(String[] args) {
		int[] stations = { 9 };
		System.out.println(new Solution().solution(16, stations, 2));

	}

}
