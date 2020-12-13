package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 다리를지나는트럭 {
	static class Solution {
		class Truck{
			int time, weight;
			public Truck(int time, int weight) {
				this.time = time;
				this.weight = weight;
			}
		}
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 1;
	        int totalWeight=0;
	        List<Truck> list = new ArrayList<>();
	        
	        int truck_no=0;
	        while(true) {
	        	int size=list.size();
	        	//삭제하기 
	        	for(int i=0; i<size; i++) {
	        		if(answer-list.get(i).time!=bridge_length) break;
	        		else {
	        			totalWeight-=list.get(0).weight;
	        			list.remove(0);
	        			i--; size--;
	        		}
	        	}
	        	
	        	
	        	if(truck_no<truck_weights.length) {
	        		if(totalWeight+truck_weights[truck_no]<=weight) {
	        			list.add(new Truck(answer,truck_weights[truck_no]));
	        			totalWeight+=truck_weights[truck_no++];
	        		}
	        	}
	        	
	        	if(truck_no>=truck_weights.length && list.size()==0) break;
	        	
	        	
	        	answer++;
	        }
	        
	        
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int bridge_length =100;
		int weight=100;
		int[] truck_weights= {10,10,10,10,10,10,10,10,10,10};
		new Solution().solution(bridge_length, weight, truck_weights);
	}

}
