package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14696_딱지놀이 {
	static List <Integer>playerA;
	static List <Integer>playerB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int R=Integer.parseInt(br.readLine());
		
		for(int r=0; r<R; r++) {
			playerA = new ArrayList<>();
			playerB = new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int Acnt=Integer.parseInt(st.nextToken());
			for(int i=0; i<Acnt; i++) {
				playerA.add(Integer.parseInt(st.nextToken()));
			}
			st=new StringTokenizer(br.readLine()," ");
			int Bcnt=Integer.parseInt(st.nextToken());
			for(int i=0; i<Bcnt; i++) {
				playerB.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(playerA, Collections.reverseOrder());
			Collections.sort(playerB, Collections.reverseOrder());
			int length=Math.min(Acnt, Bcnt);
			if(!check(length)) System.out.println("D");;
		}
	}

	private static boolean check(int length) {
		for(int i=0; i<length; i++) {
			if(playerA.get(i)>playerB.get(i)) {
				System.out.println("A");
				return true;  
			}
			else if(playerA.get(i)<playerB.get(i)) {
				System.out.println("B");
				return true;
			}
			
			if(i==length-1) {
				if(playerA.size()>playerB.size()) {
					System.out.println("A");
					return true;
				}
				else if(playerA.size()<playerB.size()) {
					System.out.println("B");
					return true;
				}
				
			}
		}
		return false;
	}

}
