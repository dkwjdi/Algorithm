package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {
	static int D, W, K, map[][], copy[][], numbers[], result;
	static boolean subSetVisit[], permutationVisit[], permutationFlag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			permutationFlag = false;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D + 1][W + 1];
			subSetVisit = new boolean[D + 1];
			permutationVisit = new boolean[D + 1];
			numbers = new int[D + 1];
			for (int i = 1; i <= D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (passCheck(map)) {
				sb.append("#" + tc +" "+ 0 + "\n");
			} else {
				for(int i=1; i<=D; i++) {
					solve(1,1,i);
				}
				sb.append("#" + tc +" "+ result + "\n");
			}
		}

		System.out.println(sb);
	}

	private static boolean passCheck(int[][] checkMap) {
		int cnt = 0;
		for (int i = 1; i <= W; i++) {
			cnt = 0;
			for (int j = 1; j < D; j++) {
				if (cnt == K - 1)
					continue ;
				if (checkMap[j][i] == checkMap[j + 1][i])
					cnt++;
				else
					cnt = 0;
			}
			if(cnt!=K-1) return false;
		}
		return true;
	}

	private static void solve(int cnt, int start, int end) {
		if (result>0)	return;
		if (cnt == end+1) {
			int trueCnt = 0;
			for (int i = 1; i <= D; i++) {
				if (subSetVisit[i])
					trueCnt++;
			}
			permutation(trueCnt, 0);
			if (permutationFlag) {
				result = trueCnt;
				return;
			}
			return;
		}
		
		for(int i=start; i<=D; i++) {
			subSetVisit[i]=true;
			solve(cnt+1,i+1,end);
			subSetVisit[i]=false;
		}
		
	}

	private static void permutation(int trueCnt, int cnt) {
		if (trueCnt == 0 || permutationFlag)
			return;
		if (trueCnt == cnt) {
			copyMap();

			int numberindex = 0;
			for (int i = 1; i <= D; i++) {
				if (subSetVisit[i]) { // 정해놓은 자리에다가
					fillWidth(i, numbers[numberindex++]); // 약품처리해주고
				}
			}
			if (passCheck(copy)) { // 통과할 수 있는지 체크 한다. 만약 통과가 된다면!!
				permutationFlag = true;
				return;
			}
			return;
		}
		for (int i = 0; i <= 1; i++) {
			numbers[cnt] = i;
			permutation(trueCnt, cnt + 1);
		}

	}
	private static void fillWidth(int row, int number) {
		for (int j = 1; j <= W; j++) {
			copy[row][j] = number;
		}
	}
	private static void copyMap() {
		copy = new int[D + 1][W + 1];
		for (int i = 1; i <= D; i++) {
			for (int j = 1; j <= W; j++) {
				copy[i][j] = map[i][j];
			}
		}

	}
}



 