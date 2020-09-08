package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014_스타트링크 {
	static int F,S,G,U,D,cnt; 
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 총 F층
		S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는곳 S
		G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 곳 위치 G
		U = Integer.parseInt(st.nextToken()); // U위로 가는 버튼
		D = Integer.parseInt(st.nextToken()); // D아래로 가는 버튼
		
		visited = new boolean[F+1];

		if(bfs(S)) System.out.println(cnt);
		else System.out.println("use the stairs");
	}

	private static boolean bfs(int floor) {
		int[] dx = { -D, U };
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		visited[S]=true;

		while (queue.size()!=0) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				if(tmp==G) return true ;

				for (int d = 0; d < 2; d++) {
					int nx = tmp + dx[d];

					if (nx < 1 || nx > F || visited[nx])
						continue;
					queue.offer(nx);
					visited[nx]=true;
				}
			}
			cnt++;
		}
		return false;
	}
}
