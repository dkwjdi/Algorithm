package 시뮬레이션;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20055_컨베이어벨트 {
	static int N, K, belt[][], robot[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2][N + 1];
		robot = new int[2][N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			belt[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N; i > 0; i--) {
			belt[1][i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve());
	}

	private static int solve() {
		int cnt = 0;

		while (true) {
			cnt++;
			// 1
			rotate(belt);
			rotate(robot);
			robot[0][N] = 0; // N번자리에 있으면 로봇 내림

			// 2
			move();
			robot[0][N] = 0; // N번자리에 있으면 로봇 내림

			// 3
			insert();
			if (check())
				return cnt;
			
		}

	}


	private static void move() {
		for(int i=N-1; i>=0; i--) {
			if(robot[0][i]==1 && belt[0][i+1] >=1 && robot[0][i+1]==0) { //로봇있고 바로 앞칸에 내구도 1이상이면 
				robot[0][i]=0;
				robot[0][i+1]=1;
				belt[0][i+1]--;
			}
		}
	}

	private static boolean check() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (belt[0][i] == 0)
				cnt++;
			if(belt[1][i]==0)
				cnt++;
		}
		if (cnt >= K)
			return true;
		return false;
	}


	private static void insert() {
		if (belt[0][1] >= 1 && robot[0][1] == 0) { // 내구도가 0보다 크고 , 로봇이 없다면
			belt[0][1]--; //내구도줄이고 
			robot[0][1] = 1; //로봇올리고
		}

	}

	private static void rotate(int[][] rot) {
		// 맨위
		int save = rot[0][N];
		int save2 = rot[1][1];
		for (int i = N - 1; i > 0; i--) {
			rot[0][i + 1] = rot[0][i];
		}
		// 아래부분
		for (int i = 1; i < N; i++) {
			rot[1][i] = rot[1][i + 1];
		}
		rot[1][N] = save;
		rot[0][1] = save2;
	}

}
