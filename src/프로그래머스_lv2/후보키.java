package 프로그래머스_lv2;

import java.util.HashMap;
import java.util.HashSet;

public class 후보키 {
	static class Solution {
		public int solution(String[][] relation) {
			
			HashMap<String, String> key=new HashMap<>();
//			System.out.println(key.size());
			int []combiArr=new int[10];
//			System.out.println(relation.length);
//			System.out.println(relation[0].length);
			for(int i=1; i<=relation[0].length; i++) { //1부터 컬럼길이만큼 1~8
				combination(key,combiArr, relation, 0,0, i);
			}
			return key.size();
		}

		private void combination(HashMap<String, String> key, int[] combiArr, String[][] relation, int cnt, int start, int end) {
			if(cnt==end) {
//				System.out.println(Arrays.toString(combiArr));
//				System.out.println("d");
				//후보키 될려는게 뭐인지 알아내고
				StringBuilder sb= new StringBuilder();
				for(int i=0; i<end; i++) {
					sb.append(combiArr[i]);
				}

				// 최소성 만족해야함
				if(!Minimalism(combiArr,relation,end,key,sb.toString())) return;

				
				//유일성 체크 튜플들을 다 더해서 set에 있는지 없는지 확인 
				if(!unique(combiArr,relation,end)) return;
				
				
//				System.out.println(sb.toString());
				//후보키에 추가해주기
				key.put(sb.toString(), "1");
				
				return;
			}
			for(int i=start; i<relation[0].length; i++) {
				combiArr[cnt]=i;
				combination(key, combiArr, relation, cnt+1, i+1, end);
				
			}
		}

		private boolean Minimalism(int[] combiArr, String[][] relation, int end, HashMap<String, String> key, String candidateKey) {
			for(String realKey:key.keySet()) {
				int cnt=0;
				for(int i=0; i<realKey.length(); i++) {
					if(candidateKey.contains(String.valueOf(realKey.charAt(i)))) cnt++;
					
				}
				if(cnt==realKey.length()) return false;
				
			}
			return true;
		}

		private boolean unique(int[] combiArr, String[][] relation, int end) {
			HashSet<String> set= new HashSet<>();
			
			for(int i=0; i<relation.length; i++) {
				StringBuilder sb= new StringBuilder();
				for(int j=0; j<end; j++) {
					sb.append(relation[i][combiArr[j]]);
				}
				
				if(sb.toString().equals("")) continue;
				if(set.contains(sb.toString())) return false;
				set.add(sb.toString());
			}
			// TODO Auto-generated method stub
			return true;
		}
	}

	public static void main(String[] args) {
		String[][] relation = { 
				{ "100", "ryan", "music", "2" }, 
				{ "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, 
				{ "400", "con", "computer", "4" }, 
				{ "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
				
		System.out.println(new Solution().solution(relation));
	}
}
