package 프로그래머스;

import java.util.Arrays;

public class 입국심사 {
	static class Solution {
		long answer;

		public long solution(int n, int[] times) {
			answer = Long.MAX_VALUE;
			long nn=n;
			Arrays.sort(times); // 시간순으로

			long left = 1;
			long right = times[times.length - 1] * nn;
			long mid = 0;
			long people = 0;

			while (left <= right) {
				people = 0;
				mid = (left + right) / 2;

				for (int i = 0; i < times.length; i++) {
					people += mid / times[i];
					if (people > nn) {// 너무 큼 숫자를 줄여야 함
						break;
					}
				}

				if (people < nn) { // 시간 부족 시간 늘려야 함
					left = mid + 1;
				} else { // 시간 충분
					right = mid - 1;
					answer = Math.min(answer, mid);
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] times = { 7, 10 };
		System.out.println(new Solution().solution(6, times));

	}

}