package IM대비문제;

import java.util.Scanner;

public class boj_2628_종이자르기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt(), x = sc.nextInt();
		boolean yarr[] = new boolean[y + 1];
		boolean xarr[] = new boolean[x + 1];
		boolean flagx = false, flagy = false; // x, y 중 한번도 한잘린거 있으면 체크해줄거

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int zeroone = sc.nextInt();
			if (zeroone == 1) {
				yarr[sc.nextInt()] = true; // 잘렷다면 true
				flagy = true;
			} else {
				xarr[sc.nextInt()] = true; // 잘렷다면 true
				flagx = true;
			}
		}
		System.out.println(solve(y, yarr, flagy) * solve(x, xarr, flagx));

	}

	private static int solve(int xy, boolean[] xyarr, boolean flag) {
		if (!flag) return xy; // 만약 한번도 안잘렷다면 크기 바로 반환
		int cnt = 0; //길이 측정 
		int maxcnt = 0; //최장 길이측정 
		for (int i = 1; i <= xy; i++) {
			cnt++;
			if (xyarr[i]) { //만약 true만나면
				maxcnt = Math.max(cnt, maxcnt); //maxcnt 와 cnt 비교해서 큰거넣어줌
				cnt = 0;
			}
		}
		return Math.max(cnt, maxcnt); //마지막 부분에서 true안나오고 끝나는데 가장 긴 것 존재할수 있으니 max함수 써서 반환
	}
}
