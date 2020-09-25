package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2304_창고다각형 {
	static class Info implements Comparable<Info> {
		int spot;
		int height;

		public Info(int spot, int height) {
			this.spot = spot;
			this.height = height;
		}

		public int compareTo(Info o) {
			return this.spot - o.spot;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Info> list = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);
		
		int sum=0;
		int size = list.size();
		int height = 0;
		for (int i = 0; i < size - 1; i++) {
			Info one = list.get(i);
			Info two = list.get(i + 1);

			if(one.height<two.height) { //그다음 기둥이 더 높을 때
				if(one.spot+1==two.spot) { //바로 다음 spot에 있을 때
					sum+=one.height;
				}
				else {  //spot이 1이상 떨어져 있을 때
					sum+=(two.spot-one.spot)*one.height;
				}
			}

		}

	}
}
