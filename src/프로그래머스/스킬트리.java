package 프로그래머스;

public class 스킬트리 {
	static class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	       loop: for(int i=0;i <skill_trees.length; i++) {
	        	String skillTree=skill_trees[i];
	        	int index=0;
	        	
	        	for(int j=0 ; j<skillTree.length(); j++) {
	        		if(skill.contains(skillTree.substring(j, j+1))) {
	        			if(index!=skill.indexOf(skillTree.substring(j, j+1))) continue loop;
	        			else index++;
	        		}
	        	}
	        	answer++;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		String skill= "CBD";
		String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA"};
		new Solution().solution(skill, skill_trees);
	}

}
