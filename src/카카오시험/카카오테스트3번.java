package 카카오시험;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//1시간 25분

public class 카카오테스트3번 {
	static class Solution {
		public int[] solution(String[] info, String[] query) {
			
			HashMap<String , List<Integer>> infoList = new HashMap<>();
			List<Integer> answerList= new ArrayList<>();
			//언어, 지원직군, 경력, 소울푸드, 점수
			
			for(int i=0; i<info.length; i++) {
				StringBuilder sb= new StringBuilder();
				String [] infos=info[i].split(" ");
				sb.append(infos[0]).append(infos[1]).append(infos[2]).append(infos[3]);
				String key=sb.toString();
				if(infoList.containsKey(key)) 
					infoList.get(key).add(Integer.parseInt(infos[4]));
				else {
					infoList.put(key, new ArrayList<>());
					infoList.get(key).add(Integer.parseInt(infos[4]));
				}
			}
			
			for(int i=0; i<query.length; i++) {
				List<String> lang= new ArrayList<>();
				List<String> position= new ArrayList<>();
				List<String> career= new ArrayList<>();
				List<String> food= new ArrayList<>();
				query[i]=query[i].replace("and", "").replace("  ", " ");
				String [] querys=query[i].split(" ");
				
				if(querys[0].equals("-")) {
					lang.add("cpp");
					lang.add("java");
					lang.add("python");
				}
				else lang.add(querys[0]);
				
				if(querys[1].equals("-")) {
					position.add("backend");
					position.add("frontend");
				}
				else position.add(querys[1]);
				
				if(querys[2].equals("-")) {
					career.add("junior");
					career.add("senior");
				}
				else career.add(querys[2]);
				
				if(querys[3].equals("-")) {
					food.add("chicken");
					food.add("pizza");
				}
				else food.add(querys[3]);
				
				answerList.add(solve(lang,position,career,food,querys[4],infoList));
			}
			
			int [] answer= new int[answerList.size()];
			
			for(int i=0; i<answerList.size(); i++) answer[i]=answerList.get(i);
			return answer;
		}

		private int solve(List<String> lang, List<String> position, List<String> career, List<String> food,String score, HashMap<String, List<Integer>> infoList) {
			String [] info= new String[4];
			int cnt=0;
			int num=Integer.parseInt(score);
			
			for(int i=0; i<lang.size(); i++) {
				info[0]=lang.get(i);
				for(int j=0; j<position.size(); j++) {
					info[1]=position.get(j);
					for(int k=0; k<career.size(); k++) {
						info[2]=career.get(k);
						for(int z=0; z<food.size(); z++) {
							info[3]=food.get(z);
							
							//여기서 확인 해서 카운트 올려줌 
							StringBuilder sb= new StringBuilder();
							sb.append(info[0]).append(info[1]).append(info[2]).append(info[3]);
							String key=sb.toString();
							
							int size=0;
							if(infoList.containsKey(key)) size=infoList.get(key).size();
							
							for(int d=0; d<size; d++) {
								if(infoList.get(key).get(d)>=num) cnt++;
							}
						}
					}
				}
			}
			
			return cnt;
		}
	}

	public static void main(String[] args) {
		String []info=
			{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query=
			{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		System.out.println(Arrays.toString(new Solution().solution(info, query)));
	}

}
