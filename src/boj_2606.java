
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2606 {

	static int computer[][],cnt,NumberOfComputer;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NumberOfComputer=sc.nextInt();
		
		computer=new int[NumberOfComputer+1][NumberOfComputer+1];
		visit=new boolean[NumberOfComputer+1];
		
		int N=sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			int from= sc.nextInt();
			int to= sc.nextInt();
			computer[from][to]=1;
			computer[to][from]=1;
		}
		//////입력 끝
		
		bfs(1);
		System.out.println(cnt);

	}

	private static void bfs(int start) {
		
		Queue<Integer> queue= new LinkedList<>();
		queue.offer(start);
		visit[start]=true;
		
		while(!queue.isEmpty()) {
			int tmp=queue.poll();
			for(int i=1; i<=NumberOfComputer; i++) {
				if(computer[tmp][i]==1 && visit[i]==false) {
					queue.offer(i);
					visit[i]=true;
					cnt++;
				}
			}
		}
		
	}

}