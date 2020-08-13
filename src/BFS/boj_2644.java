package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2644 {

	static int chonsu[][], N, men1, men2, cnt,flag;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		 N = sc.nextInt();
		men1 = sc.nextInt();
		men2 = sc.nextInt();

		chonsu = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			chonsu[from][to] = chonsu[to][from] = 1;
		}
		
		bfs();
		System.out.println((flag == 1) ? cnt : -1);
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(men1);
		visit[men1]=true;

		while (!queue.isEmpty()) {

			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				int tmp = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (chonsu[tmp][j] == 1 && visit[j] == false) {
						queue.offer(j);
						if(j==men2) {
							flag=1;
							cnt++;
							return ;
						}
						visit[j] = true;
					}
				}
			}

			cnt++;
			System.out.println(cnt);
		}
	}

}
