package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17471_게리맨더링 {
	static int N;
	static int[] population;
	static List<Integer> list[];
	static boolean visited[];
	static int  result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		N = Integer.parseInt(br.readLine());
		list = new List[N + 1];
		population = new int[N + 1];
		visited = new boolean[N + 1];
		result = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		powerSet(1);
		if(result==Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}

	private static void powerSet(int cnt) {
		if(cnt==N+1) {
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();
			
			if(isBound(first, second)) { // 한쪽으로 치우친게 아니라면!
				if(bfs(first,0) && bfs(second,1)) {
					calPopulation();
				}
			}
			return;
		}
		
		visited[cnt]=true;
		powerSet(cnt+1);
		visited[cnt]=false;
		powerSet(cnt+1);
	}

	private static void calPopulation() {
		int sum1=0, sum2=0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) sum1+=population[i];
			else sum2+=population[i];
		}
		result=Math.min(result, Math.abs(sum1-sum2));
	}

	private static boolean bfs(List<Integer> first, int mode) {
		if(first.size()==1) return true;
		
		boolean bfsVisited[]= new boolean[N+1];
		Queue <Integer> queue = new LinkedList<>();
		int tmp = first.remove(0);
		queue.offer(tmp);
		bfsVisited[tmp]=true;
		
		while(!queue.isEmpty()) {
			int area=queue.poll();
			
			for(int i=0; i<list[area].size(); i++) {
				int num=list[area].get(i);
				if(check(num,first, bfsVisited)) { //아직 선택 안됬고 갈 수 있는 놈
					bfsVisited[num]=true;
					queue.offer(num);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(mode==0) { //first
				if(bfsVisited[i] != visited[i]) return false;
			}
			else if(mode ==1) { // second
				if(bfsVisited[i] == visited[i]) return false;
			}
		}
		return true;
	}

	private static boolean check(int num, List<Integer> first, boolean[] bfsVisited) {
		for(int i=0; i<first.size(); i++) {
			if(num==first.get(i) && !bfsVisited[num]) {
				first.remove(i);
				return true;
			}
		}
		return false;
	}

	private static boolean isBound(List<Integer> first, List<Integer> second) {
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				cnt++;
				first.add(i);
			}
			else second.add(i);
		}
		
		if(cnt==0 || cnt==N) return false;
		return true;
	}
}
