import java.util.HashSet;
import java.util.PriorityQueue;

public class 불량사용자 {
	static class Solution {
		int answer;
		PriorityQueue<String> pq;
		HashSet<String> hs;
	    public int solution(String[] user_id, String[] banned_id) {
	    	answer=0;
	        boolean visited[]=new boolean[user_id.length];
	        pq=new PriorityQueue<>((o1,o2)->(o1.compareTo(o2)));
	        hs= new HashSet<String>();
	        
	        dfs(user_id, banned_id,visited,0);
	        
	        return answer;
	    }
		private void dfs(String[] user_id, String[] banned_id, boolean[] visited, int cnt) {
			if(cnt==banned_id.length) {
				
				String str=duplicateCheck(user_id,visited);
				if(hs.contains(str)) return;
				else hs.add(str);
				answer++;
				return ;
			}
			
			String ban=banned_id[cnt];
			
			for(int i=0; i<user_id.length; i++) {
				if(visited[i]) continue;
				if(check(user_id[i],ban)) { //벤 이 맞을 때 
					visited[i]=true;
					dfs(user_id, banned_id, visited, cnt+1);
				}
				visited[i]=false;
			}
			
		}
		private String duplicateCheck(String[] user_id, boolean[] visited) {
			String out="";
			for(int i=0; i<user_id.length; i++) {
				if(visited[i]) pq.offer(user_id[i]);
			}
			int size=pq.size();
			for(int i=0; i<size; i++) {
				out+=pq.poll();
			}
			return out;
		}
		private boolean check(String user, String ban) {
			if(user.length()!=ban.length()) return false;
			
			for(int i=0; i<user.length(); i++) {
				if(ban.charAt(i)=='*') continue;
				if(user.charAt(i)!=ban.charAt(i)) return false;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		String[] user_id= { "frodo", "fradi", "crodo", "abc123", "frodoc"
				
		};
		String[] banned_id={
				"fr*d*", "*rodo", "******", "******"
		};
		System.out.println(new Solution().solution(user_id, banned_id));
	}

}
