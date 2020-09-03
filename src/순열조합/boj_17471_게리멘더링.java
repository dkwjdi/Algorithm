package 순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17471_게리멘더링 {
	static List<Integer>[] list;
	static boolean isSelected[], isSelected2[];
	static int input[], N, sector1[], sector2[], population[];
	static int min=999999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input = new int[N];
		sector1 = new int[N];
		sector2 = new int[N];
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		population = new int[N];
		String data = br.readLine();
		StringTokenizer st = new StringTokenizer(data);
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			data = br.readLine();
			st = new StringTokenizer(data);
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				list[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		for (int i = 0; i < N; i++) {
			input[i] = i;
		}
		isSelected = new boolean[N];
		isSelected2 = new boolean[N];
		generateSubset(0);

	}

	private static void generateSubset(int cnt) {

		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			int index1 = 0;
			int index2 = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					sector1[index1++] = i;
				else
					sector2[index2++] = i;
			}

			if (index1 == 0 || index2 == 0)
				return;

			if(connectCheck(index1, index2)) solve();
			return;
		}
		isSelected[cnt] = true; // 부분집합 구성에 포함
		generateSubset(cnt + 1); // 다음원소로
		isSelected[cnt] = false; // 부분집합 구성에 포함 x
		generateSubset(cnt + 1); // 다음원소로
	}

	private static void solve() {
		
	}

	private static boolean connectCheck(int index1, int index2) {

		// 첫번재 선거구 연결 확인
		Queue<Integer> queue = new LinkedList<>();
		queue.add(sector1[0]);
		isSelected2[sector1[0]] = true;
		int flag=0;

		while (!queue.isEmpty()) {
			int check=queue.poll();
			
			int size= list[check].size();
			
			for(int i=0; i<size; i++) {
				int tmp=list[check].get(i);
				
				for(int j=0 ;j<index1; j++) {
					if(sector1[j]==tmp) flag=1;
				}
				
				if(flag==1 && !isSelected2[sector1[check]]) {
					queue.offer(tmp);
					isSelected2[tmp]=true;
				}
				
				
			}
		}
		
		for(int i=0; i<index1; i++) {
			if(isSelected2[i]==false) return false;
		}
		return true;

	}

}
