package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 보물상자비밀번호 {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			Set <String> set = new HashSet<>();
			String number=br.readLine();
			int size=N/4;
			
			for(int i=0; i<size; i++) { //회전 수
				int begin=0;
				int end=size;
				for(int j=0; j<4; j++) { //잘라내는 숫자 
					//System.out.println(number.substring(begin, end));
					set.add(number.substring(begin, end));
					begin+=size;
					end+=size;
				}
				//number 오른쪽으로 한칸씩 이동 
				number=number.substring(number.length()-1,number.length())+number.substring(0,number.length()-1);
				
			}
			List<String> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			sb.append("#"+tc+" "+Integer.parseInt(list.get(K-1),16)+"\n");
			
		}
		System.out.println(sb);
	}

}
