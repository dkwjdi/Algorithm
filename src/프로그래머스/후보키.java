package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
	static class Solution {
		int []arr;
		List<String> key;
	    public int solution(String[][] relation) {
	        int col=relation[0].length;
	        int row=relation.length;
	        arr=new int[col];
	        key=new ArrayList<>();
	        
	        for(int i=1; i<=col; i++) {
	        	combination(0,0,i,col,row,relation);
	        }
	        return key.size();
	    }

		private void combination(int cnt, int start, int end, int col, int row, String[][] relation) {
			if(cnt==end) {
				String checkKey="";
				for(int i=0; i<end; i++) {
					checkKey+=arr[i];
				}
				
				if(!minimality(end,checkKey)) return; //최소성 체크 
				uniqueness(end,col,row,relation,checkKey); //유일성 체크
				return;
			}
			for(int i=start; i<col; i++) {
				arr[cnt]=i;
				combination(cnt+1, i+1,end, col, row,relation);
			}
		}

		private void uniqueness(int end, int col, int row, String[][] relation, String checkKey) {
			Set<String> tmpKey = new HashSet<>();
			
			for(int i=0; i<row; i++) {
				String str="";
				for(int j=0; j<end; j++) {
					str+=relation[i][arr[j]];
				}
				tmpKey.add(str);
			}
			if(tmpKey.size()==row) key.add(checkKey); //유일성만족
			return;
		}

		private boolean minimality(int end, String checkKey) {
			int size=key.size();
			
			for(int i=0; i<size; i++) {
				String cKey=key.get(i);
				int len=cKey.length();
				int cnt=0;
				for(int j=0; j<cKey.length(); j++) {
					if(checkKey.contains(cKey.substring(j, j+1))) cnt++;
				}
				if(len==cnt) return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		String[][] relation = { 
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
		System.out.println(new Solution().solution(relation));
	}

}
