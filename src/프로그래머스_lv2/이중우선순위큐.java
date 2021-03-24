package 프로그래머스_lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	static class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        
	        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
	        
	        for(int i=0; i<operations.length; i++) {
	        	String operation[]=operations[i].split(" ");
	        	
	        	if(operation[0].equals("I")) { //삽입
	        		minHeap.add(Integer.parseInt(operation[1]));
	        		maxHeap.add(Integer.parseInt(operation[1]));
	        	}
	        	else { //삭제
	        		if(operation[1].equals("-1"))  minHeap.poll();//최솟값 삭제
	        		else maxHeap.poll(); //최댓값 삭제
	        		
	        		if(minHeap.size()==0 || maxHeap.size()==0 ||
	        				(minHeap.size()==1 && maxHeap.size()==1)) { //둘 중 하나라도 비었으면 다비워줌
	        			minHeap.clear();
	        			maxHeap.clear();
	        		}
	        		
	        	}
	        }
	        
	        if(maxHeap.size()==0) answer[0]=answer[1]=0; //큐 비어있으면
	        else {
	        	answer[0]=maxHeap.poll();
	        	answer[1]=minHeap.poll();
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String[] operations= {"I 3","I 7","D 1","D -1"};
		System.out.println(Arrays.toString(new Solution().solution(operations)));
	}

}
