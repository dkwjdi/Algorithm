package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 무선충전 {
	static class BC {
		int x, y, coverge, power;

		public BC(int x, int y, int coverge, int power) {
			this.x = x;
			this.y = y;
			this.coverge = coverge;
			this.power = power;
		}
	}

	static int inputTime, inputBc, A[], B[], Ax, Ay, Bx, By, result;
	static int dx[] = { 0, -1, 0, 1, 0 }; // 상 우 하 좌
	static int dy[] = { 0, 0, 1, 0, -1 };
	static List<BC> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			input();
			for (int i = 0; i <= inputTime; i++)
				move(i);
			sb.append("#"+tc+" "+result+"\n");
			result = 0;
		}
		System.out.println(sb);
	}

	private static void move(int time) {
		if(time==inputTime) {
			result+=solve(Ax, Ay, Bx, By);
			return ;
		}
		result+=solve(Ax, Ay, Bx, By);
		//System.out.println(result);
		Ax += dx[A[time]];
		Ay += dy[A[time]];
		Bx += dx[B[time]];
		By += dy[B[time]];
	}

	private static int solve(int ax, int ay, int bx, int by) {
		int apower[] =new int[inputBc];
		int bpower[] =new int[inputBc];
		int sum = 0;
		for (int i = 0; i < inputBc; i++) {
			BC bc = list.get(i);
			if (inRange(ax, ay, bc))
				apower[i]=bc.power;
			if (inRange(bx, by, bc))
				bpower[i]=bc.power;
		}
		for (int x = 0; x < inputBc; x++) {
			for (int y = 0; y < inputBc; y++) {
		
				if (x == y )
					sum = Math.max(sum, Math.max(apower[x], bpower[x]));
				else
					sum = Math.max(sum, apower[x] +bpower[y]);
			}
		}
		return sum;
	}

	private static boolean inRange(int ax, int ay, BC bc) {
		if (Math.abs(ax - bc.x) + Math.abs(ay - bc.y) <= bc.coverge)
			return true;
		return false;
	}

	private static void input() throws IOException {
		Ax = 1;
		Ay = 1;
		Bx = 10;
		By = 10;
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		inputTime = Integer.parseInt(st.nextToken());
		inputBc = Integer.parseInt(st.nextToken());

		A = new int[inputTime];
		B = new int[inputTime];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < inputTime; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < inputTime; i++)
			B[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < inputBc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int coverage=Integer.parseInt(st.nextToken());
			int power=Integer.parseInt(st.nextToken());
			list.add(new BC(y,x,coverage,power));
		}
	}

}
