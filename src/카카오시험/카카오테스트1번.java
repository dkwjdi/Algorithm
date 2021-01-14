package 카카오시험;
//30분 
public class 카카오테스트1번 {
	static class Solution {
		public String solution(String new_id) {
			new_id=new_id.toLowerCase(); //1단계
			
			//2단계
			StringBuilder sb= new StringBuilder();
			for(int i=0; i<new_id.length(); i++) {
				char ch=new_id.charAt(i);
				if((ch>=97 && ch<=122) || ch=='-' || ch=='_' || ch=='.' || Character.isDigit(ch)) sb.append(ch);
			}
			new_id=sb.toString();
			
			//3단계
			int size=new_id.length();
			sb= new StringBuilder();
			for(int i=0; i<size; i++) sb.append('.');
			for(int i=0; i<size; i++) {
				new_id=new_id.replace(sb.toString(), ".");
				sb=new StringBuilder(sb.substring(1));
			}
			
			//4단계
			if(new_id.length()!=0 &&new_id.charAt(0)=='.') new_id=new_id.substring(1);
			if(new_id.length()!=0 &&new_id.charAt(new_id.length()-1)=='.') new_id=new_id.substring(0, new_id.length()-1);
			
			//5단계
			if(new_id.equals("")) new_id="a";
			
			//6단계
			if(new_id.length()>=16) new_id=new_id.substring(0, 15);
			if(new_id.charAt(new_id.length()-1)=='.') new_id=new_id.substring(0, new_id.length()-1);
			
			//7단계
			if(new_id.length()<=2) {
				while(true) {
					if(new_id.length()>=3) break;
					new_id+=new_id.charAt(new_id.length()-1);
				}
			}
			return new_id;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(new Solution().solution("z-+.^."));
		System.out.println(new Solution().solution("=.="));
		System.out.println(new Solution().solution("123_.def"));
		System.out.println(new Solution().solution("abcdefghijklmn.p"));
	}

}

