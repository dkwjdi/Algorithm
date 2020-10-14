package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15685_드래곤커브 {
	static class Dragon {
		int x, y, d, g;

		public Dragon(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}

	static boolean visited[][] = new boolean[101][101];
	static List<Dragon> list;
	static int N,result;
	static int map[][] = new int[4][1024];

	public static void main(String[] args) throws NumberFormatException, IOException {
		list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			list.add(new Dragon(x, y, d, g));
		}
		mapdraw();
		start();
		System.out.println(result);

	}

	private static void start() {
		for (int i = 0; i < N; i++) {
			Dragon dragon = list.get(i);
			int x = dragon.x;
			int y = dragon.y;
			int d = dragon.d;
			visited[x][y] = true;
			int maxindex = (int) Math.pow(2, dragon.g);
			for (int j = 0; j < maxindex; j++) {
				if (map[d][j] == 0)
					x++;
				else if (map[d][j] == 1)
					y--;
				else if (map[d][j] == 2)
					x--;
				else
					y++;
				
				visited[x][y] = true;

			}
		}
		
		count();

		

	}

	private static void count() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
					result++;
				}
			}
		}
		
	}

	private static void mapdraw() {
		map[0][0] = 0;
		map[1][0] = 1;
		map[2][0] = 2;
		map[3][0] = 3;

		for (int i = 0; i < 4; i++) {
			int size = 1;
			for (int j = 1; j <= 10; j++) {
				int start = 0;
				size *= 2;
				int tmpsize = size;
				while (true) {
					tmpsize--;
					map[i][tmpsize] = (map[i][start] + 1) % 4;

					if (++start == tmpsize)
						break;
				}
			}
		}
	}
}
