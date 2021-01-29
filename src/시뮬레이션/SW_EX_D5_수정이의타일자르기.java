package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_EX_D5_수정이의타일자르기 {
	static class Rect{
		int width, height;
		public Rect(int width, int height ) {
			this.width = width;
			this.height = height;
		}
	}
	static int N, M, result;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list=new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add((int) Math.pow(2, Double.parseDouble(st.nextToken())));
			}
			
			Collections.sort(list);
			
			System.out.println("#" + tc + " " + solve());
			result = 0;
		}
	}
	private static int solve() {
		int cnt=0;
		while(cnt!=N) {
			if(list.size()==0) break;
			cnt++;
			Queue<Rect> queue = new LinkedList<>();
			queue.add(new Rect(M,M));
			
			for(int i=list.size()-1; i>=0; i--) {
				int len = list.get(i);
				//System.out.println(queue.size());
				int size=queue.size();
				for(int j=0; j<size; j++) {
					Rect rect= queue.poll();
					
					 if(rect.height>=len && rect.width>=len) {
						queue.add(new Rect(len, rect.height-len));
						queue.add(new Rect(rect.width-len ,rect.height));
						list.remove(i);
						break;
					}
				}
				
			}
			
	
		}
		return cnt;
	}

}
