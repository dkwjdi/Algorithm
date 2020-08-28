package BOJ길라잡이베타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj_2750_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		List <Integer> list= new ArrayList<>();
		
		int N=Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		for(int tmp:list) {
			sb.append(tmp+"\n");
		}
		System.out.println(sb);
	}

}
