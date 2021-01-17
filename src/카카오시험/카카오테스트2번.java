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
				HashMap<String ,Integer> hm = new HashMap<>();
				int courseNum=course[c];
				
				for(int o=0; o<orders.length; o++) {
					String order=orderSort(orders[o]);
					int size=order.length();
					
					for(int i=0; i<size-(courseNum-1); i++) {
						for(int j=i+1; j<size-(courseNum-2); j++) {
							String courseFood=Character.toString(order.charAt(i));
							courseFood+=order.substring(j, j+courseNum-1);
							if(hm.containsKey(courseFood)) hm.put(courseFood, hm.get(courseFood)+1);
							else hm.put(courseFood, 1);
						}
					}
				}
				answerSelect(hm,list);
			}
			String [] answer= new String[list.size()];
			for(int i=0; i<list.size(); i++) answer[i]=list.get(i);
			Arrays.sort(answer);
			return answer;
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
				new String[] {"BACFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				new int[] {2,3,4})));
		System.out.println(Arrays.toString(new Solution().solution(
				new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
				new int[] {2,3,5})));
		System.out.println(Arrays.toString(new Solution().solution(
				new String[] {"XYZ", "XWY", "WXA"},
				new int[] {2,3,4})));
	}

}
