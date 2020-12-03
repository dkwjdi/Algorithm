package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136_색종이붙이기 {
	static int map[][], totalCnt, paperCnt, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		map = new int[10][10];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					totalCnt++;
			}
		}
		int visited[][] = new int[10][10];
		int cntArray[] = new int[6];
		dfs(visited, 0, 0, -1, -1,-1, cntArray);
		
		if(result==Integer.MAX_VALUE) result=-1;
		System.out.println(result);
	}

	private static void dfs(int[][] visited, int oneCnt, int paperCnt,int x, int y,int kk, int cntArray[]) {
		if(result<=paperCnt) return ;
		if (oneCnt == totalCnt) {
			for(int i=1; i<=5; i++) {
				if(cntArray[i]>5) return ;
			}
			result = Math.min(result, paperCnt);
			return;
		}
		
		
		for(int i=1; i<=5; i++) {
			if(cntArray[i]>5) return ;
		}
		
		if(x!=-1)	visitedCheck(x, y, kk, visited);
		

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1 && visited[i][j]==0) {
					for (int k = 5; k >= 1; k--) {
						if (sizeCheck(i, j, k, visited)) {
							int tmpVisited[][] = copyVisited(visited);
							cntArray[k]++;
							dfs(tmpVisited, oneCnt + k*k, paperCnt + 1,i,j,k,cntArray);
							cntArray[k]--;
						}
					}
					return;
				}
			}
		}

	}

	private static void visitedCheck(int i, int j, int k, int[][] visited) {
		for (int x = i; x < i + k; x++) {
			for (int y = j; y < j + k; y++) {
				visited[x][y] = k;
			}
		}

	}

	private static int[][] copyVisited(int[][] visited) {
		int tmpVisited[][] = new int[10][10];
		for (int i = 0; i < 10; i++) {
			System.arraycopy(visited[i], 0, tmpVisited[i], 0, 10);
		}
		return tmpVisited;
	}

	private static boolean sizeCheck(int i, int j, int k, int[][] visited) {
		if (i + k-1 > 9 || j + k-1 > 9)
			return false; // 색종위가 범위 넘어가면 false

		for (int x = i; x < i + k; x++) {
			for (int y = j; y < j + k; y++) {
				if(x==i && y==j) continue;
				if (map[x][y] != 1 || visited[x][y]>0)
					return false;
			}
		}
		return true;
	}

}
