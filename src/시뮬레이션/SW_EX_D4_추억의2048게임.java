package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_EX_D4_추억의2048게임 {

	static int N;
	static int widthmap[][], heightmap[][];
	static String input;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			input = st.nextToken();
			widthmap = new int[N][N];
			heightmap = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {

					widthmap[i][j] = Integer.parseInt(st.nextToken());
					heightmap[j][i] = widthmap[i][j];
				}
			}
			
			System.out.println("#"+tc);
			solve();
			

		}
	}

	private static void solve() {
		if (input.equals("right")) {
			rightAndDown(widthmap);
			printWeight(widthmap);
		} else if (input.equals("down")) {
			rightAndDown(heightmap);
			printHeigh(heightmap);
			
		} else if (input.equals("left")) {
			leftAndUp(widthmap);
			printWeight(widthmap);
		} else { // up
			leftAndUp(heightmap);
			printHeigh(heightmap);
		}

	}

	private static void printWeight(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void printHeigh(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[j][i]+" ");
			}
			System.out.println();
		}
		
	}

	private static void leftAndUp(int[][] map) {
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			out :for (int j = 1; j <N; j++) {
				if (map[i][j] == 0)
					continue; // 0이면 그냥 넘어감
				
				int index = j; // 합쳐질 숫자 인덱스
				while (true) { // 중간에 0이 있으면 쭉 땡겨줌
					if ( (index==0) ||(map[i][index-1] != 0) )
						break;
					else {
						map[i][index-1]=map[i][index];
						map[i][index]=0;
						if(--index==0) continue out;
					}
				}
				if(map[i][index-1]==0) {
					map[i][index-1]=map[i][index];
					map[i][index]=0;
				}
				else if ((!visited[index-1] && 
						map[i][index-1] == map[i][index])) {// 새롭게 만들어진거 아니고 두개 숫자가 같다면
					map[i][index-1] *= 2; // 곱하기 2해주고
					map[i][index] = 0; // 원래 자리는 0으로 바꿔준다.
					visited[index-1]=true;
				}

			}
		}

	}

	

	private static void rightAndDown(int[][] map) {

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			out :for (int j = N-2; j >=0; j--) {
				if (map[i][j] == 0)
					continue; // 0이면 그냥 넘어감
				
				int index = j; // 합쳐질 숫자 인덱스
				while (true) { // 중간에 0이 있으면 쭉 땡겨줌
					if ( (index==N-1) ||(map[i][index+1] != 0) )
						break;
					else {
						map[i][index+1]=map[i][index];
						map[i][index]=0;
						if(++index==N-1) continue out;
					}
				}
				if(map[i][index+1]==0) {
					map[i][index+1]=map[i][index];
					map[i][index]=0;
				}
				else if ((!visited[index+1] && 
						map[i][index+1] == map[i][index])) {// 새롭게 만들어진거 아니고 두개 숫자가 같다면
					map[i][index+1] *= 2; // 곱하기 2해주고
					map[i][index] = 0; // 원래 자리는 0으로 바꿔준다.
					visited[index+1]=true;
				}

			}
		}

	}

}
