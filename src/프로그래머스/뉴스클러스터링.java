package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 뉴스클러스터링 {
	static class Solution {
		public int solution(String str1, String str2) {
			
			List<String> strSet1 = new ArrayList<>();
			List<String> strSet2 = new ArrayList<>();
			
			
			inputStr(strSet1, str1.toUpperCase().trim());
			inputStr(strSet2, str2.toUpperCase().trim());
			
			if(strSet1.size()==0 && strSet2.size()==0) return 65536;

			HashMap<String, Integer> strMap1 = new HashMap<>();
			HashMap<String, Integer> strMap2 = new HashMap<>();

			inputStr2(strMap1, strSet1);
			inputStr2(strMap2, strSet2);
			
			double result1= intersection(strMap1, strMap2);
			if(result1==0) {
				System.out.println(0);
				return 0;
			}
			double result2=union(strMap1, strMap2);
			
			double result= (result1/result2)*65536;
			System.out.println((int)result);
			return (int)result;
		}

		private double union(HashMap<String, Integer> strMap1, HashMap<String, Integer> strMap2) {
			int sum = 0;
			for (String str : strMap1.keySet()) {
				if (strMap2.containsKey(str)) sum += Math.max(strMap1.get(str), strMap2.get(str));
				else sum += strMap1.get(str);
			}
			
			for (String str : strMap2.keySet()) {
				if (strMap1.containsKey(str)) continue;
				else sum += strMap2.get(str);
			}
			return sum;
		}

		private double intersection(HashMap<String, Integer> strMap1, HashMap<String, Integer> strMap2) {
			int sum = 0;
			for (String str : strMap1.keySet()) {
				if (strMap2.containsKey(str)) sum += Math.min(strMap1.get(str), strMap2.get(str));
			}
			return sum;
		}

		private void inputStr2(HashMap<String, Integer> strMap, List<String> strSet) {
			for (String str : strSet) {
				if (strMap.containsKey(str))
					strMap.put(str, strMap.get(str) + 1);
				else
					strMap.put(str, 1);
			}
		}

		private void inputStr(List<String> strSet, String str) {
			for (int i = 0; i < str.length() - 1; i++) {
				StringBuilder sb = new StringBuilder();

				char first = str.charAt(i);
				char second = str.charAt(i + 1);

				if ((65>first || 90<first)  || (65>second || 90<second))
					continue;

				sb.append(first);
				sb.append(second);

				strSet.add(sb.toString());
			}

		}
	}

	public static void main(String[] args) {
		new Solution().solution("AA_bb_aa_AA", "BBB");
	}
}
