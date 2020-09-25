package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13300_방배정 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken()); //학생수 
		int k=Integer.parseInt(st.nextToken()); //한방의 최대 학생수
		int studentNum[][]=new int[7][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken()) ,age=Integer.parseInt(st.nextToken());
			studentNum[age][s]+=1;
		}
		int cnt=0;
		for(int i=1; i<7; i++) {
			for(int j=0; j<=1; j++) {
				if(studentNum[i][j]!=0) { //학생이 있다면!
					cnt+=roomCnt(studentNum[i][j],k);
				}
			}
		}
		System.out.println(cnt);
	}

	private static int roomCnt(int studentNum, int k) {
		int cnt=0;
		while(true) {
			studentNum-=k;
			cnt++;
			if(studentNum<=0) return cnt;
		}
	}
}
