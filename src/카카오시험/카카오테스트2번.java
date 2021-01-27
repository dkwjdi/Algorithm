package 카카오시험;
//1시간
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 카카오테스트2번 {
	static class Solution {
		class Info{
			String order;
			int num;
			public Info(String order, int num) {
				this.order = order;
				this.num = num;
			}
		}
		public String[] solution(String []orders, int []course) {
			List<String> list = new ArrayList<>();
			
			for(int c=0; c<course.length; c++) {
				HashMap<String ,Integer> hm = new HashMap<>(); //입력 한 줄에 대해 
				int courseNum=course[c]; //코스요리 개수
				StringBuilder sb= new StringBuilder();
				
				for(int o=0; o<orders.length; o++) { //입력들어온 한줄의 길이!
					String order=orderSort(orders[o]);
					
					combi(0,0,order.length(),hm,order,sb,courseNum); //start
					
				}
				answerSelect(hm,list);
			}
			String [] answer= new String[list.size()];
			for(int i=0; i<list.size(); i++) answer[i]=list.get(i);
			Arrays.sort(answer);
			return answer;
		}


		private void combi(int cnt,int start, int length, HashMap<String, Integer> hm, String order, StringBuilder sb, int courseNum) {
			if(sb.length()==courseNum) { //다 뽑았으면
				String courseFood=sb.toString();
				//System.out.println(courseFood);
				if(hm.containsKey(courseFood)) hm.put(courseFood, hm.get(courseFood)+1);
				else hm.put(courseFood, 1);
				sb=new StringBuilder();
				return;
			}
			
			if(cnt==length) { //다 돌았는데 글자 못채우면 
				sb=new StringBuilder();
				return;
			}
			
			for(int i=start; i<length; i++) {
				sb.append(order.charAt(i));
				combi(cnt+1,i+1,length,hm,order,sb,courseNum); 
				sb.deleteCharAt(sb.length()-1);
			}
			
		}

		private void answerSelect(HashMap<String, Integer> hm, List<String> list) {
			List<Info> orderList=new ArrayList<>();
			for(String order : hm.keySet()) orderList.add(new Info(order, hm.get(order)));
			Collections.sort(orderList, (o1,o2)->(o2.num-o1.num));
			if(orderList.size()==0 ) return;
			int num=orderList.get(0).num;
			if(num<2) return;
			
			for(int i=0; i<orderList.size(); i++) {
				Info info = orderList.get(i);
				if(info.num==num) list.add(info.order);
				else break;
			}
			return;
		}

		private String orderSort(String order) {
			PriorityQueue<Character> pq = new PriorityQueue<>();
			StringBuilder sb= new StringBuilder();
			
			for(int i=0; i<order.length(); i++) pq.offer(order.charAt(i));
			while(!pq.isEmpty()) {
				sb.append(pq.poll());
			}
			return sb.toString();
		}
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution(
				new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				new int[] {2,3,4})));
		System.out.println(Arrays.toString(new Solution().solution(
				new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
				new int[] {2,3,5})));
		System.out.println(Arrays.toString(new Solution().solution(
				new String[] {"XYZ", "XWY", "WXA"},
				new int[] {2,3,4})));
	}

}
